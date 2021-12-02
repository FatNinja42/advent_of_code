package com.fatninja.aoc.y2020.d12.p1;

enum Orientation {
    N {
        @Override
        public Orientation turn(int degrees) {
            switch (degrees) {
                case 0:
                    return N;
                case 90:
                case -270:
                    return E;
                case 180:
                case -180:
                    return S;
                case 270:
                case -90:
                    return W;
            }
            return N;
        }
    },
    S {
        @Override
        public Orientation turn(int degrees) {
            switch (degrees) {
                case 0:
                    return S;
                case 90:
                case -270:
                    return W;
                case 180:
                case -180:
                    return N;
                case 270:
                case -90:
                    return E;
            }
            return S;
        }
    },
    E {
        @Override
        public Orientation turn(int degrees) {
            switch (degrees) {
                case 0:
                    return E;
                case 90:
                case -270:
                    return S;
                case 180:
                case -180:
                    return W;
                case 270:
                case -90:
                    return N;
            }
            return E;
        }
    },
    W {
        @Override
        public Orientation turn(int degrees) {
            switch (degrees) {
                case 0:
                    return W;
                case 90:
                case -270:
                    return N;
                case 180:
                case -180:
                    return E;
                case 270:
                case -90:
                    return S;
            }
            return W;
        }
    };

    public abstract Orientation turn(int degrees);
}