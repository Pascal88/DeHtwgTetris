package de.htwg.tetris.model.hibernate;

import de.htwg.tetris.model.ISaveGame;

public interface IDataBase {
	public void store(ISaveGame sg);
	public ISaveGame[] load();
}
