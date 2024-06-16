package stream;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 排序与去重
 *
 * @Author jpl
 * @date 2024/4/21&上午10:09
 */
public class SortTest {
    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1, 3, 5, 4, 7, 4, 3, 6, 9);
        // distinct 去重
        integerStream.distinct().forEach(System.out::println);

        record Hero(String name, int strength) {
            int nameLength() {
                return this.name.length();
            }
        }

        Stream<Hero> heroStream = Stream.of(
                new Hero("独孤求败", 100),
                new Hero("令狐冲", 90),
                new Hero("风清扬", 98),
                new Hero("东方不败", 98),
                new Hero("方证", 92),
                new Hero("任我行", 92),
                new Hero("冲虚", 90),
                new Hero("向问天", 88),
                new Hero("不戒", 88)
        );



/**
 * 要求，首先按 strength 武力排序（逆序），武力相同的，按姓名长度排序（正序）
 * 仅用 lambda 来解
 */

//        heroStream.sorted((a,b)-> {
//            int res = Integer.compare(b.strength(), a.strength());
//            return (res == 0) ? Integer.compare(b.name.length(), a.name.length()) : res;
//        }).forEach(System.out::println);

        //简化
//       heroStream.sorted((a,b)->Integer.compare(b.strength(), a.strength())).forEach(System.out::println);
       //简化2
//        heroStream.sorted(Comparator.comparingInt(Hero::strength)).forEach(System.out::println);

/**
 *  comparingInt 接收一个 key 提取器（说明按对象中哪部分来比较），返回一个比较器
 *  reversed 返回一个顺序相反的比较器
 *  thenComparingInt 接收一个 key 提取器，返回一个新比较器，新比较器在原有比较器结果相等时执行新的比较逻辑
 */
        heroStream.sorted(
                Comparator.comparingInt(Hero::strength)
                        .reversed()
                        .thenComparingInt (Hero::nameLength)
        ).forEach(System.out::println);
/**
 * 原理
 */
        heroStream.sorted((e, f) -> {
            int res =
                    ((Comparator<Hero>) (c, d) ->
                            ((Comparator<Hero>) (a, b) -> Integer.compare(a.strength(), b.strength()))
                                    .compare(d, c))
                            .compare(e, f);
            return (res == 0) ? Integer.compare(e.nameLength(), f.nameLength()) : res;
        }).forEach(System.out::println);



    }
}
