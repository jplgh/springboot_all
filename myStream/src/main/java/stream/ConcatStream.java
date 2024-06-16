package stream;

import java.util.stream.Stream;

/**
 * 拼接
 * 截取
 *
 * @Author jpl
 * @date 2024/4/21&上午9:29
 */
public class ConcatStream {
    public static void main(String[] args) {
/**
 * 拼接
 */
        //两个流拼接
        Stream.concat(Stream.of("a", "b", "c"), Stream.of("d"));

/**
 * 截取
 * skip 是跳过几个元素
 * limit 是限制处理的元素个数  保留n几个元素，剩下的不要
 *
 */
        Stream.concat(Stream.of("a", "b", "c", "d", "e"), Stream.of("d"))
                .skip(1)
                .limit(2).forEach(System.out::println);


/**
 *  dropWhile 是 drop 流中元素，直到条件不成立，留下剩余元素
 *  takeWhile 是 take 流中元素，直到条件不成立，舍弃剩余元素
 */

        Stream.of("a", "b", "c", "d", "e")
                .dropWhile(s -> s.equals("a"))
                .takeWhile(s -> s.equals("a"))
                .forEach(System.out::println);

    }
}
