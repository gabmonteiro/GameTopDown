package entities;

import main.Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Ammo extends Entity {

    private static BufferedImage sprite = Main.spriteSheet.getSprite(128, 0, 16, 16);

    public Ammo(int x, int y, int width, int height) {
        super(x, y, width, height, sprite);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
