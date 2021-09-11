package com.fatninja.aoc.d9.p1;

import java.io.IOException;
import java.util.List;

import static com.fatninja.aoc.utils.FileUtils.readLongListFromFile;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Long> numbers = readLongListFromFile("src/resources/d9/p1/input.txt");
        int preamble = 25;

        for (int i = preamble; i < numbers.size(); i++) {
            Long numberToVerify = numbers.get(i);

            if (!verifyNumberCanBeSummedInPreamble(i - preamble, i - 1, numbers, numberToVerify)) {
                System.out.println(numberToVerify);
                return;
            }
        }
    }

    static boolean verifyNumberCanBeSummedInPreamble(int startIndex, int endIndex, List<Long> numbers, long sum) {
        for (int i = startIndex; i < endIndex; i++) {
            for (int j = i + 1; j <= endIndex; j++) {
                if (numbers.get(i) + numbers.get(j) == sum) {
                    return true;
                }
            }
        }

        return false;
    }
}
