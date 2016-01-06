package strategies;

import ipd.Game;
import ipd.Strategy;

public class TitForTat extends Strategy {

	@Override
	public Move getNextMove(Game game) {
		
		if ( game.isOnFirstMove() ) {
			return Move.COOPERATE;
		} else {
			return game.getOpponentLastMove(this);
		}
	}

}
