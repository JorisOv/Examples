/*
Joris Overzier
I1b1

Deze Applet laat een calculator zien met diverse functies. 

Er zijn meerdere booleans aangebracht om op een zo compakt mogelijke manier een functionerend apparaat te hebben.

De buttons worden aangemaakt, er word op een functie gedrukt waarna een boolean op true springt. 
De volgende ingevoerdewaarde zal hierna door middel van een if-loop bepalen welke fuctie er op de waarde
moet worden los gelaten.
 *
 */

import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class Calculator extends Applet implements ActionListener
{
private boolean plusBoolean = false;
private boolean downBoolean = false; 
public int awnserOne = 0;
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
		
		zerro = new Button("0");
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
		
		g.drawString("The plus value is "+up ,100, 70);
		g.drawString("The minus value is "+down ,100, 80);
		g.drawString("Current Value total" +awnserOne , 100, 100 );
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == one){
			if(up)
				awnserOne = awnserOne + 1;
			if(down)
				awnserOne = awnserOne - 1;
			if(down == up) 
				awnserOne = 1;
		}
	
		if(event.getSource() == two){
			if(up)
				awnserOne = awnserOne + 2;
			if(down)
				awnserOne = awnserOne - 2;
			if(down == up)
				awnserOne = 2;
		}
		
		if(event.getSource() == three){
			if(up)
				awnserOne = awnserOne + 3;
			if(down)
				awnserOne = awnserOne - 3;
			if(down == up)
			awnserOne = 3;
		}
		
		if(event.getSource() == four){
			if(up)
				awnserOne = awnserOne + 4;
			if(down)
				awnserOne = awnserOne - 4;
			if(down == up) 
			awnserOne = 4;
		}
		
		if(event.getSource() == five){
			if(up)
				awnserOne = awnserOne + 5;
			if(down)
				awnserOne = awnserOne - 5;
			if(down == up) 
			awnserOne = 5;
		}
		
		if(event.getSource() == six){
			if(up)
				awnserOne = awnserOne + 6;
			if(down)
				awnserOne = awnserOne - 6;
			if(down == up) 
			awnserOne = 6;
		}
		
		if(event.getSource() == seven){
			if(up)
				awnserOne = awnserOne + 7;
			if(down)
				awnserOne = awnserOne - 7;
			if(down == up) 
			awnserOne = 7;
		}
		
		if(event.getSource() == acht){
			if(up)
				awnserOne = awnserOne + 8;
			if(down)
				awnserOne = awnserOne - 8;
			if(down == up) 
			awnserOne = 8;
		}
		
		if(event.getSource() == nine){
			if(up)
				awnserOne = awnserOne + 9;
			if(down)
				awnserOne = awnserOne - 9;
			if(down == up) 
			awnserOne = 9;
		}
		
		if(event.getSource() == zerro){
			if(up) 
				awnserOne = awnserOne + 0;
			if(down)
				awnserOne = awnserOne - 0;
			if(down == up) 
			awnserOne = 0;
		}
		
		if(event.getSource() == plus) {			
			down = false; 
			up = true;
		}
				
		if(event.getSource() == minus) {
			down = true;
			up = false;
			
		}
			
		if(event.getSource() == complete) {
			down = false;
			up = false;
		}
		
		if(event.getSource() == clear) {
			up = false;
			down = false;
			awnserOne = 0;
		}
		
		repaint();
		
	}
	
}
