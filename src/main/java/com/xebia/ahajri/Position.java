package com.xebia.ahajri;

public class Position {

	private String x, y, cap;

	public Position(String x, String y, String cap) {
		super();
		this.x = x;
		this.y = y;
		this.cap = cap;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

}
