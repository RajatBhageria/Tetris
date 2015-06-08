Tetris | By Rajat Bhageria 
CIS 120 | UPenn

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
	If your blocks reach the top of the playing screen, press 'New Game' to play 			again!
	Be aware though: as you clear more lines, the minos speed up!
	HAVE FUN!!!

Classes I created:

The main Game Class is where the game is really activated. The constructor constructs the game, the createMenu method creates the menu at the top of the game that allows the user to start a new game, pause/play the game, and gives the directions. 

The Shape class is where the individual Minos are created. Specifically, in the setShape method, I create a 3D array where I store the 7 different kinds of Minos. These are based completely on a Cartesian plane and each Mino is simply a line. Then, in the setRandom method I pick a random Mino (the first level of the 3D array) and return it so that in the getShape method, I can return it. I additionally have methods that allow me to rotate the current Mino left and right. This shape class gives the fundamental outline of the Minos that will be used in the GameCourt class.

This GameCourt is a representation of the Tetris court. This class actually extends JPanel and so the constructor actually sets its border, its background, starts a timer that decides how fast the Mino falls. In the constructor, I also create a Status bar that not only holds the score, but also lets the user know about what’s going on in the game. After construction, there are methods to pause the game, to start the game, an an actionPreformed method (that simulates the basic functionality of making a piece keep falling one line down, or else creates a new piece). The shapeInArray method is used throughout this class and tells you what shape is located in the game board at a particular position. The paint method takes a Graphics2D parameter and uses it to paint and repaint the screen (for example, every time a particular Mino is falling to the floor of the Tetris board). The newPiece method chooses a random Mino type from the Shape class,  and sees if it is possible to add the new piece from the very top of the Tetris board, but if it cannot, the method stops the timer and says that the game has ended. The tryMove class is also used over and over throughout this class, and basically takes in a new Mino, and new coordinates to possible move the Mino to; then it takes the current coordinates and adds the values of the size of the new piece, and sees if the new coordinates be possible (it would not be possible if there is a older Mino in the way or if the new Mino would go outside of the board. Next, the removeFull method checks to see if there are any full lines that it can remove, and then removes them; it then repaints. The draw method is where the drawing of all the pieces occurs (and the color is added). And finally, the Adapter inner class has one method called keyPressed and takes in input from the user though keyboard. 

These classes work together in the following way: the Shape class is called by the GameCourt class to create a representation of a series of Minos on the board. And the main Game class calls the GameCourt class to create the court and start the actual class using the start() method.

This is the basic implementation of my game!
