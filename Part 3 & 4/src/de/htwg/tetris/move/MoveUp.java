package de.htwg.tetris.move;

import de.htwg.tetris.model.Element;
import de.htwg.tetris.model.IGameArray;
import de.htwg.tetris.model.IQuader.states;

public class MoveUp implements IMove
{
	@Override
	public void move(Element el, IGameArray gameArray) 
	{
		if (moveTest(el, gameArray)) // move if possible
		{
			el.turn();
			gameArray.elementMergeArray(el);	
		}		
	}

	@Override
	public boolean moveTest(Element el, IGameArray gameArray) 
	{
		int turnState = el.getTurnStatus();
		boolean ret = true;
		
		el.turn();

		if (!gameArray.arrayElementInArray(el) || gameArray.arrayStateOfElementPosition(el, states.TAKEN))
		{
			ret = false;
		}

		el.setTurnStatus(turnState);
		return ret;
	}
}
