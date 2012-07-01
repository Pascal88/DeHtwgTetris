package de.htwg.tetris.controller;

import de.htwg.tetris.move.IMove;

public class MechanikController implements IMechanikController {

	private GameMechanic gameMechanic = null;	
	private Thread mechanic = null;
	ITetrisController controller = null;
	
	public MechanikController(ITetrisController controller, IMove moveDown) {
		gameMechanic = new GameMechanic(controller, moveDown);
		setMechanic(new Thread(gameMechanic));
		this.controller = controller;
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
		controller.resetGame();
	}
	
	public void setMechanic(Thread mechanic) {
		this.mechanic = mechanic;
	}

	public Thread getMechanic() {
		return mechanic;
	}
	
	@Override
	public void update(int countFullLine) {
		controller.newElement();
		controller.countHighscore(countFullLine);
		if (controller.testGameOver())
			this.stopMechanic();
	}
}
