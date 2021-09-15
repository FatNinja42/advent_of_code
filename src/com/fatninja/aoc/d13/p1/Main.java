package com.fatninja.aoc.d13.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = FileUtils.readStringListFromFile("src/resources/d13/input.txt");

        int departure = Integer.parseInt(inputLines.get(0));
        String schedule = inputLines.get(1);

        String[] busArray = schedule.split(",");

        int min = Integer.MAX_VALUE;
        int busToTake = 0;
        int minutesToWait = 0;
        for (String bus : busArray) {
            if ("x".equals(bus)) {
                continue;
            }

            int busNumber = Integer.parseInt(bus);
            int num = (departure / busNumber + 1) * busNumber;

            if (num < min) {
                min = num;
                busToTake = busNumber;
                minutesToWait = min - departure;
            }
        }

        System.out.println(min);
        System.out.println(minutesToWait * busToTake);
    }
}
