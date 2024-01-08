/*
 * @(#)Stopwatch.java 1.0 02/11/18
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


public class Stopwatch extends Applet implements ActionListener{

private TextField display1;
private Button startButton;
private Button stopButton;

private long TimerValueInitial;	
private long currentTimerValue;
private boolean start;
private Timer timer ;

public void init() {
		display1 = new TextField(10);
		startButton = new Button();
		stopButton = new Button();
		timer = new Timer( 50, this );
		add(display1);
		add(startButton);
		add(stopButton);
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event){
		
		if( event.getSource() == startButton ){
			start = true;
			TimerValueInitial = System.currentTimeMillis();
			repaint();
		}
		
		if( event.getSource() == stopButton ){
			currentTimerValue = 100;
		}
		
		
		
	}

	public void paint(Graphics g) {
		
		
	display1.setText("0");
	
	if(start){
		while (currentTimerValue < 50){
			currentTimerValue = (System.currentTimeMillis() - TimerValueInitial) / 100;
			display1.setText(""+currentTimerValue);
			delay100ms();
		}
	}
	else
		g.drawString("druk op de knop om te starten", 20, 120);
	
	    
	  
	}
	
	public void delay100ms(){
		long initial;
		long currentValue;
		
		initial = System.currentTimeMillis();
		currentValue = (System.currentTimeMillis() - TimerValueInitial);
				
		while (currentValue < 100)
			currentValue = (System.currentTimeMillis() - TimerValueInitial);
		
	}
	
	
}
