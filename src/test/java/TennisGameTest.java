import katas.TennisGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Kata -> https://codingdojo.org/kata/Tennis/
public class TennisGameTest {

	private TennisGame gameUnderTest = new TennisGame("player1", "player2");

	@Test
	void shouldReturnLoveAllWhenInstantiated(){
		assertEquals("Love All", gameUnderTest.getScore());
	}

	@Test
	void shouldReturn15LoveWhenScoreIs1To0(){
		gameUnderTest.scoreP1();

		assertEquals("15 Love", gameUnderTest.getScore());
	}

	@Test
	void shouldReturnLove15WhenScoreIs0To1(){
		gameUnderTest.scoreP2();

		assertEquals("Love 15", gameUnderTest.getScore());
	}

	@Test
	void shouldReturn15AllWhenScoreIs1To1(){
		createScore(1, 1);

		assertEquals("15 All", gameUnderTest.getScore());
	}

	@Test
	void shouldReturn30LoveWhenScoreIs2To0(){
		createScore(2, 0);

		assertEquals("30 Love", gameUnderTest.getScore());
	}

	@Test
	void shouldReturn3015WhenScoreIs2To1(){
		createScore(2, 1);

		assertEquals("30 15", gameUnderTest.getScore());
	}

	@Test
	void shouldReturn40LoveWhenScoreIs3To0(){
		createScore(3, 0);

		assertEquals("40 Love", gameUnderTest.getScore());
	}

	@Test
	void shouldReturnDeuceWhenScoreIs3To3(){
		createScore(3, 3);

		assertEquals("Deuce", gameUnderTest.getScore());
	}

	@Test
	void shouldReturnPlayer1WinsWhenScoreIs4To0(){
		createScore(4, 0);

		assertEquals("player1 Wins", gameUnderTest.getScore());
	}

	@Test
	void shouldReturnPlayer2WinsWhenScoreIs0To4(){
		createScore(0, 4);

		assertEquals("player2 Wins", gameUnderTest.getScore());
	}

	@Test
	void shouldReturnAdvantagePlayer1WHenScoreIs4To3(){
		createScore(4, 3);

		assertEquals("Advantage player1", gameUnderTest.getScore());
	}

	@Test
	void shouldReturnAdvantagePlayer2WHenScoreIs3To4(){
		createScore(3, 4);

		assertEquals("Advantage player2", gameUnderTest.getScore());
	}

	@Test
	void shouldReturnPlayer1WinsWhenPlayer1ScoresAfterAdvantage(){
		createScore(5, 3);

		assertEquals("player1 Wins", gameUnderTest.getScore());
	}

	@Test
	void shouldReturnPlayer2WinsWhenPlayer2ScoresAfterAdvantage(){
		createScore(3, 5);

		assertEquals("player2 Wins", gameUnderTest.getScore());
	}

	@Test
	void shouldReturnDeuceWhenPlayer2ScoresAfterPlayer1HasAdvantage(){
		createScore(4, 4);

		assertEquals("Deuce", gameUnderTest.getScore());
	}

	private void createScore(int p1Points, int p2Points ) {
		for (int i = 0; i < p1Points; i++) {
			gameUnderTest.scoreP1();
		}
		for (int i = 0; i < p2Points; i++) {
			gameUnderTest.scoreP2();
		}
	}
}
