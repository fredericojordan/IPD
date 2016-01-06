package strategies;

import ipd.Game;
import ipd.Strategy;

public class Resentful extends Strategy {
	
	boolean opponentHasDefectedBefore = false;

	@Override
	public Move getNextMove(Game game) {
		
		verifyLastMove(game);	

		if ( opponentHasDefectedBefore )
			return Move.DEFECT;
		else
			return Move.COOPERATE;

	}
	
	private void verifyLastMove(Game game) {
		if ( !game.isOnFirstMove() && game.getOpponentLastMove(this) == Move.DEFECT )
				opponentHasDefectedBefore = true;
	}

}
