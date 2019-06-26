package eg.edu.guc.santorini.gui;

import javax.swing.*;
import eg.edu.guc.santorini.tiles.*;
import eg.edu.guc.santorini.utilities.Location;

public class Tile extends JLabel {
	private int level;
	private Piece piece;
	private Location location;

	// -----------------------------------------------------------------------
	public Tile() {
		super();
		level = 0;
	}

	// -----------------------------------------------------------------------
	public Tile(Icon ico) {
		super(ico);
		level = 1;
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
	public Piece getPiece() {
		return piece;
	}

	// -----------------------------------------------------------------------
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	// -----------------------------------------------------------------------
	public Location getLocationtiles() {
		return location;
	}

	// -----------------------------------------------------------------------
	public void setLocationtiles(Location location) {
		this.location = location;
	}

}
