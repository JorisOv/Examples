/*
 * @(#)BouncingBall3.java 1.0 02/11/20
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

public class BouncingBall3 extends Applet implements ActionListener {


private Button startBall, stopBall;

private Timer timer ;
	
private boolean runTimer;

private long initialValue, lastValue, changeValue, currentValue;

private int topBorder, bottomBorder, leftBorder, rightBorder;
private int xSize, ySize;
private int diameterBall;
private int positionX, positionY;

	
public void init() {
		
//		timer = new Timer( 50, this );
			
		//set layout
		setLayout(null);
		setSize(300,450);
		
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
		
	}

		public void actionPerformed (ActionEvent event) {
			if(event.getSource() == startBall) 
				runTimer = true;

			if(event.getSource() == stopBall) 
				runTimer = false;
		}

	public void paint(Graphics g) {

		g.drawRect (leftBorder, topBorder, xSize, ySize);
		g.drawString("Ball running: "+runTimer, 50, 310 );
		g.drawString("Time passed from start: "+changeValue, 50, 330);
	}
	
	
}
