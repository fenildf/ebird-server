package com.ebird.ebird_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;


@Configuration  
@PropertySource("classpath:properties/dubbo.properties")  
@ImportResource({ "classpath:dubbo.xml" }) 
public class DubboConfig {

}
