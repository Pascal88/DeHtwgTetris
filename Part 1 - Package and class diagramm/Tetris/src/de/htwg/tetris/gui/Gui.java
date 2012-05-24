package de.htwg.tetris.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Gui extends JFrame 
{

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar = null;
	private JMenu gameMenu = null;
	private JMenuItem newMenuItem = null;
	private JMenuItem exitMenuItem = null;

	private GridBagLayout layout = null;
	private GridBagConstraints layoutMenu = null;
	private GridBagConstraints layoutGame = null;
	
	
	private TetrisKeyListener keyListener = null;
	private NewGameListener newGameListener = null;
	private GameField gameField= null;

	public Gui(NewGameListener newGameListener,	TetrisKeyListener keyListener, GameField gameField) 
	{
		super("Tetris");
		this.newGameListener = newGameListener;
		this.keyListener = keyListener;
		this.gameField = gameField;

		
		try {
			menuBar = new JMenuBar();
			gameMenu = new JMenu();
			newMenuItem = new JMenuItem();
			exitMenuItem = new JMenuItem();

			layout = new GridBagLayout();
			layoutMenu = new GridBagConstraints();
			layoutGame = new GridBagConstraints();
			
			addKeyListener(this.keyListener);			
			guiInit();
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Exit
	public void exitWindow() {
		System.exit(0);
	}


	private void guiInit() throws Exception {
		Container panel = getContentPane();
		panel.setBackground(Color.gray);

		Dimension Size = this.getSize();
		Size.width = 500;
		Size.height = 700;
		setMinimumSize(Size);

		panel.setLayout(layout);

		// Menu
		initMenu();
		layoutMenu.gridy = 0;
		layoutMenu.gridwidth = 3;
		layoutMenu.fill = GridBagConstraints.NONE;


		// Game
		layoutGame.gridy = 1;
		layoutGame.gridx = 2;
		layoutGame.ipadx = 300;
		layoutGame.ipady = 600;
		layoutGame.fill = GridBagConstraints.CENTER;

		// Border
		layout.setConstraints(gameMenu, layoutMenu);
		layout.setConstraints(gameField, layoutGame);

		this.setJMenuBar(menuBar);
		panel.add(gameField);
	}

	void initMenu() {
		// Menu
		gameMenu.setText("Spiel");

		newMenuItem.setText("Neues Spiel");
		newMenuItem.addActionListener(newGameListener);
		
		exitMenuItem.setText("Beenden");
		exitMenuItem.addActionListener(new ExitGameListener(this));

		// put Menus together
		gameMenu.add(newMenuItem);
		gameMenu.add(exitMenuItem);
		menuBar.add(gameMenu);

	}

	// Override, so you can exit the game 
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			exitWindow();
		}
	}
}
