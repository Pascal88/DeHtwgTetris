package de.htwg.tetris.model.db;

import de.htwg.tetris.model.ISaveGame;

public interface IDataBase {
	public void store(ISaveGame sg);
	public ISaveGame[] load();
}
