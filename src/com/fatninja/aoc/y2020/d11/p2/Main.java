package com.fatninja.aoc.y2020.d11.p2;

import java.io.IOException;

import static com.fatninja.aoc.y2020.d11.p2.Main.Direction.*;
import static com.fatninja.aoc.utils.MatrixUtils.*;

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
                    } else if (configuration[i][j] == '#' && count >= 5) {
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
        count += checkFull(i - 1, j - 1, config, UP_LEFT);
        count += checkFull(i - 1, j, config, UP);
        count += checkFull(i - 1, j + 1, config, UP_RIGHT);
        count += checkFull(i, j - 1, config, LEFT);
        count += checkFull(i, j + 1, config, RIGHT);
        count += checkFull(i + 1, j - 1, config, DOWN_LEFT);
        count += checkFull(i + 1, j, config, DOWN);
        count += checkFull(i + 1, j + 1, config, DOWN_RIGHT);

        return count;
    }

    private static int checkFull(int i, int j, char[][] config, Direction direction) {
        int row = i;
        int col = j;

        if (row < 0 || col < 0 || row >= config.length || col >= config[0].length) {
            return 0;
        }

        switch (direction) {
            case UP:
                while (row > 0 && config[row][col] == '.') {
                    row--;
                }
                break;
            case DOWN:
                while (row < config.length - 1 && config[row][col] == '.') {
                    row++;
                }
                break;
            case LEFT:
                while (col > 0 && config[row][col] == '.') {
                    col--;
                }
                break;
            case RIGHT:
                while (col < config[0].length - 1 && config[row][col] == '.') {
                    col++;
                }
                break;
            case UP_LEFT:
                while (row > 0 && col > 0 && config[row][col] == '.') {
                    row--;
                    col--;
                }
                break;
            case UP_RIGHT:
                while (row > 0 && col < config[0].length - 1 && config[row][col] == '.') {
                    row--;
                    col++;
                }
                break;
            case DOWN_LEFT:
                while (row < config.length - 1 && col > 0 && config[row][col] == '.') {
                    row++;
                    col--;
                }
                break;
            case DOWN_RIGHT:
                while (row < config.length - 1 && col < config[0].length - 1 && config[row][col] == '.') {
                    row++;
                    col++;
                }
                break;
        }

        return config[row][col] == '#' ? 1 : 0;
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

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        UP_LEFT,
        UP_RIGHT,
        DOWN_LEFT,
        DOWN_RIGHT;
    }
}