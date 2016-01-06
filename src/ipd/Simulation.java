package ipd;

import java.util.ArrayList;

public class Simulation {
	
	ArrayList<Strategy> players;
	
	public Simulation(ArrayList<Strategy> players) {
		this.players = players;
	}
	
	public void run() {
		for ( int i=0; i<players.size(); i++ ) {
			for (int j=i; j<players.size(); j++ ) {
				Game game = new Game(players.get(i), players.get(j));
				game.run();
			}
		}
	}
}
