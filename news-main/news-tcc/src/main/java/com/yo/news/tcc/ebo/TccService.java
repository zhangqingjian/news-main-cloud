/**
 * 
 */
package com.yo.news.tcc.ebo;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.soap.Detail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.yo.news.sale.framework.enums.StatusCode;
import com.yo.news.sale.framework.excepiton.Shift;
import com.yo.news.tcc.domain.TCCParticipant;
import com.yo.news.tcc.enums.TccStatus;
import com.yo.news.tcc.exception.ConfirmExpireException;
import com.yo.news.tcc.exception.PartialConfirmException;
import com.yo.news.tcc.model.TccErrorResponse;
import com.yo.news.ttc.controller.request.TccRequest;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月24日 上午11:00:26 说明：
 */
@Service
public class TccService
{
	@Autowired
	LoadBalancerClient loadBalancerClient;
	private final static Logger LOGGER = LoggerFactory.getLogger(TccService.class);
	private final RestTemplate restTemplate;
	private static final HttpEntity<?> httpEntity;
	static
	{
		final HttpHeaders headers = new HttpHeaders();
		headers.setAccept(ImmutableList.of(MediaType.APPLICATION_JSON_UTF8));
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpEntity = new HttpEntity<>(headers);

	}

	/**
	 * 在confirm方法中不能够使用之前自动织入的restTemplate，否则会报以下错误:
	 * java.lang.IllegalStateException: No instances available
	 * 这个是因为自动织入的restTemplate会把服务器的逻辑名称当作服务名称来使用，造成找不到相应的服务实例，从而报错。
	 */
	private RestTemplate only4HereRestTemplate = new RestTemplate();

	@Autowired
	public TccService(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}

	public void confirm(TccRequest tccRequest)
	{
		Preconditions.checkNotNull(tccRequest);
		int iSuccess = 0;
		int iFailed = 0;
		final List<TCCParticipant> participants = tccRequest.getParticipants();
		for (TCCParticipant tccParticipant : participants)
		{
			tccParticipant.setExecuteTime(OffsetDateTime.now());
			tccParticipant.setTccStatus(TccStatus.BEING_CONFIRMED);
			String actualUrl = getBalanceRemoteServerUrl(tccParticipant);
			try
			{
				final ResponseEntity<String> responseEntity = only4HereRestTemplate.exchange(actualUrl, HttpMethod.PUT, httpEntity, String.class);
				if (responseEntity.getStatusCode() == HttpStatus.NO_CONTENT)
				{
					iSuccess++;
					tccParticipant.setTccStatus(TccStatus.CONFIRMED);
				}
				else if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND)
				{
					iFailed++;
					tccParticipant.setTccStatus(TccStatus.TIMEOUT);
					tccParticipant.setErrorResponse(responseEntity);
				}
				else
				{
					Shift.fatal(StatusCode.SERVER_UNKNOWN_ERROR, responseEntity);
				}
			}
			catch (Exception e)
			{
				throw new RuntimeException("TCC  execute put request failed, url is " + tccParticipant.getUrl() + ".detail is " + e.toString());
			}
		}
		if (iSuccess > 0 && iFailed > 0)
		{
			throw new PartialConfirmException("one or more try confirmed actions were cancelled or timeout", new TccErrorResponse(participants));
		}
		else if (iFailed == participants.size())
		{
			// 全部timeout
			throw new ConfirmExpireException("all request failed to request TCC remote url");
		}

	}

	public void cancel(TccRequest tccRequest)
	{
		Preconditions.checkNotNull(tccRequest);
		final List<TCCParticipant> list = tccRequest.getParticipants();
		try
		{
			for (TCCParticipant tccParticipant : list)
			{
				tccParticipant.setExecuteTime(OffsetDateTime.now());
				final ResponseEntity<String> responseEntity = restTemplate.exchange(tccParticipant.getUrl(), HttpMethod.DELETE, httpEntity,
						String.class);

			}
		}
		catch (Exception e)
		{
			LOGGER.debug("unknown exception catched,detail is " + e.toString());
		}

	}

	/**
	 * @author JAN
	 * @CreatedTime：2017年11月24日 上午9:40:53 说明：
	 * @param tccParticipant
	 * @return 获取TTC远程访问的地址
	 */
	private String getBalanceRemoteServerUrl(TCCParticipant tccParticipant)
	{
		// 通过请求的url地址分析地址中的spring-application-name
		String serverId = getServerId(tccParticipant.getUrl());
		// 通过applicationName到注册服务中心中获取目标服务地址实例
		ServiceInstance serviceInstance = loadBalancerClient.choose(serverId);
		if (serviceInstance == null)
		{
			throw new RuntimeException("TCCService getBalanceRemoteServerUrl failed,application name is " + serverId);
		}
		// 拼装具体要访问的IP
		String ipPort = serviceInstance.getHost() + ":" + serviceInstance.getPort();
		// 用拼装后的IP替换applicationName
		String actualUrl = tccParticipant.getUrl().replace(serverId, ipPort);
		System.out.println("TCC服务远程访问的TCC地址为：" + actualUrl);
		return actualUrl;
	}

	private static String getServerId(String url) throws RuntimeException
	{
		// // 要验证的字符串
		// String testUrl = "http://news-sale-orders/news/order/v1/pay/tcc/11";
		// 忽略大小写的写法
		Pattern p = Pattern.compile("(http://|https://)?([^/]*)", Pattern.CASE_INSENSITIVE);

		// 现在创建 matcher 对象
		Matcher m = p.matcher(url);
		// System.out.println(m.find());
		if (m.find())
		{
			return m.group(2);
		}
		else
		{
			throw new RuntimeException("can't match serverId from url by regex,example:'http://serverId/api/tcc/id' ,url is" + url);
		}

	}
}
