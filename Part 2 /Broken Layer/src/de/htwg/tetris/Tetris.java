package de.htwg.tetris;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.UIManager;



import de.htwg.tetris.controller.TetrisController;
import de.htwg.tetris.gui.*;
import de.htwg.tetris.move.IMove;
import de.htwg.tetris.move.MoveDown;
import de.htwg.tetris.move.MoveLeft;
import de.htwg.tetris.move.MoveRight;
import de.htwg.tetris.move.MoveUp;
import de.htwg.tetris.observer.GameArray;
import de.htwg.tetris.observer.IObserverNewElement;



public class Tetris 
{
	private GameArray spielarray;
	private GameField spielfeld; 
	private TetrisController controller;
	
	private ArrayList<IObserverNewElement> observersNewElement;
	private IMove moveDown, moveLeft, moveRight, moveUp;
	private TetrisKeyListener keyListener;
	
	private NewGameListener newGameListener;
	private Gui frame;
	
	
	public Tetris() {
		observersNewElement = new ArrayList<IObserverNewElement>();
		
		spielarray = new GameArray(); 				
		spielfeld = new GameField(spielarray);	//Subject for Observers	
		
		/* init move */
		moveDown = new MoveDown(observersNewElement);
		moveLeft = new MoveLeft();
		moveRight = new MoveRight();
		moveUp = new MoveUp();
		
		/* init controller*/
		controller = new TetrisController(spielarray, moveDown);
		observersNewElement.add(controller);
	
		/* init Listener */
		keyListener = new TetrisKeyListener(controller, moveDown, moveLeft, moveRight, moveUp);
		newGameListener = new NewGameListener(spielarray, controller);
		
		frame = new Gui(newGameListener, keyListener, spielfeld);	
		frame.validate();

		setWindowCenter(frame);
		frame.setVisible(true);
	}

	public void setWindowCenter(Gui frame) 
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
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
