package de.htwg.tetris.move;

import de.htwg.tetris.model.IElement;
import de.htwg.tetris.model.IGameArray;

public interface IMove {

	int h = 20; 		// 20
	int w = 10 -1; 	// 10 - 1	
	public void move(IElement el, IGameArray gameArray);
	
	/**
	 * checked whether move is possible
	 * 
	 * @param el
	 * 		Element to move
	 * @param gameArray
	 * 		the gamearray where it move
	 * @return true if it can move 
	 */
	public boolean moveTest(IElement el, IGameArray gameArray);
	
}
