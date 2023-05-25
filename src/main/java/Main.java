package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 4, 5, 1, 5, 4);

        //способ со стримом
        Map<Integer, Long> groupingByStreams = list.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(groupingByStreams);

        System.out.println("----------------");

        //способ с циклом
        System.out.println(groupingAndCountingList(list));

    }

    public static HashMap<Integer, Long> groupingAndCountingList(List<Integer> list) {
        HashMap<Integer, Long> map = new HashMap<>();

        for (Integer i : list) {
            map.merge(i, 1L, (k, v) -> ++v);
        }

        return map;
    }
}
