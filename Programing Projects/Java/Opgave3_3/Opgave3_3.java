/*
 * @(#)Opgave3_3.java 1.0 02/09/09
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


public class Opgave3_3 extends Applet
{
	public void init()
	{

	}

	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.fillArc(30, 30, 100, 100, 250, 40);
		g.setColor(Color.black);	
		g.fillRect(62, 125, 35, 50);
	}

}
