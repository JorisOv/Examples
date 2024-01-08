/*
 * @(#)BouncingBall2.java 1.0 02/11/20
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
import javax.swing.*;

public class BouncingBall2 extends Applet implements ActionListener {

private Timer timer;

private Button startBall, stopBall;

private boolean runTimer;
boolean xNegative, yNegative;

private long lastValue;

public int leftBorder,rightBorder,topBorder,bottomBorder;
public int ballPositionX,ballPositionY;
public int xSize, ySize;
public int xBuffer, yBuffer;
public int diameterBall;
public int changeValue2;


	public void actionPerformed (ActionEvent event) {
		
		if(event.getSource() == startBall) 
			runTimer = true;
		if(event.getSource() == stopBall) 
			runTimer = false;
		
		repaint();	
	}

		


	public void init() {
		
		//set layout
		setLayout(null);
		setSize(300,300);
		
		// maak borders
		leftBorder = 25;
		topBorder = 60;
		xSize = 250;
		ySize = 220;
		rightBorder = leftBorder + xSize;
		bottomBorder = topBorder + ySize;
		
		if(!runTimer){
			ballPositionX = leftBorder;
			ballPositionY = topBorder;
			diameterBall = 10;
		}	
		
				
		// maak button
		startBall = new Button("Start");
		stopBall = new Button("Stop");
		//bepaal locatie met buttonnaam.setBounds(x, y, xbreete, yhoogte);
		startBall.setBounds( 90, 20, 30, 30);
		stopBall.setBounds( 130, 20, 30, 30);
		// toevoen variable
		add(startBall);
		add(stopBall);
		//toevoegen actionListener.
		startBall.addActionListener(this);
		stopBall.addActionListener(this);
		
		//plaats timer op 50ms
		timer = new Timer( 50, this );
	}
	
	
	

	public void paint(Graphics g) {
		g.drawRect (leftBorder, topBorder, xSize, ySize);
		
		g.setColor(Color.black);					

// Komende deel heeft behoefde aan een infinite loop.
		if(runTimer){
			int bla45;
		
			for(bla45 = 0; bla45 < 87; bla45++)
				drawBall(g);
		}
// einde te editen stuk.
		
		g.drawString("X = "+ballPositionX,180,10);
		g.drawString("Y = "+ballPositionY,180,30);
		g.drawString("runTimer="+runTimer+",xNegative,"+xNegative+",yNegative,"+yNegative,10,300);
	}

	public void drawBall(Graphics g) {
			
		if(ballPositionX >= leftBorder && xBuffer >= xSize){
			xNegative = true;
			xBuffer = 0;
		}
//		it came in a dream, it went in a dream. Maar het werkt niet meer....
		if(ballPositionX <= (rightBorder - 10) && xBuffer >= xSize){
			xNegative = false;				
			xBuffer = 0;
		}
		if(ballPositionY >= bottomBorder && yBuffer >= ySize){
			yNegative = true;
			yBuffer = 0;
		}
		if(ballPositionY <= (bottomBorder - 10) && yBuffer >= ySize){
			yNegative = false;
			yBuffer = 0;
		}


			
			
		long initialValue, currentValue, changeValue;
		initialValue = System.currentTimeMillis();
		currentValue = System.currentTimeMillis() - initialValue;
		changeValue = currentValue - lastValue;
		lastValue = currentValue;
//		changeValue2 = giveChangeByTimer();
		changeValue2 = 3;
					
		xBuffer = xBuffer + changeValue2;
		yBuffer = yBuffer + changeValue2;
		if(xNegative)
			ballPositionX = ballPositionX - changeValue2;
		else
			ballPositionX = ballPositionX + changeValue2;
		if(yNegative)
			ballPositionY = ballPositionY - changeValue2;
		else
			ballPositionY = ballPositionY + changeValue2;
		
//		g.setColor( getBackground() );
		g.fillOval(ballPositionX, ballPositionY, diameterBall, diameterBall);		
	}

	public int giveChangeByTimer() {

		long initialValue, currentValue, changeValue;
		int returnedValue;
		initialValue = System.currentTimeMillis();
		currentValue = System.currentTimeMillis() - initialValue;
		changeValue = currentValue - lastValue;
		lastValue = currentValue;
		returnedValue = longToInt(changeValue);
		return returnedValue;
		
	}

	public int longToInt (long value ) {
   		Long objValue = new Long(value);
   		return objValue.intValue();
}

}
