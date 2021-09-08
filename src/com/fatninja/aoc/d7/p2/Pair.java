package com.fatninja.aoc.d7.p2;

public final class Pair {
    private final String color;
    private final int howMany;

    public Pair(String color, int howMany) {
        this.howMany = howMany;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getHowMany() {
        return howMany;
    }
}
