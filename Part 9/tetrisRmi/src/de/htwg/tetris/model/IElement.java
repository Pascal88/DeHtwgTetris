package de.htwg.tetris.model;

import java.awt.Color;
import java.awt.Point;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IElement extends Remote{
	public void turn() throws RemoteException;
	public void setQuaders(Point[] p) throws RemoteException;
	public void setTurnStatus(int status) throws RemoteException;
	public int getTurnStatus() throws RemoteException;
	public Boolean getState() throws RemoteException;
	public void setState(Boolean state) throws RemoteException;
	public Color getColor() throws RemoteException;
	public void setX(int x) throws RemoteException;
	public int getX() throws RemoteException;
	public int getY() throws RemoteException;
	public void setY(int y) throws RemoteException;
	public Quader getQ2() throws RemoteException;
	public Quader getQ3() throws RemoteException;
	public Quader getQ4() throws RemoteException;
	public void setQ1(Quader q1) throws RemoteException;
	public Quader getQ1() throws RemoteException; 
}
