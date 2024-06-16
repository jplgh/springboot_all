package stream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author jpl
 * @date 2024/4/21&下午2:33
 */
public class CollectTest {
    public static void main(String[] args) {
        Stream<String> a = Stream.of("a", "b", "c", "d");
//       List<String> collect = a.collect(() -> new ArrayList<>(), (list, s) -> list.add(s), (list1, list2) -> {});
//        for (String s : collect) {
//            System.out.println(s);
//        }
        /**
         * 收集到List 集合
         */
//       List<String> collect2 = a.collect(ArrayList::new, ArrayList::add, (list1, list2) -> {});

//       List<String> collect = a.collect(Collectors.toList());
//        for (String s : collect2) {
//            System.out.println(s);
//        }

//        /**
//         * 收集到Set 集合
//         */
//        Set<String> collect3 = a.collect(LinkedHashSet::new, Set::add, (list1, list2) -> {});

//        Set<String> collect = a.collect(Collectors.toSet());

//        for (String s : collect3) {
//            System.out.println(s);
//        }

//        /**
//         * 收集到Map 集合
//         */
//        Map<String,Integer> collect4 = a.collect(HashMap::new, (map,x)->map.put(x,1),(e, b) -> {});

//        Map<String,Integer> map= a.collect(Collectors.toMap(x->x,x->1));
//        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
//            System.out.println(stringIntegerEntry.getKey()+" "+stringIntegerEntry.getValue());
//        }

        /**
         * Map
         *   new ArrayList(["FSDA","GDSFS","FSDFSA"])
         *   new ArrayList(["FSFDA","GSDDSFS","FSDFASFSA"])
         */

/**
 *  下游收集器
 */
//       分组
//        Map<Object, List<String>> map= a.collect(Collectors.groupingBy(String::length,Collectors.toList()));

//        Map<Object, String> map= a.collect(Collectors.groupingBy(String::length,Collectors.joining(",")));

//        collect4.forEach((k,v)-> System.out.println(k+" "+v));


        /**
         * 收集到StringBuilder
         */
//        StringBuilder collect4 = a.collect(StringBuilder::new,StringBuilder::append,(e, b) -> {});
//       String collect = a.collect(Collectors.joining());
//        System.out.println(collect4);

        /**
         * 收集到StringJoiner
         */
//        StringJoiner collect5 = a.collect(()->new StringJoiner(","),StringJoiner::add,(e, b) -> {});
//               String collect = a.collect(Collectors.joining(","));
//        System.out.println(collect5);


        record Hero(String name, int strength) {
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
         * mapping(x-y,dc) 需求：根据名字长度分组，分组后组内只保留他们的武力值
         */
//        Map<Integer, List<Integer>> collect = heroStream.collect(Collectors.groupingBy(x -> x.name.length(), Collectors.mapping(x -> x.strength, Collectors.toList())));
//        for (Map.Entry<Integer, List<Integer>> integerListEntry : collect.entrySet()) {
//            System.out.println(integerListEntry.getKey()+" "+integerListEntry.getValue());
//        }

        /**
         * filtering(x-boolean,dc) 需求：根据名字长度分组，分组后组内只保留武力值小于90的英雄
         * 在分组收集的过程中，执行过滤
         */
//        Map<Integer, List<Hero>> collect = heroStream.collect(Collectors.groupingBy(x -> x.name.length(), Collectors.filtering(x -> x.strength>=90, Collectors.toList())));

        /**
         * flatMapping(x-y,dc) 需求：根据名字长度分组，分组后组保留人名，并且人名分割成单个字符
         */

//       "我是中国人".chars().mapToObj(x->Character.toString(x)).forEach(System.out::println);

//        Map<Integer, List<String>> collect = heroStream.collect(Collectors.groupingBy(x -> x.name.length(), Collectors.flatMapping(x -> x.name.chars().mapToObj(Character::toString), Collectors.toList())));
//        for (Map.Entry<Integer, List<String>> integerListEntry : collect.entrySet()) {
//            System.out.println(integerListEntry.getKey()+" "+integerListEntry.getValue());
//        }

        /**
         * counting() 需求：根据名字长度，分组后求每组个数
         */
//        Map<Integer, Long> collect = heroStream.collect(Collectors.groupingBy(x -> x.name.length(), Collectors.counting()));
//        collect.entrySet().forEach(System.out::println);

        /**
         *  minBy((a,b)->int) 需求：根据名字长度，分组后求每组最小的武力值
         *  maxBy((a,b)->int) 需求：根据名字长度，分组后求每组最高的武力值
         */
//        Map<Integer, Optional<Hero>> collect = heroStream.collect(Collectors.groupingBy(x -> x.name.length(), Collectors.minBy(Comparator.comparing(Hero::strength))));
//        Map<Integer, Optional<Hero>> collect = heroStream.collect(Collectors.groupingBy(x -> x.name.length(), Collectors.maxBy(Comparator.comparing(Hero::strength))));
//        collect.entrySet().forEach(System.out::println);

        /**
         * summingInt(x->int) 需求：根据名字长度，求每组武力值的和
         * averagingDouble(x->int) 需求：根据名字长度，求每组武力值的平均值
         */
//        Map<Integer, Integer> collect = heroStream.collect(Collectors.groupingBy(x -> x.name.length(), Collectors.summingInt(c -> c.strength)));
//        Map<Integer, Double> collect = heroStream.collect(Collectors.groupingBy(x -> x.name.length(), Collectors.averagingDouble(c -> c.strength)));
//        collect.entrySet().forEach(System.out::println);

        /**
         * reducing(init,(p,x))
         */
        Map<Integer, Integer> collect = heroStream.collect(Collectors.groupingBy(x -> x.name.length(), Collectors.mapping(c -> c.strength(), Collectors.reducing(0, (p, x) -> p + x))));
        collect.entrySet().forEach(System.out::println);







    }
}
