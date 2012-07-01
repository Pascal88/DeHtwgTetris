package de.htwg.tetris.observer;

import java.util.ArrayList;

public interface ISubject {
	public void registerObserver(IObserver o);
	public void removeObserver(IObserver o);
	public void notifyObservers(ArrayList<IObserver> observers);
}
