package de.htwg.tetris.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ExitGameListener implements ActionListener {
	private Gui gui;
	
	public ExitGameListener(Gui gui) {
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.exitWindow();
	}
}
