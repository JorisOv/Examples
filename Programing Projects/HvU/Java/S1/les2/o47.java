////////////////////////////////////////
//Datum 10 September 2004
//Autheur: Joris OVerzier
//Klas: TIV1E
//
// Een programma welk een X aantal seconden om zet naar uren minuten en seconden


import java.awt.*;
import java.applet.Applet;

public class o47 extends Applet {
	
	public void paint(Graphics g) {
		//initialisaties int's en floats
		int totalSeconds=2549;
		int floatTotalSeconds1=totalSeconds;
		//uren = seconde/3600
		float hours=floatTotalSeconds1/3600f
		//medion uren
		float remainingSeconds=floatTotalSeconds1%3600f
		//minuten = overgebleven seconden / 60
		float minutes=remainingSeconds/60f;
		//medion minuten
		remainingSeconds=remainingSeconds%60f;
		float seconds=remainingSeconds;
	
		g.drawString("Totaal Aantal seconden : "+totalSeconds,20,20);
		g.drawString("Dit totaal verdeeld in de volgende eenheden:",20,40);
		g.drawString("Totaal aantal uren     : "+hours,20,80);
		g.drawString("Totaal aantal minuten  : "+minutes,20,100);
		g.drawString("Totaal aantal seconden : "+seconds,20,120);
	}
}
