package de.htwg.tetris.model;

import java.awt.Color;

public class ElementN extends Element
{
	public ElementN() 
	{
		name ='N';
		colorElement = new Color(170, 190, 215);
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
		q3.setXY(1, 0);
		q4.setXY(1, 1);
		turnState = 1;
	}
	public void turnStatus2()
	{
		q1.setXY(0, 0);
		q2.setXY(-1, 0);
		q3.setXY(0, -1);
		q4.setXY(1, -1);
		turnState = 2;
	}
	public void turnStatus3()
	{
		q1.setXY(0, 0);
		q2.setXY(0, -1);
		q3.setXY(1, 0);
		q4.setXY(1, 1);
		turnState = 3;
	}
	public void turnStatus4()
	{
		q1.setXY(0, 0);
		q2.setXY(-1, 0);
		q3.setXY(0, -1);
		q4.setXY(1, -1);
		turnState = 4;
	}

}
