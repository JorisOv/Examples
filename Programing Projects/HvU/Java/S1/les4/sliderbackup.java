import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class o6_1 extends Applet implements AdjustmentListener {
	private Scrollbar slider;
	private int sliderValue=0;

	public void init() {
		slider = new Scrollbar(Scrollbar.HORIZONTAL.0,1,0,100);
		add(slider);
		slider.addAdjustmentListener(this);
	}

	public void paint(Graphics g) {
		g.drawString("bla"+sliderValue,10,10);
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		sliderValue = slider.getValue();
		repaint();
	}
}
