package de.htwg.tetris.model;

import java.awt.Color;

public class Element 
{
	protected int turnState = 1;
	private int x = 5;
	private int y = 1;
	protected Quader q1;
	protected Quader q2;
	protected Quader q3;
	protected Quader q4;
	protected Boolean state = true; // move if true 
	protected Color colorElement;
	protected char name = ' ';
	
	public void turn() 
	{
		switch(turnState)
		{
			case 1: 
				turnStatus2();
				break;
			case 2:
				turnStatus3();
				break;
			case 3:
				turnStatus4();
				break;
			case 4:
				turnStatus1();
				break;
			default:
				turnStatus1();
		}		
	}
	
	public void turnStatus1()
	{}
	public void turnStatus2()
	{}
	public void turnStatus3()
	{}
	public void turnStatus4()
	{}
	
	public int getTurnStatus() {
		return turnState;
	}
	
	public void setTurnStatus(int turnState) 
	{
		switch(turnState)
		{
			case 1: 
				turnStatus1();
				break;
			case 2:
				turnStatus2();
				break;
			case 3:
				turnStatus3();
				break;
			case 4:
				turnStatus4();
				break;
		}		
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

	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}

	public char getName() {
		return name;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	public Boolean getState() {
		return state;
	}
	
	/*
	 * get set Quader
	 */

	public Quader getQ2() {
		return q2;
	}

	public Quader getQ3() {
		return q3;
	}

	public Quader getQ4() {
		return q4;
	}

	public void setQ1(Quader q1) {
		this.q1 = q1;
	}

	public Quader getQ1() {
		return q1;
	}
}
