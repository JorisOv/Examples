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
	private Codemaker cm;
	private Board board;
	private StartScreen ss = new StartScreen();
	private HelpScreen hs;
	private SettingsScreen sets;


	private MenuItem menuItemNewGame, menuItemSettings,
					 menuItemHelpScreen, menuItemExit;

	public Control(MyFrame mf)
	{
		this.mf = mf;

		mf.addWindowListener(this);

		MenuBar menuBar;
		Menu menuBestand;
		MenuShortcut menuShortcutNewGame;

		menuBar = new MenuBar();
		menuBestand = new Menu("File");
		menuItemNewGame = new MenuItem("New game");
		menuItemNewGame.addActionListener(this);
		menuItemHelpScreen = new MenuItem("Help");
		menuItemHelpScreen.addActionListener(this);
		menuItemSettings = new MenuItem("Settings");
		menuItemSettings.addActionListener(this);
		menuItemExit = new MenuItem("Exit");
		menuItemExit.addActionListener(this);
		menuBestand.add(menuItemNewGame);
		menuBestand.add(menuItemSettings);
		menuBestand.add(menuItemHelpScreen);
		menuBestand.add(menuItemExit);
		menuBar.add(menuBestand);

		mf.setMenuBar(menuBar);

		mf.add(ss);
		mf.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Control.actionPerformed");
		if (ss != null)
		{
			mf.remove(ss);
			ss = null;
		}
		else if (hs != null)
		{
			mf.remove(hs);
			hs = null;
		}
		else if (sets != null)
		{
			mf.remove(sets);
			sets = null;
		}


		if (e.getSource() == menuItemNewGame)
		{
			if (board != null)
			{
				board.removeMouseListener(this);
				mf.remove(board);
				cm = null;
				board = null;
			}
			cm = new Codemaker(5,4);
			board = new Board(this, cm);
			board.addMouseListener(this);
			mf.add(board,BorderLayout.CENTER);
		}
		else if (e.getSource() == menuItemSettings)
		{
			if (board != null)
			{
				mf.remove(board);
			}
			sets = new SettingsScreen(this);
			mf.add(sets);

		}
		else if (e.getSource() == menuItemHelpScreen)
		{
			if (board != null)
			{
				mf.remove(board);
			}

			hs = new HelpScreen();
			mf.add(hs);
		}
		else if (e.getSource() == menuItemExit)
		{
			System.exit(0);
		}
		else if (e.getActionCommand().equals("Check"))
		{
				board.check();
		}
		mf.setVisible(true);
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

		if (board.checkIfGroepClicked())
			board.enableBtnCheck();
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