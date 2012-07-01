package de.htwg.tetris.gui.swt;

import javax.swing.JOptionPane;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import de.htwg.tetris.controller.ITetrisController;
import de.htwg.tetris.controller.TetrisController;

public class LoadGameListener implements SelectionListener {
	
	private ITetrisController tetrisController = null;
	
	public LoadGameListener () {
		this.tetrisController = TetrisController.INSTANCE;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Object[] possibilities = tetrisController.load();
		tetrisController.load((String)JOptionPane.showInputDialog(null, "Select Save Game!","Load", JOptionPane.PLAIN_MESSAGE,null,possibilities,possibilities[0]));
	
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
