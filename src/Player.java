
public class Player {
	private String name;
	private int totalPoints;
	
	public Player(String name) {
		this.name = name;
		this.totalPoints = 0;
	}
	
	public void addPoint(int point) {
		this.totalPoints += point;
	}
	
	public boolean isExceeded() {
		return totalPoints > 33;
	}
	
	public boolean isWinner(Player other) {
		if (Math.abs(totalPoints - 33) < Math.abs(other.getTotalPoints() - 33)) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getTotalPoints() {
		return this.totalPoints;
	}
	
	public void clearPoints() {
		this.totalPoints = 0;
	}
}
