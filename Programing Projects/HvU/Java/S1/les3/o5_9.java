////////////////////////
//Datum:	10 September 2004
//Autheur:	Joris Overzier
//Klas TIV1E
//
//Deze applet verdubbelt de waarde van een integer.


import java.applet.Applet;
import java.awt.*;

public class o5_9 extends Applet{

int initialNumber=20;

   public void init () {
	}

   public void paint(Graphics g) {
	int d1 = doubled(initialNumber);
	int d2 = doubled(doubled(doubled(10)));
	g.drawString("dubbled 20 is			: "+d1,10,60);
	g.drawString("doubled(doubled(doubled(10))) is	: "+d2,10,80);
	}
	
	private int doubled(int value) {
		value=value*2;
		return value;
	}
}
