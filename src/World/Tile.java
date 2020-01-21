package World;

import com.teste.main.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static BufferedImage TILE_FLOOR_1 = Main.spriteSheet.getSprite(0, 0, 16, 16);
    public static BufferedImage TILE_FLOOR_2 = Main.spriteSheet.getSprite(16, 48, 16, 16);
    public static BufferedImage TILE_FRONT_WALL_1 = Main.spriteSheet.getSprite(16, 32, 16, 16);
    public static BufferedImage TILE_FRONT_WALL_2 = Main.spriteSheet.getSprite(0, 48, 16, 16);
    public static BufferedImage TILE_FRONT_WALL_3 = Main.spriteSheet.getSprite(32, 32, 16, 16);
    public static BufferedImage TILE_RIGHT_WALL = Main.spriteSheet.getSprite(32, 16, 16, 16);
    public static BufferedImage TILE_LEFT_WALL = Main.spriteSheet.getSprite(0, 32, 16, 16);
    public static BufferedImage TILE_DARK_WOODS = Main.spriteSheet.getSprite(16, 16, 16, 16);
    public static BufferedImage TILE_LIGHT_TREE = Main.spriteSheet.getSprite(0, 16, 16, 16);

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
