package com.fatninja.aoc.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    public static List<Integer> readIntegerListFromFile(String path) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(path));

        return lines.map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static List<Long> readLongListFromFile(String path) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(path));

        return lines.map(Long::valueOf)
                .collect(Collectors.toList());
    }

    public static List<String> readStringListFromFile(String path) throws IOException {
        return Files.lines(Paths.get(path)).collect(Collectors.toList());
    }
}
