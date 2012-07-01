package de.htwg.tetris.server;

import java.awt.Color;
import java.awt.Point;
import java.rmi.RemoteException;

public class ElementN extends Element
{
	private static final long serialVersionUID = 7602819961798614351L;

	public ElementN() throws RemoteException{
		this.name ='N';
		this.colorElement = new Color(0, 255, 0);
		Point tmpTurn[][] = 	{
										{new Point(0,0),new Point(0,-1),new Point(1,0),new Point(1,1)},
										{new Point(0,0),new Point(-1,0),new Point(0,-1),new Point(1,-1)},
										{new Point(0,0),new Point(0,-1),new Point(1,0),new Point(1,1)},
										{new Point(0,0),new Point(-1,0),new Point(0,-1),new Point(1,-1)}
									};
		this.turn = tmpTurn;
		this.setTurnStatus(1);
	}
}