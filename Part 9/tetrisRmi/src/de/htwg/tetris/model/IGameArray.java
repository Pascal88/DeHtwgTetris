package de.htwg.tetris.model;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.List;

import de.htwg.tetris.model.IQuader.states;
import de.htwg.tetris.observer.IObserver;
import de.htwg.tetris.observer.IObserverResetGame;
import de.htwg.tetris.observer.ISubject;
import de.htwg.tetris.observer.ISubjectResetGame;
import de.htwg.tetris.server.IElement;

public interface IGameArray extends ISubject, ISubjectResetGame {
	public void resetGame();
	
	/**
	 * check if the spielarray has the passed state on the element position
	 * 
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @param z
	 * 		state to check
	 * @return true 
	 * 		if the spielarray has the passed state 
	 * @throws RemoteException 
	 */
	public boolean arrayStateOfElementPosition(IElement el, states z) throws RemoteException;
	
	/**
	 * check if the element is out of the spielarray
	 * 
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the spielarray
	 * @throws RemoteException 
	 */
	public boolean arrayElementInArray(IElement el) throws RemoteException;	
	
	/**
	 * check if the element is LEFT in the array
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the array
	 * @throws RemoteException 
	 */
	public boolean arrayElementInLeft(IElement el) throws RemoteException;
	
	/**
	 * check if the element is RIGHT in the array
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the array
	 * @throws RemoteException 
	 */
	public boolean arrayElementInRight(IElement el) throws RemoteException;

	/**
	 * check if the element is DOWN in the array
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the array
	 * @throws RemoteException 
	 */
	public boolean arrayElementInDown(IElement el) throws RemoteException;
	public void elementMergeArray(IElement el) throws RemoteException;
	public void setStateColor(int x, int y, states z, Color c);
	public states getState(int x, int y);
	
	public void setState(int x, int y, states z); 
	public void setColor(int x, int y, Color c);
	public Color getColor(int x, int y);
	


	public List<IObserverResetGame> getObserverResetGame();
	public void setObserverResetGame(List<IObserverResetGame> observerResetGame);
	public IQuader[][] getGame();
	public void setGame(IQuader[][] game);
	
	public List<IObserver> getObservers();
}