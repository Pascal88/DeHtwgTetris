package de.htwg.tetris.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import de.htwg.tetris.controller.ITetrisController;
import de.htwg.tetris.observer.GameArray;



public class NewGameListener implements ActionListener 
{
	private GameArray gameArray = null;
	private Thread mechanic = null;
	private ITetrisController controller = null;
	
	public NewGameListener(GameArray gameArray, ITetrisController controller) {
		this.gameArray = gameArray;
		this.mechanic = controller.getMechanic();
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		newGame();
	}
	
	private void newGame()
	{
		controller.stopMechanic();
		controller.newElement();
		gameArray.elementMergeArray(controller.getElement());

		try {
			mechanic.start();
		}
		catch (Throwable e)
		{	
		}
	}
}
