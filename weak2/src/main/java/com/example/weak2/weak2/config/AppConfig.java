package com.example.weak2.weak2.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

   @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

}
