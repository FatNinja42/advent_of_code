package com.fatninja.aoc.y2020.d17.p2;

import java.util.Arrays;

public class Coordinate {
    public int[] position;

    public Coordinate(int x, int y, int z, int w) {
        this.position = new int[]{x, y, z, w};
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
