package de.htwg.tetris.model;

import java.awt.Color;

public interface IQuader {
	public enum states {
		FREE, ELEMENT, TAKEN
	}
	
	public void setColor(Color f);
	public Color getColor();
	public void setState(states state);
	public states getState();
	
	public int getX();
	public void setX(int x);
	public void setXY(double d, double e);
	public int getY();
	public void setY(int y);
}
