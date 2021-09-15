package com.fatninja.aoc.d13.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = FileUtils.readStringListFromFile("src/resources/d13/input.txt");

        String schedule = inputLines.get(1);
        String[] busArray = schedule.split(",");

        long prod = getTotalProd(busArray);
        long sum = 0;
        for (int i = 0; i < busArray.length; i++) {
            if ("x".equals(busArray[i])) {
                continue;
            }

            int busNumber = Integer.parseInt(busArray[i]);
            int mod = absMod(busNumber - i, busNumber);
            long diff = prod / busNumber;
            int inverse = getInverse(diff, busNumber);

            sum += mod * diff * inverse;
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

    private static int absMod(int a, int b) {
        return ((a % b) + b) % b;
    }

    private static int getInverse(long nU, int cur) {
        long b = nU % cur;
        for (int i = 1; i < cur; i++) {
            if ((b * i) % cur == 1) {
                return i;
            }
        }

        return 1;
    }
}
