package strategies;

import java.util.ArrayList;

import ipd.Game;
import ipd.Strategy;

public class OpponentMajority extends Strategy {

	@Override
	public Move getNextMove(Game game) {
		ArrayList<Move> opponentMoves = game.getOpponentMoves(this);
		
		if ( !opponentMoves.isEmpty() ) {
			int numberOfCooperates = 0;
			int numberOfDefects = 0;

			for ( int i=0; i<opponentMoves.size(); i++ ) {
				if ( opponentMoves.get(i) == Move.DEFECT )
					numberOfDefects++;
				else
					numberOfCooperates++;
			}
			
			if ( numberOfDefects >= numberOfCooperates )
				return Move.DEFECT;
		}
		
		return Move.COOPERATE;
	}

}
