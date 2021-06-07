package com.fatninja.aoc.d1.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 2020;
        List<Integer> integers = FileUtils.readIntegerListFromFile("src/resources/d1/p1/input.txt");

        int[] result = getResult(integers, sum);

        System.out.println(result[0] * result[1] * result[2]);
    }

    private static int[] getResult(List<Integer> integers, int sum) {
        for (int i = 0; i < integers.size() - 3; i++) {
            for (int j = i + 1; j < integers.size() - 2; j++) {
                for (int k = j + 1; k < integers.size() - 1; k++) {
                    if (integers.get(i) + integers.get(j) + integers.get(k) == sum) {
                        return new int[]{integers.get(i), integers.get(j), integers.get(k)};
                    }
                }
            }
        }
        return new int[]{};
    }
}
