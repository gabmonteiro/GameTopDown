package tile;

import main.Main;
import render.RenderableObject;

import java.awt.image.BufferedImage;

public interface Tile {

    BufferedImage TILE_FLOOR_1 = Main.spriteSheet.getSprite(0, 0, 16, 16);
    BufferedImage TILE_FLOOR_2 = Main.spriteSheet.getSprite(16, 48, 16, 16);
    BufferedImage TILE_FRONT_WALL_1 = Main.spriteSheet.getSprite(16, 32, 16, 16);
    BufferedImage TILE_FRONT_WALL_2 = Main.spriteSheet.getSprite(0, 48, 16, 16);
    BufferedImage TILE_FRONT_WALL_3 = Main.spriteSheet.getSprite(32, 32, 16, 16);
    BufferedImage TILE_RIGHT_WALL = Main.spriteSheet.getSprite(32, 16, 16, 16);
    BufferedImage TILE_LEFT_WALL = Main.spriteSheet.getSprite(0, 32, 16, 16);
    BufferedImage TILE_DARK_WOODS = Main.spriteSheet.getSprite(16, 16, 16, 16);
    BufferedImage TILE_LIGHT_TREE = Main.spriteSheet.getSprite(0, 16, 16, 16);
    BufferedImage TILE_ROCK = Main.spriteSheet.getSprite(32, 48, 16, 16);
    BufferedImage TILE_DIRT_PATH = Main.spriteSheet.getSprite(16, 0, 16, 16);

    boolean equals(int colorRepresentation);
    RenderableObject create(int x, int y);
}
