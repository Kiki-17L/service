package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
@Component
@Configuration
public class webSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){

        return  new ServerEndpointExporter();
    }
}
