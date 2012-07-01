package de.htwg.tetris.gui;

import com.google.inject.AbstractModule;

import de.htwg.tetris.DI.*;

public class GuiModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IGui.class).annotatedWith(Swing.class).to(de.htwg.tetris.gui.swing.Gui.class);
		bind(IGui.class).annotatedWith(Swt.class).to(de.htwg.tetris.gui.swt.Gui.class);
	}

}
