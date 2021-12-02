package com.fatninja.aoc.y2020.d12.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> directions = FileUtils.readStringListFromFile("src/resources/y2020/d12/input.txt");

        Ship ship = new Ship();

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
            ship.getWaypoint().rotate(instruction, amount);
        } else {
            ship.updatePosition(instruction, amount);
        }
    }

    static class Ship {
        int posX;
        int posY;
        Waypoint waypoint = new Waypoint(10, 1);

        public void move(int amount) {
            this.posX += amount * waypoint.getPosX();
            this.posY += amount * waypoint.getPosY();
        }

        public void updatePosition(char orientation, int amount) {
            if ('N' == orientation) {
                this.getWaypoint().posY += amount;
            } else if ('S' == orientation) {
                this.getWaypoint().posY -= amount;
            } else if ('E' == orientation) {
                this.getWaypoint().posX += amount;
            } else {
                this.getWaypoint().posX -= amount;
            }
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }

        public Waypoint getWaypoint() {
            return this.waypoint;
        }
    }

    static class Waypoint {
        int posX;
        int posY;

        public Waypoint(int posX, int posY) {
            this.posX = posX;
            this.posY = posY;
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }

        public void rotate(char direction, int degrees) {
            int amount = degrees % 360;
            if ('L' == direction) {
                amount *= -1;
            }

            int aux;
            if (amount == 90 || amount == -270) {
                aux = posY;
                posY = -1 * posX;
                posX = aux;
            }

            if (amount == -90 || amount == 270) {
                aux = posY;
                posY = posX;
                posX = -1 * aux;
            }

            if (amount == 180 || amount == -180) {
                posY = -1 * posY;
                posX = -1 * posX;
            }
        }
    }
}