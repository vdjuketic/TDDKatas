package gameoflife;

import java.util.Arrays;

import katas.gameoflife.Cell;
import katas.gameoflife.GameOfLife;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
	Link -> https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

	Any live cell with fewer than two live neighbours dies, as if by underpopulation.
	Any live cell with two or three live neighbours lives on to the next generation.
	Any live cell with more than three live neighbours dies, as if by overpopulation.
	Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
*/

public class GameOfLifeTest {

	@Test
	void shouldReturn0When0NeighboursAroundCell(){
		Cell cell = new Cell(1,1,true);
		GameOfLife gameOfLife = new GameOfLife(5, 5);
		gameOfLife.addCell(cell);

		assertEquals(0, gameOfLife.checkNeighbours(cell));
	}

	@Test
	void shouldReturn1WhenOneNeighbourAroundCell(){
		Cell cellUnderTest = new Cell(1,1,true);
		Cell cell2 = new Cell(1,2,true);

		GameOfLife gameOfLife = new GameOfLife(5, 5);
		gameOfLife.addCell(cellUnderTest);
		gameOfLife.addCell(cell2);

		assertEquals(1, gameOfLife.checkNeighbours(cellUnderTest));
	}

	@Test
	void shouldReturn2WhenTwoNeighboursAroundCell(){
		Cell cellUnderTest = new Cell(1,1,true);
		Cell neighbour1 = new Cell(1,2,true);
		Cell neighbour2 = new Cell(2,1,true);

		GameOfLife gameOfLife = new GameOfLife(5, 5);
		gameOfLife.addCells(Arrays.asList(cellUnderTest, neighbour1, neighbour2));

		assertEquals(2, gameOfLife.checkNeighbours(cellUnderTest));
	}

	@Test
	void shouldReturn3WhenThreeNeighboursAroundCell(){
		Cell cellUnderTest = new Cell(1,1,true);
		Cell neighbour1 = new Cell(1,2,true);
		Cell neighbour2 = new Cell(2,1,true);
		Cell neighbour3 = new Cell(1,0,true);

		GameOfLife gameOfLife = new GameOfLife(5, 5);
		gameOfLife.addCells(Arrays.asList(cellUnderTest, neighbour1, neighbour2, neighbour3));

		assertEquals(3, gameOfLife.checkNeighbours(cellUnderTest));
	}

	@Test
	void shouldReturn4When4NeighboursAroundCell(){
		Cell cellUnderTest = new Cell(1,1,true);
		Cell neighbour1 = new Cell(1,2,true);
		Cell neighbour2 = new Cell(2,1,true);
		Cell neighbour3 = new Cell(1,0,true);
		Cell neighbour4 = new Cell(0,1,true);

		GameOfLife gameOfLife = new GameOfLife(5, 5);
		gameOfLife.addCells(Arrays.asList(cellUnderTest, neighbour1, neighbour2,
				neighbour3, neighbour4));

		assertEquals(4, gameOfLife.checkNeighbours(cellUnderTest));
	}

	@Test
	void shouldReturn0WhenOneDeadNeighbourAroundCell(){
		Cell cellUnderTest = new Cell(1,1,true);
		Cell cell2 = new Cell(1,2,false);

		GameOfLife gameOfLife = new GameOfLife(5, 5);
		gameOfLife.addCell(cellUnderTest);
		gameOfLife.addCell(cell2);

		assertEquals(0, gameOfLife.checkNeighbours(cellUnderTest));
	}

	@Test
	void shouldReturn0WhenTwoDeadNeighboursAroundCell(){
		Cell cellUnderTest = new Cell(1,1,true);
		Cell neighbour1 = new Cell(1,2,false);
		Cell neighbour2 = new Cell(2,1,false);

		GameOfLife gameOfLife = new GameOfLife(5, 5);
		gameOfLife.addCells(Arrays.asList(cellUnderTest, neighbour1, neighbour2));

		assertEquals(0, gameOfLife.checkNeighbours(cellUnderTest));
	}

	@Test
	void shouldReturn0WhenThreeDeadNeighboursAroundCell(){
		Cell cellUnderTest = new Cell(1,1,true);
		Cell neighbour1 = new Cell(1,2,false);
		Cell neighbour2 = new Cell(2,1,false);
		Cell neighbour3 = new Cell(1,0,false);

		GameOfLife gameOfLife = new GameOfLife(5, 5);
		gameOfLife.addCells(Arrays.asList(cellUnderTest, neighbour1, neighbour2, neighbour3));

		assertEquals(0, gameOfLife.checkNeighbours(cellUnderTest));
	}

	@Test
	void shouldReturn0When4DeadNeighboursAroundCell(){
		Cell cellUnderTest = new Cell(1,1,true);
		Cell neighbour1 = new Cell(1,2,false);
		Cell neighbour2 = new Cell(2,1,false);
		Cell neighbour3 = new Cell(1,0,false);
		Cell neighbour4 = new Cell(0,1,false);

		GameOfLife gameOfLife = new GameOfLife(5, 5);
		gameOfLife.addCells(Arrays.asList(cellUnderTest, neighbour1, neighbour2,
				neighbour3, neighbour4));

		assertEquals(0, gameOfLife.checkNeighbours(cellUnderTest));
	}
}
