package de.htwg.tetris.server;

import java.awt.Color;
import java.awt.Point;
import java.rmi.RemoteException;

public class ElementO extends Element
{
	private static final long serialVersionUID = 3682984591416208565L;

	public ElementO() throws RemoteException{
		this.name ='O';
		this.colorElement = new Color(255, 255, 0);
		Point tmpTurn[][] = 	{
										{new Point(0,0),new Point(0,1),new Point(1,0),new Point(1,1)}
									};
		this.turn = tmpTurn;	
		this.setTurnStatus(1);
	}
}