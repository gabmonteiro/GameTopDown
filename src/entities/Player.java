package entities;

import main.Main;
import render.Camera;
import render.WallTile;
import render.World;
import util.Colissions;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import static render.World.TILE_SIZE;
import static render.World.tiles;

public class Player extends Entity {

    public boolean left,right,up,down;

    private enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    private Direction direction = Direction.DOWN;
    private double speed = 3;
    private int index = 0, frames = 0;
    private final int maxIndex = 4, maxFrames = 5;
    private boolean isMoving;
    private BufferedImage[] spriteMoveRight;
    private BufferedImage[] spriteMoveLeft;
    private BufferedImage[] spriteMoveUp;
    private BufferedImage[] spriteMoveDown;

    public Player(int x, int y, int width, int height, BufferedImage sprite) {
        super(x, y, width, height, sprite);

        spriteMoveRight = new BufferedImage[4];
        spriteMoveLeft = new BufferedImage[4];
        spriteMoveUp = new BufferedImage[4];
        spriteMoveDown = new BufferedImage[4];

        for(int i = 0; i < 4; i++) {
            spriteMoveRight[i] = Main.spriteSheet.getSprite(48 + (i*16), 0, 16, 16);
        }
        for(int i = 0; i < 4; i++) {
            spriteMoveLeft[i] = Main.spriteSheet.getSprite(48 + (i*16), 16, 16, 16);
        }
        for(int i = 0; i < 4; i++) {
            spriteMoveUp[i] = Main.spriteSheet.getSprite(48 + (i*16), 32, 16, 16);
        }
        for(int i = 0; i < 4; i++) {
            spriteMoveDown[i] = Main.spriteSheet.getSprite(48 + (i*16), 48, 16, 16);
        }
    }


    public void moveCima() {
        setY(getY() - speed);
        direction = Direction.UP;
        isMoving = true;
    }

    public void moveBaixo() {
        setY(getY() + speed);
        direction = Direction.DOWN;
        isMoving = true;
    }

    public void moveEsquerda() {
        setX(getX() - speed);
        direction = Direction.LEFT;
        isMoving = true;
    }

    public void moveDireita() {
        setX(getX() + speed);
        direction = Direction.RIGHT;
        isMoving = true;
    }

    @Override
    public void tick() {
        isMoving = false;

        if(up && Colissions.canMove(getX(), getY()-(int)speed)) moveCima();
        if(down && Colissions.canMove(getX(), getY()+(int)speed)) moveBaixo();
        if(left && Colissions.canMove(getX()-(int)speed, getY())) moveEsquerda();
        if(right && Colissions.canMove(getX()+(int)speed, getY())) moveDireita();

        if(isMoving) {
            frames++;
            if (frames >= maxFrames) {
                frames = 0;
                index++;
                if (index >= maxIndex)
                    index = 0;
            }
        }
    }


    @Override
    public void render(Graphics g) {
        switch (direction) {
            case UP:
                g.drawImage(spriteMoveUp[isMoving ? index : 0], this.getX() - Camera.x, this.getY() - Camera.y, null);
                break;
            case DOWN:
                g.drawImage(spriteMoveDown[isMoving ? index : 0], this.getX() - Camera.x, this.getY() - Camera.y, null);
                break;
            case RIGHT:
                g.drawImage(spriteMoveRight[isMoving ? index : 0], this.getX() - Camera.x, this.getY() - Camera.y, null);
                break;
            case LEFT:
                g.drawImage(spriteMoveLeft[isMoving ? index : 0], this.getX() - Camera.x, this.getY() - Camera.y, null);
        }
    }

}
