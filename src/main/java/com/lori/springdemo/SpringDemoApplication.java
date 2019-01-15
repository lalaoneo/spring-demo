package com.lori.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringDemoApplication.class, args);

		Scanner scanner = new Scanner(System.in);

		System.out.println("输入quit,会优雅退出");

		String line = scanner.nextLine();

		// 只能解析一次输入,第一次输入的不是quit,后面再输入quit将会无效
		if ("quit".equals(line)){
			System.exit(1);
		}
	}

}

