///////////////////////////
//Autheur Joris Overzier
//Klas: TIV1E
//Applet maakt kaart aan en zet er bij welke waarden hij heeft.
//Wegens debug heb ik waarden laten staan. De eerste keer geeft hij al een kaart omtrek. dit is niet helemaal netjes, maar ik denk dat dit geen probleem is.


import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;

public class o7_2 extends Applet implements ActionListener {
	
	private Button pressMe;

//aanmaken variable voor kaart soord, en de waarde van deze	
	int kaartSoort;
	int cardValue;
	
	public void init(){
		//aanmaken button
		pressMe = new Button("genereer kaart");
		add(pressMe);
		pressMe.addActionListener(this);
	}
	
	public void paint(Graphics g) {
		//tekenen waarden als controlle
		g.drawString(""+cardValue,20,20);
		g.drawString(""+kaartSoort,40,20);
		//tekenen kaart
		g.drawRect(40,40,70,110);
		//tekenen kaartsoort
		switch (kaartSoort) {
			case 1 : g.drawString("Schoppen",50,70); break;
			case 2 : g.drawString("Klaveren",50,70); break;
			case 3 : g.drawString("Harten",50,70); break;
			case 4 : g.drawString("Ruiten",50,70); break;
		}
		//tekenen kaart waarde
		switch (cardValue) {
			case 1 : g.drawString("aas",50,50); break;
			case 2 : g.drawString("2",50,50); break;
			case 3 : g.drawString("3",50,50); break;
			case 4 : g.drawString("4",50,50); break;
			case 5 : g.drawString("5",50,50); break;
			case 6 : g.drawString("6",50,50); break;
			case 7 : g.drawString("7",50,50); break;
			case 8 : g.drawString("8",50,50); break;
			case 9 : g.drawString("9",50,50); break;
			case 10: g.drawString("10",50,50); break;
			case 11: g.drawString("Boer",50,50); break;
			case 12: g.drawString("Dame",50,50); break;
			case 13: g.drawString("Heer",50,50); break;
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		//spreekt voor zich :D
		//
		cardValue=(int)(Math.random()*13)+1;
		kaartSoort=(int)(Math.random()*4)+1;
		repaint();
	}
}
