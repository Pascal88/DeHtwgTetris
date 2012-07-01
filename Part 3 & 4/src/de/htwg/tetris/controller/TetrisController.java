package de.htwg.tetris.controller;

import de.htwg.tetris.gui.Gui;
import de.htwg.tetris.gui.IGameField;
import de.htwg.tetris.gui.NewGameListener;
import de.htwg.tetris.gui.TetrisKeyListener;
import de.htwg.tetris.model.IGameArray;

public class TetrisController implements ITetrisController {

	private IGameArray spielarray;
	private TetrisKeyListener keyListener;
	private NewGameListener newGameListener;
	private Gui frame;
	private IGameField spielfeld;
	private int highscore = 0;
	
	private IGameController gameController;
	private IMechanikController mechanikController;
	
	public TetrisController(IGameController gameController, IMechanikController mechanikController) {
		this.gameController = gameController;
		this.mechanikController = mechanikController;
		spielarray = gameController.getSpielarray(); 	
		spielarray.registerObserverReset(this);
		
		spielfeld = gameController.getSpielfeld();	//Subject for Observers
		
		/* init Listener */
		keyListener = new TetrisKeyListener(gameController);
		newGameListener = new NewGameListener(spielarray, gameController, mechanikController);
		
		frame = new Gui(newGameListener, keyListener, spielfeld);	
		frame.validate();

		frame.setWindowCenter();
		frame.setVisible(true);
		
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
		
		this.frame.resetTextField();		
	}
}
