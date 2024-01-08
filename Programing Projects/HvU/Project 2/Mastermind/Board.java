import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;

import java.awt.event.MouseEvent;

public class Board extends Panel
{
	private Control control;
	private Codemaker cm;
	private Button btnCheck = new Button("Check");
	private final int aantalPegs = 40;
	private Peg pegs[] = new Peg[aantalPegs];
	private Peg pegsCheck[] = new Peg[aantalPegs];
	private int groep = 1;
	private int aantalOpdeJuistePlaats;
	private int aantalGoed;
	private int teller = 1;

	Panel p1 = new Panel();
	Panel p2 = new Panel();

	public Board(Control control, Codemaker cm)
	{
		this.control = control;
		this.cm = cm;

		setLayout(new GridLayout(1,2));
		p1.setBackground(Color.black);
		p2.setBackground(Color.gray);

		p1.setLayout(new GridLayout(11,4));
		p2.setLayout(new GridLayout(11,4));

		for (int i = 0; i < aantalPegs; i++)
		{
			pegs[i] = new Peg(0,0);
			p1.add(pegs[i]);
		}

		for (int i = 0; i < aantalPegs; i++)
		{
			pegsCheck[i] = new Peg(0,0);
			pegsCheck[i].setSize(13,13);
			pegsCheck[i].setColor(0);
			p2.add(pegsCheck[i]);
		}

		btnCheck.addActionListener(control);
		p2.add(btnCheck);

		enablePegClickable();
		disableBtnCheck();

		add(p1);
		add(p2);
	}

	public void handleColor(MouseEvent e)
	{
		for (int i = 0; i < aantalPegs; i++)
		{
			if (e.getSource() == pegs[i])
				pegs[i].nextColor();
		}

		p1.repaint();
	}

	public void check()
	{
		System.out.println("board.check");

		int code[] = new int[4]; // nog juiste array maken.
		int t, i;

		for (i = 0, t = (groep * 4) - 4; i < 4; i++, t++)
		{
			code[i] = pegs[t].getColor() -1;
		}

		aantalGoed = cm.aantalGoed(code);
		aantalOpdeJuistePlaats = cm.aantalOpDeJuistePlaats(code);

		System.out.println("aantal goed: " + aantalGoed);
		System.out.println("aantal op de juiste plaats" + aantalOpdeJuistePlaats);

		disablePegClickable();
		showPegsCheck();
		groep +=1;
		disableBtnCheck();

		if (groep <= 10)
		{
			enablePegClickable();
		}


	}

	private void enablePegClickable()
	{
		for (int i = (groep * 4) - 4; i < (groep * 4); i++)
		{
			pegs[i].addMouseListener(control);
			pegs[i].setClickable(true);
		}
	}

	private void disablePegClickable()
	{
			for (int i = (groep * 4) -4; i < (groep * 4); i++)
			{
				pegs[i].removeMouseListener(control);
				pegs[i].setClickable(false);
			}
	}

	private void showPegsCheck()
	{
		int aantalZwart = aantalGoed - aantalOpdeJuistePlaats;

		// 6 = darkGray = wel goed maar niet op de juiste plaats
		// 7 = zwart = fout
		// 8 = wit = op de juiste plaats

		for (int i = (groep * 4) -4; i < (groep * 4); i++)
		{
			if (aantalOpdeJuistePlaats > 0)
			{
				pegsCheck[i].setColor(8);
				aantalOpdeJuistePlaats -= 1;
			}
			else if (aantalZwart > 0)
			{
				pegsCheck[i].setColor(6);
				aantalZwart -= 1;
			}
			else
			{
				pegsCheck[i].setColor(7);
			}
		}
		p2.repaint();
	}

	private void disableBtnCheck()
	{
		btnCheck.setEnabled(false);
	}

	public void enableBtnCheck()
	{
		btnCheck.setEnabled(true);
	}

	public boolean checkIfGroepClicked()
	{
		int i = (groep * 4) - 4;
		if (pegs[i].getClicked() &&	pegs[i+1].getClicked() && pegs[i+2].getClicked() && pegs[i+3].getClicked())
			return true;
		else
			return false;

	}


}