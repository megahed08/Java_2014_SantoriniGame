package eg.edu.guc.santorini.tiles;

import java.util.ArrayList;

import eg.edu.guc.santorini.utilities.*;

public class Cube extends Piece {
	// -----------------------------------------------------------------------
	public Cube(Location loc) {
		super(loc);
	}

	// -----------------------------------------------------------------------
	public Cube() {
		super();
	}

	// -----------------------------------------------------------------------
	public ArrayList<Location> possibleMoves() {
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		ArrayList<Location> pMoves = new ArrayList<Location>();

		if (y > 0) {
			pMoves.add(new Location(y - 1, x));
		}
		if (x > 0) {
			pMoves.add(new Location(y, x - 1));
		}
		if (x < 4) {
			pMoves.add(new Location(y, x + 1));
		}
		if (y < 4) {
			pMoves.add(new Location(y + 1, x));
		}

		return pMoves;

	}

}
