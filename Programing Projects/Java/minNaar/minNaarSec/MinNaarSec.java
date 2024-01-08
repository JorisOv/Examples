/*
Joris Overzier
I1b
Deze applet rekent de waarde van totaalSeconden om in hele uren, minuten en de resterende seconden.
 */

import java.awt.*;
import java.applet.*;


public class MinNaarSec extends Applet {
	
	public void init() {
	}

	public void paint(Graphics g) {
		int totaalSeconden = 2549;
		
		
		int sec = totaalSeconden % 60;
		int min = totaalSeconden / 60;
		int uren = min / 60;
		min = min % 60;
		g.drawString("Het begin aantal seconden kan worden verdeeld in de volgende blokken:", 10, 30);
		g.drawString("Totaal aantal uren: " + uren, 10, 50);
		g.drawString("Totaal aantal minuten: " + min, 10, 60);
		g.drawString("Aantal seconden: " + sec, 10, 70);
	}
}
