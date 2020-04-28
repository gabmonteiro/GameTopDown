package entities;

import main.Main;
import render.Camera;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Vida extends Entity {

    private static BufferedImage sprite = Main.spriteSheet.getSprite(112, 0, 16, 16);

    public Vida(int x, int y, int width, int height) {
        super(x, y, width, height, sprite);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite, getX() - Camera.x, getY() - Camera.y, null);
    }


}