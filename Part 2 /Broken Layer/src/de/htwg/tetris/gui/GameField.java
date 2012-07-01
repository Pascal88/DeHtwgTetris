package de.htwg.tetris.gui;

//import gui.Spielfeld.richtung;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import de.htwg.tetris.model.*;
import de.htwg.tetris.observer.GameArray;
import de.htwg.tetris.observer.IObserver;




public class GameField extends JPanel implements IObserver{

	private static final long serialVersionUID = 1L;
	public final static int WIDTH = 10; 	// number of elements in the width of the gamefield 
	public final static int HEIGHT = 20; 	// number of elements in the height of the gamefield 
	
	private final static int EL = 30; 		// Element width and height
	private GameArray gameArray = null;


	public GameField(GameArray gameArray) 
	{
		this.gameArray = gameArray;
		this.gameArray.registerObserver(this);
	}
	
	
	@Override
	public void update() 
	{
		repaint();		
	}	
	
	
	public void resetGameField() 
	{
		gameArray.resetGame();
	}
	


	/**
	 *  paint the Array
	 */
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);

		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (gameArray.getState(i, j) != ArrayQuader.states.FREE) {
					Color f = gameArray.getColor(i,j);
					g.setColor(f);
					g.fillRect(EL * i, EL * j, EL, EL);
				}
			}
		}
	}
}
