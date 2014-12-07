import java.util.Random;


public class Shape {

	enum Mino {LONG, BLOCK, MIDDLE, RTAIL, LTAIL, LSTAIR, RSTAIR, NONE};
	
	public Shape()
	{
		setShape(Mino.NONE);
		
		//Set the array of a piece to be 4 points, each with an x,y
		coord = new int[4][2];
		
	}
	
	private Mino curr;
	private int coord[][];
	private int [][][] coordsT = new int[][][] {
			{{0,0}, {0,0}, {0,0}, {0,0}}, //NONE Mino
			{{0,-1}, {0,0}, {-1,0}, {-1,1}}, //LSTAIR Mino
			{{0,-1}, {0,0}, {1,0}, {1,1}}, //RSTAIR Mino
			{{0,-1}, {0,0}, {0,1}, {0,2}}, //LONG Mino
			{{-1,0}, {0,0}, {1,0}, {0,1}}, //MIDDLE Mino
			{{0,0}, {1,0}, {0,1}, {1,1}}, //BLOCK Mino
			{{-1,-1}, {0,-1}, {0,0}, {0,1}}, //RTAIL Mino
			{{1,-1}, {0,-1}, {0,0}, {0,1}} //LTAIL Mino
	};
	
	public void setShape(Mino shape)
	{
		for (int i = 0; i < 4; i ++)
		{
			for (int j =0; j < 2; j++)
			{
				coord[i][j] = coordsT[shape.ordinal()][i][j];
			}
		}
		
		curr = shape;
	}
	
	public int getX(int i){
		return coord[i][0];
	}
	public int getY(int i){
		return coord[i][1];
	}
	
	public Mino getShape(){
		return curr;
	}
	
	public void setX(int i, int x){
		coord[i][0]=x;
	}
	
	public void setY(int i, int y){
		coord[i][1]=y;
	}
	
	public void setRandom()
	{
		Random random = new Random();
		int rand= Math.abs(random.nextInt()) % 7 +1;
		Mino[] minosArray = Mino.values();
		setShape(minosArray[rand]);
	}
	
	public int minX(){
		int x = coord[0][0];
		for (int i = 0; i < 4; i++){
			x = Math.min(x,coord[i][0]);
		}
		return x;
	}
	
	public int minY()
	{
		int x = coord[0][1];
		for (int i = 0; i < 4; i++){
			x = Math.min(x,coord[i][1]);
		}
		return x;
	}
	
	public Shape rotateLeft()
	{	
		Shape tgt = new Shape();
		if (curr==Mino.BLOCK) return this;
		
		else{
			tgt.curr = curr;
			for (int i = 0 ; i < 4;++i)
			{
				tgt.setX(i, getY(i));
				tgt.setY(i, -getX(i));
			}
		}
		return tgt;
		
	}
	
	public Shape rotateRight()
	{
		Shape tgt = new Shape();
		if (curr==Mino.BLOCK) return this;
		else{
			tgt.curr = curr;
			for (int i = 0 ; i < 4;++i)
			{
				tgt.setX(i, -getY(i));
				tgt.setY(i, getX(i));
			}
		}
		return tgt;
	}
	
	
	
}
