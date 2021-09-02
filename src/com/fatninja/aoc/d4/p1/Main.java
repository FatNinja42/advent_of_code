package com.fatninja.aoc.d4.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int count = 0;
        List<String> lines = FileUtils.readStringListFromFile("src/resources/d4/p1/input.txt");
        HashMap<String, String> passportDetails = new HashMap<>();

        for (String line : lines) {
            if (line.isBlank()) {
                if (isPassportValid(passportDetails)) {
                    count++;
                }
                passportDetails = new HashMap<>();
                continue;
            }

            String[] components = line.split(" ");
            for (String component : components) {
                String[] definition = component.split(":");
                passportDetails.put(definition[0], definition[1]);
            }
        }

        if (isPassportValid(passportDetails)) {
            count++;
        }

        System.out.println(count);
    }

    private static boolean isPassportValid(HashMap<String, String> detailsMap) {
        return detailsMap.keySet().containsAll(
                Arrays.asList(
                        "byr",
                        "iyr",
                        "eyr",
                        "hgt",
                        "hcl",
                        "ecl",
                        "pid"
                )
        );
    }
}
