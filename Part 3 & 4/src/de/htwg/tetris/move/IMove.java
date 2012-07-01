package de.htwg.tetris.move;


import de.htwg.tetris.gui.IGameField;
import de.htwg.tetris.model.Element;
import de.htwg.tetris.model.IGameArray;

public interface IMove {

	int h = IGameField.HEIGHT; 		// 20
	int w = IGameField.WIDTH -1; 	// 10 - 1	
	public void move(Element el, IGameArray gameArray);
	
	/**
	 * checked whether move is possible
	 * 
	 * @param el
	 * 		Element to move
	 * @param gameArray
	 * 		the gamearray where it move
	 * @return true if it can move 
	 */
	public boolean moveTest(Element el, IGameArray gameArray);
	
}
