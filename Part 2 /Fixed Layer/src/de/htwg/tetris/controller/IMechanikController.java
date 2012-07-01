package de.htwg.tetris.controller;

import de.htwg.tetris.observer.IObserverNewElement;

public interface IMechanikController extends IObserverNewElement {
	public void setMechanic(Thread mechanic);

	public Thread getMechanic();
	public void stopMechanic();
}
