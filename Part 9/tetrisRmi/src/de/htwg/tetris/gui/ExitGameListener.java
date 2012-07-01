package de.htwg.tetris.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ExitGameListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
