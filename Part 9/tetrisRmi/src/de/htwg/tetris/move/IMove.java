package de.htwg.tetris.move;


import java.rmi.RemoteException;

import de.htwg.tetris.gui.IGameField;
import de.htwg.tetris.server.IElement;
import de.htwg.tetris.model.IGameArray;

public interface IMove {

	int h = IGameField.HEIGHT; 		// 20
	int w = IGameField.WIDTH -1; 	// 10 - 1	
	public void move(IElement el, IGameArray gameArray) throws RemoteException;
	
	/**
	 * checked whether move is possible
	 * 
	 * @param el
	 * 		Element to move
	 * @param gameArray
	 * 		the gamearray where it move
	 * @return true if it can move 
	 * @throws RemoteException 
	 */
	public boolean moveTest(IElement el, IGameArray gameArray) throws RemoteException;
	
}
