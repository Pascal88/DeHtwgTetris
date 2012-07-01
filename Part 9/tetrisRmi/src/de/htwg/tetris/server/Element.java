package de.htwg.tetris.server;

import java.awt.Color;
import java.awt.Point;
import java.rmi.RemoteException;

public class Element implements IElement
{
	private static final long serialVersionUID = -7808611706353774111L;
	/*
	 * Private
	 */
	private int x = 5;
	private int y = 1;
	private int turnState = 1;
	private final int numOfQuaders = 4;
	private Quader[] q = new Quader[numOfQuaders];
	private Boolean state = true; // move if true
	
	/*
	 * Protected
	 */	
	protected Point turn[][]; 
	protected Color colorElement;
	protected char name;
	
	/*
	 * Constructor
	 */
	public Element() throws RemoteException{
		for(int i = 0; i < numOfQuaders; i++) {
			q[i] = new Quader();
		}
	}
	
	/*
	 * Methods
	 */
	public void turn() throws RemoteException {
		if(turnState == 4) {
			turnState = 0;
		}
		setTurnStatus(turnState + 1);		
	}
	
	/*
	 * Getters & Setters
	 */
	
	public void setQuaders(Point[] p) throws RemoteException{
		for(int i = 0; i < 4; i++) {
			if(p[i] == null) {
				continue;
			}
			q[i].setXY(p[i].getX(), p[i].getY());
		}	
	}
	
	public void setTurnStatus(int status) throws RemoteException{
		this.turnState = status;
		this.setQuaders(turn[status-1]);
		
	}
	
	public int getTurnStatus() throws RemoteException{
		return turnState;
	}	
	
	public Boolean getState() throws RemoteException{
		return state;
	}

	public void setState(Boolean state) throws RemoteException{
		this.state = state;
	}

	public Color getColor() throws RemoteException{
		return colorElement;
	}

	public void setX(int x) throws RemoteException{
		this.x = x;
	}
	public int getX() throws RemoteException{
		return x;
	}

	public int getY() throws RemoteException{
		return y;
	}

	public void setY(int y) throws RemoteException{
		this.y = y;
	}
	
	/*
	 * get set Quader
	 */

	public Quader getQ2() throws RemoteException{
		return q[1];
	}

	public Quader getQ3() throws RemoteException{
		return q[2];
	}

	public Quader getQ4() throws RemoteException{
		return q[3];
	}

	public void setQ1(Quader q1) throws RemoteException{
		this.q[0] = q1;
	}

	public Quader getQ1() throws RemoteException{
		return q[0];
	}
}