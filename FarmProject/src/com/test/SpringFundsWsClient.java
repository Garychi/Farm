package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFundsWsClient {
	   public static void main(String[] args) {
	        ApplicationContext context = new ClassPathXmlApplicationContext("com/test/client-config.xml");
	        IFund service = (IFund) context.getBean("fundClient");
	        Double price = service.getPrice("1235");
	        System.out.println("[1235]" + price);
	    }
}
