package com.fatninja.aoc.d4.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String COLOR_REGEX = "^#([a-f0-9]{6})$";
    private static final String ONLY_DIGITS_REGEX = "^[0-9]{9}$";

    private static final String[] REQUIRED_FIELDS = {
            "byr",
            "iyr",
            "eyr",
            "hgt",
            "hcl",
            "ecl",
            "pid"
    };

    private static final List<String> EYE_COLORS = Arrays.asList(
            "amb",
            "blu",
            "brn",
            "gry",
            "grn",
            "hzl",
            "oth"
    );

    public static void main(String[] args) throws IOException {
        int count = 0;
        List<String> lines = FileUtils.readStringListFromFile("src/resources/d4/input.txt");
        HashMap<String, String> passportDetails = new HashMap<>();

        for (String line : lines) {
            if (line.isBlank()) {
                if (isPassportValid(passportDetails)) {
                    count++;
                }
                passportDetails = new HashMap<>();
                continue;
            }

            String[] definitions = line.split(" ");
            for (String definition : definitions) {
                String[] components = definition.split(":");
                passportDetails.put(components[0], components[1]);
            }
        }

        if (isPassportValid(passportDetails)) {
            count++;
        }

        System.out.println(count);
    }

    private static boolean isPassportValid(HashMap<String, String> detailsMap) {
        if (!detailsMap.keySet().containsAll(Arrays.asList(REQUIRED_FIELDS))) {
            return false;
        }

        return isYearValid(detailsMap.get("byr"), 1920, 2002)
                && isYearValid(detailsMap.get("iyr"), 2010, 2020)
                && isYearValid(detailsMap.get("eyr"), 2020, 2030)
                && isHeightValid(detailsMap.get("hgt"))
                && isColorValid(detailsMap.get("hcl"))
                && isEyeColorValid(detailsMap.get("ecl"))
                && isPassportIdValid(detailsMap.get("pid")
        );
    }

    private static boolean isYearValid(String stringValue, int lowerBound, int upperBound) {
        int value = Integer.parseInt(stringValue);

        return value >= lowerBound && value <= upperBound;
    }

    private static boolean isHeightValid(String stringValue) {
        if (stringValue.length() < 3) {
            return false;
        }

        int value = Integer.parseInt(stringValue.substring(0, stringValue.length() - 2));

        if (stringValue.endsWith("cm")) {
            return value >= 150 && value <= 193;
        } else if (stringValue.endsWith("in")) {
            return value >= 59 && value <= 76;
        } else {
            return false;
        }
    }

    private static boolean isColorValid(String stringValue) {
        return stringValue.matches(COLOR_REGEX);
    }

    private static boolean isPassportIdValid(String stringValue) {
        return stringValue.matches(ONLY_DIGITS_REGEX);
    }

    private static boolean isEyeColorValid(String stringValue) {
        return EYE_COLORS.contains(stringValue);
    }
}
