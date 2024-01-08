///////
// autheur Joris Overzier
// Klas TIV1E
// applet gooit dobbelsteen en controleerd of er gelijke worpen zijn.

import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;

public class o7_5 extends Applet implements ActionListener {
	
	private Button pressMe;

//aanmaken variable voor kaart soord, en de waarde van deze	
	int firstValue, secondValue, thirdValue;
	
	public void init(){
		//aanmaken button
		pressMe = new Button("doe 3 worpen");
		add(pressMe);
		pressMe.addActionListener(this);
	}
	
	public void paint(Graphics g) {
		//controlle waarden:
		g.drawString("controlle waarden:",30, 10);
		g.drawString(""+firstValue,30,20);
		g.drawString(""+secondValue,30,30);
		g.drawString(""+thirdValue,30,40);
		if(firstValue==6 && secondValue ==6 && thirdValue ==6)
			g.drawString("U heeft 3 maal een 6, en wint 20 euro",30,70);			
		else if(firstValue == secondValue && secondValue==thirdValue)
			g.drawString("U heeft 3 maal een gelijke waarde, en wint 10 euro",30,70);			
		else if(firstValue == secondValue || firstValue == thirdValue || secondValue == thirdValue)
			g.drawString("U heeft 2 maal een gelijke waarde, en wint 5 euro",30,70);			
		else
			g.drawString("Gokken is slecht voor de portomonee! U wint niets",30,70);
	}
	
	
	public void actionPerformed(ActionEvent event) {
		//spreekt voor zich :D
		firstValue=(int)(Math.random()*6)+1;
		secondValue=(int)(Math.random()*6)+1;
		thirdValue=(int)(Math.random()*6)+1;
		repaint();
	}
}
