package gameoflife;

import katas.gameoflife.Cell;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 1})
	void shouldDieWhenLessThan2AliveNeighbours(int liveNeighbours){
		Cell cellUnderTest = new Cell(1,1,true);

		cellUnderTest.tick(liveNeighbours);

		assertFalse(cellUnderTest.isAlive);
	}

	@ParameterizedTest
	@ValueSource(ints = {2, 3})
	void shouldLiveWhen2OrThreeAliveNeighbours(int liveNeighbours){
		Cell cellUnderTest = new Cell(1,1,true);

		cellUnderTest.tick(liveNeighbours);

		assertTrue(cellUnderTest.isAlive);
	}

	@Test
	void shouldDieWhenMoreThan3AliveNeighbours(){
		Cell cellUnderTest = new Cell(1,1,true);

		cellUnderTest.tick(4);

		assertFalse(cellUnderTest.isAlive);
	}

	@Test
	void shouldLiveWhenDeadAnd3AliveNeighbours(){
		Cell cellUnderTest = new Cell(1,1,false);

		cellUnderTest.tick(3);

		assertTrue(cellUnderTest.isAlive);
	}
}
