package com.fatninja.aoc.utils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MatrixUtils {

    public static char[][] readCharMatrixFromFile(String path) throws IOException {
        List<String> lines = Files.lines(Paths.get(path))
                .collect(toList());

        char[][] matrix = new char[lines.size()][lines.get(0).length()];
        int i = 0;
        for (String line : lines) {
            char[] chars = line.toCharArray();
            matrix[i++] = chars;
        }

        return matrix;
    }

    public static char[][] cloneMatrix(char[][] matrixToCopy) {
        char[][] clone = matrixToCopy.clone();

        for (int i = 0; i < matrixToCopy.length; i++) {
            clone[i] = matrixToCopy[i].clone();
        }

        return clone;
    }

    public static void printCharMatrix(char[][] matrix) {
        for (char[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(aMatrix[j]);
            }
            System.out.print("\n");
        }
    }
}
