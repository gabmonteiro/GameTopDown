package render;

import main.Main;

import static render.World.TILE_SIZE;

public class Camera {
    public static int x;
    public static int y;

    public static void moveCamera(int playerX, int playerY) {
        int x = playerX - (Main.WIDTH / 2);
        int limitCameraX = World.WIDTH * TILE_SIZE - Main.WIDTH;
        if (x > 0 && x < limitCameraX) {
            Camera.x = x;
        }

        int y = playerY - (Main.HEIGHT / 2);
        int limitCameraY = World.HEIGHT * TILE_SIZE - Main.WIDTH;
        if (y > 0 && y < limitCameraY) {
            Camera.y = y;
        }
    }
}
