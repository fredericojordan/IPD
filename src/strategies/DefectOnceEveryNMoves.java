package strategies;

import java.util.ArrayList;

import ipd.Game;
import ipd.Strategy;

public class DefectOnceEveryNMoves extends Strategy {
	
	private int numberOfCooperateMoves;
	
	public DefectOnceEveryNMoves(int numberOfMoves) {
		this.numberOfCooperateMoves = numberOfMoves;
	}

	@Override
	public Move getNextMove(Game game) {
		if ( game.getMyMoves(this).size() >= numberOfCooperateMoves && areLastNMovesCooperate(game.getMyMoves(this), numberOfCooperateMoves-1) )
			return Move.DEFECT;
		else
			return Move.COOPERATE;

	}

	private boolean areLastNMovesCooperate(ArrayList<Move> moveList, int numberOfMoves) {
		for ( int i=0; i<numberOfMoves; i++ )
			if ( moveList.get(moveList.size()-1-i) == Move.DEFECT )
				return false;
		
		return true;
	}
	
	@Override
	public void printScore(int referenceScore) {
		double percentage = 100*((double) score)/((double) referenceScore);
		System.out.printf("%.1f %s(%d)\n", percentage, this.getClass().getSimpleName(), numberOfCooperateMoves);
	}

}
