/*
 * @(#)Yazee_Java.java 1.0 04/06/15
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_2\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Yazee_Java extends Applet implements ItemListener {

	public Checkbox 1;
	private boolean roleDiceAgain1;
		
	public void init() {
	1 = new Checkbox ("1");
	add(1);
	1.addItemListener(this);
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == roledDice1.getState()
			boolean roleDiceAgain1 = rolledDice1.getState();
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		int d1 = drawDice(g, 20, 20);
		int d2 = drawDice(g,100, 20);
		int d3 = drawDice(g,180, 20);
		int d4 = drawDice(g,260, 20);
		int d5 = drawDice(g,340, 20);
		int d6 = drawDice(g,420, 20);
		
		g.drawString(""+d1, 55,110);
		g.drawString(""+d2,135,110);
		g.drawString(""+d3,215,110);
		g.drawString(""+d4,295,110);
		g.drawString(""+d5,375,110);
		g.drawString(""+d6,455,110);
		
		if (roleDiceAgain1)
			gdrawString("yes",1,1);
			
	}
	
	private int drawDice(Graphics g, int initialX, int initialY) {
		
			int d1 = (int) (Math.random() * 6) + 1;
		
			g.drawRect(initialX, initialY, 70, 70 );
			
		if(d1 == 1){
			g.fillOval(initialX+30, initialY+30, 10, 10 );
		}
		
		if(d1 == 2){
			g.fillOval(initialX+10, initialY+10, 10, 10 );
			g.fillOval(initialX+50, initialY+50, 10, 10 );
		}
			
		if(d1 == 3){
			g.fillOval(initialX+10, initialY+10, 10, 10 );
			g.fillOval(initialX+50, initialY+50, 10, 10 );
			g.fillOval(initialX+30, initialY+30, 10, 10 );
		}
		
		if(d1 == 4){
			g.fillOval(initialX+10, initialY+10, 10, 10 );
			g.fillOval(initialX+50, initialY+50, 10, 10 );
			g.fillOval(initialX+10, initialY+50, 10, 10 );
			g.fillOval(initialX+50, initialY+10, 10, 10 );
		}
	
		if(d1 == 5){
			g.fillOval(initialX+30, initialY+30, 10, 10 );
			g.fillOval(initialX+10, initialY+10, 10, 10 );
			g.fillOval(initialX+50, initialY+50, 10, 10 );
			g.fillOval(initialX+10, initialY+50, 10, 10 );
			g.fillOval(initialX+50, initialY+10, 10, 10 );
		}
		
		if(d1 == 6){
			g.fillOval(initialX+10, initialY+10, 10, 10 );
			g.fillOval(initialX+50, initialY+50, 10, 10 );
			g.fillOval(initialX+10, initialY+50, 10, 10 );
			g.fillOval(initialX+50, initialY+10, 10, 10 );
			g.fillOval(initialX+30, initialY+10, 10, 10 );
			g.fillOval(initialX+30, initialY+50, 10, 10 );
		}	
		return d1;
	}
	
}
