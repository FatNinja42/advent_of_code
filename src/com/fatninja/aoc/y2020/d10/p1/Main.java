package com.fatninja.aoc.y2020.d10.p1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.fatninja.aoc.utils.FileUtils.readIntegerListFromFile;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> adapters = readIntegerListFromFile("src/resources/y2020/d10/input.txt");
        int[] adapterDifferences = new int[4];

        List<Integer> sortedAdapters = adapters.stream()
                .sorted()
                .collect(Collectors.toList());

        int lastAdapter = 0;
        for (Integer adapter : sortedAdapters) {
            adapterDifferences[adapter - lastAdapter]++;
            lastAdapter = adapter;
        }
        adapterDifferences[3]++;

        System.out.println(Arrays.toString(adapterDifferences));
        System.out.println(adapterDifferences[1] * adapterDifferences[3]);
    }
}
