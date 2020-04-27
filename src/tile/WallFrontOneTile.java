package tile;

import render.CollisionRenderableObject;
import render.RenderableObject;

public class WallFrontOneTile implements Tile {

    @Override
    public boolean equals(int colorRepresentation) {
        return 0xFFFF1500 == colorRepresentation;
    }

    @Override
    public RenderableObject create(int x, int y) {
        return new CollisionRenderableObject(x, y, 0,0, Tile.TILE_FRONT_WALL_1);
    }
}
