package com.fatninja.aoc.y2020.d17.p1;

import java.util.HashSet;
import java.util.List;

class Cube {
    private final int[] min = new int[]{
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE
    };
    private final int[] max = new int[]{
            Integer.MIN_VALUE,
            Integer.MIN_VALUE,
            Integer.MIN_VALUE
    };

    private HashSet<Coordinate> cube = new HashSet<>();

    public Cube(List<Coordinate> grid) {
        for (Coordinate coordinate : grid) {
            updateMinMax(coordinate);
            this.cube.add(coordinate);
        }
    }

    public void tick() {
        final HashSet<Coordinate> newCube = new HashSet<>();

        for (int x = min[0], maxX = this.max[0]; x <= maxX; x++) {
            for (int y = min[1], maxY = this.max[1]; y <= maxY; y++) {
                for (int z = min[2], maxZ = this.max[2]; z <= maxZ; z++) {
                    final Coordinate coordinate = new Coordinate(x, y, z);

                    final int neighbors = countNeighbors(coordinate);
                    final boolean isActive = this.cube.contains(coordinate);
                    if (isActive && (neighbors == 2 || neighbors == 3)) {
                        updateMinMax(coordinate);
                        newCube.add(coordinate);
                    } else if (!isActive && neighbors == 3) {
                        updateMinMax(coordinate);
                        newCube.add(coordinate);
                    }
                }
            }
        }

        this.cube = newCube;
    }

    private int countNeighbors(Coordinate coordinate) {
        int count = 0;

        int[] position = coordinate.position;
        for (int x = position[0] - 1; x <= position[0] + 1; x++) {
            for (int y = position[1] - 1; y <= position[1] + 1; y++) {
                for (int z = position[2] - 1; z <= position[2] + 1; z++) {
                    if (x == position[0] && y == position[1] && z == position[2]) {
                        continue;
                    }

                    count += this.cube.contains(new Coordinate(x, y, z)) ? 1 : 0;
                }
            }
        }

        return count;
    }


    private void updateMinMax(Coordinate coordinate) {
        for (int i = 0; i < 3; i++) {
            this.min[i] = Math.min(this.min[i], coordinate.position[i] - 1);
            this.max[i] = Math.max(this.max[i], coordinate.position[i] + 1);
        }
    }

    public int countActive() {
        return this.cube.size();
    }
}
