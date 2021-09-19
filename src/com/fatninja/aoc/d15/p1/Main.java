package com.fatninja.aoc.d15.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static int P1_LIMIT = 2020;
    private static int P2_LIMIT = 30_000_000;

    public static void main(String[] args) throws IOException {
        List<Integer> integers = FileUtils.readCommaSeparatedIntListFromFile("src/resources/d15/input.txt");
        Map<Integer, Integer> occurrences = new HashMap<>();

        int step = 0;
        for (Integer integer : integers) {
            occurrences.put(integer, ++step);
        }

        int lastNumber = integers.get(step - 1);

        while (step < P2_LIMIT) {
            Integer lastAppearance = occurrences.get(lastNumber);
            occurrences.put(lastNumber, step);

            if (lastAppearance == null) {
                lastNumber = 0;
            } else {
                lastNumber = step - lastAppearance;
            }
            step++;
        }

        System.out.println(lastNumber);
    }
}
