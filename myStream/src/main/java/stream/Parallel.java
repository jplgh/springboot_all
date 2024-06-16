package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 并行流
 * @Author jpl
 * @date 2024/4/21&下午6:47
 */
public class Parallel {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .parallel()
                .collect(Collectors.toList());


    }
}
