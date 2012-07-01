package de.htwg.tetris.controller;

import de.htwg.tetris.model.IGameArray;
import de.htwg.tetris.observer.IObserverNewElement;
import de.htwg.tetris.observer.IObserverResetGame;

public interface ITetrisController extends IObserverNewElement, IObserverResetGame {

	IGameArray getSpielarray();
	public void countHighscore(int i);

}
