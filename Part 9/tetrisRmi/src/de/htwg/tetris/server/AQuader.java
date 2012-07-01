package de.htwg.tetris.server;

import java.awt.Color;

public abstract class AQuader implements IQuader{

	private static final long serialVersionUID = -8885321661204587807L;
	private states state = states.FREE;
	private Color color = new Color(90, 90, 180);

	public AQuader() {
	}
	
	public AQuader(Color f) {
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
	
	public abstract int getX();
	public abstract void setX(int x);
	public abstract void setXY(double d, double e);
	public abstract int getY();
	public abstract void setY(int y);
}
