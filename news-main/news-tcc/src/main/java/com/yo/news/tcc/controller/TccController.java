/**
 * 
 */
package com.yo.news.tcc.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.yo.news.tcc.ebo.TccService;
import com.yo.news.ttc.controller.request.TccRequest;
import org.springframework.http.MediaType;
import io.swagger.annotations.ApiOperation;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月23日 下午1:50:13 说明：
 */
@RestController
@RequestMapping(value = TccController.API_PREFIX, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class TccController
{
	protected static final String API_PREFIX = "/tcc/v1";
	@Autowired
	TccService tccService;

	@ApiOperation(value = "确认", notes = "确认", httpMethod = "PUT")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.PUT, path = "/confirm")
	public void confirm(@Valid @RequestBody TccRequest tccRequest, BindingResult result, HttpSession session)
	{
		tccService.confirm(tccRequest);

	}

	@ApiOperation(value = "取消", notes = "取消")
	@RequestMapping(method = RequestMethod.DELETE, path = "/cancel")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void cancel(@Valid @RequestBody TccRequest tccRequest, BindingResult result, HttpSession session)
	{
		tccService.cancel(tccRequest);
	}

 
}
