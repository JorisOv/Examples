////////////////////////////////////
// Autheur: Joris Overzier
// datum 24 September 2004
//klas TIV1E
//
//Deze applet sorteert 3 waarden

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class o7_3_3 extends Applet implements AdjustmentListener {
	//initialisatie scrollbars, en waarden variablen
	private Scrollbar firstSlider;
	private Scrollbar secondSlider;
	private Scrollbar thirdSlider;
	private int firstSliderValue=0;
	private int secondSliderValue=0;
	private int thirdSliderValue=0;

	public void init() {
		//initialisatie Scrollbars en labels
		Label firstLabel, secondLabel, thirdLabel;
		firstSlider = new Scrollbar(Scrollbar.HORIZONTAL,firstSliderValue,1,0,101);
		secondSlider = new Scrollbar(Scrollbar.HORIZONTAL,secondSliderValue,1,0,301);
		thirdSlider = new Scrollbar(Scrollbar.HORIZONTAL,thirdSliderValue,1,0,301);
		firstLabel = new Label("1e invoer:");
		secondLabel = new Label("2e invoer:");
		thirdLabel = new Label("3e invoer:");
		add(firstLabel);
		add(firstSlider);
		add(secondLabel);
		add(secondSlider);
		add(thirdLabel);
		add(thirdSlider);
		firstSlider.addAdjustmentListener(this);
		secondSlider.addAdjustmentListener(this);
		thirdSlider.addAdjustmentListener(this);
	}

	public void paint(Graphics g) {
		//afdrukken waarden
                g.drawString(""+firstSliderValue,20,100);
                g.drawString(""+secondSliderValue,20,120);
                g.drawString(""+thirdSliderValue,20,140);
		
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		//event update
		firstSliderValue = firstSlider.getValue();
		secondSliderValue = secondSlider.getValue();
		thirdSliderValue = thirdSlider.getValue();
		
		//super dik if statementjes :D In 10 regels samengevat wat ik in 
		//zo'n 80 regels had :D
		int temp;
                if (thirdSliderValue > firstSliderValue){
                        temp = thirdSliderValue;
                        thirdSliderValue = firstSliderValue;
                        firstSliderValue = temp;
                }
                if (thirdSliderValue > secondSliderValue){
                        temp = thirdSliderValue;
                        thirdSliderValue = secondSliderValue;
                        secondSliderValue = temp;
                }
                if (secondSliderValue > firstSliderValue){
                        temp = secondSliderValue;
                        secondSliderValue = firstSliderValue;
                        firstSliderValue = temp;
                }
		repaint();
	}
}
