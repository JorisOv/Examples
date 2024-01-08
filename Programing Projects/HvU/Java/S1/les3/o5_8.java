////////////////////////
//Datum:	10 September 2004
//Autheur:	Joris Overzier
//Klas TIV1E
//
//Deze applet laat deze een circel zien, en berekent omvang, oppervlakte en volume.


import java.applet.Applet;
import java.awt.*;

public class o5_8 extends Applet{

int radiusV=20;

   public void init () {
	}

   public void paint(Graphics g) {
	drawData(g,radiusV);
	}
	
	private void drawData(Graphics g, int radius) {
	float r=radius;
	float omtrek = 2.0f*(float)Math.PI*r;
	float oppervlakte = (float)Math.PI*(r*r);
	float volume = (4f/3f)*(float)Math.PI*(r*r*r);
	
	g.drawString("De radius van de circel in pixels is      : "+radiusV,10,100);
	g.drawString("De omtrek van de circel in pixels is      : "+omtrek,10,120);
	g.drawString("De oppervlakte van de circel in pixels is : "+oppervlakte,10,140);
	g.drawString("Het vullume van de circel in pixels is    : "+oppervlakte,10,160);		
	}
}
