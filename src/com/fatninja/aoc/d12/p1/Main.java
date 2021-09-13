package com.fatninja.aoc.d12.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> directions = FileUtils.readStringListFromFile("src/resources/d12/input.txt");

        Ship ship = new Ship(Orientation.E);

        for (String direction : directions) {
            applyDirection(ship, direction);
        }

        System.out.println(ship.getPosX());
        System.out.println(ship.getPosY());

        System.out.println(Math.abs(ship.getPosX()) + Math.abs(ship.getPosY()));
    }

    private static void applyDirection(Ship ship, String direction) {
        char instruction = direction.charAt(0);
        int amount = Integer.parseInt(direction.substring(1));

        if ('F' == instruction) {
            ship.move(amount);
        } else if ('R' == instruction || 'L' == instruction) {
            ship.rotate(instruction, amount);
        } else {
            ship.updatePosition(instruction, amount);
        }
    }
}