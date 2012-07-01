package de.htwg.tetris;

import javax.ejb.Local;

import de.htwg.tetris.model.IElement;

@Local
public interface ServerLocal {
	public IElement newElement();
}
