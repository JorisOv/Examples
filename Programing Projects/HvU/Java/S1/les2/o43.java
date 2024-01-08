////////////////////////////////////////
//Datum 10 September 2004
//Autheur: Joris OVerzier
//Klas: TIV1E
//
// Een programma welk van 2 intergers een float gemiddelde maakt


import java.awt.*;
import java.applet.Applet;

public class o43 extends Applet {
	public void paint(Graphics g) {
	int mark1Int=44;
	int mark2Int=51;
	float markGemiddeld=(mark1Int+mark2Int)/2f;
	g.drawString("Het gemiddelde van mark is: "+markGemiddeld,20,20);
	}
}
