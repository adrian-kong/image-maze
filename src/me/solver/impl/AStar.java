package me.solver.impl;

import me.maze.utils.Tile;
import me.solver.Solver;
import me.solver.comp.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AStar extends Solver {

    public AStar(int width, int height, Tile start, Tile end, ArrayList<Tile> obstacles) {
        super(width, height, start, end, obstacles);
    }

    @Override
    public Solver solve() {
        while (endNode == null && !openNodes.isEmpty()) {
            Collections.sort(openNodes, Comparator.comparingDouble(Node::getfCost));
            expandNeighbours();
        }
        backTrack();
        return this;
    }
}
