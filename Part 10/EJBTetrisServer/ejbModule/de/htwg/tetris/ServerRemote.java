package de.htwg.tetris;

import javax.ejb.Remote;

import de.htwg.tetris.model.IElement;

@Remote
public interface ServerRemote {
	public IElement newElement();
}
