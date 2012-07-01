package de.htwg.tetris.controller;

import java.util.List;

import de.htwg.tetris.ServerRemote;
import de.htwg.tetris.gui.GameField;
import de.htwg.tetris.gui.IGameField;
import de.htwg.tetris.model.GameArray;
import de.htwg.tetris.model.IElement;
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
	private ServerRemote Server;

	public GameController(List<IObserverNewElement> observersNewElement, ServerRemote Server) 
	{
		this.Server = Server;
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
		this.moveDown.move(element, spielarray);		
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
		this.moveUp.move(element, spielarray);		
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
		this.moveLeft.move(element, spielarray);		
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
		this.moveRight.move(element, spielarray);		
	}
	
	public boolean testGameOver()
	{
		return spielarray.arrayStateOfElementPosition(element, states.TAKEN);	
	}
	
	public IElement newElement()
	{
		element = this.Server.newElement();
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
