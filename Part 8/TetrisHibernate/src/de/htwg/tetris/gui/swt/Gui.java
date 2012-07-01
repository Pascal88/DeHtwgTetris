package de.htwg.tetris.gui.swt;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.htwg.tetris.controller.IGameController;

public class Gui
{
	private final int layoutGameIpadX = 290;
	private final int layoutGameIpadY = 590;
	private final int layoutMenuHeightY = 30;
	private final int sizeWidth = 500;
	private final int sizeHeight = 680;
	
	private Menu menuBar = null;
	private Menu gameMenu = null;
	private MenuItem fileMenuHeader = null;
	private MenuItem newMenuItem = null;
	private MenuItem exitMenuItem = null;
	
	private Text textField = null;

	private GridLayout layout = null;
	private GridData layoutMenu = null;
	private GridData layoutGame = null;
	private GridData layoutText = null;
	
	private TetrisKeyListener keyListener = null;
	private NewGameListener newGameListener = null;
	private GameField gameField= null;
	private IGameController gameController;
	private Display display = null;
	private Shell shell = null;

	public Gui(NewGameListener newGameListener,	TetrisKeyListener keyListener, IGameController gameController) 
	{
		this.display = new Display();
		this.shell = new Shell(display);
		this.newGameListener = newGameListener;
		this.keyListener = keyListener;
		this.gameField = (GameField) gameField;
		this.gameController = gameController;
		
		try {
			//addKeyListener(this.keyListener);	
			guiInit();
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		shell.open();
		newGameListener.newGame();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
					display.sleep();
			}
		}
		display.dispose();
	}


	private final void guiInit() throws Exception {
		shell.setSize(sizeWidth, sizeHeight);
		shell.setText("Tetris");

		layout = new GridLayout();
		layout.numColumns = 1;
		shell.setLayout(layout);
		
		layoutMenu = new GridData();
		layoutGame = new GridData();
		layoutText = new GridData();
		
		// Menu
		initMenu();

		this.gameField = new GameField(this.gameController.getSpielarray(), shell);
		this.textField = new Text(shell,1);

		layoutMenu.heightHint = layoutMenuHeightY;
		layoutMenu.horizontalAlignment = GridData.FILL;
		
		// Game
		layoutGame.minimumWidth = layoutGameIpadX;
		layoutGame.minimumHeight = layoutGameIpadY;
		layoutGame.horizontalAlignment = GridData.FILL;
		layoutGame.verticalAlignment = GridData.FILL;
		
		layoutText.horizontalAlignment = GridData.FILL;
		
		textField.setEnabled(false);
		textField.setText("00000");

		// Border
		menuBar.setLocation(0, 50);
		gameField.setLayoutData(layoutGame);
		textField.setLayoutData(layoutText);

		shell.addKeyListener(keyListener);
		shell.setMenuBar(menuBar);
	}

	void initMenu() {
		// Menu
		menuBar = new Menu(shell, SWT.BAR);
		fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHeader.setText("&File");
		gameMenu = new Menu(shell, SWT.DROP_DOWN);
		newMenuItem = new MenuItem(gameMenu, SWT.CASCADE);
		newMenuItem.setText("&New");
		newMenuItem.addSelectionListener(newGameListener);
		exitMenuItem = new MenuItem(gameMenu, SWT.CASCADE);
		exitMenuItem.setText("&Exit");
		exitMenuItem.addSelectionListener(new ExitGameListener());
	}

	// Override, so you can exit the game 
	/*protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}*/

	public void setTextFieldValue(int highscore) {
		textField.setText(new Integer(highscore).toString());
	}
	
	public void resetTextField() {
		textField.setText(new Integer(0).toString());
	}
	
	/*public final void setWindowCenter() 
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
	}	*/
}
