package de.htwg.tetris.model;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface INewElement extends Remote{
	public IElement newEl() throws RemoteException;
}