package utils;

import ipd.Game;
import ipd.Strategy;

import java.util.ArrayList;

public class Misc {

	public static Strategy getTopScored(ArrayList<Strategy> allPlayers) { 
		Strategy topScored = allPlayers.get(0);

		for ( int i=0; i<allPlayers.size(); i++ ) {
			Strategy currentPlayer = allPlayers.get(i);

			if ( currentPlayer.score > topScored.score )
				topScored = currentPlayer;
		}

		return topScored;
	}
	
	public static void resetScores(ArrayList<Strategy> allPlayers) {
		for ( int i=0; i<allPlayers.size(); i++ )
			allPlayers.get(i).resetScore();
	}
	
	@SuppressWarnings("unchecked")
	public static void printRank(ArrayList<Strategy> allPlayers) {
		ArrayList<Strategy> players = (ArrayList<Strategy>) allPlayers.clone();
		
		while ( !players.isEmpty() ) {
			Strategy topScored = Misc.getTopScored(players);
//			topScored.printScore();
			topScored.printScore(Game.defaultNumberOfMovesPerGame*Game.REWARDFORMUTUALCOOPERATION*(allPlayers.size()+1));
			players.remove(topScored);
		}
	}
}
