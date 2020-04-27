package tile;

import render.AbstractRenderableObject;
import render.RenderableObject;

public class FloorTwoTile implements Tile {

    @Override
    public boolean equals(int colorRepresentation) {
        return 0xFF4C4C4C == colorRepresentation;
    }

    @Override
    public RenderableObject create(int x, int y) {
        return new AbstractRenderableObject(x, y, 0,0, Tile.TILE_FLOOR_2);
    }
}
