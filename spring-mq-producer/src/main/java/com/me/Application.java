package com.me;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
		System.out.println(ac);
		
	}

}
