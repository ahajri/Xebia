package com.xebia.ahajri;

import java.util.ArrayList;
import java.util.List;

public class Mower {
	
	private Position startPos;
	private List<Position> forbiddenPositions=new ArrayList<>();
	
	public Mower(Position startPos, List<Position> forbiddenPositions) {
		super();
		this.startPos = startPos;
		this.forbiddenPositions.addAll(forbiddenPositions);
	}
	
	

	public Position mow(String line){
		return null;
	}
}
