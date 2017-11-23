package com.ebird.ebird_server;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ebird")
public class MainApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);

	public static void main(String[] args) {
		LOGGER.info("服务开始启动..........");
        SpringApplication.run(MainApplication.class, args);  
        try {  
            System.in.read();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        LOGGER.info("服务启动完成..........");

	}

}
