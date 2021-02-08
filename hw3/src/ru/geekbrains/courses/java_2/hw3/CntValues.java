package ru.geekbrains.courses.java_2.hw3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CntValues {

    public static Map cntValues() {
        String[] arr = {"cat", "book", "dog", "table"};
        String[] arrRandom = new String[20];
        Random random = new Random();

        for (int i = 0; i < arrRandom.length; i++) {
            int num = random.nextInt(arr.length);
            arrRandom[i] = arr[num];
        }

        System.out.println(Arrays.toString(arrRandom));

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arrRandom.length; i++) {
            int cnt = map.getOrDefault(arrRandom[i], 0);
            map.put(arrRandom[i], cnt + 1);
        }
        return map;
    }
}
