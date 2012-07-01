package de.htwg.tetris.model.db4o;

import de.htwg.tetris.model.ISaveGame;

public interface IDataBase {
	public void store(ISaveGame sg);
	public ISaveGame[] load();
}
