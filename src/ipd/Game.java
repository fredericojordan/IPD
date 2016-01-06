package ipd;

import ipd.Strategy.Move;

import java.util.ArrayList;

public class Game {
	
	public Strategy player1;
	public Strategy player2;
	public ArrayList<Move> p1moveList;
	public ArrayList<Move> p2moveList;
	
	public static final int TEMPTATIONTODEFECT = 5;
	public static final int REWARDFORMUTUALCOOPERATION = 3;
	public static final int PUNISHMENTPAYOFF = 1;
	public static final int SUCKERSPAYOFF = 0;

	public static final int defaultNumberOfMovesPerGame = 200;
	
	private int numberOfMoves = defaultNumberOfMovesPerGame;
	private int moveNumber = 0;
	
	public Game(Strategy player1, Strategy player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.p1moveList = new ArrayList<Move>();
		this.p2moveList = new ArrayList<Move>();
	}
	
	public void run() {
		for (moveNumber=0; moveNumber<numberOfMoves; moveNumber++) {
			Move player1move = player1.getNextMove(this);
			Move player2move = player2.getNextMove(this);
			
			if ( player1move == Move.COOPERATE && player2move == Move.COOPERATE ) {
				player1.score += REWARDFORMUTUALCOOPERATION;
				player2.score += REWARDFORMUTUALCOOPERATION;
			} else if ( player1move == Move.COOPERATE && player2move == Move.DEFECT ) {
				player1.score += SUCKERSPAYOFF;
				player2.score += TEMPTATIONTODEFECT;
			} else if ( player1move == Move.DEFECT && player2move == Move.COOPERATE ) {
				player1.score += TEMPTATIONTODEFECT;
				player2.score += SUCKERSPAYOFF;
			} else if ( player1move == Move.DEFECT && player2move == Move.DEFECT) {
				player1.score += PUNISHMENTPAYOFF;
				player2.score += PUNISHMENTPAYOFF;
			}
			
			p1moveList.add(player1move);
			p2moveList.add(player2move);
		}
		
	}
	
	public boolean isOnFirstMove() { return (moveNumber==0); }
	public int getMoveNumber() { return moveNumber; }

	public ArrayList<Move> getOpponentMoves(Strategy myself) {
		if ( myself == player1 )
			return p2moveList;
		else if ( myself == player2 )
			return p1moveList;
		else
			return null;
	}
	
	public ArrayList<Move> getMyMoves(Strategy myself) {
		if ( myself == player1 )
			return p1moveList;
		else if ( myself == player2 )
			return p2moveList;
		else
			return null;
	}
	
	public Move getOpponentLastMove(Strategy myself) {
		if ( myself == player1 )
			return p2moveList.get(p2moveList.size()-1);
		else if ( myself == player2 )
			return p1moveList.get(p1moveList.size()-1);
		else
			return null;
	}
	
	public Move getMyLastMove(Strategy myself) {
		if ( myself == player1 )
			return p1moveList.get(p1moveList.size()-1);
		else if ( myself == player2 )
			return p2moveList.get(p2moveList.size()-1);
		else
			return null;
	}
	

	public void printResults() {
		player1.printScore();
		player2.printScore();
	}
}