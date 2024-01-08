import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.lang.InterruptedException;

public class StartScreen extends Panel {

	char[] m = {'M','a','s','t','e','r','M','i','n','d'};
	char[] n = new char[10];
	boolean keepGoing = true;
	boolean keepGoingSwitch = true;

	public StartScreen()
	{

	}

	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		letterGeneratie(g, m);
	}


	public void letterGeneratie(Graphics g, char[] orgineelChar)
	{
		int counter = 0;
		while(keepGoing){
			if (keepGoingSwitch){
				for (int i = 0; i <= 9; i++){
					if (n[i] != orgineelChar[i]){
						n[i] = (char)((Math.random() * 250) + 1); //fout Math.random() compiled wel
						for (i = 0; i <= 9; i++){
							if (n[i] == orgineelChar[i]){
								counter++;
							}
						}
					}

					//g.setColor(Color.black);
					//wait(20);
					repaint();
					g.drawString(""+n[0] +n[1] +n[2] +n[3] +n[4] +n[5] +n[6] +n[7] +n[8]+ n[9],60,60);
					if (counter==10){
						keepGoingSwitch = false;
					}
					repaint();
				}
			}
			else{
				keepGoing = false;
			}

		}
		g.drawString(""+m[0] +m[1] +m[2] +m[3] +m[4] +m[5] +m[6] +m[7] +m[8]+ m[9],60,60);
	}

}
