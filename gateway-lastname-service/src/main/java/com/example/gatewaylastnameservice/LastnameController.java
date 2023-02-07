package com.example.gatewaylastnameservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

@RestController
public class LastnameController {

    @Value("${app.male.lastnames}")
    private List<String> maleLastnames;

    @Value("${app.female.lastnames}")
    private List<String> femaleLastnames;

    private final Random random = new Random();

    @GetMapping("female/random")
    public Mono<String> getRandomFemaleSurname() {
        return Mono.just(femaleLastnames.get(random.nextInt(femaleLastnames.size())));
    }

    @GetMapping("male/random")
    public Mono<String> getRandomMaleSurname() {
        return Mono.just(maleLastnames.get(random.nextInt(maleLastnames.size())));
    }

}
