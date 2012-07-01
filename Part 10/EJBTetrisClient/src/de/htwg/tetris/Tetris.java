package de.htwg.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.UIManager;

import de.htwg.tetris.controller.IGameController;
import de.htwg.tetris.controller.IMechanikController;
import de.htwg.tetris.controller.ITetrisController;
import de.htwg.tetris.controller.MechanikController;
import de.htwg.tetris.controller.GameController;
import de.htwg.tetris.controller.TetrisController;
import de.htwg.tetris.observer.IObserverNewElement;



public class Tetris 
{
	private ITetrisController tetrisController;
	private IGameController gameController;
	private IMechanikController mechanikController;
	ServerRemote Server;
	
	private List<IObserverNewElement> observersNewElement;
	
	public Tetris() {
		observersNewElement = new ArrayList<IObserverNewElement>();
		
		String urlName = "jnp://localhost:1099";
		Properties p = new Properties();
		p.put("java.naming.factory.initial",
		"org.jnp.interfaces.NamingContextFactory");
		p.put("java.naming.provider.url", urlName);
		p.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
		InitialContext context = null;
		try {
			context = new InitialContext(p);
			this.Server = (ServerRemote) context.lookup("tetrisServer");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		/* init controller*/
		gameController = new GameController(observersNewElement, this.Server);
		mechanikController = new MechanikController(gameController);
		tetrisController = new TetrisController(gameController, mechanikController);
		observersNewElement.add(tetrisController);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Tetris(); 
	}
}
