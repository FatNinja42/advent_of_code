package com.fatninja.aoc.d17.p1;

import java.util.Arrays;

public class Coordinate {
    public int[] position;

    public Coordinate(int x, int y, int z) {
        this.position = new int[]{x, y, z};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate coordinate1 = (Coordinate) o;
        return Arrays.equals(position, coordinate1.position);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(position);
    }
}
