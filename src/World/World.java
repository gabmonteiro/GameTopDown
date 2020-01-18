package World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class World {

    private Tile[] tiles;
    public static int WIDTH, HEIGHT;


    public World(String path) {
        try {

            BufferedImage map = ImageIO.read(getClass().getResource(path));
            int[] pixels = new int[map.getWidth() * map.getHeight()];
            WIDTH = map.getWidth();
            HEIGHT = map.getHeight();
            tiles = new Tile[map.getWidth() * map.getHeight()];
            map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());

            for(int xx = 0; xx < map.getWidth(); xx++) {
                for(int yy = 0; yy < map.getHeight(); yy++) {
                    int pixelAtual = pixels[xx + (yy * map.getWidth())];

                    if(pixelAtual == 0xFF000000) {
                        // chão
                        tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, xx*16, Tile.TILE_FLOOR);
                    }else if(pixelAtual == 0xFF278C00) {
                        //muro direita
                        tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, xx*16, Tile.TILE_RIGHT_WALL);
                    }else if(pixelAtual == 0xFF2AFF00) {
                        //muro esquerda
                        tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, xx*16, Tile.TILE_LEFT_WALL);
                    }else if(pixelAtual == 0xFFFF1500) {
                        //muro de cima
                        tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, xx*16, Tile.TILE_FRONT_WALL);
                    }else if(pixelAtual == 0xFF1407FF) {
                        //Player
                        tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, xx*16, Tile.TILE_FLOOR);
                    } else {
                        //chão
                        tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, xx*16, Tile.TILE_FLOOR);
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {
        for(int xx = 0; xx < WIDTH; xx++) {
            for(int yy = 0; yy < HEIGHT; yy++) {
                Tile tile = tiles[xx + (yy * WIDTH)];
                tile.render(g);
            }
        }
    }
}
