/*
 * @(#)DeLift.java 1.0 02/10/14
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


public class DeLift extends Applet implements ActionListener
{
private Button floorOne, floorTwo, floorThree;


	public void init()
	{
		setLayout(null);
		setSize(300,230);
		
		floorOne = new Button("1");
		add(floorOne);
		floorOne.addActionListener(this);
		floorOne.setBounds(10,50, 30, 30);
	
		floorTwo = new Button("1");
		add(floorTwo);
		floorTwo.addActionListener(this);
		floorTwo.setBounds(10,100, 30, 30);	
	
		floorThree = new Button("1");
		add(floorThree);
		floorThree.addActionListener(this);
		floorThree.setBounds(10,150, 30, 30);	
	
	
	}

	public void paint(Graphics g)
	{
		g.drawLine(  1,  1, 1, 299);
		g.drawLine( 50,  1, 50,229);
		g.drawLine( 50, 45,299, 45);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == floorOne);
		
		}
		

}
