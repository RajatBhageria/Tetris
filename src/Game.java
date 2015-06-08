/**
 * CIS 120 HW10
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Game extends JFrame {

    JLabel status;
    
    /**
 	 * Constructor for the game
 	 * This Game actually is an instance of JFrame and
 	 * so sets its size, sets its title, 
 	 * adds the GameCourt
 	 * and adds it to the center of the JFrame. 
 	 */
    public Game() {

        status = new JLabel("Score: 0");
        setSize(210, 500);
        setTitle("Tetris by Rajat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(status, BorderLayout.SOUTH);
        
        board = new GameCourt(this);
        add(board, BorderLayout.CENTER);

        
        
        createMenu();
   }
   //Static instance of the GameCourt 
   private final GameCourt board;

   /**
	 * @return returns a JLabel of the status bar
	 */
   public JLabel getStatus() {
       return status;
   }
   
   /**
	 * The main method creates an instance of the game
	 * Sets the game to be visible and 
	 * makes sure that its location is not relative 
	 * to anything else. 
	 */
    public static void main(String[] args) {
         Game game = new Game();
         game.setVisible(true);

         game.setLocationRelativeTo(null);
       

    } 
	/**
	 * Creates the menu for the game
	 * This menu contains a 'File' button with 
	 * JMenuItems of Directions, A Play/Pause 
	 * and a New Game.
	 * This method is used in the main constructor for
	 * the game. 
	 */
    private void createMenu(){

        JMenuBar menuBar = new JMenuBar();
         JMenu fileMenu = new JMenu("File");
         
        JMenuItem newAction = new JMenuItem("New Game");
        newAction.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
            	
                 board.start();
            }
        });
        
        JMenuItem directionsAction = new JMenuItem("Directions");
        final String directions = "This is how to play Tetris by Rajat Bhageria\n"
        		+ "\n"
        		
        		+ "To start a new game, go to 'File' and then press 'New Game'\n"
        		+ "To pause a game, you can go to 'File' press 'Pause/Play'\n"
        		+ "To start a paused game, press 'Pause/Play' again\n"
        		+ "\n"
        		
        		+ "The 'Left Arrow Key' pushes the current block left\n"
        		+ "The 'Right Arrow Key' pushes the current block right\n"
        		+ "The 'Up Arrow Key' rotates the current block left\n"
        		+ "The 'Down Arrow Key' rotates the current block right\n"
        		+ "\n"
        		
        		+ "The score for your current game is shown right below the Game\n"
        		+ "If you press 'Space Bar' the falling block will drop down completely\n"
        		+ "If your blocks reach the top of the playing screen, press 'New Game' to play again!\n"
        		+ "Be aware though: as you clear more lines, the minos speed up!\n"
        		+ "HAVE FUN!!!";
        
        directionsAction.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	
            JOptionPane.showMessageDialog(null, directions);
            
    		}
    	});
        
        JMenuItem pauseAction = new JMenuItem("Pause/Play");
         pauseAction.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        	 
        	board.pause();
        	}
    	});
      
        fileMenu.add(newAction);
        fileMenu.add(directionsAction);
        fileMenu.add(pauseAction);
        
        
        menuBar.add(fileMenu);
        add(menuBar, BorderLayout.NORTH);

        this.setJMenuBar(menuBar);
    }
    
}

