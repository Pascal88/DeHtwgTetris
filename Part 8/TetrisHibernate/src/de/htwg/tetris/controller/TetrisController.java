package de.htwg.tetris.controller;

import de.htwg.tetris.gui.swing.Gui;
import de.htwg.tetris.gui.swing.LoadGameListener;
import de.htwg.tetris.gui.swing.NewGameListener;
import de.htwg.tetris.gui.swing.SaveGameListener;
import de.htwg.tetris.gui.swing.TetrisKeyListener;
import de.htwg.tetris.model.IGameArray;
import de.htwg.tetris.model.IQuader;
import de.htwg.tetris.model.ISaveGame;
import de.htwg.tetris.model.SaveGame;
import de.htwg.tetris.model.hibernate.DataBase;
import de.htwg.tetris.model.hibernate.IDataBase;

public class TetrisController implements ITetrisController {

	private IGameArray spielarray;
	private TetrisKeyListener keyListener;
	private NewGameListener newGameListener;
	private SaveGameListener saveGameListener;
	private LoadGameListener loadGameListener;
	private Gui frame;
	private int highscore = 0;
	private ISaveGame saveGame = null;
	private ISaveGame[] result = null;
	
	private IGameController gameController;
	private IMechanikController mechanikController;
	
	private IDataBase db = null;
	
	public TetrisController(IGameController gameController, IMechanikController mechanikController) {
		this.gameController = gameController;
		this.mechanikController = mechanikController;
		spielarray = gameController.getSpielarray(); 	
		spielarray.registerObserverReset(this);
		
		this.db = new DataBase();
		
		/* init Listener */
		keyListener = new TetrisKeyListener(gameController);
		newGameListener = new NewGameListener(spielarray, gameController, mechanikController);
		saveGameListener = new SaveGameListener(this);
		loadGameListener = new LoadGameListener(this);
		
		frame = new Gui(newGameListener, keyListener, gameController, saveGameListener, loadGameListener);	
		
	}

	public IGameArray getSpielarray() {
		return spielarray;
	}

	public void setSpielarray(IGameArray spielarray) {
		this.spielarray = spielarray;
	}
	
	public void update(int countFullLine) {
		gameController.newElement();
		countHighscore(countFullLine);
		if (gameController.testGameOver()) {
			mechanikController.stopMechanic();
			gameController.resetGame();
			this.mechanikController.newMechanik();
		}
	}
	
	public void countHighscore(int i)
	{
		highscore += (i*100);
		if (i>0) {
			this.frame.setTextFieldValue(highscore);
		}
	}

	public void update() {
		
		//this.frame.resetTextField();		
	}

	public Gui getFrame() {
		return frame;
	}	
	
	public int getHighscore(){
		return highscore;
	}
	
	public void setHighscore(int s){
		this.highscore = s;
		this.frame.setTextFieldValue(highscore);
	}
	
	public void save(String s) {
		IQuader[][] game = gameController.getSpielarray().getGame();
		int score = this.getHighscore();
		
		mechanikController.stopMechanic();
		
		if(s != null) {
			ISaveGame sg = new SaveGame(s, game, score);
			this.db.store(sg);
		}
		mechanikController.newMechanik();
	}

	public Object[] load() {
		mechanikController.stopMechanic();
		result = this.db.load();
		Object[] possibilities = new Object[result.length];
		
		for(int i = 0; i < result.length; i++){
			possibilities[i] = result[i].getName();
		}
		
		return possibilities;
	}
	
	public void load(String s) {
		saveGame = null;
		if(s != "") {
			for(int i = 0; i < result.length; i++) {
				if(s == result[i].getName()){
					saveGame = result[i];
				}
			}
			gameController.newElement();
			gameController.getSpielarray().elementMergeArray(gameController.getElement());
			this.gameController.getSpielarray().setGame(saveGame.getGame());
			this.setHighscore(saveGame.getHighscore());
			this.mechanikController.newMechanik();
		}
	}
}
