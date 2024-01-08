/*
 * @(#)Neerval2.java 1.0 02/09/17
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


public class Neerval2 extends Applet
{
	public void init()
	{

	}

	public void paint(Graphics g)
	{
		//Opbouw X & Y-as
		g.drawLine(50, 50, 50,250);
		g.drawLine(50,250, 200,250);
		
		//Opmaak X & Y-as
		g.drawLine(60,245, 60,255);
		g.drawLine(70,245, 70,255);
		g.drawLine(80,245, 80,255);
		g.drawLine(90,245, 90,255);
		g.drawLine(100,245,100,255);
		g.drawLine(110,245,110,255);
		g.drawLine(120,245,120,255);
		g.drawLine(130,245,130,255);
		g.drawLine(140,245,140,255);
		g.drawLine(150,245,150,255);
		g.drawLine(160,245,160,255);
		g.drawLine(170,245,170,255);
		g.drawLine(180,245,180,255);
		g.drawLine(190,245,190,255);
		g.drawLine(200,245,200,255);
		
		//commentaar X & Y-as
		g.drawString("X-as 0-200",210,270);
		g.drawString("1994",  5, 80);
		g.drawString("1995",  5,160);
		g.drawString("1996",  5,220);
	
		//Waarden blokken in diverse kleuren
		g.setColor(Color.blue);
		g.fillRect( 50, 50,150, 60);
		g.setColor(Color.red);
		g.fillRect( 50, 120,175, 60);
		g.setColor(Color.orange);
		g.fillRect( 50, 190,120, 60);
		
		//Waarden print
		g.setColor(Color.black);
		g.drawString("150",180, 80);
		g.drawString("175",205,160);
		g.drawString("120",150,220);
		
		
	}
}
