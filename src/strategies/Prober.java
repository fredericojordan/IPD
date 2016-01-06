package strategies;

import ipd.Game;
import ipd.Strategy;

public class Prober extends Strategy {
	
	boolean opponentIsDumb = false;

	@Override
	public Move getNextMove(Game game) {
		
		if ( game.getMoveNumber() == 0 )
			return Move.COOPERATE;
		if ( game.getMoveNumber() == 1 || game.getMoveNumber() == 2 )
			return Move.DEFECT;
		if ( game.getMoveNumber() == 3 &&
				game.getOpponentMoves(this).get(1) == Move.COOPERATE &&
				game.getOpponentMoves(this).get(2) == Move.COOPERATE )
			opponentIsDumb = true;


		if ( opponentIsDumb )
			return Move.DEFECT;
		else
			return game.getOpponentLastMove(this);
		
	}

}
