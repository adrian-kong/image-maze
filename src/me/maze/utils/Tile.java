package me.maze.utils;

public class Tile {

    private int x;
    private int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOutOfBoard(int maxWidth, int maxHeight) {
        return x < 0 || y < 0 || x >= maxWidth || y >= maxHeight;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Tile ? ((Tile) obj).getX() == getX() && ((Tile) obj).getY() == getY() : super.equals(obj);
    }
}
