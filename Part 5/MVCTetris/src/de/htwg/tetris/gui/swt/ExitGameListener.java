package de.htwg.tetris.gui.swt;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class ExitGameListener implements SelectionListener {

	@Override
	public void widgetSelected(SelectionEvent e) {
		System.exit(0);
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		
	}
}
