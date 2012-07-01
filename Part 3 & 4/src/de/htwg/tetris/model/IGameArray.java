package de.htwg.tetris.model;

import java.awt.Color;

import de.htwg.tetris.model.IQuader.states;
import de.htwg.tetris.observer.ISubject;
import de.htwg.tetris.observer.ISubjectResetGame;

public interface IGameArray extends ISubject, ISubjectResetGame {
	public void resetGame();
	
	/**
	 * check if the spielarray has the passed state on the element position
	 * 
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @param z
	 * 		state to check
	 * @return true 
	 * 		if the spielarray has the passed state 
	 */
	public boolean arrayStateOfElementPosition(Element el, states z);
	
	/**
	 * check if the element is out of the spielarray
	 * 
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the spielarray
	 */
	public boolean arrayElementInArray(Element el);	
	
	/**
	 * check if the element is LEFT in the array
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the array
	 */
	public boolean arrayElementInLeft(Element el);
	
	/**
	 * check if the element is RIGHT in the array
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the array
	 */
	public boolean arrayElementInRight(Element el);

	/**
	 * check if the element is DOWN in the array
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the array
	 */
	public boolean arrayElementInDown(Element el);
	public void elementMergeArray(Element el);
	public void setStateColor(int x, int y, states z, Color c);
	public states getState(int x, int y);
	
	public void setState(int x, int y, states z); 
	public void setColor(int x, int y, Color c);
	public Color getColor(int x, int y);
}
