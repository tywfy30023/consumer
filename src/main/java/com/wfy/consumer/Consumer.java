package com.wfy.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wfy.intf.DemoService;

public class Consumer {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring/dubbo-demo-consumer.xml" });
		context.start();
		DemoService demoService = (DemoService) context.getBean("demoService"); // obtain proxy object for remote
																				// invocation
		String hello = demoService.sayHello("world"); // execute remote invocation
		System.out.println(hello); // show the result
	}
}
