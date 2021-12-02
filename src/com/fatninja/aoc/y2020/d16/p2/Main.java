package com.fatninja.aoc.y2020.d16.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Map<Integer, List<String>> intervals = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readStringListFromFile("src/resources/y2020/d16/input.txt");
        List<String> validTickets = new ArrayList<>();
        List<Integer> myTicket = new ArrayList<>();
        boolean otherTickets = false;
        String line;
        for (int i = 0; i < lines.size(); i++) {
            line = lines.get(i);
            if ("".equals(line)) {
                continue;
            }

            if (line.contains("your")) {
                String[] numbers = lines.get(i + 1).split(",");
                for (String number : numbers) {
                    myTicket.add(Integer.valueOf(number));
                }
            } else if (line.contains("or")) {
                updateIntervals(line);
            } else if (line.contains("nearby")) {
                otherTickets = true;
            } else {
                if (!otherTickets) {
                    continue;
                }
                if (isValidTicket(line)) {
                    validTickets.add(line);
                }
            }
        }

        int[][] allTicketsConfiguration = new int[validTickets.size()][validTickets.get(0).split(",").length];
        int row = 0;
        int col;
        for (String ticket : validTickets) {
            col = 0;

            String[] numbers = ticket.split(",");
            for (String number : numbers) {
                allTicketsConfiguration[row][col++] = Integer.parseInt(number);
            }
            row++;
        }

        String[] discoveredProperties = new String[allTicketsConfiguration[0].length];
        List<String> properties = new ArrayList<>();

        while (isNotFull(discoveredProperties)) {
            for (int j = 0; j < allTicketsConfiguration[0].length; j++) {
                if (discoveredProperties[j] != null) {
                    continue;
                }

                properties.clear();
                for (int[] ticket : allTicketsConfiguration) {
                    properties = intersection(properties, intervals.get(ticket[j]));
                }

                if (properties.size() > 1) {
                    properties.removeAll(intersection(properties, Arrays.asList(discoveredProperties)));
                }

                if (properties.size() == 1) {
                    discoveredProperties[j] = properties.get(0);
                }
            }
        }

        long prod = 1;
        for (int i = 0; i < discoveredProperties.length; i++) {
            if (discoveredProperties[i].contains("departure")) {
                prod *= myTicket.get(i);
            }
        }

        System.out.println(prod);

    }

    private static boolean isValidTicket(String line) {
        String[] numbers = line.split(",");
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (intervals.get(num) == null) {
                return false;
            }
        }

        return true;
    }

    private static boolean isNotFull(String[] taken) {
        for (String s : taken) {
            if (s == null) {
                return true;
            }
        }
        return false;
    }

    private static void updateIntervals(String line) {
        String property = getProperty(line);
        String[] components = line.split(" ");

        for (String component : components) {
            if (component.contains("-")) {
                String[] boundaries = component.split("-");
                int lowerBoundary = Integer.parseInt(boundaries[0]);
                int upperBoundary = Integer.parseInt(boundaries[1]);

                for (int i = lowerBoundary; i <= upperBoundary; i++) {
                    intervals.computeIfAbsent(i, k -> new ArrayList<>());
                    intervals.get(i).add(property);
                }
            }
        }
    }

    private static String getProperty(String line) {
        String[] components = line.split(":");

        return components[0];
    }

    private static List<String> intersection(List<String> one, List<String> other) {
        if (one.isEmpty()) {
            return other;
        }

        if (other.isEmpty()) {
            return one;
        }

        return one.stream()
                .filter(other::contains).distinct()
                .collect(Collectors.toList());
    }
}
