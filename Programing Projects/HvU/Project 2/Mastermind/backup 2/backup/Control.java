import java.awt.Color;
import java.awt.BorderLayout;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;


public class Control
implements MouseListener, WindowListener, ActionListener {

	private MyFrame mf = null;
	private Peg p;
	private Codemaker cm = new Codemaker(5,4);
	private Board board = new Board(this, cm);


	private MenuBar menuBar;
	private Menu menuBestand;
	private MenuShortcut menuShortcutNewGame;
	private MenuItem menuItemNewGame, menuItemSettings, menuItemExit;

	public Control(MyFrame mf) {
		this.mf = mf;

		mf.addWindowListener(this);
		board.addMouseListener(this);

		menuBar = new MenuBar();
		menuBestand = new Menu("File");
		menuItemNewGame = new MenuItem("New game");
		menuItemNewGame.addActionListener(this);
		menuItemSettings = new MenuItem("Settings");
		menuItemSettings.addActionListener(this);
		menuItemExit = new MenuItem("Exit");
		menuItemExit.addActionListener(this);
		menuBestand.add(menuItemNewGame);
		menuBestand.add(menuItemSettings);
		menuBestand.add(menuItemExit);
		menuBar.add(menuBestand);

		mf.setMenuBar(menuBar);

		mf.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Control.actionPerformed");

		if (e.getSource() == menuItemNewGame)
		{
			mf.add(board,BorderLayout.CENTER);
			mf.setVisible(true);
		}
		else if (e.getSource() == menuItemExit)
		{
			System.exit(0);
		}
		else
		{
			board.check();
		}

	}

	public void mouseExited(MouseEvent e)
	{
		System.out.println("Control.mouseExited");
	}

	public void mouseEntered(MouseEvent e)
	{
		System.out.println("Control.mouseEntered");
	}

	public void mousePressed(MouseEvent e)
	{
		System.out.println("Control.mousePressed");
	}

	public void mouseReleased(MouseEvent e)
	{
		System.out.println("Control.mouseReleased");
	}

	public void mouseClicked(MouseEvent e)
	{
		System.out.println("Control.mouseClicked");

		board.handleColor(e);
		board.repaint();
	}

	public void windowDeactivated(WindowEvent e)
	{
		System.out.println("Control.windowDeactivated");
	}

	public void windowActivated(WindowEvent e)
	{
		System.out.println("Control.windowActivated");
	}

	public void windowDeiconified(WindowEvent e)
	{
		System.out.println("Control.windowDeiconified");
	}

	public void windowIconified(WindowEvent e)
	{
		System.out.println("Control.windowIconified");
	}

	public void windowClosed(WindowEvent e)
	{
		System.out.println("Control.windowClosed");
	}

	public void windowClosing(WindowEvent e)
	{
		System.out.println("Control.windowClosing");
		System.exit(0);
	}

	public void windowOpened(WindowEvent e)
	{
		System.out.println("Control.windowOpened");
	}

}