package me.solver.utils;

import me.maze.utils.Tile;

public class Cost {

    public static int manhattan(Tile a, Tile b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    public static double euclidean(Tile a, Tile b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

}
