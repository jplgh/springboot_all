package stream;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * @Author jpl
 * @date 2024/4/21&上午11:47
 */
public class MapTest {

    /**
     * 映射 map
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
                .map(f -> f.cname() + "酱")
                .forEach(System.out::println);

    }



    record Fruit(String cname, String name, String category, String color) {
    }

}

