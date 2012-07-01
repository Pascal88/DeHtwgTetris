package de.htwg.tetris.server;

import java.awt.Color;
import java.awt.Point;
import java.rmi.RemoteException;

public class ElementT extends Element {
	
	private static final long serialVersionUID = 1401456317022039968L;

	public ElementT() throws RemoteException{
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
