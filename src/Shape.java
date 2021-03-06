import java.util.Random;
import java.lang.Math;

public class Shape {

    public enum Mino {NONE, Type1, Type2, Type3, 
               Type4, SQUARE, Type6, Type7 };
    private Shape.Mino curr;
    private int coord[][];
    private int[][][] coordT;

    /**
	 * Constructor
	 */
    public Shape() {
        coord = new int[4][2];
        setShape(Shape.Mino.NONE);
    }

    /**
	 * set the current Mino to the mino passed in
	 * @param Mino to change current mino to. 
	 */
    public void setShape(Shape.Mino shape) {
         coordT = new int[][][] {	 
			{{0,0}, {0,0}, {0,0}, {0,0}}, //NONE Mino
			{{0,-1}, {0,0}, {-1,0}, {-1,1}}, //LSTAIR Mino
			{{0,-1}, {0,0}, {1,0}, {1,1}}, //RSTAIR Mino
			{{0,-1}, {0,0}, {0,1}, {0,2}}, //LONG Mino
			{{-1,0}, {0,0}, {1,0}, {0,1}}, //MIDDLE Mino
			{{0,0}, {1,0}, {0,1}, {1,1}}, //BLOCK Mino
			{{-1,-1}, {0,-1}, {0,0}, {0,1}}, //RTAIL Mino
			{{1,-1}, {0,-1}, {0,0}, {0,1}} //LTAIL Mino
        };

        for (int i=0;i<4;i++) {
        	
             for (int j=0;j<2;++j) {
              coord[i][j] = coordT[shape.ordinal()][i][j];
            }
        }
        curr = shape;
    }

    /**
	 * Select a random mino type to set the current one to
	 */
    public void setRandom(){
         Random r = new Random();
         int x = Math.abs(r.nextInt()) % 7 + 1;
         
         Shape.Mino[] values = Shape.Mino.values(); 
         setShape(values[x]);
    }

    
    /**
	 * Create a new left rotation of the current mino
	 * @return Left rotated shape of the currnt mino
	 */
    public Shape rotateLeft() {
        if (curr == Shape.Mino.SQUARE) return this;
        Shape tgt = new Shape();
        tgt.curr = curr;

        for (int i=0;i<4;++i) {
        	
             tgt.setY(i, -getX(i));
            tgt.setX(i, getY(i));
        }
        
        return tgt;
    }
    
    /**
	 * Create a new right rotation of the current mino
	 * @return right rotated shape of the currnt mino
	 */
    public Shape rotateRight(){
        if (curr == Shape.Mino.SQUARE) return this;
        Shape tgt = new Shape();
        
        tgt.curr = curr;
 
        for (int i=0;i< 4;++i) {
             tgt.setY(i,getX(i));
             
            tgt.setX(i,-getY(i));
        }
        return tgt;
    }

    /**
	 * Changes x value of index to new value
	 * @param index to change x value of 
	 * @param x value of changed value
	 */
    private void setX(int index, int x) {
    	
    	coord[index][0] = x; 
    }
    
    /**
	 * Changes y value of index to new value
	 * @param index to change y value of 
	 * @param y value of changed value
	 */
    private void setY(int index, int y) {
    	coord[index][1] = y; 
    }
    
    /**
	 * Gets the value of x in the index of the array
	 * @param index of a type of mino in array
	 */
    public int getX(int index) {
    	return coord[index][0];
    }
    
    /**
	 * Gets the value of y in the index of the array
	 * @param index of a type of mino in array
	 */
    public int getY(int index) {
    	return coord[index][1]; 
    }
    
    
    /**
	 * Find the minimum x value of the current Mino
	 * @return minimum x value of current Mino
	 */
    public int minX(){
      int x = coord[0][0];
       
      for (int i=0; i<4; i++) {
    	   
           x = Math.min(x, coord[i][0]);
      }
      return x;
    }

    /**
	 * Find the minimum y value of the current Mino
	 * @return minimum y value of current Mino
	 */
    public int minY() {
      int y = coord[0][1];
      
       for (int i=0; i < 4; i++) {
           
    	  y = Math.min(y, coord[i][1]);
      }
      return y;
    }
    /**
     * Get the type of mino of the current mino
     * @return current Mino type 
	 */
    public Shape.Mino getShape()  {
    	return curr; 
    }
}