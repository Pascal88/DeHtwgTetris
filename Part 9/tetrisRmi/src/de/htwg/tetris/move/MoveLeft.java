package de.htwg.tetris.move;

import java.rmi.RemoteException;

import de.htwg.tetris.server.IElement;
import de.htwg.tetris.model.IGameArray;
import de.htwg.tetris.model.IQuader.states;

public class MoveLeft implements IMove
{	
	@Override
	public void move(IElement el, IGameArray gameArray) throws RemoteException {
		if (moveTest(el, gameArray)) // move if possible
		{
			el.setX(el.getX() - 1);
			gameArray.elementMergeArray(el);		
		}
	}

	@Override
	public boolean moveTest(IElement el, IGameArray gameArray) throws RemoteException 
	{
		boolean ret = true;
		int x = el.getX();
		
		el.setX(x - 1);
		
		if (!gameArray.arrayElementInLeft(el) || gameArray.arrayStateOfElementPosition(el, states.TAKEN))
		{
			ret = false;
		}	

		el.setX(x);
		return ret;
	}
}
