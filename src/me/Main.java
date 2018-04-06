package me;

import me.maze.Maze;
import me.maze.utils.Tile;

public class Main {

    public static final Tile endTile = new Tile(99, 0);

    public static void main(String[] args) throws Exception {
        String filePath = "./whiteSolved.jpg";
        new Maze(filePath, new Tile(0, 50), endTile).solveAndSave("./whiteSolved1.png");

    }
}
