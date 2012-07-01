package de.htwg.tetris.controller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import de.htwg.tetris.gui.GameField;
import de.htwg.tetris.gui.IGameField;
import de.htwg.tetris.model.GameArray;
import de.htwg.tetris.server.IElement;
import de.htwg.tetris.server.INewElement;
import de.htwg.tetris.model.IGameArray;
import de.htwg.tetris.model.IQuader.states;
import de.htwg.tetris.move.IMove;
import de.htwg.tetris.move.MoveDown;
import de.htwg.tetris.move.MoveLeft;
import de.htwg.tetris.move.MoveRight;
import de.htwg.tetris.move.MoveUp;
import de.htwg.tetris.observer.IObserverNewElement;



public class GameController implements IGameController{

	private IElement element = null;
	private IMove moveDown, moveLeft, moveRight, moveUp;
	private IGameField spielfeld;
	private IGameArray spielarray;

	public GameController(List<IObserverNewElement> observersNewElement) 
	{
		/* init move */
		moveDown = new MoveDown(observersNewElement);
		moveLeft = new MoveLeft();
		moveRight = new MoveRight();
		moveUp = new MoveUp();
		
		spielarray = new GameArray(); 	
		spielfeld = new GameField(spielarray);	//Subject for Observers
	}
	
	public IGameField getSpielfeld() {
		return spielfeld;
	}


	public void setSpielfeld(IGameField spielfeld) {
		this.spielfeld = spielfeld;
	}


	public IGameArray getSpielarray() {
		return spielarray;
	}


	public void setSpielarray(IGameArray spielarray) {
		this.spielarray = spielarray;
	}
	
	/**
	 * verschiebt das Element nach unten
	 * 
	 * @param el
	 * 		�bergebenes Element
	 * @param m
	 * 		Richtung die das Interface Move implementiert
	 */
	public void moveDown() 
	{
		try {
			this.moveDown.move(element, spielarray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Dreht das Element
	 * 
	 * @param el
	 * 		�bergebenes Element
	 * @param m
	 * 		Richtung die das Interface Move implementiert
	 */
	public void moveUp() 
	{
		try {
			this.moveUp.move(element, spielarray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * verschiebt das Element nach Links
	 * 
	 * @param el
	 * 		�bergebenes Element
	 * @param m
	 * 		Richtung die das Interface Move implementiert
	 */
	public void moveLeft() 
	{
		try {
			this.moveLeft.move(element, spielarray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * verschiebt das Element nach Rechts
	 * 
	 * @param el
	 * 		�bergebenes Element
	 * @param m
	 * 		Richtung die das Interface Move implementiert
	 */
	public void moveRight() 
	{
		try {
			this.moveRight.move(element, spielarray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
	}
	
	public boolean testGameOver()
	{
		try {
			return spielarray.arrayStateOfElementPosition(element, states.TAKEN);
		} catch (RemoteException e) {
			e.printStackTrace();
			return true;
		}	
	}
	
	public IElement newElement()
	{
		try {
			Registry reg = LocateRegistry.getRegistry("localhost");
			
			INewElement newEle = (INewElement) reg.lookup("newelement");
			element = newEle.newEl();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return element;
	}
	

	public IElement getElement()
	{
		return element;
	}

	@Override
	public void resetGame() 
	{
		spielarray.resetGame();	
	}
}
