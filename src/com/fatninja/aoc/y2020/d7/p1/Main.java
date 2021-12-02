package com.fatninja.aoc.y2020.d7.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.*;

public class Main {

    private static final HashMap<String, List<String>> linkMap = new HashMap<>();
    private static boolean found = false;

    public static void main(String[] args) throws IOException {
        List<String> fileLines = FileUtils.readStringListFromFile("src/resources/y2020/d7/input.txt");

        for (String line : fileLines) {
            String[] rule = line.split("contain");
            String bagColor = rule[0].substring(0, rule[0].trim().lastIndexOf(" "));
            String contains = rule[1].trim();

            List<String> containedList = buildContainedList(contains);
            linkMap.put(bagColor, containedList);
        }

        int count = 0;
        for (String bag : linkMap.keySet()) {
            found = false;
            checkIfContainsShinyBag(bag);
            if (found) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void checkIfContainsShinyBag(String bag) {
        List<String> contained = linkMap.get(bag);
        if (contained.contains("shiny gold")) {
            found = true;
            return;
        }

        for (String containedBag : contained) {
            checkIfContainsShinyBag(containedBag);
        }
    }

    private static List<String> buildContainedList(String rule) {
        if (rule.equalsIgnoreCase("no other bags.")) {
            return Collections.emptyList();
        }

        List<String> containedList = new ArrayList<>();
        String[] split = rule.split(", ");

        for (String contained : split) {
            String color = contained.substring(contained.indexOf(" "), contained.lastIndexOf(" ")).trim();

            containedList.add(color);
        }

        return containedList;
    }
}
