package com.fatninja.aoc.d17.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final List<String> input = FileUtils.readStringListFromFile("src/resources/d17/input.txt");

        final List<Coordinate> activeCoordinates = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            final String line = input.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '#') {
                    activeCoordinates.add(new Coordinate(j, i, 0, 0));
                }
            }
        }

        Cube cube = new Cube(activeCoordinates);
        for (int i = 0; i < 6; i++) {
            cube.tick();
        }

        System.out.println(cube.countActive());
    }
}
