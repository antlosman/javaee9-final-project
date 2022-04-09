package com.javaee9.javaee9finalproject.controller;

import com.javaee9.javaee9finalproject.dto.InitialConfig;
import com.javaee9.javaee9finalproject.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController is going to provide us just a data as a JSON format. So we are going to connect to this backend from
// our frontend application and we need just get InitialConfig (DTO) as a JSON and provide it to the frontend.
// Normal controller provides a html page, but in our case Angular will provide us html page.
@RestController
@Slf4j
@RequestMapping("/config")
@CrossOrigin("${allowed.origin.url}")
// https://developer.mozilla.org/en-US/docs/Web/Security/Same-origin_policy

public class ConfigController {

    // firs of all we need reference to the service
    private final ConfigService configService;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping // we can leave url unnamed because we return only one object in this controller
    public InitialConfig provideInitialConfig() {
        log.info("provide initial config was called");
        return configService.getInitialConfig();
    }
}
