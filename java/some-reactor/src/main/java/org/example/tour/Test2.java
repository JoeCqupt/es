package org.example.tour;

import reactor.core.publisher.Flux;

public class Test2 {
    public static void main(String[] args) {
        Flux<String> flux = Flux
                .<String>error(new IllegalArgumentException())
                .doOnError(System.out::println)
                .retryWhen(companion -> companion.take(3));
    }
}
