package de.htwg.tetris.controller;

import de.htwg.tetris.gui.Gui;
import de.htwg.tetris.model.IGameArray;
import de.htwg.tetris.observer.IObserverNewElement;
import de.htwg.tetris.observer.IObserverResetGame;

public interface ITetrisController extends IObserverNewElement, IObserverResetGame {

	IGameArray getSpielarray();
	public void countHighscore(int i);
	public Gui getFrame();
	public int getHighscore();
	public void setHighscore(int s);
}
