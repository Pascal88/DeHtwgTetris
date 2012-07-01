package de.htwg.tetris.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwg.tetris.controller.IMechanikController;
import de.htwg.tetris.controller.IGameController;
import de.htwg.tetris.model.IGameArray;



public class NewGameListener implements ActionListener 
{
	private IGameArray gameArray = null;
	private Thread mechanic = null;
	private IGameController tetrisController = null;
	private IMechanikController mechanikController = null;
	
	public NewGameListener(IGameArray spielarray, IGameController tetrisController, IMechanikController mechanikController) {
		this.gameArray = spielarray;
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

		mechanic.start();
		
	}
}
