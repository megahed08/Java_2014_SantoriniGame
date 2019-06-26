package eg.edu.guc.santorini.players;

import eg.edu.guc.santorini.tiles.*;

public class Player {
	private String name;
	private Piece t1;
	private Piece t2;

	// -----------------------------------------------------------------------
	public Player(String name, int number) {
		this.name = name;

		if (number == 1) {
			t1 = new Cube();
			t2 = new Cube();
		}
		if (number == 2) {
			t1 = new Pyramid();
			t2 = new Pyramid();
		}
	}

	// -----------------------------------------------------------------------
	public Player() {
	}

	// -----------------------------------------------------------------------
	public void setName(String name) {
		this.name = name;
	}

	// -----------------------------------------------------------------------
	public String getName() {
		return name;
	}

	// -----------------------------------------------------------------------
	public Piece getT1() {
		return t1;
	}

	// -----------------------------------------------------------------------
	public Piece getT2() {
		return t2;
	}
}
