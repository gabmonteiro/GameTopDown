package render;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class RenderableObject {

    private int x;
    private int y;
    private int width;
    private int height;

    private BufferedImage sprite;

    public RenderableObject(int x, int y, int width, int height, BufferedImage sprite) {
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

    protected BufferedImage getSprite() {
        return sprite;
    }

    abstract public void render(Graphics g);
}
