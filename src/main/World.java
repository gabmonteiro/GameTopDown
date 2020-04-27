package main;

import entities.Ammo;
import entities.Enemy;
import entities.Life;
import render.Camera;
import render.RenderableObject;
import tile.TileFactory;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class World {

    public static RenderableObject[] tiles;
    public static int WIDTH, HEIGHT;
    public static final int TILE_SIZE = 16;
    private TileFactory tileFactory = TileFactory.of();

    public World(String path) {
        try {
            BufferedImage map = ImageIO.read(getClass().getResource(path));
            int[] pixels = new int[map.getWidth() * map.getHeight()];
            WIDTH = map.getWidth();
            HEIGHT = map.getHeight();
            tiles = new RenderableObject[map.getWidth() * map.getHeight()];
            map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());

            for(int xx = 0; xx < map.getWidth(); xx++) {
                for(int yy = 0; yy < map.getHeight(); yy++) {
                    int pixelAtual = pixels[xx + (yy * map.getWidth())];

                    tiles[xx + (yy * WIDTH)] = tileFactory.getByColor(pixelAtual).create(xx * 16, yy * 16);

                    //Player
                    if(pixelAtual == 0xFF1407FF) {
                        Main.player.setX(xx*16);
                        Main.player.setY(yy*16);
                    }
                    //Municao
                    else if(pixelAtual == 0xFF4800FF) {
                        Main.entities.add(new Ammo(xx*16, yy*16, 16, 16));
                    }
                    //Vida
                    else if(pixelAtual == 0xFFFF8800) {
                        Main.entities.add(new Life(xx*16, yy*16, 16, 16));

                    }
                    //inimigo
                    else if(pixelAtual == 0xFFFF7F7F) {
                        Main.entities.add(new Enemy(xx*16, yy*16, 16, 16));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {
        int xStart = Camera.x>>4;
        int yStart = Camera.y>>4;

        int xFinal = xStart + (Main.WIDTH >> 4);
        int yFinal = yStart + (Main.HEIGHT >> 4);

        for(int xx = xStart; xx <= xFinal; xx++) {
            for(int yy = yStart; yy <= yFinal; yy++) {
                if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT)
                    continue;
                RenderableObject renderableObject = tiles[xx + (yy * WIDTH)];
                renderableObject.render(g);
            }
        }
    }
}
