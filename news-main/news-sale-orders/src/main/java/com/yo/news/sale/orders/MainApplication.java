package com.yo.news.sale.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = { "com.yo.news.*" })
// 加载applicationContext-mybatis.xml配置
@ImportResource({ "classpath:applicationContext*.xml" })
// （需要加上这些注解排除多个数据源，否则会报'javax.sql.DataSource' available:expected single
// matching bean but found 4:
// parentDataSource,masterDataSource,slaveDataSource,dataSource）
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, })
public class MainApplication
{
	// 该用于对其他接口发起REST请求，此已经被服务消费（Feign）所替代
	// @Bean
	// public RestTemplate restTemplate()
	// {
	// return new RestTemplate();
	// }
	public static void main(String[] args)
	{
		SpringApplication.run(MainApplication.class, args);
	}
}
