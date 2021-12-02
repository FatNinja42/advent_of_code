package com.fatninja.aoc.y2021.d2.p2;

public class Submarine {
    private int depth;
    private int poz;
    private int aim;

    public void increaseDepth(int value) {
        depth += aim * value;
    }

    public void increasePoz(int value) {
        poz += value;
    }

    public void increaseAim(int value) {
        aim += value;
    }

    @Override
    public String toString() {
        return "Submarine{" +
                "depth=" + depth +
                ", poz=" + poz +
                ", aim=" + aim +
                ", poz * depth =" + poz * depth +
                '}';
    }
}
