package com.fatninja.aoc.y2020.d7.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.*;

public class Main {

    private static final HashMap<String, List<Pair>> linkMap = new HashMap<>();
    private static int finalSum = 0;

    public static void main(String[] args) throws IOException {
        List<String> fileLines = FileUtils.readStringListFromFile("src/resources/y2020/d7/input.txt");

        for (String line : fileLines) {
            String[] rule = line.split("contain");
            String bagColor = rule[0].substring(0, rule[0].trim().lastIndexOf(" "));
            String contains = rule[1].trim();

            List<Pair> containedList = buildContainedList(contains);
            linkMap.put(bagColor, containedList);
        }

        countContainedBags("shiny gold", 1);
        System.out.println(finalSum);
    }

    private static void countContainedBags(String bagColor, int multiplicative) {
        List<Pair> contained = linkMap.get(bagColor);
        if (contained.isEmpty()) {
            return;
        }

        for (Pair containedBag : contained) {
            int partialSum = multiplicative * containedBag.getHowMany();

            finalSum += partialSum;
            countContainedBags(containedBag.getColor(), partialSum);
        }
    }

    private static List<Pair> buildContainedList(String rule) {
        if (rule.equalsIgnoreCase("no other bags.")) {
            return Collections.emptyList();
        }

        List<Pair> containedList = new ArrayList<>();
        String[] split = rule.split(", ");

        for (String contained : split) {
            String color = contained.substring(contained.indexOf(" "), contained.lastIndexOf(" ")).trim();
            int howMany = Integer.parseInt(contained.substring(0, contained.indexOf(" ")));

            Pair pair = new Pair(color, howMany);
            containedList.add(pair);
        }

        return containedList;
    }

}
