package stream;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 化简
 *
 * @Author jpl
 * @date 2024/4/21&上午11:27
 */
public class ReduceTest {
    public static void main(String[] args) {

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
 * 化简：两两合并，只剩一个
 * 适合；最大值，最小值，求和，求个数........
 *  .reduce((p，x)->r)     p 上次合并后的结果，x 当前元素，r 返回值
 *  init 初始值
 *  .reduce(init,(p,x)->r)
 *  .reduce(init, (p,x)->r, (r1,r2)->r)
 */
//        Optional<Hero> reduce = heroStream.reduce((hero1, hero2) -> hero1.strength > hero2.strength ? hero1 : hero2);
//        System.out.println(reduce);
        /**
         * 初始值 init == new Hero("fff",2)
         */
//        Hero reduce1 = heroStream.reduce(new Hero("fff",2),(hero1, hero2) -> hero1.strength > hero2.strength ? hero1 : hero2);
//        System.out.println(reduce1);

//       求高手总数 heroStream.map(h->1） 映射为1，然后求和
//       System.out.println(heroStream.map(h->1).reduce(0,(a,b)->a+b));

        //求和
//        long count = heroStream.count();
//        System.out.println(count);
//         最大
//        System.out.println(heroStream.max(Comparator.comparingInt(Hero::strength)));
//         最小
//        System.out.println(heroStream.min(Comparator.comparingInt(Hero::strength)));
//         求和
//        System.out.println(heroStream.mapToInt(Hero::strength).sum());
//         求平均
        System.out.println(heroStream.mapToInt(Hero::strength).average());


    }
}


