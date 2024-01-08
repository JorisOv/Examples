////////////////////////
//Datum:	10 September 2004
//Autheur:	Joris Overzier
//Klas TIV1E
//
// Deze applet tekend een familie van een volwassene, en 2 kinderen.  Maar heeft ook 
// de methode om een mannetje te tekenen.


import java.awt.*;
import java.applet.*;

public class o5_5 extends Applet {

int inHeight=40;
int inBaseX=30;
int inBaseY=70;

	public void paint(Graphics g) {
                drawFamily(g,inHeight, inBaseX, inBaseY);

        }

	public void drawFamily(Graphics g, int height, int baseX, int baseY) {
		drawPerson(g,height, baseX, baseY);
		baseX=baseX+30;
		drawPerson(g,height,baseX,baseY);
		height=height/2;
		baseX=baseX+30;
		baseY=baseY/2;
		drawPerson(g,height, baseX, baseY);
		baseX=baseX+30;
		drawPerson(g,height, baseX, baseY);
		}

	private void drawPerson(Graphics g, int height, int baseX, int baseY) {
		
		//Berekenen van de top positie
		int topPosition = baseY-height; //70-50=20
		
		//aan maken hoofd positie
		int yPosHead = topPosition; //20
		
		//de hoogte door 2 delen om zo een lengte verhouding te krijgen
		int lengthBodyLegs= height/2; //50/2=25
		lengthBodyLegs = lengthBodyLegs-2; //ruimte maken voor het hoofd...
		int halfBody=lengthBodyLegs/2;//11
		
		//parameters voor lichaamsdelen. FOUT
		int headSize=4;
		int positionBody=topPosition+headSize;
		int positionLegs=positionBody+lengthBodyLegs;
		int positionFeet=positionLegs+lengthBodyLegs;
		int positionArms=positionBody+halfBody;
		

		//tekenen mannetje
		g.drawOval(baseX-2, yPosHead, 4, 4);
		g.drawLine(baseX,positionBody, baseX,positionLegs);
		g.drawLine(baseX-5, positionArms, baseX+5, positionArms);		
		g.drawLine(baseX, positionLegs, baseX-5, positionFeet);
		g.drawLine(baseX, positionLegs, baseX+5, positionFeet);
		   
}
}
