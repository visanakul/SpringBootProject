package com.vishal.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(DemoApplication.class, args);
		System.out.println("*** :: Context : "+ctx.getClass().getName()+" :: ***");
	}

}
