package tile;

import render.AbstractRenderableObject;
import render.RenderableObject;

public class DarkWoodTile implements Tile {

    @Override
    public boolean equals(int colorRepresentation) {
        return 0xFFFFD800 == colorRepresentation;
    }

    @Override
    public RenderableObject create(int x, int y) {
        return new AbstractRenderableObject(x, y, 0,0, Tile.TILE_DARK_WOODS);
    }
}
