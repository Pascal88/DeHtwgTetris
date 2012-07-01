package de.htwg.tetris.controller;

public class GameMechanic extends Thread 
{
	private IGameController gameController = null;
	private Boolean isTetrisRun = true;
	private int count = 0;
	private int tMove = 320;

	public GameMechanic(IGameController gameController) 
	{
		this.gameController = gameController;	
	}
	
	@Override
	public void run() 
	{
		while (isTetrisRun)
		{
			if (isInterrupted())
			{
				break;
			}
			while (gameController.getElement().getState())
			{
				try {
					Thread.sleep(tMove);
				} 
				catch (InterruptedException e) 
				{
					interrupt();
				}
				gameController.moveDown();
			}
			
			count++;
			if(count == 15)
			{
				count = 0;
				tMove = tMove-(tMove/5);
			}
		}		
	}
}
