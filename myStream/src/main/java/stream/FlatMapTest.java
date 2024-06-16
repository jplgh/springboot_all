package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author jpl
 * @date 2024/4/21&上午11:47
 */
public class FlatMapTest {

    /**
     * 扁平化(降维) flatMap
     *
     * @param args
     */
    public static void main(String[] args) {
        Stream.of(
                        List.of(
                                new Fruit("草莓", "Strawberry", "浆果", "红色"),
                                new Fruit("桑葚", "Mulberry", "浆果", "紫色"),
                                new Fruit("杨梅", "Waxberry", "浆果", "红色"),
                                new Fruit("蓝莓", "Blueberry", "浆果", "蓝色")
                        ),
                        List.of(
                                new Fruit("核桃", "Walnut", "坚果", "棕色"),
                                new Fruit("草莓", "Peanut", "坚果", "棕色")
                        )
                )
//               这样把坚果和浆果两个集合变成了含六个元素的水果流
//               .flatMap(list->list.stream())  等效于   .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .forEach(System.out::println);

// 示例2
        Integer[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//    等效于(1)(2)
//        Stream.of(arr)
//                .flatMap(Stream::of)
//                .forEach(System.out::println);

//    (2)
        Arrays.stream(arr)
                .flatMap(a -> Arrays.stream(a))
                .forEach(System.out::println);


    }

    record Fruit(String cname, String name, String category, String color) {
    }

}

