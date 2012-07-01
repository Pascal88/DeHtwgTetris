package de.htwg.tetris.move;


import de.htwg.tetris.model.Element;
import de.htwg.tetris.observer.GameArray;
import de.htwg.tetris.gui.GameField;

public interface IMove {

	int h = GameField.HEIGHT; 		// 20
	int w = GameField.WIDTH -1; 	// 10 - 1	
	public void move(Element el, GameArray gameArray);
	
	/**
	 * checked whether move is possible
	 * 
	 * @param el
	 * 		Element to move
	 * @param gameArray
	 * 		the gamearray where it move
	 * @return true if it can move 
	 */
	public boolean moveTest(Element el, GameArray gameArray);
	
}
