package _43_perfer_no_side_effect_function_in_stream;

import com.sun.corba.se.spi.orb.Operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("");
        Map<String, Long> freq = new HashMap<>();

        // 1、下面的流操作修改了外部的变量，不推荐
        // forEach 操作应仅用于报告流计算的结果，而不是用于执行计算。
//        try (Stream<String> words = new Scanner(file).tokens()) {
//            words.forEach(word -> {
//                freq.merge(word.toLowerCase(), 1L, Long::sum);
//            });
//        }

        // 2、统计词频的正确用法
//        Map<String, Long> freq;
//        try (Stream<String> words = new Scanner(file).tokens()) {
//            freq = words
//                    .collect(groupingBy(String::toLowerCase, counting()));
//        }


        // 3、Collectors可以将多个对象缩减为一个对象，这个对象通常是一个集合
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());

        // 4、Collectors收集Map，还有其他的groupBy，join等
//        private static final Map<String, Operation> stringToEnum =
//                Stream.of(values()).collect(
//                        toMap(Object::toString, e -> e));
    }
}
