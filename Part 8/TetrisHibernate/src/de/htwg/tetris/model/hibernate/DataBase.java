package de.htwg.tetris.model.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import de.htwg.tetris.model.AGameArray;
import de.htwg.tetris.model.IQuader;
import de.htwg.tetris.model.ISaveGame;
import de.htwg.tetris.model.Quader;
import de.htwg.tetris.model.SaveGame;
import de.htwg.tetris.model.hibernate.persistent.HibernateUtil;
import de.htwg.tetris.model.hibernate.persistent.PersistentQuader;
import de.htwg.tetris.model.hibernate.persistent.PersistentSaveGame;


public class DataBase implements IDataBase {
	private ISaveGame[] saveGame = null;
	private Session session = null;
	public DataBase (){
		session = HibernateUtil.getInstance().getCurrentSession();

	}

	public void store(ISaveGame sg) {
		this.saveGame = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			PersistentSaveGame saveGame = new PersistentSaveGame();
			saveGame.setName(sg.getName());
			saveGame.setHighscore(sg.getHighscore());
			IQuader[][] game = sg.getGame();
			List<PersistentQuader> g = new ArrayList<PersistentQuader>();
			
			for(int w = 0; w < AGameArray.WIDTH; w++) {
				for(int h = 0; h < AGameArray.HEIGHT; h++) {
					PersistentQuader quader = new PersistentQuader(game[w][h], saveGame);
					g.add(quader);
					session.save(quader);
				}
			}
			saveGame.setGame(g);
			session.save(saveGame);
			//tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
			try {
				tx.rollback();
			} catch (HibernateException exRb) {	}
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public ISaveGame[] load() {
		Transaction tx = null;
		if(saveGame == null){
			try {
				tx = session.beginTransaction();
				
				List<PersistentSaveGame> saveGames = session.createCriteria(PersistentSaveGame.class).list();
				this.saveGame = new SaveGame[saveGames.size()];
				for(int i = 0; i < saveGames.size(); i++) {
					List<PersistentQuader> quads = saveGames.get(i).getGame();
					IQuader[][] game = new Quader[AGameArray.WIDTH][AGameArray.HEIGHT];
					
					for(int w = 0; w < AGameArray.WIDTH; w++) {
						for(int h = 0; h < AGameArray.HEIGHT; h++) {
							game[w][h].setColor(quads.get(w*h).getColor());
							game[w][h].setState(quads.get(w*h).getState());
							game[w][h].setX(quads.get(w*h).getX());
							game[w][h].setY(quads.get(w*h).getY());
						}
					}
					this.saveGame[i].setGame(game);
					this.saveGame[i].setHighscore(saveGames.get(i).getHighscore());
					this.saveGame[i].setName(saveGames.get(i).getName());
				}
				tx.commit();
			} catch (HibernateException ex) {
				if (tx != null)
				try {
					tx.rollback();
				} catch (HibernateException exRb) {	}
				throw new RuntimeException(ex.getMessage());
			}			
		}
		return saveGame;
	}
}
