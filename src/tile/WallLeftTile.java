package tile;

import render.CollisionRenderableObject;
import render.RenderableObject;

public class WallLeftTile implements Tile {

    @Override
    public boolean equals(int colorRepresentation) {
        return 0xFF2AFF00 == colorRepresentation;
    }

    @Override
    public RenderableObject create(int x, int y) {
        return new CollisionRenderableObject(x, y, 0,0, Tile.TILE_LEFT_WALL);
    }
}
