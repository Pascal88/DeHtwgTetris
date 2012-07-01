package de.htwg.tetris.server;

import java.awt.Color;
import java.awt.Point;
import java.rmi.RemoteException;

public class ElementL extends Element
{	
	private static final long serialVersionUID = 7792946929736247294L;

	public ElementL() throws RemoteException{
		this.name ='L';
		this.colorElement = new Color(255, 153, 0);
		Point tmpTurn[][] = 	{
										{new Point(0,0),new Point(0,1),new Point(0,-1),new Point(1,1)},
										{new Point(0,0),new Point(1,0),new Point(-1,0),new Point(-1,1)},
										{new Point(0,0),new Point(0,-1),new Point(0,1),new Point(-1,-1)},
										{new Point(0,0),new Point(-1,0),new Point(1,0),new Point(1,-1),}
									};
		this.turn = tmpTurn;
		this.setTurnStatus(1);
	}
}
