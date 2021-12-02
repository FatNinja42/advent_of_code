package com.fatninja.aoc.y2020.d3.p1;

import com.fatninja.aoc.utils.MatrixUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        char[][] map = MatrixUtils.readCharMatrixFromFile("src/resources/y2020/d3/input.txt");

        int down = 1;
        int right = 3;
        int noOfTrees = getNoOfTrees(map, down, right);
        System.out.println(noOfTrees);
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
