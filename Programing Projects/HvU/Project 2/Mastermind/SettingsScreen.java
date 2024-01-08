import java.awt.Panel;
import java.awt.Graphics;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Label;


public class SettingsScreen extends Panel {

	private Control control;
	private CheckboxGroup cbgKleur, cbgAantalpegs;

	public SettingsScreen(Control control)
	{
		this.control = control;

		Label lblAmountColors, lblAmountPegs;
		lblAmountColors = new Label("Aantal kleuren:");
		add(lblAmountColors);

		Checkbox chkColorFour, chkColorFive, chkColorSix, chkColorSeven;
		Checkbox chkAmountFour, chkAmountFive;

		cbgKleur = new CheckboxGroup();
		chkColorFour = new Checkbox("4",cbgKleur,false);
		add(chkColorFour);
		chkColorFive = new Checkbox("5",cbgKleur,false);
		add(chkColorFive);
		chkColorSix = new Checkbox("6",cbgKleur,true);
		add(chkColorSix);
		chkColorSeven = new Checkbox("7",cbgKleur,false);
		add(chkColorSeven);

		lblAmountPegs = new Label("Aantal pionnen:");
		add(lblAmountPegs);

		cbgAantalpegs = new CheckboxGroup();
		chkAmountFour = new Checkbox("4",cbgAantalpegs,true);
		add(chkAmountFour);
		chkAmountFive = new Checkbox("5",cbgAantalpegs,false);
		add(chkAmountFive);

	}

	public void paint(Graphics g)
	{
	}



}