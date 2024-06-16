package stream;

import java.util.stream.Stream;

/**
 * 特性
 * @Author jpl
 * @date 2024/4/21&下午6:39
 */
public class Summary {
    /**
     * 特性
     * 1. 一次使用：流只能使用一次（终结方法只能调用一次）
     * 2. 两类操作：
     * 1. 中间操作，lazy 懒惰的
     * 2. 终结操作，eager 迫切的
     */

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  //水滴
        //----------------------------------------//
        stream
                .map(x -> x * x)   //水管
                .filter(x -> x % 2 == 0)  //水管
                .forEach(System.out::println);  //水管  总阀门


    }
}
