package com.example.gatewaynameservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

@RestController
public class NameController {

    @Value("${app.male.names}")
    private List<String> maleNames;

    @Value("${app.female.names}")
    private List<String> femaleNames;

    private final Random random = new Random();

    @GetMapping("female/random")
    public Mono<String> getRandomFemaleName() {
        return Mono.just(femaleNames.get(random.nextInt(femaleNames.size())));
    }

    @GetMapping("male/random")
    public Mono<String> getRandomMaleName() {
//        return Mono.error(new IllegalStateException());
        return Mono.just(maleNames.get(random.nextInt(maleNames.size())));
    }

}
