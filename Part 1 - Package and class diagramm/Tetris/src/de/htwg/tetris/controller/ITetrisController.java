package de.htwg.tetris.controller;

import de.htwg.tetris.observer.IObserverNewElement;
import de.htwg.tetris.model.Element;
import de.htwg.tetris.move.IMove;


public interface ITetrisController extends IObserverNewElement
{
	void solve();
	public void resetGame();
	public void move(IMove moveDown);

	public Element newElement();
	public Element getElement();
	public void countHighscore(int i);
	public void setMechanic(Thread mechanic);


	public Thread getMechanic();
	public void stopMechanic();
}
