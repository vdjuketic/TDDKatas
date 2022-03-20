import katas.Diamond;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiamondTest {

	@Test
	void shouldReturnAWhenPassedA(){
		Diamond diamond = new Diamond();
		assertEquals("A", diamond.draw('A'));
	}

	@Test
	void shouldReturn2LetterPyramidWhenPassedB(){
		Diamond diamond = new Diamond();
		String expectedResult = String.join( "\n",
				" A",
				"B B",
				" A");

		assertEquals(expectedResult, diamond.draw('B'));
	}

	@Test
	void shouldReturn3LetterPyramidWhenPassedC(){
		Diamond diamond = new Diamond();
		String expectedResult = String.join( "\n",
				"  A",
				" B B",
				"C   C",
				" B B",
				"  A");

		assertEquals(expectedResult, diamond.draw('C'));
	}

	@Test
	void shouldReturn4LetterPyramidWhenPassedD(){
		Diamond diamond = new Diamond();
		String expectedResult = String.join( "\n",
				"   A",
				"  B B",
				" C   C",
				"D     D",
				" C   C",
				"  B B",
				"   A");

		assertEquals(expectedResult, diamond.draw('D'));
	}
}
