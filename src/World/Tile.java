package World;

import com.teste.main.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static BufferedImage TILE_FLOOR = Main.spriteSheet.getSprite(0, 0, 16, 16);
    public static BufferedImage TILE_FRONT_WALL = Main.spriteSheet.getSprite(16, 32, 16, 16);
    public static BufferedImage TILE_RIGHT_WALL = Main.spriteSheet.getSprite(32, 16, 16, 16);
    public static BufferedImage TILE_LEFT_WALL = Main.spriteSheet.getSprite(0, 32, 16, 16);

    private BufferedImage sprite;
    private int x,y;

    public Tile(int x, int y, BufferedImage sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    public void render(Graphics g) {
        g.drawImage(sprite, x, y, null);
    }
}
