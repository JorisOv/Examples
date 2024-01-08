/*

Applet zorgt voor het wel gewilde zwembad. De linker diepte gaat tot 1 meter. De rechter gaat tot 3 meter.
Het gemiddelde wordt uitgerekend in kubeke meters.

 */

import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class SwimPool extends Applet
implements AdjustmentListener {

//initialiseren van variablen
	private Scrollbar barLeft, barRight;
	private int barLeftValue = 0;
	private int barRightValue = 0;
	
	
	public void init()
	{
//de linker en rechter diepte bar creeren.
		barLeft = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 10);
		add(barLeft);
		barLeft.addAdjustmentListener(this);
		
		barRight = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 30);
		add(barRight);
		barRight.addAdjustmentListener(this);
		
		
	}

	public void paint(Graphics g)
	{
//het maken van lijnen tussen de hoeken van het zwembad
		g.drawLine(50, 50 , 50, 50+barLeftValue);
		g.drawLine(250, 50 , 250, 50+barRightValue);
		g.drawLine(50, 50, 250, 50);
		g.drawLine(50, 50+barLeftValue, 250, 50+barRightValue);
		
//gemiddelde berekening en weergaven.
		float gemiddelde = 0.0f;
		gemiddelde = (barLeftValue + barRightValue) / 20.0f * 5 * 20;
		g.drawString ("de waarde gemiddelde diepte van het zwembad is " + gemiddelde + " m2", 50, 30);
		
		Polygon zwembad = new Polygon();
		zwembad.addPoint(250, 50);
		zwembad.addPoint(50, 50);
		zwembad.addPoint(50, 50+barLeftValue);
		zwembad.addPoint(251, 50+barRightValue);
		g.setColor(Color.blue);
		g.fillPolygon(zwembad);
		
	}

//repaint van het scherm na verandering waarden.
	public void adjustmentValueChanged(AdjustmentEvent e) 
	{
		barLeftValue = barLeft.getValue();
		barRightValue = barRight.getValue();
		repaint();		
	}


}
