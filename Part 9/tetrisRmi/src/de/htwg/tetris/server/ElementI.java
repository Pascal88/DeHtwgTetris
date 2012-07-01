package de.htwg.tetris.server;

import java.awt.Color;
import java.awt.Point;
import java.rmi.RemoteException;

public class ElementI extends Element
{
	private static final long serialVersionUID = -5195982631885199071L;

	public ElementI() throws RemoteException{
		this.name = 'I';
		this.colorElement = new Color(0, 255, 255);
		Point[][] tmpTurn = {
										{new Point(0,0),new Point(0,-1),new Point(0,1),new Point(0,2)},
										{new Point(0,0),new Point(-1,0),new Point(1,0),new Point(2,0)},
										{new Point(0,1),new Point(0,1),new Point(0,-1),new Point(0,-2)},
										{new Point(0,0),new Point(1,0),new Point(-1,0),new Point(-2,0),}
									};
		this.turn = tmpTurn;
		this.setTurnStatus(1);
	}
}