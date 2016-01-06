package strategies;

import ipd.Game;
import ipd.Strategy;

public class Pavlov extends Strategy {

	@Override
	public Move getNextMove(Game game) {
		if ( game.isOnFirstMove() )
			return Move.COOPERATE;
		
		double probabilityToCooperate = 1;
		
		if ( game.getMyLastMove(this) == Move.COOPERATE && game.getOpponentLastMove(this) == Move.COOPERATE )
			probabilityToCooperate = 1;
		if ( game.getMyLastMove(this) == Move.COOPERATE && game.getOpponentLastMove(this) == Move.DEFECT )
			probabilityToCooperate = 0;
		if ( game.getMyLastMove(this) == Move.DEFECT && game.getOpponentLastMove(this) == Move.COOPERATE )
			probabilityToCooperate = 0;
		if ( game.getMyLastMove(this) == Move.DEFECT && game.getOpponentLastMove(this) == Move.DEFECT )
			probabilityToCooperate = 0.8;
		
		
		if ( Math.random() < probabilityToCooperate )
			return Move.COOPERATE;
		else
			return Move.DEFECT;
	}

}
