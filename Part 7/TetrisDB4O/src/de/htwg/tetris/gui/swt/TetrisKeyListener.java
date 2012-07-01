package de.htwg.tetris.gui.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

import de.htwg.tetris.controller.IGameController;

public class TetrisKeyListener implements KeyListener
{
	private IGameController gameController;

	public TetrisKeyListener(IGameController gameController)
	{
		this.gameController = gameController;
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
			int key = e.keyCode;
			switch(key) {
				case SWT.ARROW_LEFT:
					gameController.moveLeft();
					break;
				case SWT.ARROW_RIGHT:
					gameController.moveRight();
					break;
				case SWT.ARROW_UP:
					gameController.moveUp();
					break;
				default:
					gameController.moveDown();
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
