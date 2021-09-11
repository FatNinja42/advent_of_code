package com.fatninja.aoc.d3.p2;

import com.fatninja.aoc.utils.MatrixUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        char[][] map = MatrixUtils.readCharMatrixFromFile("src/resources/d3/input.txt");

        int noOfTrees1 = getNoOfTrees(map, 1, 1);
        int noOfTrees2 = getNoOfTrees(map, 1, 3);
        int noOfTrees3 = getNoOfTrees(map, 1, 5);
        int noOfTrees4 = getNoOfTrees(map, 1, 7);
        int noOfTrees5 = getNoOfTrees(map, 2, 1);

        System.out.println(noOfTrees1 * noOfTrees2 * noOfTrees3 * noOfTrees4 * noOfTrees5);
    }

    private static int getNoOfTrees(char[][] map, int down, int right) {
        int rows = map.length - 1;
        int colls = map[0].length - 1;

        int currentRow = 0;
        int currentCol = 0;

        int trees = 0;
        while (currentRow <= rows) {
            if (currentCol > colls) {
                currentCol = currentCol - colls - 1;
            }

            if (map[currentRow][currentCol] == '#') {
                trees++;
            }

            currentRow += down;
            currentCol += right;
        }

        return trees;
    }
}
