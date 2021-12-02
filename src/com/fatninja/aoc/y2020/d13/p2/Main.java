package com.fatninja.aoc.y2020.d13.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = FileUtils.readStringListFromFile("src/resources/y2020/d13/input.txt");

        String schedule = inputLines.get(1);
        String[] busArray = schedule.split(",");

        long prod = getTotalProd(busArray);

        long sum = 0;
        for (int i = 0; i < busArray.length; i++) {
            if ("x".equals(busArray[i])) {
                continue;
            }

            int busNumber = Integer.parseInt(busArray[i]);

            long Ni = prod / busNumber;
            int bi = (busNumber - i) % busNumber;
            int xi = getInverse(Ni, busNumber);

            sum += bi * Ni * xi;
        }

        System.out.println(sum % prod);
    }

    private static long getTotalProd(String[] busArray) {
        long prod = 1;
        for (String bus : busArray) {
            if ("x".equals(bus)) {
                continue;
            }

            prod *= Long.parseLong(bus);
        }

        return prod;
    }

    private static int getInverse(long diff, int number) {
        long b = diff % number;
        for (int i = 1; i < number; i++) {
            if ((b * i) % number == 1) {
                return i;
            }
        }

        return 1;
    }
}
