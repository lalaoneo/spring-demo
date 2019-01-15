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

		if ("quit".equals(line)){
			System.exit(1);
		}
	}

}

