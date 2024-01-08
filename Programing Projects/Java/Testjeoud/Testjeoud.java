/**
 * @(#)Testjeoud.java
 *
 * Sample Applet application
 *
 * @author 
 * @version 1.00 04/09/02
 */
 
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Testjeoud extends Applet
implements AdjustmentListener {
	
	private Scrollbar horpos;
	private Scrollbar vertpos;
	private Scrollbar sldiam;
	private int sliderValuehorpos;
	private int sliderValuevertpos;
	private int sliderValuesldiam;
	
	int inlefttop=sliderValuehorpos;
	int inlefttopvert=sliderValuevertpos;
	int indiam=sliderValuesldiam;
	
	public void init() {
		horpos = new Scrollbar(Scrollbar.HORIZONTAL, 0,0,0,200);
		vertpos = new Scrollbar(Scrollbar.HORIZONTAL, 0,0,0,200);
		sldiam = new Scrollbar(Scrollbar.HORIZONTAL, 20,0,0,200);
		add(horpos);
		add(vertpos);
		add(sldiam);
		horpos.addAdjustmentListener(this);
		vertpos.addAdjustmentListener(this);
		sldiam.addAdjustmentListener(this);
	}

	public void paint(Graphics g) {
		drawCirc(g, inlefttop, inlefttopvert,indiam);
		g.drawString("top left= "+inlefttop +inlefttopvert, indiam/2+inlefttop,indiam/2+inlefttopvert);
		
	}
	
	private void drawCirc(Graphics g, int lefttop, int lefttopvert, int diam) {
		g.drawOval(lefttop,lefttopvert,diam,diam);
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e){
		sliderValuehorpos = horpos.getValue();
		sliderValuevertpos = vertpos.getValue();
		sliderValuesldiam = sldiam.getValue();
		inlefttop=sliderValuehorpos;
		inlefttopvert=sliderValuevertpos;
		indiam=sliderValuesldiam;
		repaint();
	}
}
