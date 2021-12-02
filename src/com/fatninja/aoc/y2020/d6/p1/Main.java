package com.fatninja.aoc.y2020.d6.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> fileLines = FileUtils.readStringListFromFile("src/resources/y2020/d6/input.txt");

        HashSet<Character> questionSet = new HashSet<>();
        int sum = 0;
        for (String line : fileLines) {
            if (line.isEmpty()) {
                sum += questionSet.size();
                questionSet = new HashSet<>();
            }

            char[] questions = line.toCharArray();
            for (char question : questions) {
                questionSet.add(question);
            }
        }
        sum += questionSet.size();

        System.out.println(sum);
    }
}