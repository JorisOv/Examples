/*
Joris Overzier
I1b
Dit programma haalt een 20 procent van de variable "bruto" af.
 */

import java.awt.*;
import java.applet.*;


public class Belasting extends Applet {
	
	public void init() {
	}

	public void paint(Graphics g) {
		
		//initialisatie
		float bruto;
		float netto;
		float belasting;
		
		//berekening
		bruto = 100;
		netto = (bruto /100) * 80;
		belasting = (bruto - netto);
		
		//weergaven
		g.drawString("Bruto bedrag is " + bruto, 10, 30);
		g.drawString("Netto bedrag is " + netto, 10, 40);
		g.drawString("Het ingehouden bedrag bedraagd: " + belasting, 10, 50); 
	}
}
