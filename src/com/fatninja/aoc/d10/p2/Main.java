package com.fatninja.aoc.d10.p2;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.fatninja.aoc.utils.FileUtils.readIntegerListFromFile;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> adapters = readIntegerListFromFile("src/resources/d10/input.txt");
        adapters.add(0);

        List<Integer> sortedAdapters = adapters.stream()
                .sorted()
                .collect(Collectors.toList());

        int maxAdapter = sortedAdapters.get(sortedAdapters.size() - 1) + 3;
        sortedAdapters.add(maxAdapter);

        long[] permutations = new long[maxAdapter + 1];
        permutations[0] = 1;

        for (Integer adapter : sortedAdapters) {
            for (int i = 1; i <= 3; i++) {
                if (sortedAdapters.contains(adapter + i)) {
                    permutations[adapter + i] += permutations[adapter];
                }
            }
        }

        System.out.println(permutations[maxAdapter]);
    }
}
