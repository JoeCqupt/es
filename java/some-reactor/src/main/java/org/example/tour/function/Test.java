package org.example.tour.function;

import java.util.Calendar;
import java.util.Comparator;
import java.util.function.*;

public class Test {

    public static void main(String[] args) {

        Predicate<String> p = String::isEmpty;
        p.test("");

        Supplier<Calendar> s = Calendar::getInstance;
        Calendar calendar = s.get();


        // 继承自Function
        UnaryOperator<String> unaryOperator = String::join;

        // 继承自BiFunction
        BinaryOperator<String> binaryOperator = String::concat;

        BinaryOperator<String> strCompareFunc = BinaryOperator.<String>maxBy(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        String res = strCompareFunc.apply("aaa", "aaab");
        System.out.println(res);


        IntToLongFunction intToLongFunction = (int i) -> i;

    }
}
