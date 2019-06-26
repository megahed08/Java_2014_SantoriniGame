package eg.edu.guc.santorini.utilities;

import eg.edu.guc.santorini.tiles.Piece;

public class Location {
	private int y;
	private int x;
	private int level;
	private Piece locpiece;

	// -----------------------------------------------------------------------
	public Location(int y, int x) {
		this.y = y;
		this.x = x;
		level = 0;
		locpiece = null;
	}

	// -----------------------------------------------------------------------
	public Location() {
	}

	// -----------------------------------------------------------------------
	public void setLocation(Location newLocation) {
		this.setX(newLocation.getX());
		this.setY(newLocation.getY());
	}

	// -----------------------------------------------------------------------
	public boolean equals(Location x) {
		if (x == null) {
			return false;
		}

		return this.getY() == x.getY() && this.getX() == x.getX();

	}

	// -----------------------------------------------------------------------
	public int getY() {
		return y;
	}

	// -----------------------------------------------------------------------
	public void setY(int y) {
		this.y = y;
	}

	// -----------------------------------------------------------------------
	public int getX() {
		return x;
	}

	// -----------------------------------------------------------------------
	public void setX(int x) {
		this.x = x;
	}

	// -----------------------------------------------------------------------
	public int getLevel() {
		return level;
	}

	// -----------------------------------------------------------------------
	public void setLevel(int level) {
		this.level = level;
	}

	// -----------------------------------------------------------------------
	public Piece getLocpiece() {
		return locpiece;
	}

	// -----------------------------------------------------------------------
	public void setLocpiece(Piece locpiece) {
		this.locpiece = locpiece;
	}

}
