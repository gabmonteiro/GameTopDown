package entities;

import main.Main;
import render.Camera;
import util.Colissions;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy extends Entity {

    private double speed = 1;
    private int x = getX();
    private int y = getY();



    private static BufferedImage sprite = Main.spriteSheet.getSprite(144, 0, 16, 16);

    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height, sprite);
    }


    public void tick() {
    if(Main.player.getX() > x && Colissions.canMove(x+=speed, this.getY())) {x+=speed;}
    else if(Main.player.getX() < x && Colissions.canMove(x-=speed, this.getY())) {x-=speed;}
    if(Main.player.getY() > y && Colissions.canMove(this.getX(), y+=speed)) {y+=speed;}
    else if(Main.player.getY() < y && Colissions.canMove(this.getX(), y-=speed)) {y-=speed;}

    setX(x);
    setY(y);
    }


    public void render(Graphics g) {
        g.drawImage(sprite, getX() - Camera.x, getY() - Camera.y, null);
    }
}
