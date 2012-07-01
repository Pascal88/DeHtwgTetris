package de.htwg.tetris.model;

import java.awt.Color;

public class ArrayQuader {

	public enum states {
		FREE, ELEMENT, TAKEN
	}

	protected states state = states.FREE;
	protected Color color = new Color(90, 90, 180);

	public ArrayQuader() {
	}
	
	public ArrayQuader(Color f) {
		this.color = f;
	}

	public void setColor(Color f) {
		this.color = f;
	}

	public Color getColor() {
		return color;
	}

	public void setState(states state) {
		this.state = state;
	}

	public states getState() {
		return state;
	}
}
