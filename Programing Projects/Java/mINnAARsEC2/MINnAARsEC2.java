/*
 * @(#)MINnAARsEC2.java 1.0 02/09/17
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_2\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */

import java.awt.*;
import java.applet.*;


public class MINnAARsEC2 extends Applet {
	int total;


	public void init() {
	
		total = 2549;
	

		
	}

	
	public void paint(Graphics g) {
		g.drawString("totaal seconden: " + total(total%60), 50, 50);
		int sec = total % 60;
		int min = total / 60;
		int uren = min / 60;
		min = min % 60;
		g.drawString("Het begin aantal seconden kan worden verdeeld in de volgende blokken:", 10, 30);
		g.drawString("Totaal aantal uren: " + uren, 10, 50);
		g.drawString("Totaal aantal minuten: " + min, 10, 60);
		g.drawString("Aantal seconden: " + sec, 10, 70);
	}
	
	
}
