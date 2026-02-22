import java.awt.*;
// Blueprint for Tile and its properties are in the Class Tile.

public class Game {
    // Moderating and Adjusting the speed in which the tiles falls.
    private static final double speedIncrease = 0.0001;
    public double tileSpeed = 0.01;

    // Keeps track of number of tiles correctly pressed
    public int score = 0;

    // Keeps track of number of tiles
    int tileCount = 0;

    // Initialization of an array of tiles.
    int initialSize = 2;
    private Tile[] gameTiles = new Tile[initialSize];

    // Arrays of keys to press the falling black tiles
    public static final char[] keys = {'z', 'x', '.', '/'};

    // Assortment of piano music sourced from Youtube
    public static final String[] music = {"HallofMountainKing.wav", "campanella.wav", "rushe.wav"};

    // Resets the game's progress for replay.
    private void reset() {
        // music (Grieg – In the Hall of the Mountain King, Campanella, and Rush E)
        StdAudio.playInBackground(music[(int)(Math.random()*3)]);


        score = 0;
        tileCount = 0;
        tileSpeed = 0.01;
        gameTiles = new Tile[initialSize];
        spawnTile();

    }


    // Main function that initiates and runs the game
    public static void main(String[] args) {
        Game game = new Game();
        game.gameStart();
    }

    public void spawnTile() {
        // Adjusts game tile array length if necessary
        if (tileCount >= gameTiles.length) {
            Tile[] expandedTiles = new Tile[gameTiles.length * 2];
            System.arraycopy(gameTiles, 0, expandedTiles, 0, gameTiles.length);
            gameTiles = expandedTiles;

        }

        int column = (int)((Math.random()*1000)%4);

        // Spawns tile from the top at random column
        gameTiles[tileCount++] = new Tile(column);
    }

    public Game () {

        // Set game canvas
        StdDraw.setPenColor(Color.black);
        StdDraw.setCanvasSize(400, 800);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.enableDoubleBuffering();


        // Spawns a tile.
        spawnTile();
    }

    // Function to increase speed of tiles falling.
    public void increaseSpeed() {
        this.tileSpeed += speedIncrease;
    }

    // Game loop
    public void gameStart() {
        // Enables the game to repeat as much as the player desires.
        reset();

        while (true)
        {
            StdDraw.clear();


            // Draws the tiles based on number of tiles in array.
            for (int i = 0; i < tileCount; i++) {
                gameTiles[i].DrawTile();
            }


            // Visualizing score and brief rules.
            StdDraw.setPenRadius(.05);
            StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
            StdDraw.line(0, .10, 1, .1);
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.filledRectangle(.5, .90, .5,.1 );
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.text(0.5, .95, "PIANO TILES");
            StdDraw.text(0.5, 0.90, "Score: " + score);
            StdDraw.text(0.5, 0.87, "Use keys 'Z', 'X', '.', & '/' to play!");
            StdDraw.text(0.5, 0.82, "Press the tiles at the orange line!");

            // Visualizing cue to guide the player to knowing which buttons to
            // press for which position of the tiles.
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(.100, .025, .13,.025 );
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(0.1, 0.025, "Z");
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(.375, .025, .13,.025 );
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(0.375, 0.025, "X");
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(.645, .025, .13,.025 );
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(0.645, 0.025, ".");
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(.92, .025, .13,.025 );
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(0.92, 0.025, "/");

            StdDraw.show();

            // Visualizing the animated falling of the tiles
            for (int i = 0; i < tileCount; i++) {
                gameTiles[i].updatePosition(tileSpeed);
            }

            // Checks and proceeds with action if a black tile is pressed correctly
            // by the player.
            tilePressedCorrectly();

            // Allows for Consecutive Tiles separated by some distance.
            if (tileCount == 0) {
                spawnTile();
            }
            if (gameTiles[tileCount-1].getYposition() < 0.77) {
                spawnTile();
            }

            // Falling of black tiles will increase in speed for every 15 pts
            if (score != 0 && score % 15 == 0) {
                increaseSpeed();
            }



            // Game will end if tile passes the playing line.
            for (int i = 0; i < tileCount; i++) {
                if (gameTiles[i].getYposition() < .15) {
                    endGame();
                    return;
                }

            }

            // Game's frame rate is 30.
            StdDraw.pause(30);

        }

    }


    // Function to vanish the tiles that are pressed correctly by the player.
    private void tilePressedCorrectly() {


        for (int i = 0; i < tileCount; i++) {

            // Only addresses the first tile in the array
            Tile tile = gameTiles[0];
            int column = tile.getColumns();

            // If the tile isn't visible or is inactive, no action will
            // be taken towards the tile. Loop proceeds to next tile.
            if (!tile.isShow) {
                continue;
            }

            // If a button is pressed, a variable will store that action.
            // If the tile in which the button is pressed for is far away from
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                    // the orange line or the player presses the wrong button, game ends.
                    if (tile.getYposition() > .25) {
                        PressedTooEarly();
                    }

                    // If the tile in which the button is pressed correctly for is near or
                    // on the orange line, the tile will be marked as hit and disappear.
                    if (key == (keys[column]) && (tile.getYposition() >= 0.15 && tile.getYposition() <= 0.25)) {
                    tile.hit();

                    // A score will increase by a unit
                    score++;

                    // Tiles array will adjust in response to the disappearance of that tile.
                    shiftTiles(i);
                    break;
                }

            }

        }

    }


    // Recursion that enables the
    // shifting of tiles to adjust for the removal of black tiles
    // that are tapped by the player.
    public void shiftTiles(int i) {
        if (i >= tileCount - 1) {
            gameTiles[--tileCount] = null;
            return;
        }
        gameTiles[i] = gameTiles[i + 1];
        shiftTiles(i + 1);
    }

    // Function for ending of a game.
    private void endGame() {
        // Visualizes end scene.
        StdAudio.stopInBackground();
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledRectangle(.5,.50,.4,.05);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.5, 0.52, "Game Over! Final score: " + score);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.text(0.5, 0.48, "Click to Retry or Press q to Exit Game");
        StdDraw.show();

        while (true) {
            // Allows player to replay by clicking the cursor anywhere on the
            // canvas.
            if (StdDraw.isMousePressed()) {
                gameStart();
                break;

                // Player can quit game (system) by pressing q.
            } else if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'q') {
                    System.exit(0);
                }
            }
            StdDraw.pause(30);
        }
    }

    // It is the same code as endGame() but text is altered in response to
    // player pressing tiles too early.
    private void PressedTooEarly() {
        StdAudio.stopInBackground();
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledRectangle(.5,.50,.4,.05);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.5, 0.52, "Pressed too early! Final score: " + score);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.text(0.5, 0.48, "Click to Retry or Press q to Exit Game");
        StdDraw.show();

        while (true) {
            if (StdDraw.isMousePressed()) {
                gameStart();
                break;
            } else if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'q') {
                    System.exit(0);
                }
            }
            StdDraw.pause(30);
        }
    }
}

