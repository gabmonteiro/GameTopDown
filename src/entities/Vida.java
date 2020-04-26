package entities;

import main.Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Vida extends Entity {

    private static BufferedImage LIFE_EN = Main.spriteSheet.getSprite(112, 0, 16, 16);

    public Vida(int x, int y, int width, int height) {
        super(x, y, width, height, LIFE_EN);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }


}
