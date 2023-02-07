package com.example.configvault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greeting")
@RefreshScope
public class GreetingController {

    @Value("${app.greeting.static:static-not-configured}")
    private String staticGreetingProperty;

    @Value("${app.greeting.dynamic:dynamic-not-configured}")
    private String dynamicGreetingProperty;

    @GetMapping("static")
    public String staticGreeting() {
        return createGreeting(staticGreetingProperty);
    }

    @GetMapping("dynamic")
    public String dynamicGreeting() {
        return createGreeting(dynamicGreetingProperty);
    }

    private String createGreeting(String name) {
        return "Hello '" + name + "'!";
    }
}
