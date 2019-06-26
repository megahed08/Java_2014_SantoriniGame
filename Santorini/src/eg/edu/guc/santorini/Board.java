package eg.edu.guc.santorini;

import java.util.ArrayList;

import eg.edu.guc.santorini.players.*;

import eg.edu.guc.santorini.utilities.*;
import eg.edu.guc.santorini.exceptions.*;
import eg.edu.guc.santorini.tiles.*;

public class Board implements BoardInterface {
	private Player one;
	private Player two;
	private Player turn;
	private Location[][] board;
	private boolean moveplace;

	// -----------------------------------------------------------------------
	public Board(Player one, Player two) {
		this.one = one;
		this.two = two;
		turn = one;
		moveplace = true;
		board = new Location[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = new Location(i, j);
			}
		}
		one.getT1().setLocation(board[0][0]);
		board[0][0].setLocpiece(one.getT1());
		one.getT2().setLocation(board[4][1]);
		board[4][1].setLocpiece(one.getT2());
		two.getT1().setLocation(board[0][3]);
		board[0][3].setLocpiece(two.getT1());
		two.getT2().setLocation(board[4][4]);
		board[4][4].setLocpiece(two.getT2());
	}

	// -----------------------------------------------------------------------
	public Board() {
	}

	// -----------------------------------------------------------------------
	public void move(Piece piece, Location newLocation)
			throws InvalidMoveException {
		if (canMove(piece, board[newLocation.getY()][newLocation.getX()])
				&& (turn.getT1().equals(piece) || turn.getT2().equals(piece))
				&& moveplace && !isGameOver()) {
			piece.getLocation().setLocpiece(null);
			piece.setLocation(board[newLocation.getY()][newLocation.getX()]);
			board[newLocation.getY()][newLocation.getX()].setLocpiece(piece);
			moveplace = false;

		} else {
			throw new InvalidMoveException("Can't Move");
		}
	}

	// -----------------------------------------------------------------------
	public Piece getotherpiece(Piece piece) {
		if (this.getTurn().getT1().equals(piece)) {
			return this.getTurn().getT2();
		} else {
			return this.getTurn().getT2();
		}
	}

	// -----------------------------------------------------------------------

	public boolean canMove(Piece piece, Location location) {

		if (board[location.getY()][location.getX()].getLocpiece() != null
				|| board[location.getY()][location.getX()].getLevel() == 4
				|| board[location.getY()][location.getX()].getLevel()
						- piece.getLocation().getLevel() > 1) {
			return false;
		}
		ArrayList<Location> pMoves = piece.possibleMoves();
		for (int i = 0; i < pMoves.size(); i++) {
			if (pMoves.get(i).equals(board[location.getY()][location.getX()])) {
				return true;
			}
		}
		return false;
	}

	// -----------------------------------------------------------------------
	public void place(Piece piece, Location newLocation)
			throws InvalidPlacementException {
		if (canPlace(piece, board[newLocation.getY()][newLocation.getX()])
				&& (turn.getT1().equals(piece) || turn.getT2().equals(piece))
				&& !moveplace && !isGameOver()) {
			board[newLocation.getY()][newLocation.getX()]
					.setLevel(board[newLocation.getY()][newLocation.getX()]
							.getLevel() + 1);
			moveplace = true;
			if (getTurn().equals(one)) {
				setTurn(two);
			} else {
				setTurn(one);
			}
		} else {
			throw new InvalidPlacementException("Can't Place");
		}
	}

	// -----------------------------------------------------------------------
	public boolean canPlace(Piece piece, Location location) {
		if (board[location.getY()][location.getX()].getLocpiece() != null
				|| board[location.getY()][location.getX()].getLevel() == 4) {
			return false;
		}
		ArrayList<Location> pPlace = piece.possiblePlacements();
		for (int i = 0; i < pPlace.size(); i++) {
			if (pPlace.get(i).equals(board[location.getY()][location.getX()])) {
				return true;
			}
		}
		return false;
	}

	// -----------------------------------------------------------------------
	public boolean hasNoMoves(Player player) {
		ArrayList<Location> at1 = player.getT1().possibleMoves();
		ArrayList<Location> at2 = player.getT2().possibleMoves();
		for (int i = 0; i < at1.size(); i++) {
			if (canMove(player.getT1(), at1.get(i))) {
				return false;
			}
		}
		for (int j = 0; j < at2.size(); j++) {
			if (canMove(player.getT2(), at2.get(j))) {
				return false;
			}
		}
		return true;
	}

	// -----------------------------------------------------------------------
	public boolean isWinner(Player player) {
		if (player.getT1().getLocation().getLevel() == 3
				|| player.getT2().getLocation().getLevel() == 3) {
			return true;
		}
		if (player.equals(one)) {
			if (hasNoMoves(two) && getTurn().equals(two)) {
				return true;
			}
		}
		if (player.equals(two)) {
			if (hasNoMoves(one) && getTurn().equals(one)) {
				return true;
			}
		}
		return false;
	}

	// -----------------------------------------------------------------------
	public Player getWinner() {
		if (isWinner(one)) {
			return one;
		} else {
			if (isWinner(two)) {
				return two;
			}
		}
		return null;
	}

	// -----------------------------------------------------------------------
	public boolean isGameOver() {
		return (isWinner(one) || isWinner(two));
	}

	// -----------------------------------------------------------------------
	public String[][] display() {
		String[][] d = new String[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				d[i][j] = "";
				d[i][j] = d[i][j] + (board[i][j].getLevel());
				if (board[i][j].getLocpiece() != null) {
					if (board[i][j].getLocpiece() instanceof Cube) {
						d[i][j] = d[i][j] + "C";
					}
					if (board[i][j].getLocpiece() instanceof Pyramid) {
						d[i][j] = d[i][j] + "P";
					}
					if (board[i][j].getLocpiece().equals(one.getT1())
							|| board[i][j].getLocpiece().equals(one.getT2())) {
						d[i][j] = d[i][j] + "1";
					}
					if (board[i][j].getLocpiece().equals(two.getT1())
							|| board[i][j].getLocpiece().equals(two.getT2())) {
						d[i][j] = d[i][j] + "2";
					}
				}
			}
		}
		return d;
	}

	// -----------------------------------------------------------------------
	public Player getTurn() {
		if (turn.equals(one)) {
			return one;
		} else {
			return two;
		}
	}

	// -----------------------------------------------------------------------
	public void setTurn(Player turn) {
		this.turn = turn;
	}

	// -----------------------------------------------------------------------
	public boolean isMoveplace() {
		return moveplace;
	}

	// -----------------------------------------------------------------------
	public void setMoveplace(boolean moveplace) {
		this.moveplace = moveplace;

	}

	public Location[][] getLocation() {
		return board;

	}
}
