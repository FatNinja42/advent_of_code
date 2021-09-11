package com.fatninja.aoc.d9.p2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.fatninja.aoc.utils.FileUtils.readLongListFromFile;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Long> numbers = readLongListFromFile("src/resources/d9/input.txt");
        int preamble = 25;
        long invalidNumber = 0;

        for (int i = preamble; i < numbers.size(); i++) {
            Long numberToVerify = numbers.get(i);

            if (!verifyNumberCanBeSummedInPreamble(i - preamble, i - 1, numbers, numberToVerify)) {
                invalidNumber = numberToVerify;
                break;
            }
        }

        long[] minAndMax = getMinAndMaxOfNumbersThatSum(numbers, preamble, invalidNumber);

        System.out.println(Arrays.toString(minAndMax));
        System.out.println(minAndMax[0] + minAndMax[1]);
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

    static long[] getMinAndMaxOfNumbersThatSum(List<Long> numberList, int preamble, long finalSum) {
        int index;
        long sum;
        long min;
        long max;

        long listNumber;
        for (int i = numberList.indexOf(finalSum) - 1; i >= preamble; i--) {
            index = i;

            sum = 0;
            min = finalSum;
            max = 0;
            while (sum < finalSum) {
                listNumber = numberList.get(index);
                if (listNumber > max) {
                    max = listNumber;
                }
                if (listNumber < min) {
                    min = listNumber;
                }

                sum += listNumber;
                index--;
            }

            if (sum == finalSum) {
                return new long[]{min, max};
            }
        }

        return new long[2];
    }
}