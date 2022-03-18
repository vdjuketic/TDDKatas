package katas.gameoflife;


public class Cell {
	public int xPos;
	public int yPos;
	public boolean isAlive;

	public Cell(int xPos, int yPos, boolean isAlive) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.isAlive = isAlive;
	}

	public void tick(int neighbours){
		this.isAlive = neighbours >= 2 && neighbours <= 3;
	}
}
