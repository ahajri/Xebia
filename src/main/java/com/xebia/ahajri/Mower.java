package com.xebia.ahajri;

import com.xebia.ahajri.exception.MowException;

/**
 * Mower class
 * 
 * @author
 *         <p>
 *         ahajri
 *         <p>
 */
public class Mower {

	private Position position;
	private int xMax;
	private int yMax;
	private String commandLine;

	public Mower(Position position, int xMax, int yMax, String commandLine) {
		super();
		this.position = position;
		this.xMax = xMax;
		this.yMax = yMax;
		this.commandLine = commandLine;
	}

	public Position mow() throws MowException {
		assert commandLine != null;
		String[] commands = commandLine.split("(?!^)");
		for (String command : commands) {

			if (command.equalsIgnoreCase("D")) {
				Position newPositionD = new Position(position.getX(), position.getY(),
						nextCap(command, position.getCap()));
				setPosition(newPositionD);
			}
			if (command.equalsIgnoreCase("G")) {
				Position newPositionG = new Position(position.getX(), position.getY(),
						nextCap(command, position.getCap()));
				setPosition(newPositionG);
			}
			if (command.equalsIgnoreCase("A")) {
				int nextX = nextX(position.getX(), position.getCap());
				int nextY = nextY(position.getY(), position.getCap());
				String cap = position.getCap();
				Position newPositionA = new Position(nextX, nextY, cap);
				setPosition(newPositionA);
			}

		}
		return position;
	}

	private int nextY(int y, String cap) {
		int nextY = y;

		if (cap.equalsIgnoreCase("N")) {
			nextY = y + 1;
		} else if (cap.equalsIgnoreCase("S")) {
			nextY = y - 1;
		}
		if (nextY > yMax) {
			nextY = yMax;
		}
		if (nextY < 0) {
			nextY = 0;
		}
		return nextY;
	}

	private int nextX(int x, String cap) {
		int nextX = x;
		if (cap.equalsIgnoreCase("E")) {
			nextX = x + 1;
		} else if (cap.equalsIgnoreCase("W")) {
			nextX = x - 1;
		}
		if (nextX > xMax) {
			nextX = xMax;
		}
		if (nextX < 0) {
			nextX = 0;
		}
		return nextX;
	}

	private String nextCap(String command, String cap) {

		String newCap = null;
		if (command.equalsIgnoreCase("D")) {
			if (cap.equalsIgnoreCase("N")) {
				newCap = "E";
			}
			if (cap.equalsIgnoreCase("E")) {
				newCap = "S";
			}
			if (cap.equalsIgnoreCase("S")) {
				newCap = "W";
			}
			if (cap.equalsIgnoreCase("W")) {
				newCap = "N";
			}

		} else if (command.equalsIgnoreCase("G")) {
			if (cap.equalsIgnoreCase("N")) {
				newCap = "W";
			}
			if (cap.equalsIgnoreCase("E")) {
				newCap = "N";
			}
			if (cap.equalsIgnoreCase("S")) {
				newCap = "E";
			}
			if (cap.equalsIgnoreCase("W")) {
				newCap = "S";
			}

		}
		return newCap;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Mower [position=" + position + ", xMax=" + xMax + ", yMax=" + yMax + ", commandLine=" + commandLine
				+ "]";
	}

}
