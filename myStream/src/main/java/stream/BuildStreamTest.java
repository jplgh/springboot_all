package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 构建
 *
 * @Author jpl
 * @date 2024/4/21&上午11:47
 */
public class BuildStreamTest {
    public static void main(String[] args) {
        // 1. 从集合构建
        Integer[] arr = {1, 2, 3};
        //根据已有的数组构建流
        Arrays.stream(arr);
        // 根据已有的 Collection 构建流（包括 List，Set 等）
        List.of("a", "b", "c").stream();
        Set.of("a", "b", "c").stream().forEach(System.out::println);
        // 把一个对象变成流
        Stream.of("x");
        // 把多个对象变成流
        Stream.of("x", "y");
        //map键值
        Map.of("a",1, "b",2).entrySet().stream().forEach(System.out::println);
    }
}
