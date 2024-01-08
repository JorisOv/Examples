// autheur: Joris Overzier
// Klas TIV1E
// applet tekent 100 random diameter circels met random positie.


import java.awt.*;
import java.applet.Applet;

public class o8_3 extends Applet{
	
	public void paint(Graphics g) {
		for(int i = 0; i < 100;i++){
		//aan maken maximale nummer random
			int maxRandomValue = 100;
		//aan maken 4 variablen voor circel
			int circelX = makeRandom(maxRandomValue);
			int circelY = makeRandom(maxRandomValue);
			int circelDiam = makeRandom(maxRandomValue);
			drawCircle(g,circelX,circelY,circelDiam,circelDiam);
		}

		
	}
	
	private void drawCircle(Graphics g, int x, int y, int hoogte, int breete){
		g.drawOval(x,y,hoogte,breete);
	}
	
	private int makeRandom(int limit){
		int returnValue=(int)(Math.random()* limit) +1;
		return returnValue;
	}
	
}

