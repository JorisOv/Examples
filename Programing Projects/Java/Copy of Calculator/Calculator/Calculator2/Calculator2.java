/*
 * @(#)Calculator2.java 1.0 02/10/06
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


public class Calculator2 extends Applet implements ActionListener
{
private Button one, two, three, four, five, six, seven, acht, nine, zerro, plus, minus, complete, clear;

	public void init()
	{
		one = new Button("1");
		add(one);
		one.addActionListener(this);
		
		two = new Button("2");
		add(two);
		two.addActionListener(this);
		
		three = new Button("3");
		add(three);
		three.addActionListener(this);
		
		four = new Button("4");
		add(four);
		four.addActionListener(this);
		
		five = new Button("5");
		add(five);
		five.addActionListener(this);
		
		six = new Button("6");
		add(six);
		six.addActionListener(this);
		
		seven = new Button("7");
		add(seven);
		seven.addActionListener(this);
		
		acht = new Button("8");
		add(acht);
		acht.addActionListener(this);
		
		nine = new Button("9");
		add(nine);
		nine.addActionListener(this);
		
		zerro = new Button("10");
		add(zerro);
		zerro.addActionListener(this);
		
		plus = new Button("+");
		add(plus);
		plus.addActionListener(this);
		
		minus = new Button("-");
		add(minus);
		minus.addActionListener(this);
		
		complete = new Button("=");
		add(complete);
		complete.addActionListener(this);
		
		clear = new Button("Clear");
		add(clear);
		clear.addActionListener(this);
	}

	public void paint(Graphics g)
	{
		g.drawString("Welcome to Java!!", 50, 60 );
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == one){

		}
	
		if(event.getSource() == two){

		}
		
		if(event.getSource() == three){

		}
		
		if(event.getSource() == four){

		}
		
		if(event.getSource() == five){

		}
		
		if(event.getSource() == six){

		}
		
		if(event.getSource() == seven){

		}
		
		if(event.getSource() == acht){

		}
		
		if(event.getSource() == nine){

		}
		
		if(event.getSource() == zerro){

		}
		
		if(event.getSource() == plus) {			

		}
				
		if(event.getSource() == minus) {

		}
			
		if(event.getSource() == complete) {

		}
		
		if(event.getSource() == clear) {
		
		}
		
		
		repaint();
		
	}

}
