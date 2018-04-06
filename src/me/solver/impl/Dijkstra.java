package me.solver.impl;

import me.maze.utils.Tile;
import me.solver.Solver;

import java.util.ArrayList;

public class Dijkstra extends Solver {

    public Dijkstra(int width, int height, Tile start, Tile end, ArrayList<Tile> obstacles) {
        super(width, height, start, end, obstacles);
    }

    @Override
    public Solver solve() {
        while (endNode == null && !openNodes.isEmpty()) {
            expandNeighbours();
        }
        backTrack();
        return this;
    }
}
