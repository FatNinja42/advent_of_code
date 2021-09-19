package com.fatninja.aoc.d15.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main2 {
    private static final int P2_LIMIT = 30_000_000;

    public static void main(String[] args) throws IOException {
        List<Integer> integers = FileUtils.readCommaSeparatedIntListFromFile("src/resources/d15/input.txt");
        int[] occurrences = new int[100000000];

        int step = 0;
        for (Integer integer : integers) {
            occurrences[integer] = ++step;
        }
        int lastNumber = integers.get(step - 1);

        int occurrence;
        while (step < P2_LIMIT) {
            occurrence = occurrences[lastNumber];
            occurrences[lastNumber] = step;

            if (occurrence == 0) {
                lastNumber = 0;
            } else {
                lastNumber = step - occurrence;
            }

            step++;
        }

        System.out.println(lastNumber);
    }
}
