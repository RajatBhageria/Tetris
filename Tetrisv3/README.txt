Tetris | By Rajat Bhageria 

Directions to play: 
	To start a new game, go to 'File' and then press 'New Game'
	To pause a game, you can go to 'File' press 'Pause/Play'
	To start a paused game, press 'Pause/Play' again

	The 'Left Arrow Key' pushes the current block left
	The 'Right Arrow Key' pushes the current block right
	The 'Up Arrow Key' rotates the current block left
	The 'Down Arrow Key' rotates the current block right

	The score for your current game is shown right below the Game
	If you press 'Space Bar' the falling block will drop down completely
	Pressing the 'd' key makes the current block fall down one line
	If your blocks reach the top of the playing screen, press 'New Game' to play 			again!
	Be aware though: as you clear more lines, the minos speed up!
	HAVE FUN!!!

Classes I created:

The main Game Class is where the game is really activated. The constructor constructs the game, the createMenu method creates the menu at the top of the game that allows the user to start a new game, pause/play the game, and gives the directions. 

The Shape class is where the individual Minos are created. Specifically, in the setShape method, I create a 3D array where I store the 7 different kinds of Minos. These are based completely on a Cartesian plane and each Mino is simply a line. Then, in the setRandom method I pick a random Mino (the first level of the 3D array) and return it so that in the getShape method, I can return it. I additionally have methods that allow me to rotate the current Mino left and right. This shape class gives the fundamental outline of the Minos that will be used in the GameCourt class.

This GameCourt is a representation of the Tetris court. This class actually extends JPanel and so the constructor actually sets its border, its background, starts a timer that decides how fast the Mino falls. In the constructor, I also create a Status bar that not only holds the score, but also lets the user know about what’s going on in the game. 