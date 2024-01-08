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
	private int groep = 1;


	Panel p1 = new Panel();
	Panel p2 = new Panel();

	public Board(Control control, Codemaker cm)
	{
		this.control = control;
		this.cm = cm;

		setLayout(new GridLayout(1,2));
		p1.setBackground(Color.black);
		p2.setBackground(Color.gray);

		p1.setLayout(new GridLayout(10,4));
		p2.setLayout(new FlowLayout());

		for (int i = 0; i < aantalPegs; i++)
		{
			pegs[i] = new Peg(25,25);
			p1.add(pegs[i]);
		}

		btnCheck.addActionListener(control);
		p2.add(btnCheck);

		enablePegClickable(groep);

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

		for (int i = 0; i < 4; i++)
		{
			code[i] = pegs[i].getColor() -1;
		}


		System.out.println("aantal goed: " + cm.aantalGoed(code));
		System.out.println("aantal op de juiste plaats" + cm.aantalOpDeJuistePlaats(code));

		disablePegClickable(groep);
		groep +=1;
		enablePegClickable(groep);


	}

	private void enablePegClickable(int groep)
	{
		for (int i = (groep * 4) -4; i < (groep * 4); i++)
		{
			pegs[i].addMouseListener(control);
			pegs[i].setClickable(true);
		}
	}

	private void disablePegClickable(int groep)
	{
			for (int i = (groep * 4) -4; i < (groep * 4); i++)
			{
				pegs[i].removeMouseListener(control);
				pegs[i].setClickable(false);
			}
	}
}