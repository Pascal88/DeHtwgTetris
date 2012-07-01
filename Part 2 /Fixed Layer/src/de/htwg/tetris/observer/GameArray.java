package de.htwg.tetris.observer;

import java.awt.Color;
import java.util.ArrayList;

import de.htwg.tetris.gui.GameField;
import de.htwg.tetris.model.ArrayQuader;
import de.htwg.tetris.model.Element;
import de.htwg.tetris.model.ArrayQuader.states;





public class GameArray implements ISubject{
	
	private ArrayQuader[][] game = null;
	protected final static int WIDTH = 10; 	// number of elements in the width 
	protected final static int HEIGHT = 20; // number of elements in the height
	private ArrayList<IObserver> observers;


	public GameArray() 
	{
		game = new ArrayQuader[WIDTH][HEIGHT]; 	// init Array
		for (int i = 0; i < WIDTH; i++) 		// init Elements in the Array
		{
			for (int j = 0; j < HEIGHT; j++) 
			{
				game[i][j] = new ArrayQuader();
			}
		}
		observers = new ArrayList<IObserver>();
		notifyObservers(observers);	
	}
	
	@Override
	public void notifyObservers(ArrayList<IObserver> observers) 
	{
		for (int i=0; i<observers.size();i++)
		{
			IObserver observer = observers.get(i);
			observer.update();
		}		
	}	
	@Override
	public void registerObserver(IObserver o) {
		observers.add(o);	
	}

	@Override
	public void removeObserver(IObserver o) {
		int i = observers.indexOf(o);
		if(i>=0)
		{
			observers.remove(i);
		}		
	}
	
	public void resetGame()
	{
		for (int i = 0; i < WIDTH; i++) // init Elements in the Array
		{
			for (int j = 0; j < HEIGHT; j++) {
				game[i][j].setState(states.FREE);
			}
		}
		notifyObservers(observers);
	}

	public ArrayQuader[][] getGame() {
		return game;
	}
	
	
	
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
	public boolean arrayStateOfElementPosition(Element el, states z)
	{
		boolean ret = true;
		int x = el.getX();
		int y = el.getY();
		if (!(
			(getState(x, y) == z)
			|| (getState(x + el.getQ2().getX(), y + el.getQ2().getY()) == z)
			|| (getState(x + el.getQ3().getX(), y + el.getQ3().getY()) == z)
			|| (getState(x + el.getQ4().getX(), y + el.getQ4().getY()) == z))
		)
		{
			return false;
		}
		return ret;		
	}
	
	
	/**
	 * check if the element is out of the spielarray
	 * 
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the spielarray
	 */
	public boolean arrayElementInArray(Element el)
	{
		boolean ret = false;
		
		if ((arrayElementInLeft(el)) 
			&(arrayElementInRight(el))
			&(arrayElementInDown(el))
			){
				ret = true;
		}	
		return ret;		
	}
	
	
	/**
	 * check if the element is LEFT in the array
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the array
	 */
	public boolean arrayElementInLeft(Element el)
	{
		boolean ret = false;
		int x = el.getX();

		if (((x >= 0) 
			& (x + el.getQ2().getX() >= 0)
			& (x + el.getQ3().getX() >= 0) 
			& (x + el.getQ4().getX() >= 0)))
		{
			ret = true;
		}
		return ret;		
	}
	
	/**
	 * check if the element is RIGHT in the array
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the array
	 */
	public boolean arrayElementInRight(Element el)
	{
		boolean ret = false;
		int b = GameField.WIDTH -1; // 10 -1	
		int x = el.getX();		
		
		if (((x <= b) 
			& (x + el.getQ2().getX() <= b)
			& (x + el.getQ3().getX() <= b) 
			& (x + el.getQ4().getX() <= b)))
		{
			ret = true;
		}
		return ret;		
	}

	/**
	 * check if the element is DOWN in the array
	 * @param el
	 * 		element that specifies the positions to be checked 
	 * @return true 
	 * 		if the element is in the array
	 */
	public boolean arrayElementInDown(Element el)
	{
		boolean ret = true;
		int h = GameField.HEIGHT; // 20 -1	
		int y = el.getY();		
		
		if (!((y < h) 
				& (y + el.getQ2().getY() < h)
				& (y + el.getQ3().getY() < h) 
				& (y + el.getQ4().getY() < h))) 
		{
			ret = false;
		}
		return ret;		
	}
	
	public void elementMergeArray(Element el) {
		for (int i = 0; i < GameField.WIDTH; i++) {
			for (int j = 0; j < GameField.HEIGHT; j++) {
				if (getState(i, j) == states.ELEMENT) {
					setState(i, j, states.FREE);
				}
			}
		}
		// set the elements
		if(el.getState())
		{
			setGameArrayElementToState(el, states.ELEMENT);
		}
		else	//element has reached the bottom
		{
			setGameArrayElementToState(el, states.TAKEN);
		}
	}
	
	
	private void setGameArrayElementToState(Element el, states z) 
	{
		int x = el.getX();
		int y = el.getY();
		
		setStateColor(x, y, z, el.getColor());
		setStateColor(
				(x + el.getQ2().getX()), (y + el.getQ2().getY()), 
				z, el.getColor());
		setStateColor(
				(x + el.getQ3().getX()), (y + el.getQ3().getY()), 
				z, el.getColor());
		setStateColor(
				(x + el.getQ4().getX()), (y + el.getQ4().getY()), 
				z, el.getColor());
		notifyObservers(observers);
	}
	
	
	
	public void setStateColor(int x, int y, states z, Color c)
	{
		game[x][y].setState(z);
		game[x][y].setColor(c);
		
	}
	/*
	 * State
	 */
	public states getState(int x, int y) 
	{
		states ret;
		if ((x >= 0) & (x < WIDTH) & (y >= 0) & (y < HEIGHT))
			ret = game[x][y].getState();
		else
			ret = states.TAKEN;
		return ret;
	}
	
	public void setState(int x, int y, states z) {
		game[x][y].setState(z);
		notifyObservers(observers);
	}

	
	/*
	 * Color
	 */
	public void setColor(int x, int y, Color c) {
		game[x][y].setColor(c);
		notifyObservers(observers);
	}
	public Color getColor(int x, int y) {
		return game[x][y].getColor();
	}
}
