package com.fatninja.aoc.y2020.d16.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {

    static int[] intervals = new int[1000];

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readStringListFromFile("src/resources/y2020/d16/input.txt");

        boolean otherTickets = false;
        int sum = 0;
        for (String line : lines) {
            if ("".equals(line) || line.contains("your")) {
                continue;
            }

            if (line.contains("or")) {
                updateIntervals(line);
            } else if (line.contains("nearby")) {
                otherTickets = true;
            } else {
                if (!otherTickets) {
                    continue;
                }

                String[] numbers = line.split(",");
                for (String number : numbers) {
                    int num = Integer.parseInt(number);
                    if (intervals[num] == 0) {
                        sum += num;
                    }
                }
            }
        }

        System.out.println(sum);
    }

    private static void updateIntervals(String line) {
        String[] components = line.split(" ");

        for (String component : components) {
            if (component.contains("-")) {
                String[] boundaries = component.split("-");
                int lowerBoundary = Integer.parseInt(boundaries[0]);
                int upperBoundary = Integer.parseInt(boundaries[1]);

                for (int i = lowerBoundary; i <= upperBoundary; i++) {
                    intervals[i]++;
                }
            }
        }
    }
}
