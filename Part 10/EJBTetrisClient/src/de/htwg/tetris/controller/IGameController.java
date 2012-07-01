package de.htwg.tetris.controller;

import de.htwg.tetris.gui.IGameField;
import de.htwg.tetris.model.IElement;
import de.htwg.tetris.model.IGameArray;

public interface IGameController
{
	public void resetGame();
	public void moveDown();
	public void moveUp();
	public void moveLeft();
	public void moveRight();
	
	public IElement newElement();
	public IElement getElement();
	boolean testGameOver();
	
	public IGameField getSpielfeld();
	public void setSpielfeld(IGameField spielfeld);
	public IGameArray getSpielarray();
	public void setSpielarray(IGameArray spielarray);
}
