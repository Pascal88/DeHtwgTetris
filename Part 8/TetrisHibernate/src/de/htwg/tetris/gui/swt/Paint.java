package de.htwg.tetris.gui.swt;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import de.htwg.tetris.model.IGameArray;
import de.htwg.tetris.model.ITetrisColor;
import de.htwg.tetris.model.IQuader.states;

public class Paint implements PaintListener {

	private IGameArray gameArray = null;
	
	public Paint(IGameArray gameArray){
		this.gameArray = gameArray;
	}
	
	@Override
	public void paintControl(PaintEvent e) {
		for (int i = 0; i < IGameField.WIDTH; i++) {
			for (int j = 0; j < IGameField.HEIGHT; j++) {
				if (gameArray.getState(i, j) != states.FREE) {
					ITetrisColor c = gameArray.getColor(i,j);
					Color f = new Color(Display.getCurrent(), c.getR(), c.getG(), c.getB());
					e.gc.setForeground(f);
					e.gc.fillRectangle(IGameField.EL * i, IGameField.EL * j, IGameField.EL, IGameField.EL);
				}
			}
		}		
	}
}