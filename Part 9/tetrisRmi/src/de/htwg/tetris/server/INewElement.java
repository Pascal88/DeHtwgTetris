package de.htwg.tetris.server;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface INewElement extends Remote, Serializable{
	public IElement newEl() throws RemoteException;
}
