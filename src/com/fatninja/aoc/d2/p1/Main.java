package com.fatninja.aoc.d2.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> policies = FileUtils.readStringListFromFile("src/resources/d2/input.txt");

        int result = checkNoOfValidPasswords(policies);

        System.out.println(result);
    }

    private static int checkNoOfValidPasswords(List<String> policies) {
        int count = 0;
        String split[];
        String password;
        String rule;
        char ch;
        int[] bounds;

        for (String policy : policies) {
            split = policy.split(":");
            password = split[1].trim();
            rule = split[0];

            ch = rule.charAt(rule.length() - 1);
            bounds = getBounds(rule);

            if (isPasswordValid(password, ch, bounds)) {
                count ++;
            }
        }

        return count;
    }

    private static boolean isPasswordValid(String password, char ch, int[] bounds) {
        long count = password.chars()
                .filter(c -> c == ch)
                .count();

        return count >= bounds[0] && count <= bounds[1];
    }

    private static int[] getBounds(String rule) {
        String[] split = rule.split(" ");
        String[] bounds = split[0].split("-");

        return new int[] {Integer.valueOf(bounds[0]), Integer.valueOf(bounds[1])};
    }
}
