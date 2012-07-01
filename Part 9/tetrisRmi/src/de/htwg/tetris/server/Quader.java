package de.htwg.tetris.server;

import java.awt.Color;


public class Quader extends AQuader{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7149984763923394734L;
	/**
	 * 		zustand und Farbe sind in Array_Quader definiert
	 * 		zustand kann: enum zust{FREI, ELEMENT, BELEGT} sein
	 */
	private int x = 0;
	private int y = 0;
	
	public Quader(){		
	}
	
	public Quader(int x, int y){
		setX(x);
		setY(y);	
	}
	
	public Quader(Color f) {
		super(f);
	}
	
	//Getter Setter
	
	public int getX() {
		return x;
	}

	public final void setX(int x) {
		this.x = x;
	}
	public void setXY(double d, double e) {
		this.x = (int) d;
		this.y = (int) e;
	}

	public int getY() {
		return y;
	}

	public final void setY(int y) {
		this.y = y;
	}
}
