package de.htwg.tetris.observer;

import java.util.ArrayList;

public interface ISubjectNewElement {
	public void registerObserver(IObserverNewElement o);
	public void removeObserver(IObserverNewElement o);
	public void notifyObservers(ArrayList<IObserverNewElement> observers);
}

