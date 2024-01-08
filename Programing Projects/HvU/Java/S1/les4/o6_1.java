/////////////////////////////////////
//Autheur: Joris Overzier
//datum 24 September 2004
//klas TIV1e
//
//Deze applet heeft een slider welk gebruikt wordt om de waarde van een celcius grade weer te geven.
//Vervolgens wordt deze waarde om gerekend naar een farenheid

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class o6_1 extends Applet implements AdjustmentListener {
	private Scrollbar slider;
	private int sliderValue=0;
	float farenheit;

	public void init() {
		slider = new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,100);
		add(slider);
		farenheit = (sliderValue*9f/5f)+32;
		slider.addAdjustmentListener(this);
	}

	public void paint(Graphics g) {
		g.drawString("de waarde in celcius is   :"+sliderValue,10,50);
		g.drawString("De waarde in farenheit is :"+farenheit,10,60);
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		sliderValue = slider.getValue();
		farenheit = (sliderValue*9f/5f)+32;
		repaint();
	}
}
