package strategies;

import ipd.Game;
import ipd.Strategy;

public class AlwaysCooperate extends Strategy {

	@Override
	public Move getNextMove(Game game) { return Move.COOPERATE; }

}
