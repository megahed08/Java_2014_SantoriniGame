package eg.edu.guc.santorini.tiles;

import java.util.ArrayList;

import eg.edu.guc.santorini.utilities.*;

public abstract class Piece implements PieceInterface {
	private Location location;

	// -----------------------------------------------------------------------
	public Piece(Location location) {
		this.location = location;
	}

	// -----------------------------------------------------------------------
	public Piece() {
	}

	// -----------------------------------------------------------------------
	public abstract ArrayList<Location> possibleMoves();

	// -----------------------------------------------------------------------
	public ArrayList<Location> possiblePlacements() {
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		ArrayList<Location> pMoves = new ArrayList<Location>();

		if (x > 0 && y > 0) {
			pMoves.add(new Location(y - 1, x - 1));
		}
		if (y > 0) {
			pMoves.add(new Location(y - 1, x));
		}
		if (x < 4 && y > 0) {
			pMoves.add(new Location(y - 1, x + 1));
		}
		if (x > 0) {
			pMoves.add(new Location(y, x - 1));
		}
		if (x < 4) {
			pMoves.add(new Location(y, x + 1));
		}
		if (x > 0 && y < 4) {
			pMoves.add(new Location(y + 1, x - 1));
		}
		if (y < 4) {
			pMoves.add(new Location(y + 1, x));
		}
		if (y < 4 && x < 4) {
			pMoves.add(new Location(y + 1, x + 1));
		}
		return pMoves;
	}

	// -----------------------------------------------------------------------
	public void setLocation(Location location) {
		this.location = location;
	}

	// -----------------------------------------------------------------------
	public Location getLocation() {
		return location;
	}

}
