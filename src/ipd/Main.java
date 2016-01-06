package ipd;

import java.util.ArrayList;

import strategies.*;
import utils.Misc;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Strategy> allPlayers = new ArrayList<Strategy>();
		allPlayers.add(new TitForTat());
		allPlayers.add(new TitForTwoTat());
		allPlayers.add(new DefectOnceEveryNMoves(10));
		allPlayers.add(new OpponentMajority());
		allPlayers.add(new AlwaysCooperate());
		allPlayers.add(new AlwaysDefect());
		allPlayers.add(new RandomMoves());
		allPlayers.add(new Resentful());
		allPlayers.add(new Alternate());
		allPlayers.add(new Prober());
		allPlayers.add(new Pavlov());
		allPlayers.add(new GenerousTitForTat());
		allPlayers.add(new ILikeRegularity());
		allPlayers.add(new IHateRegularity());
		
		Simulation sim = new Simulation(allPlayers);
		
		for ( int i=0; i<5; i++ ) {
			sim.run();
//			Misc.resetScores(allPlayers);
		}
		Misc.printRank(allPlayers);
	}

}
