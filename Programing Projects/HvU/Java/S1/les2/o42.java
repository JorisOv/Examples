////////////////////////
//Datum:	10 September 2004
//Autheur:	Joris Overzier
//Klas TIV1E
//
//Deze applet maakt een scroll bar. Indien de waarde van deze bar weizigd, 
//laat deze een circel zien, en berekent omvang, oppervlakte en volume.


import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class o42 extends Applet implements AdjustmentListener {

private Scrollbar radiusBar;
private int radiusBarValue;

   public void init () {
   	radiusBar = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,101);
   	add(radiusBar);
   	radiusBar.addAdjustmentListener(this);
	}

   public void paint(Graphics g) {
	float r=radiusBarValue;
	float omtrek = 2.0f*(float)Math.PI*r;
	float oppervlakte = (float)Math.PI*(r*r);
	float volume = (4f/3f)*(float)Math.PI*(r*r*r);

	g.drawOval(80,80,2*radiusBarValue,2*radiusBarValue);
	g.drawString("Omtrek     : "+omtrek,10,10);
	g.drawString("Oppervlakte: "+oppervlakte,10,30);
	g.drawString("Volume     : "+volume,10,50);
}

   public void adjustmentValueChanged(AdjustmentEvent e) {
   	radiusBarValue = radiusBar.getValue();
   	repaint();
	}

}
