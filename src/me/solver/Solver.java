package me.solver;

import me.solver.comp.Node;
import me.maze.utils.Tile;
import me.solver.utils.Direction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class Solver {

    public ArrayList<Node> openNodes = new ArrayList();
    public ArrayList<Node> closedNodes = new ArrayList();

    public ArrayList<Node> route = new ArrayList();

    public ArrayList<Tile> obstacles;

    public Node endNode;

    public final Tile startTile;
    public final Tile endTile;

    public final int width;
    public final int height;

    public Solver(int width, int height, Tile startTile, Tile endTile, ArrayList<Tile> obstacles) {
        this.width = width;
        this.height = height;

        this.startTile = startTile;
        this.endTile = endTile;

        this.obstacles = obstacles;

        openNodes.add(new Node(startTile, null));
    }

    public abstract Solver solve();

    public void expandNeighbours() {
        Node node = openNodes.remove(0);
        closedNodes.add(node);
        for (Direction direction : Direction.values()) {
            Tile temp = new Tile(node.getPosition().getX() + direction.dX, node.getPosition().getY() + direction.dY);
            if (!temp.isOutOfBoard(width, height) && !obstacles.contains(temp)) {
                Node tempNode = new Node(temp, node);
                if (tempNode.getPosition().equals(endTile)) {
                    endNode = tempNode;
                    break;
                }
                if (!openNodes.contains(tempNode) && !closedNodes.contains(tempNode)) {
                    openNodes.add(tempNode);
                }
            }
        }
    }

    public void backTrack() {
        if (endNode != null) {
            System.out.println("Found path");

            route.clear();
            Node latestParent = endNode;
            while (latestParent.getParent() != null) {
                latestParent = latestParent.getParent();
                route.add(latestParent);
            }
            Collections.reverse(route);
        } else {
            System.out.println("No path found");
        }
    }

    public void save(BufferedImage image, String out) throws Exception {
        for (Node node : route) {
            Tile tile = node.getPosition();
            System.out.println(tile.toString());
            Random random = new Random();
            image.setRGB(tile.getX(), tile.getY(), new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)).getRGB());
        }
        ImageIO.write(image, "jpg", new File(out + ".jpg"));
    }

}
