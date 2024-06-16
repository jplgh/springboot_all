package stream;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 生成
 *
 * @Author jpl
 * @date 2024/4/21&上午9:35
 */
public class IntStreamTest {
    public static void main(String[] args) {
        //生成从 0 ~ 9 的数字
        IntStream.range(0, 10).forEach(System.out::println);
        // 或者
        IntStream.rangeClosed(0, 9).forEach(System.out::println);
        //如果想订制，可以用 iterate 方法，例如下面生成奇数序列
        /**
         *  参数1 是初始值
         *  参数2 是一个特殊 Function，即参数类型与返回值相同，它会根据上一个元素 x 的值计算出当前元素
         *  需要用 limit 限制元素个数
         */
        IntStream.iterate(1, x -> x + 2).limit(10).forEach(System.out::println);

        //也可以用 iterate 的重载方法
        /**
         *  参数1 是初始值
         *  参数2 用来限制元素个数，一旦不满足此条件，流就结束
         *  参数3 相当于上个方法的参数2
         */
        IntStream.iterate(1, x -> x < 10, x -> x + 2).forEach(System.out::println);

        /**
         * iterate 的特点是根据上一个元素计算当前元素，如果不需要依赖上一个元素，可以改用 generate 方法
         * 例如下面是生成 5 个随机 int
         */
        Stream.generate(() -> ThreadLocalRandom.current().nextInt()).limit(5).forEach(System.out::println);
       //不过如果只是生成随机数的话，有更简单的办法
        ThreadLocalRandom.current().ints(5).forEach(System.out::println);
       //如果要指定上下限，例如下面是生成从 0~9 的100个随机数
        ThreadLocalRandom.current().ints(100, 0, 10).forEach(System.out::println);
    }
}
