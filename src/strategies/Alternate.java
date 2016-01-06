package strategies;

import ipd.Game;
import ipd.Strategy;

public class Alternate extends Strategy {

	@Override
	public Move getNextMove(Game game) {
		if ( !game.isOnFirstMove() && game.getMyLastMove(this) == Move.COOPERATE )
			return Move.DEFECT;

		return Move.COOPERATE;
	}

}
