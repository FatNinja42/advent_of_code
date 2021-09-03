package com.fatninja.aoc.d5.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> codeList = FileUtils.readStringListFromFile("src/resources/d5/p1/input.txt");
        int maxValue = 908;
        int[] flagList = new int[maxValue + 1];

        for (String code : codeList) {
            String rowsCode = code.substring(0, 7);
            String colsCode = code.substring(7);

            int row = compute(rowsCode, 0, 127);
            int col = compute(colsCode, 0, 7);

            int id = row * 8 + col;
            flagList[id] = 1;
        }

        int myPosition = 0;
        for (int i = 1; i < maxValue; i++) {
            if (flagList[i - 1] != 0 && flagList[i] == 0 && flagList[i + 1] != 0) {
                myPosition = i;
                break;
            }
        }

        System.out.println(myPosition);
    }

    public static int compute(String code, int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            return upperBound;
        }

        char letter = code.charAt(0);
        if (shouldChooseFirstHalf(letter)) {
            return compute(code.substring(1), lowerBound, upperBound - ((upperBound - lowerBound) / 2 + 1));
        } else {
            return compute(code.substring(1), lowerBound + (upperBound - lowerBound) / 2 + 1, upperBound);
        }
    }

    private static boolean shouldChooseFirstHalf(char letter) {
        return letter == 'F' || letter == 'L';
    }
}
