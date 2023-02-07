package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackEndpoint {

    @GetMapping("name/male")
    public Mono<String> getMaleName() {
        return Mono.just("Артур");
    }

    @GetMapping("name/female")
    public Mono<String> getFemaleName() {
        return Mono.just("Анна");
    }

    @GetMapping("lastname/male")
    public Mono<String> getMaleLastname() {
        return Mono.just("Розниченко");
    }

    @GetMapping("lastname/female")
    public Mono<String> getFemaleLastname() {
        return Mono.just("Ларенко");
    }
}
