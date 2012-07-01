package de.htwg.tetris.controller;

import de.htwg.tetris.model.Element;
import de.htwg.tetris.move.IMove;

public interface ITetrisController
{
	public void resetGame();
	public void move(IMove moveDown);

	public Element newElement();
	public Element getElement();
	public void countHighscore(int i);
	boolean testGameOver();
}
