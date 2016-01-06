package ipd;


public abstract class Strategy {
	
	public enum Move { DEFECT, COOPERATE };
	
	public int score = 0;

	public abstract Move getNextMove(Game game);
	public void resetScore() { score = 0; }
	
	public void printScore() {
		System.out.printf("%d %s\n", score, this.getClass().getSimpleName());
	}
	
	public void printScore(int referenceScore) {
		double percentage = 100*((double) score)/((double) referenceScore);
		System.out.printf("%.1f %s\n", percentage, this.getClass().getSimpleName());
	}
	
}
