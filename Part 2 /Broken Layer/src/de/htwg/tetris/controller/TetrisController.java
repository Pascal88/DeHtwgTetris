package de.htwg.tetris.controller;


import java.util.Random;

import de.htwg.tetris.mechanik.GameMechanic;
import de.htwg.tetris.model.Element;
import de.htwg.tetris.model.ElementI;
import de.htwg.tetris.model.ElementJ;
import de.htwg.tetris.model.ElementL;
import de.htwg.tetris.model.ElementN;
import de.htwg.tetris.model.ElementO;
import de.htwg.tetris.model.ElementT;
import de.htwg.tetris.model.ElementZ;
import de.htwg.tetris.model.ArrayQuader.states;
import de.htwg.tetris.move.IMove;
import de.htwg.tetris.observer.GameArray;



public class TetrisController implements ITetrisController{

	GameArray gameArray = null;
	public Element element = null;
	public int highscore = 0; 
	private GameMechanic gameMechanic = null;	
	private Thread mechanic = null;

	public TetrisController(GameArray gameArray, IMove moveDown) 
	{
		this.gameArray = gameArray;
		/* init thread */
		gameMechanic = new GameMechanic(this, moveDown);
		setMechanic(new Thread(gameMechanic));
	}
	
	
	public void countHighscore(int i)
	{
		highscore += (i*100);
		if (i>0)
			System.out.println(highscore);
	}

	/**
	 * verschiebt das Element in die Richtung Move
	 * 
	 * @param el
	 * 		�bergebenes Element
	 * @param m
	 * 		Richtung die das Interface Move implementiert
	 */
	public void move(IMove m) 
	{
		m.move(element, gameArray);		
	}
		

	@Override
	public void update(int countFullLine) {
		newElement();
		countHighscore(countFullLine);
		if (testGameOver())
			stopMechanic();
	}
	
	public void stopMechanic()
	{
		mechanic.interrupt();	//interrupt the Thread -> Thread exit 
		try {
			wait(5);
		}
		catch (Throwable e)
		{	
		}
		resetGame();
	}
	
	private boolean testGameOver()
	{
		return gameArray.arrayStateOfElementPosition(element, states.TAKEN);	
	}
	
	public Element newElement()
	{
		Random rand = new Random();
		
		int el = rand.nextInt() % 7;
		if (el < 0)
		{
			el = el *-1;
		}
		switch (el) 
		{
		case 0:
			element = new ElementL();
			break;
		case 1:
			element = new ElementO();
			break;
		case 2:
			element = new ElementN();
			break;
		case 3:
			element = new ElementZ();
			break;
		case 4:
			element = new ElementI();
			break;
		case 5:
			element = new ElementJ();
			break;
		case 6:
			element = new ElementT();
			break;
		default:
			element = new ElementL();
			;
		}
		return element;
	}
	

	public Element getElement()
	{
		return element;
	}
	

	@Override
	public void solve() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void resetGame() 
	{
		gameArray.resetGame();	
	}


	public void setMechanic(Thread mechanic) {
		this.mechanic = mechanic;
	}


	public Thread getMechanic() {
		return mechanic;
	}
}
