package de.htwg.tetris.model;

import java.awt.Color;
import java.awt.Point;


public class ElementJ extends Element {
	public ElementJ(){
		this.name ='J';
		this.colorElement = new Color(0, 51, 255);
		Point tmpTurn[][] = 	{
										{new Point(0,0),new Point(0,1),new Point(0,-1),new Point(-1,1)},
										{new Point(0,0),new Point(1,0),new Point(-1,0),new Point(-1,-1)},
										{new Point(0,0),new Point(0,-1),new Point(0,1),new Point(1,-1)},
										{new Point(0,0),new Point(-1,0),new Point(1,0),new Point(1,1),}
									};
		this.turn = tmpTurn;
		this.setTurnStatus(1);
	}

}
