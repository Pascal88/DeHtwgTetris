package de.htwg.tetris.gui;

import com.google.inject.Inject;

import de.htwg.tetris.DI.*;

public class GuiFactory implements IGui{
	
	private IGui gui = null;
	
	@Inject
	public GuiFactory (@Swt IGui gui) {
		this.gui = gui;
	}

	public void setTextFieldValue(int highscore) {
		this.gui.setTextFieldValue(highscore);		
	}

	public void resetTextField() {
		this.gui.resetTextField();		
	}
}