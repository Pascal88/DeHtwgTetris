package de.htwg.tetris.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.htwg.tetris.controller.TetrisController;
import de.htwg.tetris.move.IMove;

public class TetrisKeyListener implements KeyListener
{
	private TetrisController controller;
	private IMove moveDown = null, moveLeft = null, moveRight = null, moveUp = null;

	public TetrisKeyListener(TetrisController controller, IMove moveDown, IMove moveLeft, IMove moveRight, IMove moveUp)
	{
		this.controller = controller;
		this.moveDown = moveDown;
		this.moveLeft = moveLeft;
		this.moveRight = moveRight;
		this.moveUp = moveUp;
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.CHAR_UNDEFINED) // Button pressed
		{
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_LEFT)
			{
				controller.move(moveLeft);
			}
			if (key == KeyEvent.VK_RIGHT)
			{
				controller.move(moveRight);
			}
			if (key == KeyEvent.VK_UP)
			{
				controller.move(moveUp);
			}
			if(key == KeyEvent.VK_DOWN)
			{
				controller.move(moveDown);
			}
		}		
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
}
