package de.htwg.tetris.server;

import java.awt.Color;
import java.awt.Point;
import java.rmi.RemoteException;


public class ElementJ extends Element {
	
	private static final long serialVersionUID = 359132928412109674L;

	public ElementJ() throws RemoteException{
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
