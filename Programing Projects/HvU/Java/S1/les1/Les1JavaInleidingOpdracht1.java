////////////////////////
//Datum:	10 September 2004
//Autheur:	Joris Overzier
//Klas TIV1E
//
// Deze applet maakt een Java huisje :)







import java.awt.*;
import java.applet.*;


public class Les1JavaInleidingOpdracht1 extends Applet {

int inBottom=150;
int inTop=50;
int inLeftBase=50;
int inRightBase=150;
int inMidPoint=100;

        public void init() {
        }

        public void paint(Graphics g) {
                g.drawString("JavaChuch", inLeftBase+20,inBottom-20 );
                drawHome(g,inLeftBase, inRightBase, inMidPoint, inTop, inBottom);

        }

	        private void drawHome(Graphics g, int leftBase, int rightBase, int midPoint, int topPoint, int bottom) {
	                g.drawLine(leftBase,bottom,rightBase,bottom);
	                g.drawLine(leftBase,bottom,midPoint,topPoint);
	                g.drawLine(midPoint,topPoint,rightBase,bottom);
	                g.fillRect(leftBase,bottom,inMidPoint,bottom-100);
	                g.setColor(Color.RED);
	                g.fillRect(leftBase+3,bottom+35,5, 15);
	                g.setColor(Color.BLUE);
	                g.fillRect(leftBase+13,bottom+10,10,20);
	                g.fillRect(leftBase+13,bottom+35,10,10);
	                g.fillRect(leftBase+33,bottom+10,10,20);
	                g.fillRect(leftBase+33,bottom+35,10,10);
	                g.fillRect(leftBase+53,bottom+10,10,20);
	                g.fillRect(leftBase+53,bottom+35,10,10);
        	        g.fillRect(leftBase+73,bottom+10,10,20);
	                g.fillRect(leftBase+73,bottom+35,10,10);
	                g.setColor(Color.RED);
	                g.fillRect(leftBase+93,bottom+35,5, 15);
	                g.setColor(Color.BLACK);
	                g.drawLine(midPoint,topPoint,midPoint,topPoint-30);
	                g.drawLine(midPoint-10,topPoint-20,midPoint+10,topPoint-20);
	        }


}