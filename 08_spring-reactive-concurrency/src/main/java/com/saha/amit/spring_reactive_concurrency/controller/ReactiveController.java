package com.saha.amit.spring_reactive_concurrency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/reactive")
public class ReactiveController {

    /**
     * MONO: Represents 0 or 1 element.
     */
    @GetMapping("/mono")
    public Mono<String> getMono() {
        return Mono.just("Hello from WebFlux (Mono)!")
                .delayElement(Duration.ofMillis(500));
    }

    /**
     * FLUX: Represents a stream of 0 to N elements.
     * Best Practice: Use for real-time data streaming.
     */
    @GetMapping(value = "/flux", produces = "text/event-stream")
    public Flux<String> getFlux() {
        return Flux.just("Spring", "Boot", "Reactive", "Streams")
                .delayElements(Duration.ofMillis(1000));
    }
}
