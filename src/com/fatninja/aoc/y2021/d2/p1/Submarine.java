package com.fatninja.aoc.y2021.d2.p1;

public class Submarine {
    private int depth;
    private int poz;

    public Submarine(int depth, int poz) {
        this.depth = depth;
        this.poz = poz;
    }

    public void increaseDepth(int value) {
        depth += value;
    }

    public void increasePoz(int value) {
        poz += value;
    }

    @Override
    public String toString() {
        return "Submarine{" +
                "depth=" + depth +
                ", poz=" + poz +
                ", poz * depth =" + poz * depth +
                '}';
    }
}
