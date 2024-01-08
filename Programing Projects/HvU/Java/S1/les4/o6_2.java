////////////////////////////////////
// Autheur: Joris Overzier
// datum 24 September 2004
//klas TIV1E
//
//Deze applet maakt een zwembad. Dit zwembad heeft als linker diepte max 100 px, en als rechter diepte max 300px

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class o6_2 extends Applet implements AdjustmentListener {
	//initialisatie scrollbars, en waarden variablen
	private Scrollbar leftSlider;
	private Scrollbar rightSlider;
	private int leftSliderValue=100;
	private int rightSliderValue=300;
	private float volume=(leftSliderValue+rightSliderValue)/200f*5*20;

	public void init() {
		//initialisatie Scrollbars
		Label labelOne, labelTwo;
		leftSlider = new Scrollbar(Scrollbar.HORIZONTAL,leftSliderValue,1,0,101);
		rightSlider = new Scrollbar(Scrollbar.HORIZONTAL,rightSliderValue,1,0,301);
		labelOne = new Label("LinkerDiepte:");
		labelTwo = new Label("rechterDiepte:");
		add(labelOne);
		add(leftSlider);
		add(labelTwo);
		add(rightSlider);
		leftSlider.addAdjustmentListener(this);
		rightSlider.addAdjustmentListener(this);
	}

	public void paint(Graphics g) {
		//slecht geplaatste zwembad pointers
		Polygon zwembad = new Polygon();
		zwembad.addPoint(250, 100);
		zwembad.addPoint(50, 100);
		zwembad.addPoint(50, 120+leftSliderValue);
		zwembad.addPoint(251, 120+rightSliderValue);
		
		
		//tekenen zwembad
		g.drawString("Het Vollume in kubieke meters: "+volume,30,50);
//		g.drawLine(30,70,530,70);
//		g.drawLine(30,70,30,leftSliderValue+70);
//		g.drawLine(530,70,530,rightSliderValue+70);
//		g.drawLine(30,leftSliderValue+70,530, rightSliderValue+70);
		g.setColor(Color.blue);
		g.fillPolygon(zwembad);
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		//event update
		leftSliderValue = leftSlider.getValue();
		rightSliderValue = rightSlider.getValue();
		float gemiddeldeDiepte = (leftSliderValue+rightSliderValue)/2f;
		volume=gemiddeldeDiepte/100f*5*20;
		
		repaint();
	}
}
