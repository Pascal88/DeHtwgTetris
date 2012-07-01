package de.htwg.tetris.model.db4o;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;

import de.htwg.tetris.model.ISaveGame;
import de.htwg.tetris.model.SaveGame;

public class DataBase implements IDataBase {
	private ObjectContainer db = null;
	private ObjectSet<SaveGame> result = null;
	ISaveGame[] saveGame = null;
	
	@SuppressWarnings("deprecation")
	public DataBase (){
		db=Db4o.openFile("TetrisDB.yap");
	}

	public void store(ISaveGame sg) {
		try {
			db.store(sg);
		} catch (DatabaseClosedException e) {
			e.printStackTrace();
		} catch (DatabaseReadOnlyException e) {
			e.printStackTrace();
		}
		this.saveGame = null;
	}

	@Override
	public ISaveGame[] load() {
		if(saveGame == null){
			result = db.queryByExample(new SaveGame());
			saveGame = new SaveGame[result.size()];
			while(result.hasNext()){
				int i = result.indexOf(result.next()); 
				saveGame[i] = new SaveGame(result.get(i).getName(), result.get(i).getGame(), result.get(i).getHighscore()); 
			}
		}
		return saveGame;
	}

	protected void finalize() throws Throwable {
		db.close();
	} 
}
