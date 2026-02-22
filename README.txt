
COSC-111 Final Project -  Java Recreation of Piano Tiles
Tiffany Sun

Note: I would also like to express my gratitude and thanks to Professor Wu, who aided me in a part of player-interaction debugging.
________________________________________________________________________________________________________________________


GENERAL DESCRIPTION OF THE PROGRAM

The program is a Java recreation of Piano Tiles, a popular mobile game in the 2010s in which the player strategically presses the falling black tiles to play various songs. In this version, the player will press buttons corresponding to the positions of the black tiles near or on the playing line, aka the orange line. If the player presses the buttons too early or too late, the game will end. As the player correctly taps on the tiles, the score will be kept record of. When the score reaches certain numbers, the speed in which the tiles fall will increase, furthering the difficulty of the game.

There are a total of 8 files for the game:

- README.txt - Provides a general explanation and description of the program. You are reading this right now.
- Tile.java - Provides the properties and its accesses of a singular black tile. This includes the visualization and position of tile. The latter can be accessed in the main game file through several functions.
- Game.java - The main file that includes the programming for the game’s setup, mechanisms and loops. It is also the file that runs the game through the ‘main’ method.
- StdAudio.java](http://StdAudio.java) - API created by Princeton University, which provides static methods for playing, reading, and saving audio.
- StdDraw.java - API created by Princeton University, which provides static methods for drawing and visualizing animations and objects in the program.
- campanella.wav - Music file included in the game. Features La Campanella, performed by Rousseau.
- rushe.wav - Music file included in the game. Features Rush E, performed by Piano Present.
- HallofMountainKing.wav - Music file included in the game. Features E. Grieg Peer Gynt, Suite No. 1, Op. 46, performed by Dreaming Piano.

There will be keys and mouse interactions achieved by the API of StdDraw. The following possible interactions are below:

- “Z”: If there is black tile on the first column (the outer left column of the game platform), the button will allow the player to “tap” that tile.
- “X”: If there is black tile on the second column (the inner left column of the game platform), the button will allow the player to “tap” that tile.
- “.”: If there is black tile on the third column (the inner right column of the game platform), the button will allow the player to “tap” that tile.
- “/”: If there is black tile on the last column (the outer right column of the game platform), the button will allow the player to “tap” that tile.
- “q”: When the game ends, the player, given two choices, can quit the game entirely by pressing this button
- mouse-click anywhere on the screen: When the game ends, the player, given two choices, can replay the game.

The songs, which will be played in the background of the game through the utilization of StdAudio. The songs are sourced from the following:

- Performed by Dreaming Piano, E. Grieg Peer Gynt, Suite No. 1, Op. 46: In the Hall of the Mountain King, Arranged by Ginzburg, https://www.youtube.com/watch?v=OhnCNr3LYo8
- Performed by Piano Present, Rush E by Sheet Music Boss, https://www.youtube.com/watch?v=fox_5DQ8Hz8
- Performed by Rousseau, La Campanella, Arranged by Franz Liszt, https://www.youtube.com/watch?v=H1Dvg2MxQn8

NOTE: Do not refer here for programming explanations. Technical Explanations of functions, loops, recursions, and variables will be included as comments in the source code.


________________________________________________________________________________________________________________________

TIMELINE OF PROJECT

UPDATE 12/11/2024:
Functionalities Updated:
* Ensured only one note is affected for every key pressed.
* Cleaned up code for readability
* Added an assortment of songs, each credited in README.txt.

Progress:
* Completion in both debugging, programming, and visualizing the game!

______

UPDATE 12/06/2024
Functionalities Updated:
* Setup of the game, including consecutive spawns of tiles
* Score Board + Rules
* Added Music Functionality
* Added Keys Functionality
* Added Increasing Speed Functionality

Progress
* Ensure only one note is affected for every key pressed.
* Add credits for Rousseau, who played Flight of the Bumblebee,
  the background music for the game.
* Clean up code for readability
* Add various music selections(?)

_____

UPDATE 12/02/2024
Functionalities Established:
* Setup of the Piano Tiles Game, including spawn of tile
* Score Board
* Ending Scene of Game

Progress
* Adding Keys Functionalities
* Increasing Speed Functionality
* Adding Music Functionality

_____

