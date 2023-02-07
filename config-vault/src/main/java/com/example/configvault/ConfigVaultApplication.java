package com.example.configvault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class ConfigVaultApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigVaultApplication.class, args);
    }

}
