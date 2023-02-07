package com.example.demo;

import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class DemoApplication {

	@Lazy
	private final EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	@Value("${eureka.instance.instance-id}")
	private String instanceId;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/ping")
	public String ping() {
		return String.format(
				"You called application '%s' with id '%s'!",
				eurekaClient.getApplication(appName).getName(),
				instanceId);
	}


}
