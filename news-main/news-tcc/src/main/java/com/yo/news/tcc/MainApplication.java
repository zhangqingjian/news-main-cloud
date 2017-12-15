package com.yo.news.tcc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.yo.news.*" })
// 加载applicationContext-mybatis.xml配置
// （需要加上这些注解排除多个数据源，否则会报'javax.sql.DataSource' available:expected single
// matching bean but found 4:
// parentDataSource,masterDataSource,slaveDataSource,dataSource）
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class MainApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MainApplication.class, args);
	}
}
