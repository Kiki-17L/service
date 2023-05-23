package com.example.demo.config;

import jakarta.websocket.server.ServerEndpointConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBasedConfigurator extends ServerEndpointConfig.Configurator implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
        return super.getEndpointInstance(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBasedConfigurator.applicationContext= applicationContext;
    }
}
