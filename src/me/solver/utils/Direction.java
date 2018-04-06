package me.solver.utils;

public enum Direction {

    LEFT(-1, 0), RIGHT(1, 0), UP(0, 1), DOWN(0, -1),
    TOPLEFT(-1, 1), TOPRIGHT(1, 1), BOTTOMLEFT(-1, -1), BOTTOMRIGHT(-1, 1);

    public int dX;
    public int dY;

    Direction(int dX, int dY) {
        this.dX = dX;
        this.dY = dY;
    }

}
