package me.solver.comp;

import me.Main;
import me.maze.utils.Tile;
import me.solver.utils.Cost;

public class Node {

    private Tile position;
    private Node parent;

    private double fCost = -1;
    private double gCost = -1;
    private double hCost = -1;

    public Node(Tile position, Node parent) {
        this.position = position;
        this.parent = parent;
    }

    public Tile getPosition() {
        return position;
    }

    public Node getParent() {
        return parent;
    }

    public double getgCost() {
        return gCost == -1 ? gCost = (parent == null ? 0 : parent.getgCost()) + 1 : gCost;
    }

    public double gethCost() {
        return hCost == -1 ? hCost = Cost.euclidean(position, Main.endTile) : hCost;
    }

    public double getfCost() {
        return fCost == -1 ? fCost = getgCost() + gethCost() : fCost;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Node ? ((Node) obj).getPosition().equals(getPosition()) : super.equals(obj);
    }
}
