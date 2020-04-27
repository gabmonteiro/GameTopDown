package util;

import render.WallTile;
import render.World;

import static render.World.TILE_SIZE;
import static render.World.tiles;

public class Colissions {

    public static boolean canMove(int xnext, int ynext) {
        int x1 = xnext / TILE_SIZE;
        int y1 = ynext / TILE_SIZE;

        int x2 = (xnext+ TILE_SIZE-1) / TILE_SIZE;
        int y2 = ynext / TILE_SIZE;

        int x3 = xnext / TILE_SIZE;
        int y3 = (ynext+TILE_SIZE-1) / TILE_SIZE;

        int x4 = (xnext+TILE_SIZE-1) / TILE_SIZE;
        int y4 = (ynext+TILE_SIZE-1) / TILE_SIZE;

        try {
            return !(tiles[x1 + (y1 * World.WIDTH)] instanceof WallTile ||
                    tiles[x2 + (y2 * World.WIDTH)] instanceof WallTile ||
                    tiles[x3 + (y3 * World.WIDTH)] instanceof WallTile ||
                    tiles[x4 + (y4 * World.WIDTH)] instanceof WallTile);
        } catch (Exception ex) {
            return false;
        }
    }
}
