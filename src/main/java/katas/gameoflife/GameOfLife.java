package katas.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
	public int gridXSize;
	public int gridYSize;
	public Cell[][] grid;
	public List<Cell> cells;

	public GameOfLife(int gridXSize, int gridYSize) {
		this.cells = new ArrayList<>();
		this.grid = new Cell[gridXSize][gridYSize];
		this.gridXSize = gridXSize;
		this.gridYSize = gridYSize;
	}

	public void addCell(Cell cell){
		this.grid[cell.xPos][cell.yPos] = cell;
		this.cells.add(cell);
	}

	public void addCells(List<Cell> cells){
		for (Cell cell: cells) {
			this.grid[cell.xPos][cell.yPos] = cell;
		}

		this.cells.addAll(cells);
	}

	public void tick(){
		for (Cell cell: cells) {
			cell.tick(checkNeighbours(cell));
		}
	}

	public int checkNeighbours(Cell cell){
		int neighbourCount = 0;
		if(checkCellForAliveNeighbour(cell.xPos+1, cell.yPos)) neighbourCount ++;
		if(checkCellForAliveNeighbour(cell.xPos, cell.yPos+1)) neighbourCount ++;
		if(checkCellForAliveNeighbour(cell.xPos-1, cell.yPos)) neighbourCount ++;
		if(checkCellForAliveNeighbour(cell.xPos, cell.yPos-1)) neighbourCount ++;

		return neighbourCount;
	}

	private boolean checkCellForAliveNeighbour(int xPos, int yPos) {
		if(xPos <= gridXSize && yPos <= gridYSize &&grid[xPos][yPos] != null) {
			Cell neighbour = grid[xPos][yPos];
			return neighbour.isAlive;
		}
		return false;
	}
}
