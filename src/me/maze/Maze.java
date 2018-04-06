package me.maze;

import me.maze.utils.Tile;
import me.solver.Solver;
import me.solver.impl.AStar;
import me.solver.impl.Dijkstra;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Maze {

    private ArrayList<Tile> obstacles = new ArrayList();

    private final int width;
    private final int height;

    private Solver solver;

    private BufferedImage image;

    public Maze(String directory, Tile start, Tile end) throws Exception {

        File file = new File(directory);
        BufferedImage image = ImageIO.read(file);

        this.image = image;

        width = image.getWidth();
        height = image.getHeight();
        this.solver = new AStar(width, height, start, end, obstacles);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                if (new Color(image.getRGB(x, y)).getRGB() != -1) {
                    obstacles.add(new Tile(x, y));
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ArrayList<Tile> getObstacles() {
        return obstacles;
    }

    public void solveAndSave(String out) throws Exception {
        solver.solve();
        solver.save(image, out);
    }
}
