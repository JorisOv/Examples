////////////////////////
//Datum:	10 September 2004
//Autheur:	Joris Overzier
//Klas TIV1E
//
// Deze applet neemt aan dat er 100 cent in geworpen wordt
// en er een retour geld moet komen in zo min mogelijk munten.

import java.awt.*;
import java.applet.*;


public class o49 extends Applet {

	int amountGiven=100;
	int itemCost=55;
	int returnCash;
	int c50,c20,c10,c5,c2,c1;
		
	public void init() {
		returnCash=amountGiven-itemCost;
		c50=returnCash/50;
		returnCash=returnCash%50;
		c20=returnCash/20;
		returnCash=returnCash%20;
		c10=returnCash/10;
		returnCash=returnCash%10;
		c5=returnCash/5;
		returnCash=returnCash%5;
		c2=returnCash/2;
		returnCash=returnCash%2;
		c1=returnCash/1;
		returnCash=returnCash%1;
	}

	public void paint(Graphics g) {
		g.drawString("Ingegeven hoeveelhied: "+amountGiven, 50,20);
		g.drawString("Kosten product: " +itemCost,50,40);
		g.drawString("return 50c munten: "+c50, 50, 60 );
		g.drawString("return 20c munten: "+c20, 50, 80 );
		g.drawString("return 10c munten: "+c10, 50, 100 );
		g.drawString("return 5c munten: "+c5, 50, 120 );
		g.drawString("return 2c munten: "+c2, 50, 140 );
		g.drawString("return 1c munten: "+c1, 50, 160 );
	}
}
