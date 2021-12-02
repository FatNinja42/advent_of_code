package com.fatninja.aoc.y2020.d14.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> instructions = FileUtils.readStringListFromFile("src/resources/y2020/d14/input.txt");

        HashMap<Integer, Long> memory = new HashMap<>();
        String mask = "";
        for (String instruction : instructions) {
            String[] components = instruction.split("=");
            if (instruction.startsWith("mask")) {
                mask = components[1].trim();
                continue;
            }

            String keyString = components[0].substring(components[0].indexOf('[') + 1, components[0].lastIndexOf(']'));
            Long value = Long.valueOf(components[1].trim());

            long result = applyMaskToValue(value, mask);
            memory.put(Integer.parseInt(keyString), result);
        }

        Long sum = memory.values()
                .stream().mapToLong(Long::longValue)
                .sum();

        System.out.println(sum);
    }

    private static long applyMaskToValue(Long value, String mask) {
        String padding = "000000000000000000000000000000000000";
        String binaryValue = Long.toBinaryString(value);

        String binaryRepresentation = padding.substring(binaryValue.length()) + binaryValue;
        char[] binaryCharArray = binaryRepresentation.toCharArray();
        char[] maskCharArray = mask.toCharArray();

        for (int i = 0; i < mask.length(); i++) {
            if (maskCharArray[i] == 'X') {
                continue;
            }

            binaryCharArray[i] = maskCharArray[i];
        }

        return Long.parseLong(new String(binaryCharArray), 2);
    }
}
