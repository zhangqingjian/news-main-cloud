/**
 * 
 */
package com.yo.news.sale.framework.utils.database;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

/**
 */
/**
 * @author JAN
 * @CreatedTime：2016年1月13日 下午1:48:28 说明：通过拦截器对数据库访问进行读写分离
 */
public class DataSourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice
{
	static Logger logAPI = Logger.getLogger(DataSourceAdvice.class);
	private List<String> slaveFilterList;

	// service方法执行之前被调用
	public void before(Method method, Object[] args, Object target) throws Throwable
	{

		boolean isSlave = isSwitchSlave(method.getName());
		if (isSlave)
		{
			// 切到只读数据库
			DataSourceSwitcher.setSlave();
			// logAPI.debug("切入到Slave: " + target.getClass().getName() + "类中" +
			// method.getName() + "方法");
			 System.out.println("\r\n切入到Slave: " + target.getClass().getName()
			 + "类中" + method.getName() + "方法");

		}
		else
		{
			// 如果没有匹配到则切到读写都可以的数据库
			DataSourceSwitcher.setMaster();
			// logAPI.debug("切入到Master: " + target.getClass().getName() + "类中" +
			// method.getName() + "方法");
			 System.out.println("\r\n切入到Master: " +
			 target.getClass().getName() + "类中" + method.getName() + "方法");
		}

	}

	/**
	 * @author JAN
	 * @CreatedTime：2017年5月25日 下午2:47:37 说明：
	 * @param method
	 */
	private boolean isSwitchSlave(String methodName)
	{
		for (String str : slaveFilterList)
		{
			if (methodName.startsWith(str))
			{
				return true;
			}
		}
		return false;
	}

	// service方法执行完之后被调用
	public void afterReturning(Object arg0, Method method, Object[] args, Object target) throws Throwable
	{
	}

	// 抛出Exception之后被调用
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable
	{
		// 目前slave是只读，所以不用切换
		DataSourceSwitcher.setSlave();
		logAPI.error("数据库读取分离DataSourceAdvice出现异常:", ex);
		// System.out.println("数据库读取分离DataSourceAdvice出现异常:"+ex);
		throw ex;
	}

	public List<String> getSlaveFilterList()
	{
		return slaveFilterList;
	}

	public void setSlaveFilterList(List<String> slaveFilterList)
	{
		this.slaveFilterList = slaveFilterList;
	}
}
