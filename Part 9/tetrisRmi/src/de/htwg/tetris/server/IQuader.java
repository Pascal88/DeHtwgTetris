package de.htwg.tetris.server;

import java.awt.Color;
import java.io.Serializable;
import java.rmi.Remote;

public interface IQuader extends Remote, Serializable {
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
