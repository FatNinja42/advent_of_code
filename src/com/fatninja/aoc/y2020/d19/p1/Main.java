package com.fatninja.aoc.y2020.d19.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.*;

public class Main {
    private static Map<String, List<List<String>>> ruleMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readStringListFromFile("src/resources/y2020/d19/input.txt");


        computeRuleMap(lines);
        for (Map.Entry<String, List<List<String>>> entry : ruleMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void computeRuleMap(List<String> rules) {
        for (String rule : rules) {
            String[] ruleComponents = rule.split(":");
            String ruleKey = ruleComponents[0];
            String ruleTo = ruleComponents[1].trim();

            String[] ruleToComponents = ruleTo.split("\\|");

            List<List<String>> ruleToList = new ArrayList<>();
            List<String> toList;
            for (String to : ruleToComponents) {
                toList = new ArrayList<>();
                String[] split = to.split(" ");
                for (String value : split) {
                    if (Arrays.asList("", "\"").contains(value)) {
                        continue;
                    }

                    toList.add(value);
                }
                ruleToList.add(toList);
            }

            ruleMap.put(ruleKey, ruleToList);
        }
    }
}
