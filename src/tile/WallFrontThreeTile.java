package tile;

import render.CollisionRenderableObject;
import render.RenderableObject;

public class WallFrontThreeTile implements Tile {

    @Override
    public boolean equals(int colorRepresentation) {
        return 0xFF910900 == colorRepresentation;
    }

    @Override
    public RenderableObject create(int x, int y) {
        return new CollisionRenderableObject(x, y, 0,0, Tile.TILE_FRONT_WALL_3);
    }
}
