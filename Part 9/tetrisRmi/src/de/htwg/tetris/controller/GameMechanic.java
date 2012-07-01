package de.htwg.tetris.controller;

import java.rmi.RemoteException;

public class GameMechanic implements Runnable
{
	private IGameController gameController = null;
	private volatile Boolean isTetrisRun = true;
	private volatile int count = 0;
	private volatile int tMove = 320;

	public GameMechanic(IGameController gameController) 
	{
		this.gameController = gameController;	
	}
	
	public void shutdown(){
		this.isTetrisRun = false;
	}
	
	public void run() 
	{
		while (isTetrisRun)
		{
			try {
				while (isTetrisRun && gameController.getElement().getState())
				{
					try {
						Thread.sleep(tMove);
					} 
					catch (InterruptedException e) 
					{
						shutdown();
					}
					synchronized(this.gameController){
						gameController.moveDown();
					}
				}
			} catch (RemoteException e) {
				e.printStackTrace();
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
