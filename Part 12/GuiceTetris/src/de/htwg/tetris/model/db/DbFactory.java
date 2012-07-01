package de.htwg.tetris.model.db;

import com.google.inject.Inject;

import de.htwg.tetris.DI.*;
import de.htwg.tetris.model.ISaveGame;

public class DbFactory implements IDataBase {
	
	private IDataBase db = null;
	
	@Inject
	public DbFactory(@Db4o IDataBase db){
		this.db = db;
	}

	public void store(ISaveGame sg) {
		this.db.store(sg);

	}

	public ISaveGame[] load() {
		return this.db.load();
	}

}
