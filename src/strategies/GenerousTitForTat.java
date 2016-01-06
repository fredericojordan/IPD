package strategies;

import ipd.Game;
import ipd.Strategy;

public class GenerousTitForTat extends Strategy {
	
	private double probabilityToCooperateAfterDefection = 0.1;

	@Override
	public Move getNextMove(Game game) {
		if ( game.isOnFirstMove() )
			return Move.COOPERATE;
		
		if ( game.getOpponentLastMove(this) == Move.DEFECT && Math.random() > probabilityToCooperateAfterDefection )
			return Move.DEFECT;
		else
			return Move.COOPERATE;
	}

}
