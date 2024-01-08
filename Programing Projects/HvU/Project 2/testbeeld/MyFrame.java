import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.Toolkit;
import java.awt.Dimension;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.geom.Ellipse2D;

public class MyFrame
extends Window
implements MouseListener
{
  private Dimension screenSize = getToolkit().getScreenSize();
  private Ellipse2D circel = new Ellipse2D.Float();
  
  public MyFrame()
  {
    super(new Frame());
    
    //System.out.println(screenSize.width+", "+screenSize.height);
    setBounds(0, 0, screenSize.width, screenSize.height);
    addMouseListener(this);
    show();
  }

  //Berekenen variablen.
  int centerSchermX = screenSize.width / 2;
  int centerSchermY = screenSize.height / 2;
  //hier zit fout!! spareSpaceLeftRight heeft geen waarde, in tijd nood dus ik ga er geen float meer van maken, bovendien heeft graphics moeite met floats.
  int spareSpaceLeftRight = screenSize.width % 17 /2;
  int spareSpaceTopBottom = screenSize.height % 13 /2;
  //doet het weer :)
  int enkelBgHokjeX = screenSize.width / 17;
  int enkelBgHokjeY = screenSize.height / 13;
  int halfBgHokjeX = enkelBgHokjeX / 2;
  int halfBgHokjeY = enkelBgHokjeY / 2;

  public void paint(Graphics g)
  {
    g.setColor(Color.white);

    int xLocatie, yLocatie;
    xLocatie = 0;
    yLocatie = 0;
    xLocatie = xLocatie + spareSpaceLeftRight;
    yLocatie = yLocatie + spareSpaceTopBottom;
	
	
    //Tekenen Achtergrond
    for (int i=0;i<13;i++){
       	for (int j=0;j<17;j++){
    		g.setColor(Color.gray);
    		g.fillRect(xLocatie+spareSpaceLeftRight, yLocatie+spareSpaceTopBottom, enkelBgHokjeX, enkelBgHokjeY);
    		g.setColor(Color.white);
    		g.drawRect(xLocatie+spareSpaceLeftRight, yLocatie+spareSpaceTopBottom, enkelBgHokjeX, enkelBgHokjeY);
    		xLocatie = xLocatie + (enkelBgHokjeY+1);
   		}
   		xLocatie = 0;
   		xLocatie = xLocatie + spareSpaceLeftRight;
   		yLocatie = yLocatie + enkelBgHokjeY;
   	}
   	//Eind tekenen Achtergrond

	xLocatie = 0;
	yLocatie = 0;


    //Maken van de graphishe dingen buiten het rondje :)
   	g.setColor(Color.green);
   	g.fillRect(xLocatie + spareSpaceLeftRight+enkelBgHokjeX+1,yLocatie+spareSpaceTopBottom+enkelBgHokjeY+1,xLocatie + spareSpaceLeftRight+enkelBgHokjeX-3,centerSchermY-(yLocatie+spareSpaceTopBottom+enkelBgHokjeY));
    g.setColor(Color.pink);
	g.fillRect(xLocatie + spareSpaceLeftRight+enkelBgHokjeX+1,screenSize.height-centerSchermY, enkelBgHokjeX,5*enkelBgHokjeY+halfBgHokjeY);
	
    //links secundair
    g.setColor(Color.blue);
    g.fillRect(xLocatie + spareSpaceLeftRight+2*enkelBgHokjeX+1,yLocatie+spareSpaceTopBottom+enkelBgHokjeY+1,xLocatie + spareSpaceLeftRight+enkelBgHokjeX-3,yLocatie+spareSpaceTopBottom+enkelBgHokjeY+enkelBgHokjeY+1);
    g.setColor(Color.cyan);
    g.fillRect(xLocatie + spareSpaceLeftRight+2*enkelBgHokjeX+1,yLocatie+spareSpaceTopBottom+10*enkelBgHokjeY+1,xLocatie + spareSpaceLeftRight+enkelBgHokjeX-3,yLocatie+spareSpaceTopBottom+enkelBgHokjeY+enkelBgHokjeY+1);
   
    //Maken van de rechter graphishe dingen buiten het rondje :)
    g.setColor(Color.green);
   	g.fillRect(xLocatie + spareSpaceLeftRight+15*enkelBgHokjeX,yLocatie+spareSpaceTopBottom+enkelBgHokjeY,xLocatie + spareSpaceLeftRight+enkelBgHokjeX,centerSchermY-(yLocatie+spareSpaceTopBottom+enkelBgHokjeY));
    g.setColor(Color.pink);
	g.fillRect(xLocatie + spareSpaceLeftRight+15*enkelBgHokjeX,screenSize.height-centerSchermY, enkelBgHokjeX,5*enkelBgHokjeY+halfBgHokjeY);
	//rechts secundair
    g.setColor(Color.blue);
    g.fillRect(xLocatie + spareSpaceLeftRight+14*enkelBgHokjeX,yLocatie+spareSpaceTopBottom+enkelBgHokjeY,xLocatie + spareSpaceLeftRight+enkelBgHokjeX,yLocatie+spareSpaceTopBottom+enkelBgHokjeY+enkelBgHokjeY);
    g.setColor(Color.cyan);
    g.fillRect(xLocatie + spareSpaceLeftRight+14*enkelBgHokjeX,yLocatie+spareSpaceTopBottom+10*enkelBgHokjeY,xLocatie + spareSpaceLeftRight+enkelBgHokjeX,yLocatie+spareSpaceTopBottom+enkelBgHokjeY+enkelBgHokjeY);
	
	//tracht ronde te maken.
	//aanmaken variable
	int xLocatieCircle = (screenSize.width - screenSize.height) /2;
	//maken circel
	circel.setFrame(xLocatieCircle+enkelBgHokjeX+1,enkelBgHokjeY,screenSize.height-enkelBgHokjeY-enkelBgHokjeY,screenSize.height-enkelBgHokjeY-enkelBgHokjeY);
	g.setClip(circel);
	g.setColor(Color.white);
	g.fillOval(xLocatieCircle+enkelBgHokjeX+1,enkelBgHokjeY,screenSize.height-enkelBgHokjeY-enkelBgHokjeY,screenSize.height-enkelBgHokjeY-enkelBgHokjeY);
    g.setColor(Color.red);
  	
  	/*Mental Note to self!
  	 *
  	 *	De locatie van de circel is gelijk aan 
  	 *	Xlocatie = xLocatieCircel(links)+enkelBgHokjeX+1
  	 *	Ylocatie = yLocatieCircel(boven)+enkelBgHokjeY
  	 *	Breete circel = height-enkelBgHokjeY-enkelBgHokjeY
  	 *
  	 */
  	 
  	 //aanmaken bottom -2 geel vierkant.
  	 g.setColor(Color.yellow);
  	 g.fillRect(0, screenSize.height-enkelBgHokjeX-enkelBgHokjeX, screenSize.height, screenSize.width);
  	 //zwart blokje in bodem geel vierkant
  	 g.setColor(Color.black);
  	 g.fillRect(8*enkelBgHokjeX, screenSize.height-enkelBgHokjeX-enkelBgHokjeX,enkelBgHokjeX, screenSize.width);
  	 //zwart balkje daar boven, incl text.
  	 g.fillRect(6*enkelBgHokjeX, screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 5*enkelBgHokjeX,enkelBgHokjeY);
  	 g.setColor(Color.gray);
  	 g.drawString("Joris Overzier TIV1E",15*halfBgHokjeX, screenSize.height-halfBgHokjeY-enkelBgHokjeY-enkelBgHokjeY);
  	 //5 rect's hier boven
  	 g.setColor(Color.black);
  	 g.fillRect(3*enkelBgHokjeX, screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 2*enkelBgHokjeX,enkelBgHokjeY);
  	 g.setColor(Color.gray);
  	 g.fillRect(5*enkelBgHokjeX, screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 2*enkelBgHokjeX,enkelBgHokjeY);
 	 g.setColor(Color.black);
 	 g.fillRect(7*enkelBgHokjeX, screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 2*enkelBgHokjeX,enkelBgHokjeY);
 	 g.setColor(Color.gray);
  	 g.fillRect(9*enkelBgHokjeX, screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 2*enkelBgHokjeX,enkelBgHokjeY); 
 	 g.setColor(Color.black);
 	 g.fillRect(11*enkelBgHokjeX, screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 2*enkelBgHokjeX,enkelBgHokjeY);
 	 g.setColor(Color.gray);
  	 g.fillRect(13*enkelBgHokjeX, screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 2*enkelBgHokjeX,enkelBgHokjeY); 
  	 
  	 //hier boven aanvankelijk de 2 zij rect's
  	 g.setColor(Color.black);
  	 g.fillRect(2*enkelBgHokjeX,screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 5*halfBgHokjeX,2*enkelBgHokjeY);
 	 g.fillRect(25*halfBgHokjeX,screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 2*enkelBgHokjeX,2*enkelBgHokjeY);
 	 //aanmaken boolean strepen
 	 boolean schakelaarZwartWit;
 	 schakelaarZwartWit = false;
 	 
 	 //aanmaken Lijnen DMV loopje.
 	 
 	 for(int i=0;i<(2*enkelBgHokjeX);){
 	 	if(schakelaarZwartWit = true){
 	 		g.fillRect(9*halfBgHokjeX+i,screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 8,2*enkelBgHokjeY);
 	 		i = i+8;
 	 		schakelaarZwartWit = false;
 	    }
 		else if (schakelaarZwartWit = false){
 			i = i+8;
 			schakelaarZwartWit = true;
 		}
 		else
 			schakelaarZwartWit = true;
 			i = i+8;
 		}
 	
 	for(int i=0;i<(2*enkelBgHokjeX);){
 	 	if(schakelaarZwartWit = true){
 	 		g.fillRect(13*halfBgHokjeX+i,screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 4,2*enkelBgHokjeY);
 	 		i = i+4;
 	 		schakelaarZwartWit = false;
 	    }
 		else if (schakelaarZwartWit = false){
 			i = i+4;
 			schakelaarZwartWit = true;
 		}
 		else
 			schakelaarZwartWit = true;
 			i = i+4;
 		}
 	
 	for(int i=0;i<(2*enkelBgHokjeX);){
 	 	if(schakelaarZwartWit = true){
 	 		g.fillRect(17*halfBgHokjeX+i,screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 2,2*enkelBgHokjeY);
 	 		i = i+2;
 	 		schakelaarZwartWit = false;
 	    }
 		else if (schakelaarZwartWit = false){
 			i = i+2;
 			schakelaarZwartWit = true;
 		}
 		else
 			schakelaarZwartWit = true;
 			i = i+2;
 		} 	
 	
 	 	for(int i=0;i<(2*enkelBgHokjeX);){
 	 	if(schakelaarZwartWit = true){
 	 		g.fillRect(21*halfBgHokjeX+i,screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 1,2*enkelBgHokjeY);
 	 		i = i+1;
 	 		schakelaarZwartWit = false;
 	    }
 		else if (schakelaarZwartWit = false){
 			i = i+1;
 			schakelaarZwartWit = true;
 		}
 		else
 			schakelaarZwartWit = true;
 			i = i+1;
 		} 	
 	
 	//tekenen 6 kleur vakken boven midden.
 	g.setColor(Color.yellow);
 	g.fillRect(5*halfBgHokjeX,4*enkelBgHokjeY,2*enkelBgHokjeX,5*halfBgHokjeY);
 	g.setColor(Color.cyan);
 	g.fillRect(9*halfBgHokjeX,4*enkelBgHokjeY,2*enkelBgHokjeX,5*halfBgHokjeY);
 	g.setColor(Color.green);
 	g.fillRect(13*halfBgHokjeX,4*enkelBgHokjeY,2*enkelBgHokjeX,5*halfBgHokjeY);
 	g.setColor(Color.pink);
 	g.fillRect(17*halfBgHokjeX,4*enkelBgHokjeY,2*enkelBgHokjeX,5*halfBgHokjeY);
 	g.setColor(Color.red);
 	g.fillRect(21*halfBgHokjeX,4*enkelBgHokjeY,2*enkelBgHokjeX,5*halfBgHokjeY);
 	g.setColor(Color.blue);
 	g.fillRect(25*halfBgHokjeX,4*enkelBgHokjeY,2*enkelBgHokjeX,5*halfBgHokjeY);


 	//aanmaken midden
 	g.setColor(Color.black);
 	g.fillRect(2*enkelBgHokjeX,screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, 24*halfBgHokjeX,enkelBgHokjeY);	
 	g.fillRect(centerSchermX-halfBgHokjeX, screenSize.height-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY-enkelBgHokjeY, enkelBgHokjeX, 3*enkelBgHokjeY);
 	//aanmaken door midden kruisende lijnen.
 	g.setColor(Color.white);
 	g.drawLine(2*enkelBgHokjeX,centerSchermY,14*enkelBgHokjeX, centerSchermY);
 	g.drawLine(centerSchermX, 5*enkelBgHokjeY+5, centerSchermX,8*enkelBgHokjeY+3);
 	//loopje voor midden lijnen
 	xLocatie = 4*enkelBgHokjeX;
 	yLocatie = 0;
 	for (int i=0; i<13;i++){
 		g.drawLine(xLocatie,6*enkelBgHokjeY+5,xLocatie, 7*enkelBgHokjeY+2);
 		xLocatie = xLocatie+enkelBgHokjeX;
 	}
 	
 	//rij boven 6 kleur vakken
 	int rotBlokMaat=(enkelBgHokjeX/3)*2;
 	xLocatie = 3*enkelBgHokjeX;
 	
 	for (int i=0;i<30;i++){
 		g.setColor(Color.gray);
 		g.fillRect(xLocatie, 3*enkelBgHokjeY,rotBlokMaat, enkelBgHokjeY);
 		xLocatie = xLocatie+rotBlokMaat;
 		g.setColor(Color.black);
 		g.fillRect(xLocatie, 3*enkelBgHokjeY,rotBlokMaat, enkelBgHokjeY);
 		xLocatie = xLocatie+rotBlokMaat;
 	}
 	
 	//rij daar boven.
 	g.setColor(Color.black);
 	g.fillRect(3*enkelBgHokjeX, 2*enkelBgHokjeY, 5*halfBgHokjeX,enkelBgHokjeY);
 	g.fillRect(12*halfBgHokjeX, 2*enkelBgHokjeY, 6,enkelBgHokjeY);
 	g.fillRect(11*enkelBgHokjeX, 2*enkelBgHokjeY, 5*halfBgHokjeX,enkelBgHokjeY);
  	
  	//bovenste rij in ronde.
  	g.fillRect(13*halfBgHokjeX,enkelBgHokjeY,4*enkelBgHokjeX,enkelBgHokjeY);
  	}
 	
 	
  public void mouseReleased(MouseEvent e)
  {
  }
  public void mousePressed(MouseEvent e)
  {
   System.exit(0);
  }
  public void mouseClicked(MouseEvent e)
  {
  }
  public void mouseEntered(MouseEvent e)
  {
  }
  public void mouseExited(MouseEvent e)
  {
  }
}