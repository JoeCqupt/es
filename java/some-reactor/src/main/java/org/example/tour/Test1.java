package org.example.tour;

import reactor.core.publisher.Flux;

public class Test1 {

    public static void main(String[] args) {
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        seq1.subscribe(); // do nothing

        seq1.subscribe(v -> System.out.println(v));


        System.out.println("================================");

        Flux<Integer> seq2 = Flux.range(1, 4)
                .map(v -> {
                    if (v <= 3) return v;
                    throw new RuntimeException("Got to 4");
                });

        seq2.subscribe(
                v -> System.out.println(v),
                error -> error.printStackTrace()
        );

        System.out.println("================================");
        

    }
}
