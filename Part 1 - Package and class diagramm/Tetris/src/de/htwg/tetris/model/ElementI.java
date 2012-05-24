package de.htwg.tetris.model;

import java.awt.Color;

public class ElementI extends Element
{
	public ElementI() 
	{
		name ='I';
		colorElement = new Color(50, 45, 90);
		initQuader();
	}
	
	public void initQuader()
	{
		q1 = new Quader();
		q2 = new Quader();
		q3 = new Quader();
		q4 = new Quader();
		turnStatus1();
	}

	public void turnStatus1()
	{
		q1.setXY(0, 0);
		q2.setXY(0, -1);
		q3.setXY(0, 1);
		q4.setXY(0, 2);
		turnState = 1;
	}
	public void turnStatus2()
	{
		q1.setXY(0, 0);
		q2.setXY(-1, 0);
		q3.setXY(1, 0);
		q4.setXY(2, 0);
		turnState = 2;
	}
	public void turnStatus3()
	{
		q1.setXY(0, 0);
		q2.setXY(0, 1);
		q3.setXY(0, -1);
		q4.setXY(0, -2);
		turnState = 3;
	}
	public void turnStatus4()
	{
		q1.setXY(0, 0);
		q2.setXY(1, 0);
		q3.setXY(-1, 0);
		q4.setXY(-2, 0);
		turnState = 4;
	}
}
