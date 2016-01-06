package strategies;

import ipd.Game;
import ipd.Strategy;

public class RandomMoves extends Strategy {

	@Override
	public Move getNextMove(Game game) {
		if ( Math.random() > 0.5 )
			return Move.DEFECT;
		else
			return Move.COOPERATE;
	}

}
