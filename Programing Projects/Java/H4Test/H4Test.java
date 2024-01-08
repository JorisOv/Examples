/*
 * @(#)H4Test.java 1.0 02/09/05
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


public class H4Test extends Applet
{
	public void init()
	{

	}

	public void paint(Graphics g)
	{
		float farStart = 0f;
		float calcFollow;
		
		while(farStart < 300)
		{
			farStart += 10;
			calcFollow = (farStart - 32.0f) * 5.0f / 9.0f;
		g.drawString("Welcome to Java!!", 50, 60 );
		}
		
		
	}
}
