package com.yo.news.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public  class MainApplication
{
	final C a;
	public MainApplication()
	{
		a=null;
	}
	public MainApplication(C c)
	{
		a=c;
		c.c=4;
		System.out.println(a);
	}

	public static void main(String[] args)
	{
//		new MainApplication(new MainApplication().new C());
		SpringApplication.run(MainApplication.class, args);
	}
	class C
	{
		public Object c=3;
	}
}
