package stream;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 查找与判断
 *
 * @Author jpl
 * @date 2024/4/21&上午9:48
 */
public class FindTest {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 4, 7, 6, 9};
//下面的代码找到流中任意（Any）一个偶数
        /**
         *  注意 findAny 返回的是 OptionalInt 对象，因为可能流中不存在偶数
         *  对于 OptionalInt 对象，一般需要用 ifPresent 或 orElse（提供默认值）来处理
         */
        Arrays.stream(array)
                .filter(x -> (x & 1) == 0)
                .findAny()
                .ifPresent(System.out::println);

        /**
         * 与 findAny 比较类似的是 firstFirst，它俩的区别
         *  findAny 是找在流中任意位置的元素，不需要考虑顺序，对于上例返回 6 也是可以的
         *  findFirst 是找第一个出现在元素，需要考虑顺序，对于上例只能返回 4
         *  findAny 在顺序流中与 findFirst 表现相同，区别在于并行流下会更快
         */
        IntStream intStream = IntStream.of(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
//        intStream.filter(x -> (x&1)==0).findFirst().ifPresent(System.out::println);
        System.out.println(intStream.filter(x -> (x & 1) == 0).findFirst().orElse(1));

// 判断流中是否存在任意一个偶数
        /**
         * 它返回的是 boolean 值，可以直接用来判断
         */
        System.out.println(Arrays.stream(array).anyMatch(x -> (x & 1) == 0));
//判断流是否全部是偶数
        /**
         * 同样，它返回的是 boolean 值，可以直接用来判断
         */
        System.out.println(Arrays.stream(array).allMatch(x -> (x & 1) == 0));
//判断流是否全部不是偶数
        /**
         * noneMatch 与 allMatch 含义恰好相反
         */
        System.out.println(Arrays.stream(array).noneMatch(x -> (x & 1) == 0));
    }
}
