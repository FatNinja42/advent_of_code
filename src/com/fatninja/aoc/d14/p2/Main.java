package com.fatninja.aoc.d14.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    static List<Long> addresses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> instructions = FileUtils.readStringListFromFile("src/resources/d14/input.txt");

        HashMap<Long, Long> memory = new HashMap<>();
        String mask = "";
        for (String instruction : instructions) {
            String[] components = instruction.split("=");
            if (instruction.startsWith("mask")) {
                mask = components[1].trim();
                continue;
            }

            String keyString = components[0].substring(components[0].indexOf('[') + 1, components[0].lastIndexOf(']'));
            Long value = Long.valueOf(components[1].trim());

            applyMaskToAddress(Integer.valueOf(keyString), mask);

            for (Long address : addresses) {
                memory.put(address, value);
            }
        }

        Long sum = memory.values()
                .stream().mapToLong(Long::longValue)
                .sum();

        System.out.println(sum);
    }

    private static void applyMaskToAddress(Integer value, String mask) {
        String padding = "000000000000000000000000000000000000";
        String binaryValue = Long.toBinaryString(value);

        String binaryRepresentation = padding.substring(binaryValue.length()) + binaryValue;
        char[] binaryCharArray = binaryRepresentation.toCharArray();
        char[] maskCharArray = mask.toCharArray();

        for (int i = 0; i < mask.length(); i++) {
            if (maskCharArray[i] == '0') {
                continue;
            }
            binaryCharArray[i] = maskCharArray[i];
        }

        addresses = new ArrayList<>();
        computeAdresses(new String(binaryCharArray));
    }

    private static void computeAdresses(String input) {
        int i = input.indexOf("X");

        if (i == -1) {
            addresses.add(Long.valueOf(input, 2));
            return;
        }

        computeAdresses(input.substring(0, i) + 0 + input.substring(i + 1));
        computeAdresses(input.substring(0, i) + 1 + input.substring(i + 1));
    }
}
