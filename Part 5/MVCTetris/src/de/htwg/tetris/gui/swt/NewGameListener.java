package de.htwg.tetris.gui.swt;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import de.htwg.tetris.controller.GameController;
import de.htwg.tetris.controller.IMechanikController;
import de.htwg.tetris.controller.IGameController;
import de.htwg.tetris.controller.MechanikController;
import de.htwg.tetris.model.IGameArray;



public class NewGameListener implements SelectionListener 
{
	private IGameArray gameArray = null;
	private IGameController gameController = null;
	private IMechanikController mechanikController = null;
	
	public NewGameListener() {
		this.gameController = GameController.INSTANCE;
		this.mechanikController = MechanikController.INSTANCE;
		this.gameArray = this.gameController.getSpielarray();
	}
	
	public void newGame()
	{
		mechanikController.stopMechanic();
		gameController.resetGame();
		gameController.newElement();
		gameArray.elementMergeArray(gameController.getElement());

		mechanikController.newMechanik();
		
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		newGame();
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		
	}
}
