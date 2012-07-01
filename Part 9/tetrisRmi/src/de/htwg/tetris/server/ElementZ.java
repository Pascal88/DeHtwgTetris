package de.htwg.tetris.server;

import java.awt.Color;
import java.awt.Point;
import java.rmi.RemoteException;

public class ElementZ extends Element
{	
	private static final long serialVersionUID = 2131092780986731467L;

	public ElementZ() throws RemoteException{
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