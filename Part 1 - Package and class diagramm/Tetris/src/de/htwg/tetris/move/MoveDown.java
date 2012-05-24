package de.htwg.tetris.move;

import java.awt.Color;
import java.util.ArrayList;

import de.htwg.tetris.model.Element;
import de.htwg.tetris.model.ArrayQuader.states;
import de.htwg.tetris.observer.IObserverNewElement;
import de.htwg.tetris.observer.ISubjectNewElement;
import de.htwg.tetris.observer.GameArray;
import de.htwg.tetris.gui.GameField;

public class MoveDown implements IMove, ISubjectNewElement
{
	GameArray gameArray;
	private ArrayList<IObserverNewElement> observersNewElement;
	public int countFullLine;
	
	public MoveDown(ArrayList<IObserverNewElement> observersNewElement)
	{
		this.observersNewElement = observersNewElement;
	}
	
	
	@Override
	public void move(Element el, GameArray gameArray) {
		this.gameArray = gameArray;
		if (moveTest(el, gameArray)) // move if it is possible
		{
			el.setY(el.getY() + 1);
			gameArray.elementMergeArray(el);		
		}	
		else	// element has reached the bottom
		{
			elementMergeArrayBottom(el);
			countFullLine = fullLine();		//return sum delete lines
			notifyObservers(observersNewElement);
		}
	}

	@Override
	public boolean moveTest(Element el, GameArray gameArray) 
	{
		boolean ret = true;
		int y = el.getY();
		el.setY(y + 1);

		// check border
		if (!(gameArray.arrayElementInDown(el)))
		{
			ret = false;
		}	
		// check if there is another element
		if (gameArray.arrayStateOfElementPosition(el, states.TAKEN))
		{
			el.setState(false);
			ret = false;
		}
		el.setY(y);
		return ret;
	}
	
	

	
	public void elementMergeArrayBottom(Element el) 
	{
		setGameArrayElementToState(el, states.TAKEN);
	}
	
	
	private void setGameArrayElementToState(Element el, states z) 
	{
		int x = el.getX();
		int y = el.getY();
		
		gameArray.setStateColor(x, y, z, el.getColor());
		gameArray.setStateColor(
				(x + el.getQ2().getX()), (y + el.getQ2().getY()), 
				z, el.getColor());
		gameArray.setStateColor(
				(x + el.getQ3().getX()), (y + el.getQ3().getY()), 
				z, el.getColor());
		gameArray.setStateColor(
				(x + el.getQ4().getX()), (y + el.getQ4().getY()), 
				z, el.getColor());
	}
	
	
	
	public void deleteFullLine(int j) {
		for (int y = j; y > 0; y--) 
		{
			for (int x = 0; x < GameField.WIDTH; x++) {
				gameArray.setState(x, y, gameArray.getState(x, y-1));
				Color c = gameArray.getColor(x, y-1);
				gameArray.setColor(x, y, c);
			}
		}
	}

	public int fullLine() 
	{
		int i = 0;
		for (int y = 0; y < GameField.HEIGHT; y++) 
		{
			int count = 0;
			for (int x = 0; x < GameField.WIDTH; x++) {
				if (gameArray.getState(x, y) != states.TAKEN) {
					break; // break, because row can not be full
				}
				count++;
			}
			if (count == 10) 
			{
				i++;
				deleteFullLine(y);
			}
		}
		return i;
	}




	@Override
	public void notifyObservers(ArrayList<IObserverNewElement> observersNewElement) 
	{
		for (int i=0; i<observersNewElement.size();i++)
		{
			IObserverNewElement observer = observersNewElement.get(i);
			observer.update(countFullLine);
		}			
	}

	@Override
	public void registerObserver(IObserverNewElement o) 
	{
		observersNewElement.add(o);	
	}

	@Override
	public void removeObserver(IObserverNewElement o) 
	{
		int i = observersNewElement.indexOf(o);
		if(i>=0)
		{
			observersNewElement.remove(i);
		}	
	}
}
