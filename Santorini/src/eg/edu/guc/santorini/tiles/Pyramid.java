package eg.edu.guc.santorini.tiles;

import java.util.ArrayList;

import eg.edu.guc.santorini.utilities.*;

public class Pyramid extends Piece {
	// -----------------------------------------------------------------------
	public Pyramid(Location loc) {
		super(loc);
	}

	// -----------------------------------------------------------------------
	public Pyramid() {
		super();
	}

	// -----------------------------------------------------------------------
	public ArrayList<Location> possibleMoves() {
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		ArrayList<Location> pMoves = new ArrayList<Location>();

		if (x > 0 && y > 0) {
			pMoves.add(new Location(y - 1, x - 1));
		}
		if (x < 4 && y > 0) {
			pMoves.add(new Location(y - 1, x + 1));
		}
		if (x > 0 && y < 4) {
			pMoves.add(new Location(y + 1, x - 1));
		}
		if (y < 4 && x < 4) {
			pMoves.add(new Location(y + 1, x + 1));
		}

		return pMoves;
	}
}
