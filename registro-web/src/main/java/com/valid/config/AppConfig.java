package com.valid.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author neira
 */
@EnableAspectJAutoProxy
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.*" })
public class AppConfig {


    
}