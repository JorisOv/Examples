/*
 * @(#)BouncingBallTig.java 1.0 02/11/20
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


public class BouncingBallTig extends Applet implements ActionListener {

private Button startBall, stopBall;
private int leftBorder, rightBorder, topBorder, bottomBorder;
private int xSize, ySize;
private int ballPositionX, ballPositionY, diameterBall;
private Timer timer ;
private long changedTime;
private boolean xNegative, yNegative;
	
	public void init() {
		
		//set timer initial value.
		timer = new Timer( 50, this );
				
		//set layout
		setLayout(null);
		setSize(300,400);
		
		// maak borders
		leftBorder = 25;
		topBorder = 60;
		xSize = 250;
		ySize = 220;
		rightBorder = leftBorder + xSize;
		bottomBorder = topBorder + ySize;
		
		
						
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
		
		//initialiseer begin waarden 
		ballPositionX = leftBorder+1;
		ballPositionY = topBorder+1;
		diameterBall = 10;

	}

	public void actionPerformed (ActionEvent event) {
		if( event.getSource() == startBall) {
			
			//reageer op de startbutton
			timer.start();
			repaint();	
		}
	}
	
	public void paint(Graphics g) {
		g.drawRect (leftBorder, topBorder, xSize, ySize);
		changeBallLocation();
		drawBall(g);
	}


	public int longToInt (long value ) {
   		Long objValue = new Long(value);
   		return objValue.intValue();
   		
	}

		public void drawBall(Graphics g){
		g.drawOval (ballPositionX, ballPositionY, diameterBall, diameterBall);
	}

		public void changeBallLocation(){

			long initTimer;
			initTimer = System.currentTimeMillis();
			if (initTimer != changedTime){
				

				if ((ballPositionX % xSize) == 0)
					if(xNegative)
						xNegative = false;
					else
						xNegative = true;
				
				if ((ballPositionY % ySize) == 0);
					if(yNegative)
						yNegative = false;
					else
						yNegative = true;
						
				if (xNegative)
					ballPositionX--;
				if (!xNegative)
					ballPositionX++;				
				
				if (yNegative)
					ballPositionY--;
				if (!yNegative)
					ballPositionY++;
				
/*				if (ballPositionY > (bottomBorder - 10))
					ballPositionY--;
				else
					ballPositionY++; 
				
				if (ballPositionX > (rightBorder -10))
					ballPositionX++;
				else
					ballPositionY--;
*/					
					
			}
		changedTime = initTimer;
		}
	}