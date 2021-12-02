package com.fatninja.aoc.y2020.d6.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> fileLines = FileUtils.readStringListFromFile("src/resources/y2020/d6/input.txt");

        int sum = 0;
        int groupCount = 0;
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (String line : fileLines) {
            if (line.isEmpty()) {
                sum += getQuestionCount(countMap, groupCount);
                countMap = new HashMap<>();
                groupCount = 0;
                continue;
            }

            char[] chars = line.toCharArray();
            for (char c : chars) {
                if (countMap.containsKey(c)) {
                    countMap.put(c, countMap.get(c) + 1);
                } else {
                    countMap.put(c, 1);
                }
            }
            groupCount++;
        }
        sum += getQuestionCount(countMap, groupCount);

        System.out.println(sum);
    }

    private static int getQuestionCount(HashMap<Character, Integer> countMap, int groupCount) {
        int count = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == groupCount) {
                count++;
            }
        }

        return count;
    }
}