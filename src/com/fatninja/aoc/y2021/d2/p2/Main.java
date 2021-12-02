package com.fatninja.aoc.y2021.d2.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> instructions = FileUtils.readStringListFromFile("src/resources/y2021/d2/input.txt");

        Submarine submarine = new Submarine();
        applyInstructions(instructions, submarine);
        System.out.println(submarine);
    }

    private static void applyInstructions(List<String> instructions, Submarine submarine) {
        for (String instruction : instructions) {
            String[] components = instruction.split(" ");
            switch (components[0]) {
                case "forward":
                    submarine.increasePoz(Integer.parseInt(components[1]));
                    submarine.increaseDepth(Integer.parseInt(components[1]));
                    break;
                case "up":
                    submarine.increaseAim((-1) * Integer.parseInt(components[1]));
                    break;
                case "down":
                    submarine.increaseAim(Integer.parseInt(components[1]));
                    break;
            }
        }
    }
}
