package com.fatninja.aoc.y2020.d15.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final int P2_LIMIT = 30_000_000;

    /*
     * The implementation made for part 1 also works for part 2, but being implemented using hash tables
     * the execution time is way slower than this one.
     */
    public static void main(String[] args) throws IOException {
        List<Integer> integers = FileUtils.readCommaSeparatedIntListFromFile("src/resources/y2020/d15/input.txt");
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
