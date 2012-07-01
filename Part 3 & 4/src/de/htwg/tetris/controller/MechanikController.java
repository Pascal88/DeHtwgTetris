package de.htwg.tetris.controller;

public class MechanikController implements IMechanikController {

	private GameMechanic gameMechanic = null;	
	private Thread mechanic = null;
	private IGameController gameController = null;
	
	public MechanikController(IGameController gameController) {
		gameMechanic = new GameMechanic(gameController);
		setMechanic(new Thread(gameMechanic));
		this.gameController = gameController;
	}
	public void stopMechanic()
	{
		mechanic.interrupt();	//interrupt the Thread -> Thread exit 
		
		gameController.resetGame();
	}
	
	public final void setMechanic(Thread mechanic) {
		this.mechanic = mechanic;
	}

	public Thread getMechanic() {
		return mechanic;
	}
}
