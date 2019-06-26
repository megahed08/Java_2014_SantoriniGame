package eg.edu.guc.santorini.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import eg.edu.guc.santorini.Board;
import eg.edu.guc.santorini.exceptions.InvalidMoveException;
import eg.edu.guc.santorini.exceptions.InvalidPlacementException;
import eg.edu.guc.santorini.players.Player;
import eg.edu.guc.santorini.tiles.Piece;
import eg.edu.guc.santorini.utilities.Location;

public class Window extends JFrame implements MouseListener, ActionListener {
	private JLabel label1 = new JLabel("Santorini");
	private JLabel label2 = new JLabel("Enter Player One Name :");
	private JLabel label3 = new JLabel("Choose Your Piece :");
	private JLabel label4 = new JLabel("Enter Player Two Name :");
	private JLabel label5 = new JLabel("Choose Your Piece :");
	private Tile[][] labels = new Tile[5][5];
	private JButton btn = new JButton("Start");
	private JButton btn1 = new JButton("Cube");
	private JButton btn2 = new JButton("Pyramid");
	private JButton btn3 = new JButton("Cube");
	private JButton btn4 = new JButton("Pyramid");
	private JPanel panel1 = new JPanel();
	private JTextField txt1 = new JTextField();
	private JTextField txt2 = new JTextField();
	private int i1 = 1;
	private int i2 = 2;
	private String s1 = "Player One";
	private String s2 = "Player Two";
	private ArrayList<Location> possmove;
	private ArrayList<Location> possplace;
	private Player player1;
	private Player player2;
	private Tile temp;
	private Board game;
	private boolean moved = false;
	private boolean action2 = false;
	@SuppressWarnings("unused")
	private Piece tempPiece;

	public Window() {
		super();
		possmove = new ArrayList<Location>();
		possplace = new ArrayList<Location>();
		setSize(700, 700);
		setLocation(200, 0);
		setTitle("SANTORINI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setVisible(true);
		welcome();

	}

	public void welcome() {
		label1.setBounds(215, 130, 280, 60);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Serif", Font.ROMAN_BASELINE, 70));
		getContentPane().add(label1);

		welcomep1();
		welcomep2();

		btn.setBounds(250, 550, 180, 50);
		btn.setForeground(Color.white);
		btn.setBackground(Color.darkGray);
		btn.setFont(new Font("Serif", Font.ITALIC, 40));
		btn.setActionCommand("start");
		btn.addActionListener(this);
		getContentPane().add(btn);
		getContentPane().validate();
		getContentPane().repaint();
	}

	public void welcomep1() {
		label2.setBounds(100, 250, 280, 60);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Serif", Font.ITALIC, 20));
		getContentPane().add(label2);
		txt1.setBounds(350, 275, 250, 20);
		txt1.setFont(new Font("Serif", Font.BOLD, 15));
		getContentPane().add(txt1);
		label3.setBounds(100, 290, 280, 60);
		label3.setForeground(Color.white);
		label3.setFont(new Font("Serif", Font.ITALIC, 20));
		getContentPane().add(label3);
		btn1.setBounds(430, 320, 70, 20);
		btn1.setBackground(Color.white);
		btn1.addActionListener(this);
		getContentPane().add(btn1);
		btn2.setBounds(510, 320, 90, 20);
		btn2.setBackground(Color.white);
		btn2.addActionListener(this);
		getContentPane().add(btn2);
	}

	public void welcomep2() {
		label4.setBounds(100, 390, 280, 60);
		label4.setFont(new Font("Serif", Font.ITALIC, 20));
		label4.setForeground(Color.white);
		getContentPane().add(label4);
		txt2.setBounds(350, 415, 250, 20);
		txt2.setFont(new Font("Serif", Font.BOLD, 15));
		getContentPane().add(txt2);
		label5.setBounds(100, 430, 280, 60);
		label5.setForeground(Color.white);
		label5.setFont(new Font("Serif", Font.ITALIC, 20));
		getContentPane().add(label5);
		btn3.setBounds(430, 460, 70, 20);
		btn3.setBackground(Color.white);
		btn3.addActionListener(this);
		getContentPane().add(btn3);
		btn4.setBounds(510, 460, 90, 20);
		btn4.setBackground(Color.white);
		btn4.addActionListener(this);
		getContentPane().add(btn4);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("start")) {
			start();
		}
		if (e.getActionCommand().equals("restart")) {
			restart();
		}

		if (e.getSource() == btn1) {
			btn1.setBackground(Color.DARK_GRAY);
			btn1.setForeground(Color.white);
			btn2.setBackground(Color.white);
			btn2.setForeground(Color.black);
			i1 = 1;

		}
		if (e.getSource() == btn2) {
			btn2.setBackground(Color.DARK_GRAY);
			btn2.setForeground(Color.white);
			btn1.setBackground(Color.white);
			btn1.setForeground(Color.black);
			i1 = 2;
		}
		if (e.getSource() == btn3) {
			btn3.setBackground(Color.DARK_GRAY);
			btn3.setForeground(Color.white);
			btn4.setBackground(Color.white);
			btn4.setForeground(Color.black);
			i2 = 1;
		}
		if (e.getSource() == btn4) {
			btn4.setBackground(Color.DARK_GRAY);
			btn4.setForeground(Color.white);
			btn3.setBackground(Color.white);
			btn3.setForeground(Color.black);
			i2 = 2;
		}
	}

