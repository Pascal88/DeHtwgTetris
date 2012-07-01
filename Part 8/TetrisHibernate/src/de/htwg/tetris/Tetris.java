package de.htwg.tetris;


import java.util.ArrayList;
import java.util.List;

import de.htwg.tetris.controller.IGameController;
import de.htwg.tetris.controller.IMechanikController;
import de.htwg.tetris.controller.ITetrisController;
import de.htwg.tetris.controller.MechanikController;
import de.htwg.tetris.controller.GameController;
import de.htwg.tetris.controller.TetrisController;
import de.htwg.tetris.observer.IObserverNewElement;



public class Tetris 
{
	private ITetrisController tetrisController;
	private IGameController gameController;
	private IMechanikController mechanikController;
	
	private List<IObserverNewElement> observersNewElement;
	
	public Tetris() {
		observersNewElement = new ArrayList<IObserverNewElement>();
		
		/* init controller*/
		gameController = new GameController(observersNewElement);
		mechanikController = new MechanikController(gameController);
		tetrisController = new TetrisController(gameController, mechanikController);
		observersNewElement.add(tetrisController);
	}

	public static void main(String[] args) {

		new Tetris(); 
	}
}
