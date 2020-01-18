package Entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    private double x;
    private double y;
    private int width;
    private int height;

    private BufferedImage sprite;

    public Entity(int x, int y, int width, int height, BufferedImage sprite) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }



    public void setX(int newX) { this.x = newX; }

    public void setY(int newY) { this.y = newY; }

    public int getX() { return (int) x; }

    public int getY() {
        return (int) y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }



    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(sprite, getX(), getY(), null);
    }
}
