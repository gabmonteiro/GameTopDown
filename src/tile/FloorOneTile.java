package tile;

import render.AbstractRenderableObject;
import render.RenderableObject;

public class FloorOneTile implements Tile {

    @Override
    public boolean equals(int colorRepresentation) {
        return  0xFF000000 == colorRepresentation ||
                0xFF1407FF == colorRepresentation || // player color
                0xFF4800FF == colorRepresentation || // municao
                0xFFFF8800 == colorRepresentation || // vida
                0xFFFF7F7F == colorRepresentation;   // inimigo
    }

    @Override
    public RenderableObject create(int x, int y) {
        return new AbstractRenderableObject(x, y, 0,0, Tile.TILE_FLOOR_1);
    }
}
