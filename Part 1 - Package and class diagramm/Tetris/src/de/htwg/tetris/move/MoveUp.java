package de.htwg.tetris.move;

import de.htwg.tetris.model.Element;
import de.htwg.tetris.model.ArrayQuader.states;
import de.htwg.tetris.observer.GameArray;

public class MoveUp implements IMove
{
	@Override
	public void move(Element el, GameArray gameArray) 
	{
		if (moveTest(el, gameArray)) // move if possible
		{
			el.turn();
			gameArray.elementMergeArray(el);	
		}		
	}

	@Override
	public boolean moveTest(Element el, GameArray gameArray) 
	{
		int turnState = el.getTurnStatus();
		boolean ret = true;
		
		el.turn();

		if (!gameArray.arrayElementInArray(el))
		{
			ret = false;
		}
		if (gameArray.arrayStateOfElementPosition(el, states.TAKEN))
		{
			ret = false;
		}
		el.setTurnStatus(turnState);
		return ret;
	}
}
