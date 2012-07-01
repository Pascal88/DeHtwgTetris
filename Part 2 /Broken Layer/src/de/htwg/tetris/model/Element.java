package de.htwg.tetris.model;

import java.awt.Color;
import java.awt.Point;


public abstract class Element implements IElement
{
	/*
	 * Private
	 */
	private int x = 5;
	private int y = 1;
	
	/*
	 * Protected
	 */
	protected int turnState = 1;
	protected Point turn[][];
	protected Quader[] q = new Quader[4];
	protected Boolean state = true; // move if true 
	protected Color colorElement;
	protected char name;
	
	/*
	 * Constructor
	 */
	public Element() {
		for(int i = 0; i < 4; i++) {
			q[i] = new Quader();
		}
	}
	
	/*
	 * Methods
	 */
	public void turn() 
	{
		if(turnState == 4) turnState = 0;
		setTurnStatus(turnState + 1);		
	}
	
	/*
	 * Getters & Setters
	 */
	
	public void setQuaders(Point[] p) {
		for(int i = 0; i < 4; i++) {
			if(p[i] == null) continue;
			q[i].setXY(p[i].getX(), p[i].getY());
		}	
	}
	
	public void setTurnStatus(int status) {
		this.turnState = status;
		this.setQuaders(turn[status-1]);
		
	}
	
	public int getTurnStatus() {
		return turnState;
	}	
	
	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Color getColor() {
		return colorElement;
	}

	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/*
	 * get set Quader
	 */

	public Quader getQ2() {
		return q[1];
	}

	public Quader getQ3() {
		return q[2];
	}

	public Quader getQ4() {
		return q[3];
	}

	public void setQ1(Quader q1) {
		this.q[0] = q1;
	}

	public Quader getQ1() {
		return q[0];
	}
}