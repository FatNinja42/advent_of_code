package com.fatninja.aoc.y2020.d1.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        int sum = 2020;
        List<Integer> integers = FileUtils.readIntegerListFromFile("src/resources/y2020/d1/input.txt");

        int[] result = getResult(integers, sum);

        System.out.println(result[0] * result[1]);
    }

    private static int[] getResult(List<Integer> integers, int sum) {
        for (int i = 0; i < integers.size() - 1; i++) {
            for (int j = i; j < integers.size(); j++) {
                if (integers.get(i) + integers.get(j) == sum) {
                    return new int[]{integers.get(i), integers.get(j)};
                }
            }
        }
        return new int[]{};
    }
}
