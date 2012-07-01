package de.htwg.tetris.model;


public class Quader extends ArrayQuader{
	
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
	
	//Getter Setter
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	public void setXY(double d, double e) {
		this.x = (int) d;
		this.y = (int) e;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
