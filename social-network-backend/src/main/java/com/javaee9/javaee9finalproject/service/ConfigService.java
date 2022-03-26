package com.javaee9.javaee9finalproject.service;

import com.javaee9.javaee9finalproject.dto.InitialConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// This class will read InitialConfig DTO and give it to the controller.

// This service will read the variable from the application.properties file
@Service
@Slf4j
public class ConfigService {

    private final String applicationName;

    public ConfigService(@Value("${social.network.application.name}")String applicationName) {
        log.info("application name: [{}]", applicationName);
        this.applicationName = applicationName;
    }


    public InitialConfig getInitialConfig() {
        return new InitialConfig(applicationName);
    }
}
