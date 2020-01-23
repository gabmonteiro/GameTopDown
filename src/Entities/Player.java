package Entities;

import com.teste.main.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    public boolean left,right,up,down;
    private int direcaoRight = 0,direcaoLeft = 1,direcaoUp = 2, direcaoDown =  3;
    private int direcao = direcaoRight;
    public double speed = 2.0;

    private int frames = 0, maxFrames = 5, index = 0, maxIndex = 4;
    private boolean moved;
    private BufferedImage[] rightPlayer;
    private BufferedImage[] leftPlayer;
    private BufferedImage[] upPlayer;
    private BufferedImage[] downPlayer;


    public Player(int x, int y, int width, int height, BufferedImage sprite) {
        super(x, y, width, height, sprite);

        rightPlayer = new BufferedImage[4];
        leftPlayer = new BufferedImage[4];
        upPlayer = new BufferedImage[4];
        downPlayer = new BufferedImage[4];

        for(int i = 0; i < 4; i++) {
            rightPlayer[i] = Main.spriteSheet.getSprite(48 + (i*16), 0, 16, 16);
        }
        for(int i = 0; i < 4; i++) {
            leftPlayer[i] = Main.spriteSheet.getSprite(48 + (i*16), 16, 16, 16);
        }
        for(int i = 0; i < 4; i++) {
            upPlayer[i] = Main.spriteSheet.getSprite(48 + (i*16), 32, 16, 16);
        }
        for(int i = 0; i < 4; i++) {
            downPlayer[i] = Main.spriteSheet.getSprite(48 + (i*16), 48, 16, 16);
        }
    }


    public void moveCima() {
        int result = (int) (getY() - speed);
        setY(result);
        direcao = direcaoUp;
        moved = true;
    }

    public void moveBaixo() {
        int result = (int) (getY() + speed);
        setY(result);
        direcao = direcaoDown;
        moved = true;
    }

    public void moveEsquerda() {
        int result = (int) (getX() - speed);
        setX(result);
        direcao = direcaoLeft;
        moved = true;
    }

    public void moveDireita() {
        int result = (int) (getX() + speed);
        setX(result);
        direcao = direcaoRight;
        moved = true;
    }


    public void tick() {
        moved = false;
        if(up) moveCima();
        if(down) moveBaixo();
    if(left) moveEsquerda();
    if(right) moveDireita();


        if(moved) {
            frames++;
            if(frames >= maxFrames) {
                frames = 0;
                index++;
                if(index >= maxIndex)
                    index = 0;
            }
        }
    }

    public void render(Graphics g) {
         if(direcao == direcaoUp) {
            g.drawImage(upPlayer[index], this.getX(), this.getY(), null);
        }else if(direcao == direcaoDown) {
            g.drawImage(downPlayer[index], this.getX(), this.getY(), null);
        }else if(direcao == direcaoRight) {
            g.drawImage(rightPlayer[index], this.getX(), this.getY(), null);
        }else if(direcao == direcaoLeft) {
            g.drawImage(leftPlayer[index], this.getX(), this.getY(), null);
        }

         if(moved == false) {
             if(direcao == direcaoRight) {
                 g.drawImage(rightPlayer[0], this.getX(), this.getY(), null);
             }else if(direcao == direcaoLeft) {
                 g.drawImage(leftPlayer[0], this.getX(), this.getY(), null);
             }else if(direcao == direcaoUp) {
                 g.drawImage(upPlayer[0], this.getX(), this.getY(), null);
             }else if(direcao == direcaoDown) {
                 g.drawImage(downPlayer[0], this.getX(), this.getY(), null);
             }
         }
    }

}
