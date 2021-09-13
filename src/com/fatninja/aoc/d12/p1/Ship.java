package com.fatninja.aoc.d12.p1;

class Ship {
    int posX;
    int posY;
    Orientation currentOrientation;

    public Ship(Orientation currentOrientation) {
        this.currentOrientation = currentOrientation;
    }

    public void move(int amount) {
        if (Orientation.N.equals(currentOrientation)) {
            this.posX += amount;
        } else if (Orientation.S.equals(currentOrientation)) {
            this.posX -= amount;
        } else if (Orientation.E.equals(currentOrientation)) {
            this.posY += amount;
        } else {
            this.posY -= amount;
        }
    }

    public void rotate(char direction, int degrees) {
        int amount = degrees % 360;

        if ('L' == (direction)) {
            amount *= -1;
        }

        currentOrientation = currentOrientation.turn(amount);
    }

    public void updatePosition(char orientationInstruction, int amount) {
        Orientation orientation = Orientation.valueOf(String.valueOf(orientationInstruction));

        if (Orientation.N.equals(orientation)) {
            this.posX += amount;
        } else if (Orientation.S.equals(orientation)) {
            this.posX -= amount;
        } else if (Orientation.E.equals(orientation)) {
            this.posY += amount;
        } else {
            this.posY -= amount;
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
