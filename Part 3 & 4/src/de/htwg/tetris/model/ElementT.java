package de.htwg.tetris.model;

import java.awt.Color;
import java.awt.Point;

public class ElementT extends Element {
	
	public ElementT(){
		this.name ='T';
		this.colorElement = new Color(128, 0, 255);
		Point tmpTurn[][] = 	{
										{new Point(0,0),new Point(1,0),new Point(-1,0),new Point(0,-1)},
										{new Point(0,0),new Point(1,0),new Point(0,1),new Point(0,-1)},
										{new Point(0,0),new Point(1,0),new Point(0,1),new Point(-1,0)},
										{new Point(0,0),new Point(0,-1),new Point(0,1),new Point(-1,0)}
									};
		this.turn = tmpTurn;
		this.setTurnStatus(1);
	}

}
