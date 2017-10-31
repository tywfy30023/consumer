package com.wfy.consumer;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wfy.intf.DemoService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("消费者：" + App.class.getResource("/").getPath());
		String path = "";// App.class.getResource("/consumer.xml").getPath();
		path = "/consumer.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { path });
		context.start();
		System.out.println("消费者启动（按任意键退出或在console窗口中停止）:");

		DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
		String msg = demoService.sayHello("张三");

		System.out.println("调用结果:" + msg);

		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("已退出:");
	}
}
