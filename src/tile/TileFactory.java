package tile;

import java.util.stream.Stream;

public class TileFactory {

    private DarkWoodTile darkWoodTile = new DarkWoodTile();
    private DirtPathTile dirtPathTile = new DirtPathTile();
    private FloorOneTile floorOneTile = new FloorOneTile();
    private FloorTwoTile floorTwoTile = new FloorTwoTile();
    private LightTreeTile lightTreeTile = new LightTreeTile();
    private RockTile rockTile = new RockTile();
    private WallFrontOneTile wallFrontOneTile = new WallFrontOneTile();
    private WallFrontTwoTile wallFrontTwoTile = new WallFrontTwoTile();
    private WallFrontThreeTile wallFrontThreeTile = new WallFrontThreeTile();
    private WallLeftTile wallLeftTile = new WallLeftTile();
    private WallRightTile wallRightTile = new WallRightTile();

    private TileFactory() {}

    public static TileFactory of() {
        return new TileFactory();
    }

    public Tile getByColor(int colorRepresentation) {
        return Stream.of(darkWoodTile, dirtPathTile, floorOneTile, floorTwoTile, lightTreeTile, rockTile, wallFrontOneTile, wallFrontTwoTile, wallFrontThreeTile, wallLeftTile, wallRightTile)
        .filter(item -> item.equals(colorRepresentation))
        .findFirst()
        //.orElse(new FloorOneTile());
        .orElseThrow(() -> new RuntimeException("Tile '" + colorRepresentation + "' não mapeado ou conhecido!"));
    }
}
