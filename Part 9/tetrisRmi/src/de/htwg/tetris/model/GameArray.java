package de.htwg.tetris.model;

import java.rmi.RemoteException;
import java.util.List;

import de.htwg.tetris.gui.IGameField;
import de.htwg.tetris.model.IQuader.states;
import de.htwg.tetris.observer.IObserver;
import de.htwg.tetris.observer.IObserverResetGame;
import de.htwg.tetris.server.IElement;

public class GameArray extends AGameArray {

	public GameArray() {
		super();
	}
	public GameArray(IQuader[][] game,	List<IObserverResetGame> observerResetGame, List<IObserver> observers) {
		this.game = game;
		this.observerResetGame = observerResetGame;
		this.observers = observers;
	}

	public boolean arrayStateOfElementPosition(IElement el, states z) throws RemoteException
	{
		boolean ret = true;
		int x = el.getX();
		int y = el.getY();
		if (!(
			(getState(x, y) == z)
			|| (getState(x + el.getQ2().getX(), y + el.getQ2().getY()) == z)
			|| (getState(x + el.getQ3().getX(), y + el.getQ3().getY()) == z)
			|| (getState(x + el.getQ4().getX(), y + el.getQ4().getY()) == z))
		)
		{
			return false;
		}
		return ret;		
	}
	
	public boolean arrayElementInArray(IElement el) throws RemoteException
	{
		boolean ret = false;
		
		if ((arrayElementInLeft(el)) 
			&(arrayElementInRight(el))
			&(arrayElementInDown(el))
			){
				ret = true;
		}	
		return ret;		
	}
	
	public boolean arrayElementInLeft(IElement el) throws RemoteException
	{
		boolean ret = false;
		int x = el.getX();

		if (((x >= 0) 
			& (x + el.getQ2().getX() >= 0)
			& (x + el.getQ3().getX() >= 0) 
			& (x + el.getQ4().getX() >= 0)))
		{
			ret = true;
		}
		return ret;		
	}
	
	public boolean arrayElementInRight(IElement el) throws RemoteException
	{
		boolean ret = false;
		int b = IGameField.WIDTH -1; // 10 -1	
		int x = el.getX();		
		
		if (((x <= b) 
			& (x + el.getQ2().getX() <= b)
			& (x + el.getQ3().getX() <= b) 
			& (x + el.getQ4().getX() <= b)))
		{
			ret = true;
		}
		return ret;		
	}
	
	public boolean arrayElementInDown(IElement el) throws RemoteException
	{
		boolean ret = true;
		int h = IGameField.HEIGHT; // 20 -1	
		int y = el.getY();		
		
		if (!((y < h) 
				& (y + el.getQ2().getY() < h)
				& (y + el.getQ3().getY() < h) 
				& (y + el.getQ4().getY() < h))) 
		{
			ret = false;
		}
		return ret;		
	}
	
	public void elementMergeArray(IElement el) throws RemoteException {
		for (int i = 0; i < IGameField.WIDTH; i++) {
			for (int j = 0; j < IGameField.HEIGHT; j++) {
				if (getState(i, j) == states.ELEMENT) {
					setState(i, j, states.FREE);
				}
			}
		}
		// set the elements
		if(el.getState())
		{
			setGameArrayElementToState(el, states.ELEMENT);
		}
		else	//element has reached the bottom
		{
			setGameArrayElementToState(el, states.TAKEN);
		}
	}
	
	private void setGameArrayElementToState(IElement el, states z) throws RemoteException 
	{
		int x = el.getX();
		int y = el.getY();
		
		setStateColor(x, y, z, el.getColor());
		setStateColor(
				(x + el.getQ2().getX()), (y + el.getQ2().getY()), 
				z, el.getColor());
		setStateColor(
				(x + el.getQ3().getX()), (y + el.getQ3().getY()), 
				z, el.getColor());
		setStateColor(
				(x + el.getQ4().getX()), (y + el.getQ4().getY()), 
				z, el.getColor());
		notifyObservers(observers);
	}
}
