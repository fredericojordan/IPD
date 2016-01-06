package strategies;

import ipd.Game;
import ipd.Strategy;

public class ILikeRegularity extends Strategy {
	
	@Override
	public Move getNextMove(Game game) {

		if ( game.getMoveNumber() < 2 ||
				game.getOpponentLastMove(this) == game.getOpponentMoves(this).get(game.getMoveNumber()-2) )
			return Move.COOPERATE;
		else 
			return Move.COOPERATE;
	}

}
