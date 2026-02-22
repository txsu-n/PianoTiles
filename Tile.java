
// Blueprint for black tiles.
public class Tile {

    private static final int columns = 4;
    private static final double tileHeight = .2;
    private double Yposition;
    private final int column;

    // Determines if a tile is visible or active.
    public boolean isShow = true;

    // Tile's position based on Y-coordinates and column.
    public Tile(int column) {
        this.column = column;
        this.Yposition = 1;
    }

    // Tile's visualization.
    public void DrawTile() {
        // If a tile is marked active and isn't pressed by the player,
        // the tile will be drawn.
        if(isShow) {
        StdDraw.setPenColor(StdDraw.BLACK);
        double xPos = (column + 0.5) * (1.0 / columns);
        StdDraw.filledRectangle(xPos, Yposition, 0.5 / columns, tileHeight / 2);}

    }

    // Accesses y position of tile
    public double getYposition(){
        return this.Yposition;
    }

    // Accesses the column of tile
    public int getColumns() {
        return this.column;
    }

    // Enables the tile to fall
    public void updatePosition(double speed) {
        this.Yposition -= speed;
    }

    // When a tile is marked as "hit," or pressed by player
    // tile will be marked as inactive and disappears
    public void hit() {
        this.isShow = false;
    }


}
