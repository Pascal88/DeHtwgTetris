package de.htwg.tetris.model;

import java.awt.Color;
import java.awt.Point;

public class ElementZ extends Element
{	
	public ElementZ(){
		this.name ='Z';
		this.colorElement = new Color(255, 0, 0);
		Point tmpTurn[][] = 	{
			{new Point(0,0),new Point(1,-1),new Point(1,0),new Point(0,1)},
			{new Point(0,0),new Point(-1,-1),new Point(0,-1),new Point(1,0)},
			{new Point(0,0),new Point(1,-1),new Point(1,0),new Point(0,1)},
			{new Point(0,0),new Point(-1,-1),new Point(0,-1),new Point(1,0)}
		};
		this.turn = tmpTurn;	
		this.setTurnStatus(1);
	}
}