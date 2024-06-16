package stream;

import java.util.stream.Stream;

/**
 * @Author jpl
 * @date 2024/4/21&上午11:47
 */
public class FilterTest {

    /**
     * 过滤 filter
     *
     * @param args
     */
    public static void main(String[] args) {
        Stream.of(
                        new Fruit("草莓", "Strawberry", "浆果", "红色"),
                        new Fruit("桑葚", "Mulberry", "浆果", "紫色"),
                        new Fruit("杨梅", "Waxberry", "浆果", "红色"),
                        new Fruit("核桃", "Walnut", "坚果", "棕色"),
                        new Fruit("草莓", "Peanut", "坚果", "棕色"),
                        new Fruit("蓝莓", "Blueberry", "浆果", "蓝色")
                )
                //找到所有浆果
//                .filter(f -> f.category.equals("浆果"))
                //找到蓝色的浆果 方法1：
                .filter(f -> f.category().equals("浆果") && f.color().equals("蓝色"))
                //找到蓝色的浆果 方法2：让每个 lambda 只做一件事，两次 filter 相对于并且关系
//                .filter(f -> f.category.equals("浆果"))
//                .filter(f -> f.color().equals("蓝色"))
                .forEach(System.out::println);
    }

    record Fruit(String cname, String name, String category, String color) {
    }

}

