package de.htwg.tetris.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwg.tetris.controller.IMechanikController;
import de.htwg.tetris.controller.ITetrisController;
import de.htwg.tetris.observer.GameArray;



public class NewGameListener implements ActionListener 
{
	private GameArray gameArray = null;
	private Thread mechanic = null;
	private ITetrisController tetrisController = null;
	IMechanikController mechanikController = null;
	
	public NewGameListener(GameArray gameArray, ITetrisController tetrisController, IMechanikController mechanikController) {
		this.gameArray = gameArray;
		this.mechanic = mechanikController.getMechanic();
		this.tetrisController = tetrisController;
		this.mechanikController = mechanikController;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		newGame();
	}
	
	private void newGame()
	{
		mechanikController.stopMechanic();
		tetrisController.newElement();
		gameArray.elementMergeArray(tetrisController.getElement());

		try {
			mechanic.start();
		}
		catch (Throwable e)
		{	
		}
	}
}
