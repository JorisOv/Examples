//////////////////
//autheur Joris overzier
//klas TIV1E
//applet maakt een muurtje op scherm

import java.awt.*;
import java.applet.Applet;

public class o8_4 extends Applet{
	
	public void paint(Graphics g) {
	//variable critiek voor werken applicatie
	int hoogteSteen =20;
	int breeteSteen=30;
	boolean inSpring=false;
	for (; hoogteSteen < 200; hoogteSteen=hoogteSteen+20){
		for (breeteSteen =30; breeteSteen < 300 ; breeteSteen=breeteSteen+30){
			if(inSpring)
				g.drawRect(breeteSteen,hoogteSteen, 30, 20);	
			
			else
				g.drawRect(breeteSteen-15,hoogteSteen, 30,20);
			
			
		}
		if (inSpring)
			inSpring=false;

		else 
			inSpring=true;
	}
	}
}
