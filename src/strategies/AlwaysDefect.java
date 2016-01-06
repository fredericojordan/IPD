package strategies;

import ipd.Game;
import ipd.Strategy;

public class AlwaysDefect extends Strategy {

	@Override
	public Move getNextMove(Game game) { return Move.DEFECT; }

}
