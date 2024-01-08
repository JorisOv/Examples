/*
 * @(#)Neerval_Xanadu.java 1.0 02/09/09
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


public class Neerval_Xanadu extends Applet
{
	public void init()
	{

	}

	public void paint(Graphics g)
	{
		
		// maken X & Y as.
		g.drawLine(30, 30, 30, 250);
		g.drawLine(30, 250, 250, 250);
		
		//Gegevens invoer incl, comentaar waarden
		g.setColor(Color.blue);
		g.fillRect(40, 100, 30, 150);
		g.setColor(Color.black);
		g.drawString("150cm", 40, 90);
		g.setColor(Color.red);
		g.fillRect(80, 75, 30, 175);
		g.setColor(Color.black);
		g.drawString("175cm", 80, 65);
		g.setColor(Color.orange);
		g.fillRect(120, 130, 30, 120);
		g.setColor(Color.black);
		
		// Maken van commentaar tabel
		g.drawString("1994", 40, 260);
		g.drawString("1995", 80, 260);
		g.drawString("1996", 120, 260);
		g.drawString("120cm", 120, 125);
		g.drawString("Years", 230, 265);
		g.drawString("n", 10, 40);
		g.drawString("e", 10, 50);
		g.drawString("e", 10, 60);
		g.drawString("r", 10, 70);
		g.drawString("v", 10, 80);
		g.drawString("a", 10, 90);
		g.drawString("l", 10, 100);
		g.drawString(" ", 10, 110);
		g.drawString("i", 10, 120);
		g.drawString("n", 10, 130);
		g.drawString(" ", 10, 140);
		g.drawString("C", 10, 150);
		g.drawString("M", 10, 160);

		//opmaak X as (afschijdingen van 25 picksels.)
		
		g.drawLine(25, 225, 35, 225);
		g.drawLine(25, 200, 35, 200);
		g.drawLine(25, 175, 35, 175);
		g.drawLine(25, 150, 35, 150);
		g.drawLine(25, 125, 35, 125);
		g.drawLine(25, 100, 35, 100);
		g.drawLine(25, 75, 35, 75);
		g.drawLine(25, 50, 35, 50);

		

	}
	
}
