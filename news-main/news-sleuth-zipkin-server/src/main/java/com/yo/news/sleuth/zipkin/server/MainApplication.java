package com.yo.news.sleuth.zipkin.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class MainApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MainApplication.class, args);
		List<String> names = new ArrayList<>();
		names.add("1");
		names.add("2");
		names.add("3");
		names.add("4");
		Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
		names.stream().map((String name)->{return name.toLowerCase();});
		
	}
}
