package strategies;

import ipd.Game;
import ipd.Strategy;

public class TitForTwoTat extends Strategy {
	
	boolean firstOffense = true;

	@Override
	public Move getNextMove(Game game) {
		Move returnedMove = Move.COOPERATE;
		if ( game.isOnFirstMove() )
			return Move.COOPERATE;
		
		if ( game.getOpponentLastMove(this) == Move.DEFECT ) {
			if ( !firstOffense )
				returnedMove = Move.DEFECT;

			firstOffense = false;
		} else {
			firstOffense = true;
		}
		
		return returnedMove;
	}

}
