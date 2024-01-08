////////////////////////////////////////
//Datum 10 September 2004
//Autheur: Joris OVerzier
//Klas: TIV1E
//
// Een programma welk een parallel en serieele weerstand weer geeft.



import java.awt.*;
import java.applet.Applet;

public class o48 extends Applet {
	public void paint(Graphics g) {
		float r1 = 4.7f;
		float r2 = 6.8f;
		float serie = r1+r2;
		float parall = (r1*r2)/(r1+r2);
		g.drawString("serie weerstand   : "+serie, 20, 20);
		g.drawString("parallel weerstand: "+parall, 20, 40);
	}
}