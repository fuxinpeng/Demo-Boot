package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

//@EnableRabbit//开启基于Rabbitmq注解的模式
@EnableAsync//开启异步注解
@MapperScan(value="com.example.demo.mapper")//mybaits扫描映射器
@SpringBootApplication
public class StudyBootApplication {

	public static void main(String[] args) {
		System.out.println("springboot开始启动......");
		SpringApplication.run(StudyBootApplication.class, args);
		System.out.println("springboot启动成功......");
	}

	@Bean
	public RestTemplate getRestTemplate(){
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(30000);// 设置建立连接的时间不超过20秒
		requestFactory.setReadTimeout(30000);//设置读取数据的时间不超过20秒
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		return restTemplate;
	}

}
