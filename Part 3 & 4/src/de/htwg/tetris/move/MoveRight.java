package de.htwg.tetris.move;

import de.htwg.tetris.model.Element;
import de.htwg.tetris.model.IGameArray;
import de.htwg.tetris.model.IQuader.states;

public class MoveRight implements IMove
{
	@Override
	public void move(Element el, IGameArray gameArray) 
	{
		if (moveTest(el, gameArray)) // move if possible
		{
			el.setX(el.getX() + 1);
			gameArray.elementMergeArray(el);	
		}
	}
	
	@Override
	public boolean moveTest(Element el, IGameArray gameArray) 
	{
		Boolean ret = true;
		int x = el.getX();
		
		el.setX(x + 1);
		
		if (!gameArray.arrayElementInRight(el) || gameArray.arrayStateOfElementPosition(el, states.TAKEN))
		{
			ret = false;
		}		
		
		el.setX(x);
		return ret;
	}
}
