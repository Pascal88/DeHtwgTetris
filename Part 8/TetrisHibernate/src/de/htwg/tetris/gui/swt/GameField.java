package de.htwg.tetris.gui.swt;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Shell;

import de.htwg.tetris.gui.swt.IGameField;
import de.htwg.tetris.model.IGameArray;
import de.htwg.tetris.observer.IObserver;

public class GameField extends Canvas implements IObserver, IGameField{

	private IGameArray gameArray = null;

	public GameField(IGameArray spielarray, Shell shell) 
	{
		super(shell, SWT.NO_REDRAW_RESIZE);
		this.gameArray = spielarray;
		this.gameArray.registerObserver(this);
		this.addPaintListener(new Paint(gameArray));
	}
	
	public void update() 
	{
		this.redraw();
	}	
	
	public void resetGameField() 
	{
		gameArray.resetGame();
	}
}