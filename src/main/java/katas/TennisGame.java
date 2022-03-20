package katas;

public class TennisGame {
	public String p1;
	public String p2;
	public int p1Points;
	public int p2Points;

	public TennisGame(String p1, String p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public String getScore(){
		if (checkForWinner()) {
			return playerWithHigherPoints() + " Wins";
		}

		if(checkForAdvantage()){
			return "Advantage "+ playerWithHigherPoints();
		}

		if(p1Points == p2Points){
			if(checkForDeuce()) return "Deuce";
			return pointsToString(p1Points) + " All";
		}

		return pointsToString(p1Points) + " " + pointsToString(p2Points);
	}

	private boolean checkForDeuce() {
		if(p1Points >= 3){
			this.p1Points = 3;
			this.p2Points = 3;
			return true;
		}
		return false;
	}

	private boolean checkForAdvantage() {
		return p1Points >= 4 && p1Points >= p2Points + 1 || p2Points >= 4 && p2Points >= p1Points + 1;
	}

	private boolean checkForWinner() {
		return p1Points >= 4 && p1Points >= p2Points + 2 || p2Points >= 4 && p2Points >= p1Points + 2;
	}

	private String playerWithHigherPoints() {
		if(p1Points > p2Points) return p1;
		return p2;
	}

	private String pointsToString(int points){
		switch (points) {
			case 0:
				return "Love";
			case 1:
				return "15";
			case 2:
				return "30";
			case 3:
				return "40";
		}
		throw new IllegalArgumentException("Illegal amount of points: "+ points);
	}

	public void scoreP1(){
		this.p1Points++;
	}

	public void scoreP2(){
		this.p2Points++;
	}
}
