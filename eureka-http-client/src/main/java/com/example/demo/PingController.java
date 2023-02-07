package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PingController {

    private final RestTemplate restTemplate;
    private final String middleClient;

    private final String middlePing;

    public PingController(RestTemplate restTemplate, @Value("${app.middle-client.name}") String middleClient) {
        this.restTemplate = restTemplate;
        this.middleClient = middleClient;
        this.middlePing = String.format("http://%s/ping", middleClient);
    }

    @GetMapping("/ping")
    public String ping() {
        String remoteResponse = restTemplate.getForEntity(middlePing, String.class).getBody();

        return "Remote service response: " + remoteResponse;
    }
}
