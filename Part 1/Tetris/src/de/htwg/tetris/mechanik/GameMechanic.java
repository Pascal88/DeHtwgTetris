package de.htwg.tetris.mechanik;

import de.htwg.tetris.model.Element;
import de.htwg.tetris.move.*;
import de.htwg.tetris.controller.ITetrisController;

public class GameMechanic extends Thread implements Runnable 
{
	private ITetrisController controller = null;
	private IMove moveDown;
	Boolean isTetrisRun = true;
	Element el;

	public GameMechanic(ITetrisController controller, IMove moveDown) 
	{
		this.controller = controller;	
		this.moveDown = moveDown;
	}
	
	@Override
	public void run() 
	{
		int t_move = 320;	//0,32 seconds
		int count = 0;
		
		while (isTetrisRun)
		{
			if (isInterrupted())
			{
				break;
			}
			while (controller.getElement().getState())
			{
				try {
					Thread.sleep(t_move);
				} 
				catch (InterruptedException e) 
				{
					interrupt();
				}
				controller.move(moveDown);
			}
			
			count++;
			if(count == 15)
			{
				count = 0;
				t_move = t_move-(t_move/5);
			}
		}		
	}
}
