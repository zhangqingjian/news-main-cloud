/**
 * 
 */
package com.yo.news.sale.framework.bean.configuration;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月18日 下午2:46:54 说明：
 */
@Component
@Getter
@Setter
@ToString(callSuper = true)
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties
{
	/**
	 * 
	 */
	@Value("${spring.redis.cluster.nodes}")
	private String nodes;
	private int timeout;
	private String password;
	private int maxIdle;
	private int minIdle;
	private int maxTotal;
	private int maxWaitMillis;
	private boolean testOnBorrow;
	private boolean testOnReturn;
	private boolean testWhileIdle;

}
