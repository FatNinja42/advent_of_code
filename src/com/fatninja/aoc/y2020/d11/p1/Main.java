package com.fatninja.aoc.y2020.d11.p1;

import java.io.IOException;

import static com.fatninja.aoc.utils.MatrixUtils.cloneMatrix;
import static com.fatninja.aoc.utils.MatrixUtils.readCharMatrixFromFile;

public class Main {

    public static void main(String[] args) throws IOException {
        char[][] configuration = readCharMatrixFromFile("src/resources/y2020/d11/input.txt");

        int noChanges;
        char[][] configurationCopy;

        do {
            noChanges = 0;
            configurationCopy = cloneMatrix(configuration);
            for (int i = 0; i < configuration.length; i++) {
                for (int j = 0; j < configuration[i].length; j++) {
                    int count = getCountOfOccupiedSeats(i, j, configurationCopy);

                    if (configuration[i][j] == 'L' && count == 0) {
                        configuration[i][j] = '#';
                        noChanges++;
                    } else if (configuration[i][j] == '#' && count >= 4) {
                        configuration[i][j] = 'L';
                        noChanges++;
                    }
                }
            }

        } while (noChanges != 0);

        int result = countOccupiedSeats(configuration);
        System.out.println(result);
    }

    private static int getCountOfOccupiedSeats(int i, int j, char[][] config) {
        int count = 0;

        count += isFull(i - 1, j - 1, config);
        count += isFull(i - 1, j, config);
        count += isFull(i - 1, j + 1, config);
        count += isFull(i, j - 1, config);
        count += isFull(i, j + 1, config);
        count += isFull(i + 1, j - 1, config);
        count += isFull(i + 1, j, config);
        count += isFull(i + 1, j + 1, config);

        return count;
    }

    private static int isFull(int row, int column, char[][] config) {
        if (row < 0 || column < 0 || row >= config.length || column >= config[0].length) {
            return 0;
        }

        return config[row][column] == '#' ? 1 : 0;
    }

    private static int countOccupiedSeats(char[][] config) {
        int count = 0;
        for (int i = 0; i < config.length; i++) {
            for (int j = 0; j < config[0].length; j++) {
                if (config[i][j] == '#') {
                    count++;
                }
            }
        }

        return count;
    }

}
