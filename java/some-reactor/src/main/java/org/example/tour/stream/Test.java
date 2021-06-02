package org.example.tour.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Stream stream = Stream.empty();

        int[] ints = IntStream.range(0, 20).parallel().map(x -> x * 2).toArray();
        System.out.println(Arrays.toString(ints));

        // identity 表示初始值
        int sum = IntStream.range(0, 100).reduce(1, (x, y) -> x + y);
        System.out.println(sum);

        Arrays.asList("a", "b", "c").stream().collect(Collectors.toList());

    }
}
