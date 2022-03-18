import katas.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

	@Test
	public void shouldReturnZeroWhenEmptyString(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(0, calculator.add(""));
	}

	@Test
	public void shouldReturnNumberWhenNumber(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(1, calculator.add("1"));
	}

	@Test
	public void shouldReturnSumWhenTwoNumbersSeparatedByComma(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(3, calculator.add("1,2"));
	}

	@Test
	public void shouldReturnSumWhenMultipleNumbersSeparatedByComma(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(6, calculator.add("1,2,3"));
	}

	@Test
	public void shouldAcceptNewLineAsDelimiter(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(6, calculator.add("1\n2,3"));
	}

	@Test
	public void shouldAcceptCustomDelimiter(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(3, calculator.add("//;\n1;2"));
	}

	@Test
	public void shouldThrowExceptionWhenNegativeNumber(){
		StringCalculator calculator = new StringCalculator();
		Exception thrown = assertThrows(
				RuntimeException.class,
				() -> calculator.add("-1,2"));

		assertEquals("negatives not allowed: [-1]", thrown.getMessage());
	}

	@Test
	public void shouldIgnoreWhenNumberGreaterThan1000(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(2, calculator.add("2,1001"));
	}

	@Test
	public void shouldAcceptCustomDelimiterOfAnyLength(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(6, calculator.add("//[***]\n1***2***3"));
	}
}
