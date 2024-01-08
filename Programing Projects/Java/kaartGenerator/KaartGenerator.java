/*

Let op! Ik heb het probleem met case 1 == case 11 of 15 of wat dan ook.

 */

import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class KaartGenerator extends Applet implements ActionListener {
	
	private Button getCard;
	private boolean cardCall = false;
	int kind;
	int valueCard;

	
	public void init()
	{
		getCard = new Button("New Card");
		add(getCard);
		getCard.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		cardCall = true;
		repaint();
	}

	public void paint(Graphics g)
	{
		int card;
		if(cardCall) {
			kind = (int) (Math.random() * 4) + 1;
			valueCard = (int) (Math.random() * 13) + 1;
			if (kind == 1) {
				switch (valueCard) {
					case 1 : g.drawString("De getrokken kaart is Schoppen Aas", 50, 50);
					case 2 : g.drawString("De getrokken kaart is Schoppen 2", 50, 50);
					case 3 : g.drawString("De getrokken kaart is Schoppen 3", 50, 50);
					case 4 : g.drawString("De getrokken kaart is Schoppen 4", 50, 50);
					case 5 : g.drawString("De getrokken kaart is Schoppen 5", 50, 50);
					case 6 : g.drawString("De getrokken kaart is Schoppen 6", 50, 50);
					case 7 : g.drawString("De getrokken kaart is Schoppen 7", 50, 50);
					case 8 : g.drawString("De getrokken kaart is Schoppen 8", 50, 50);
					case 9 : g.drawString("De getrokken kaart is Schoppen 9", 50, 50);
					case 10 : g.drawString("De getrokken kaart is Schoppen 10", 50, 50);
					case 11 : g.drawString("De getrokken kaart is Schoppen Boer", 50, 50);
					case 12 : g.drawString("De getrokken kaart is Schoppen Dame", 50, 50);
					case 13 : g.drawString("De getrokken kaart is Schoppen Heer", 50, 50);
					}
				}
			}
			if (kind == 2) {
				switch (valueCard) {
					case 1 : g.drawString("De getrokken kaart is Klaver Aas", 50, 50);
					case 2 : g.drawString("De getrokken kaart is Klaver 2", 50, 50);
					case 3 : g.drawString("De getrokken kaart is Klaver 3", 50, 50);
					case 4 : g.drawString("De getrokken kaart is Klaver 4", 50, 50);
					case 5 : g.drawString("De getrokken kaart is Klaver 5", 50, 50);
					case 6 : g.drawString("De getrokken kaart is Klaver 6", 50, 50);
					case 7 : g.drawString("De getrokken kaart is Klaver 7", 50, 50);
					case 8 : g.drawString("De getrokken kaart is Klaver 8", 50, 50);
					case 9 : g.drawString("De getrokken kaart is Klaver 9", 50, 50);
					case 10 : g.drawString("De getrokken kaart is Klaver 10", 50, 50);
					case 11 : g.drawString("De getrokken kaart is Klaver Boer", 50, 50);
					case 12 : g.drawString("De getrokken kaart is Klaver Dame", 50, 50);
					case 13 : g.drawString("De getrokken kaart is Klaver Heer", 50, 50);
				}
		}

			if (kind == 3) {
				switch (valueCard) {
					case 1 : g.drawString("De getrokken kaart is Harten Aas", 50, 50);
					case 2 : g.drawString("De getrokken kaart is Harten 2", 50, 50);
					case 3 : g.drawString("De getrokken kaart is Harten 3", 50, 50);
					case 4 : g.drawString("De getrokken kaart is Harten 4", 50, 50);
					case 5 : g.drawString("De getrokken kaart is Harten 5", 50, 50);
					case 6 : g.drawString("De getrokken kaart is Harten 6", 50, 50);
					case 7 : g.drawString("De getrokken kaart is Harten 7", 50, 50);
					case 8 : g.drawString("De getrokken kaart is Harten 8", 50, 50);
					case 9 : g.drawString("De getrokken kaart is Harten 9", 50, 50);
					case 10 : g.drawString("De getrokken kaart is Harten 10", 50, 50);
					case 11 : g.drawString("De getrokken kaart is Harten Boer", 50, 50);
					case 12 : g.drawString("De getrokken kaart is Harten Dame", 50, 50);
					case 13 : g.drawString("De getrokken kaart is Harten Heer", 50, 50);
				}
		}


			if (kind == 4) {
				switch (valueCard) {
					case 1 : g.drawString("De getrokken kaart is Ruiten Aas", 50, 50);
					case 2 : g.drawString("De getrokken kaart is Ruiten 2", 50, 50);
					case 3 : g.drawString("De getrokken kaart is Ruiten 3", 50, 50);
					case 4 : g.drawString("De getrokken kaart is Ruiten 4", 50, 50);
					case 5 : g.drawString("De getrokken kaart is Ruiten 5", 50, 50);
					case 6 : g.drawString("De getrokken kaart is Ruiten 6", 50, 50);
					case 7 : g.drawString("De getrokken kaart is Ruiten 7", 50, 50);
					case 8 : g.drawString("De getrokken kaart is Ruiten 8", 50, 50);
					case 9 : g.drawString("De getrokken kaart is Ruiten 9", 50, 50);
					case 10 : g.drawString("De getrokken kaart is Ruiten 10", 50, 50);
					case 11 : g.drawString("De getrokken kaart is Ruiten Boer", 50, 50);
					case 12 : g.drawString("De getrokken kaart is Ruiten Dame", 50, 50);
					case 13 : g.drawString("De getrokken kaart is Ruiten Heer", 50, 50);
				}
		}

}
}
		

