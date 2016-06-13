package com.xebia.ahajri;

import java.util.ArrayList;
import java.util.List;

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
	private List<Position> forbiddenPositions = new ArrayList<>();
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

	public void addForbidden(Position p) {
		assert p != null;
		this.forbiddenPositions.add(p);
	}

	public void addForbiddens(List<Position> p) {
		assert p != null;
		this.forbiddenPositions.addAll(p);
	}

	public Position mow() throws MowException {
		assert commandLine != null;
		String[] commands = commandLine.split("(?!^)");
		for (String command : commands) {
			switch (command) {
			case "D":
				Position newPositionD = new Position(position.getX(), position.getY(),
						nextCap(command, position.getCap()));
				position = newPositionD;
				break;
			case "G":
				Position newPositionG = new Position(position.getX(), position.getY(),
						nextCap(command, position.getCap()));
				position = newPositionG;
				break;
			case "A":
				int nextX = nextX(position.getX(), position.getCap());
				int nextY = nextY(position.getY(), position.getCap());
				String cap = position.getCap();
				Position newPositionA = new Position(nextX, nextY, cap);
				this.position=newPositionA;
				break;

			default:
				break;
			}
		}
		return position;
	}

	private int nextY(int y, String cap) {
		int nextY = y;
		switch (cap) {
		case "N":
			nextY = y + 1;
			break;
		case "E":
			break;
		case "S":
			nextY = y - 1;
			break;
		case "W":
			break;

		default:
			break;
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
		switch (cap) {
		case "N":

			break;
		case "E":
			nextX = x + 1;
			break;
		case "S":

			break;
		case "W":
			nextX = x - 1;
			break;

		default:
			break;
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
			switch (cap) {
			case "N":
				newCap = "E";
				break;
			case "E":
				newCap = "S";
				break;
			case "S":
				newCap = "W";
				break;
			case "W":
				newCap = "N";
				break;

			default:
				break;
			}
		} else if (command.equalsIgnoreCase("G")) {
			switch (cap) {
			case "N":
				newCap = "W";
				break;
			case "E":
				newCap = "N";
				break;
			case "S":
				newCap = "E";
				break;
			case "W":
				newCap = "S";
				break;

			default:
				break;
			}
		}
		return newCap;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Mower [position=" + position + ", forbiddenPositions=" + forbiddenPositions + ", xMax=" + xMax
				+ ", yMax=" + yMax + ", commandLine=" + commandLine + "]";
	}

}
