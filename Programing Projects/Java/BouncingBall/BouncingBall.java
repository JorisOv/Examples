/*
 * @(#)BouncingBall.java 1.0 02/11/18
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


public class BouncingBall extends Applet implements ActionListener {

private Button startBall, stopBall;
private long initialTimer;
private long calculateTimer;
private Timer timer ;	
private boolean runTimer;
private long initialValue, lastValue, changeValue;
private int topBorder, bottomBorder, leftBorder, rightBorder;
private int xSize, ySize;
private int diameterBall;
private long positionX, positionY;
private int intPositionX, intPositionY;
private boolean xNegative, yNegative;
	
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
		
		positionX = 25;
		positionY = 60;
		diameterBall = 10;
		
		
				
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
		
		keepTimer();
		
		
	}
		public void actionPerformed (ActionEvent event) {
			if(event.getSource() == startBall) 
				runTimer = true;
				timer.start();
			if(event.getSource() == stopBall) 
				runTimer = false;
			
			repaint();	
			
			
		}

	public void paint(Graphics g) {
		g.drawRect (leftBorder, topBorder, xSize, ySize);
		drawBall(g);
	}
	
	public void keepTimer(){
		long currentValue;
		if(runTimer)

						
			initialValue = System.currentTimeMillis();
			currentValue = System.currentTimeMillis() - initialValue;
			changeValue = currentValue - lastValue;
			lastValue = currentValue;
			

			
			if(positionX <= leftBorder)
				xNegative = false;
			if(positionX >= (rightBorder - 10))
				xNegative = true;				
			if(positionY <= bottomBorder)
				yNegative = false;
			if(positionY >= (bottomBorder - 10))
				yNegative = true;
				
			if(xNegative)
				positionX = positionX - changeValue;
			else
				positionX = positionX + changeValue;
			
			if(yNegative)
				positionY = positionY - changeValue;
			else
				positionY = positionY + changeValue;
			
			
			
	}
	
	public void drawBall(Graphics g){
		intPositionX = longToInt(positionX);
		intPositionY = longToInt(positionY);
	
		g.setColor(Color.black);					
		g.fillOval(intPositionX, intPositionY, diameterBall, diameterBall);
		
		g.drawString(""+intPositionX,150,150);
		g.drawString(""+intPositionY,150,170);
	}
	
	

}
