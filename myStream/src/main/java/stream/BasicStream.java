package stream;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 基本流
 * 基本类型流指 IntStream、LongStream 和 DoubleStream，它们在做数值计算时有更好的性能。
 *
 * @Author jpl
 * @date 2024/4/21&下午6:16
 */
public class BasicStream {
    public static void main(String[] args) {
        /**
         * 三种基本流
         */
        IntStream a = IntStream.of(1, 2, 3, 4, 5);
        LongStream b = LongStream.of(1L, 2L, 3L, 4L, 5L);
        DoubleStream c = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);

        Stream<Integer> d = Stream.of(1, 2, 3, 4, 5);
         /**转化成obj流*/
//        a.mapToObj(Character::toString).forEach(System.out::println);
          /** 转化为Integer 流*/
//        a.boxed().forEach(System.out::println);
        /** 求和*/
//        a.sum();
        /** 求平均值*/
//        a.average();
        /** 求最大值*/
//        a.max();
        /** 求最小值*/
//        a.min();



         /**综合*/
        IntSummaryStatistics sat = a.summaryStatistics();
        System.out.println(sat.getSum());
        System.out.println(sat.getCount());
        System.out.println(sat.getMax());
        System.out.println(sat.getMin());
        System.out.println(sat.getAverage());


        record Hero(String name, int strength) {
        }

        Stream<Hero> heroStream = Stream.of(
                new Hero("独孤求败", 100),
                new Hero("令狐冲", 90));

        /**转换*/
//        heroStream.mapToInt(Hero::strength).forEach(System.out::println);
//        heroStream.flatMap(hero -> Stream.of(hero.name(), hero.strength()));
//       heroStream.mapMulti((hero, consumer) -> {});
//        heroStream.map(hero -> hero.name() + ":" + hero.strength()).forEach(System.out::println);)
//        heroStream.mapToLong(Hero::strength);
//        heroStream.mapToDouble(Hero::strength);
    }


    /**
     *转换成基本流
     *
     *  mapToInt
     *  mapToLong
     *  mapToDouble
     *  flatMapToInt
     *  flatMapToLong
     *  flatMapToDouble
     *  mapMultiToInt
     *  mapMultiToLong
     *  mapMultiToDouble
     *
     * 基本流转对象流
     *  mapToObj
     *  boxed
     */



}