	public void restart() {
	}

	public void start() {
		if (!txt1.getText().equals("")) {
			s1 = txt1.getText();
		}
		if (!txt2.getText().equals("")) {
			s2 = txt2.getText();
		}
		this.setLayout(null);
		this.setBounds(100, 0, 900, 739);
		getContentPane().removeAll();
		getContentPane().setBackground(Color.black);
		getContentPane().validate();
		getContentPane().repaint();
		getContentPane().add(panel1);
		label1.setBounds(250, 50, 300, 10);
		label1.setFont(new Font("Serif", Font.ITALIC, 15));
		getContentPane().add(label1);
		panel1.setBounds(0, 0, 700, 700);
		panel1.setBackground(Color.white);
		panel1.setLayout(new GridLayout(5, 5));
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				labels[i][j] = new Tile(new ImageIcon("0.png"));
				labels[i][j].addMouseListener(this);
				labels[i][j].setLocationtiles(new Location(i, j));
				labels[i][j].setBackground(Color.gray);
				labels[i][j].setOpaque(true);
				panel1.add(labels[i][j]);
				panel1.validate();
			}
		}
		defLoc();
	}

	public void defLoc() {
		player1 = new Player(s1, i1);
		player2 = new Player(s2, i2);
		if (i1 == 1) {
			labels[0][0].setPiece(player1.getT1());
			labels[0][0].setIcon(new ImageIcon("0C1.png"));
			labels[4][1].setPiece(player1.getT2());
			labels[4][1].setIcon(new ImageIcon("0C1.png"));
		}
		if (i1 == 2) {
			labels[0][0].setPiece(player1.getT1());
			labels[0][0].setIcon(new ImageIcon("0P1.png"));
			labels[4][1].setPiece(player1.getT2());
			labels[4][1].setIcon(new ImageIcon("0P1.png"));
		}
		if (i2 == 1) {
			labels[0][3].setPiece(player2.getT1());
			labels[0][3].setIcon(new ImageIcon("0C2.png"));
			labels[4][4].setPiece(player2.getT2());
			labels[4][4].setIcon(new ImageIcon("0C2.png"));
			game = new Board(player1, player2);
		}
		if (i2 == 2) {
			labels[0][3].setPiece(player2.getT1());
			labels[0][3].setIcon(new ImageIcon("0P2.png"));
			labels[4][4].setPiece(player2.getT2());
			labels[4][4].setIcon(new ImageIcon("0p2.png"));
			game = new Board(player1, player2);
			label3.setText(game.getTurn().getName() + " Move");
			label3.setBounds(720, 100, 500, 50);
			getContentPane().add(label3);
			btn.setText(" restart ");
			btn.setForeground(Color.white);
			btn.setActionCommand("restart");
			btn.setBounds(720, 150, 100, 23);
			btn.setFont(new Font("Serif", Font.ITALIC, 20));
			getContentPane().add(btn);

		}
	}

	public void highlightmoves(Tile t) {
		if (t.getPiece() != null) {

			for (int i = 0; i < t.getPiece().possibleMoves().size(); i++) {
				if (game.canMove(t.getPiece(), labels[t.getPiece()
						.possibleMoves().get(i).getY()][t.getPiece()
						.possibleMoves().get(i).getX()].getLocationtiles())) {
					labels[t.getPiece().possibleMoves().get(i).getY()][t
							.getPiece().possibleMoves().get(i).getX()]
							.setBorder(BorderFactory.createLineBorder(
									Color.darkGray, 200));
				}
			}
		}
	}

	public void undohighlightmoves(Tile t) {
		for (int i = 0; i < t.getPiece().possibleMoves().size(); i++) {
			labels[t.getPiece().possibleMoves().get(i).getY()][t.getPiece()
					.possibleMoves().get(i).getX()].setBorder(BorderFactory
					.createEmptyBorder());
		}
	}

	public void highlightplaces(Tile t) {
		if (t.getPiece() != null
				&& (game.getTurn().getT1().equals(t.getPiece()) || game
						.getTurn().getT2().equals(t.getPiece()))) {

			for (int i = 0; i < t.getPiece().possiblePlacements().size(); i++) {
				if (game.canPlace(t.getPiece(), labels[t.getPiece()
						.possiblePlacements().get(i).getY()][t.getPiece()
						.possiblePlacements().get(i).getX()].getLocationtiles())) {
					labels[t.getPiece().possiblePlacements().get(i).getY()][t
							.getPiece().possiblePlacements().get(i).getX()]
							.setBorder(BorderFactory.createLineBorder(
									Color.yellow, 200));
				}

			}
		}
	}

	public void undohighlightplaces(Tile t) {
		for (int i = 0; i < t.getPiece().possiblePlacements().size(); i++) {
			labels[t.getPiece().possiblePlacements().get(i).getY()][t
					.getPiece().possiblePlacements().get(i).getX()]
					.setBorder(BorderFactory.createEmptyBorder());
		}
	}

	public void displaygui() {
		String[][] s = game.display();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				labels[i][j].setIcon(new ImageIcon(s[i][j] + ".png"));
			}
		}
		this.validate();
		this.repaint();
	}

	public void move1(Tile tempLabel) {
		if (!action2
				&& !moved
				&& !game.isGameOver()
				&& tempLabel.getPiece() != null
				&& (game.getTurn().getT1().equals(tempLabel.getPiece()) || game
						.getTurn().getT2().equals(tempLabel.getPiece()))) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					labels[i][j].setBorder(null);
				}
			}
			tempLabel.setBorder(BorderFactory.createLineBorder(Color.red, 6));
			for (int i = 0; i < tempLabel.getPiece().possibleMoves().size(); i++) {
				if (game.canMove(tempLabel.getPiece(),
						labels[tempLabel.getPiece().possibleMoves().get(i)
								.getY()][tempLabel.getPiece().possibleMoves()
								.get(i).getX()].getLocationtiles())) {
					possmove.add(tempLabel.getPiece().possibleMoves().get(i));
					temp = tempLabel;
				}
			}
			action2 = true;
			return;
		}
	}

	public void move2(Tile tempLabel) {
		if (action2 && !moved) {
			for (int i = 0; i < possmove.size(); i++) {
				if (possmove.get(i)
						.equals(game.getLocation()[tempLabel.getLocationtiles()
								.getY()][tempLabel.getLocationtiles().getX()])) {
					tempLabel.setPiece(temp.getPiece());
					temp.setPiece(null);
					try {
						game.move(tempLabel.getPiece(),
								tempLabel.getLocationtiles());
					} catch (InvalidMoveException e1) {
						label3.setText("Invalid Move");
					}
					displaygui();
					temp = null;
					tempPiece = tempLabel.getPiece();
					moved = true;
					action2 = false;
					label3.setText(game.getTurn().getName() + " Place");
					this.validate();
					this.repaint();
					gameEnd();
					return;

				}
			}
		}
	}

	public void place1(Tile tempLabel) {
		if (moved
				&& !action2
				&& tempLabel.getPiece() != null
				&& (game.getTurn().getT1().equals(tempLabel.getPiece()) || game
						.getTurn().getT2().equals(tempLabel.getPiece()))) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					labels[i][j].setBorder(null);
				}
			}
			tempLabel.setBorder(BorderFactory.createLineBorder(Color.red, 6));
			highlightplaces(tempLabel);
			for (int i = 0; i < tempLabel.getPiece().possiblePlacements()
					.size(); i++) {
				if (game.canPlace(tempLabel.getPiece(),
						labels[tempLabel.getPiece().possiblePlacements().get(i)
								.getY()][tempLabel.getPiece()
								.possiblePlacements().get(i).getX()]
								.getLocationtiles())) {
					possplace.add(tempLabel.getPiece().possiblePlacements()
							.get(i));
					temp = tempLabel;
				}
			}
			action2 = true;
			return;
		}
	}

	public void place2(Tile tempLabel) {
		if (action2 && moved) {
			for (int i = 0; i < possplace.size(); i++) {
				if (possplace.get(i)
						.equals(game.getLocation()[tempLabel.getLocationtiles()
								.getY()][tempLabel.getLocationtiles().getX()])) {
					tempLabel.setPiece(temp.getPiece());
					temp.setBorder(null);
					try {
						game.place(tempLabel.getPiece(),
								tempLabel.getLocationtiles());
					} catch (InvalidPlacementException e1) {
						label3.setText("Invalid Move");
					}
					displaygui();
					temp = null;
					moved = false;
					action2 = false;
					label3.setText(game.getTurn().getName() + " Move");
					this.validate();
					this.repaint();
					return;
				}
			}
		}
	}

	public void gameEnd() {
		if (game.isGameOver()) {
			setSize(700, 700);
			setLocation(200, 0);
			getContentPane().removeAll();
			label1.setText("Game Over");
			label1.setBounds(50, 100, 500, 100);
			label1.setFont(new Font("Serif", Font.ITALIC, 70));
			getContentPane().add(label1);
			label2.setText("" + game.getWinner().getName() + " is Winner");
			label2.setBounds(215, 330, 500, 50);
			label2.setFont(new Font("Serif", Font.ITALIC, 40));
			getContentPane().add(label2);
		}
	}

	public void mouseClicked(MouseEvent e) {
		Tile tempLabel = (Tile) e.getSource();
		gameEnd();
		this.validate();
		this.repaint();
		move2(tempLabel);
		move1(tempLabel);
		/*if (action2 && temp != null && !moved && tempLabel.getPiece() != null) {
			action2 = false;

		}*/
		place2(tempLabel);
		place1(tempLabel);
	}

	public void mouseEntered(MouseEvent e) {
		Tile tempLabel = (Tile) e.getSource();
		if (!moved) {
			highlightmoves(tempLabel);
		}
		if (moved) {
			highlightplaces(tempLabel);
		}
	}

	public void mouseExited(MouseEvent e) {
		Tile tempLabel = (Tile) e.getSource();
		if (!moved && tempLabel.getPiece() != null) {
			undohighlightmoves(tempLabel);
		}
		if (moved && tempLabel.getPiece() != null) {
			undohighlightplaces(tempLabel);
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

		/*
		 * Tile tempLabel = (Tile) e.getSource(); if (tempLabel.getPiece() ==
		 * null || (!game.getTurn().getT1().equals(tempLabel.getPiece()) &&
		 * !game .getTurn().getT2().equals(tempLabel.getPiece()))) {
		 * tempLabel.setBorder(BorderFactory.createEmptyBorder()); }
		 */

	}

	public static void main(String[] args) {
		new Window();
	}
}
