import java.awt.Panel;
import java.awt.Graphics;
import javax.imageio.ImageIO;

public class HelpScreen extends Panel {

	public HelpScreen()
	{


	}

	public void paint(Graphics g)
	{
		g.drawString("Welcom to Mastermind.",10,10);
		g.drawString("This application is created by Jelko Sluis and Joris Overzier",10,30);
		g.drawString("in order of Ing Erik Gerlofsma",10,40);
		
		g.drawString("When you start the application, you will see a menu caled 'File'",10,60);
		g.drawString("Within this menu, u can select the folowing options:",10,70);
		g.drawString("New game",30,80);
		g.drawString("Settings",30,90);
		g.drawString("Help",30,100);
		g.drawString("Exit",30,110);
		
		g.drawString("initiates a new game",110,80);
		g.drawString("adjust the used number of colors and pegs",110,90);
		g.drawString("displays this help",110,100);
		g.drawString("exits the game",110,110);

		g.drawString("About the game:",10,130);
		g.drawString("The game Mastermind offers you a mind game",30,140);
		g.drawString("There is some code chosen by the computer containing a",30,150);
		g.drawString("number of pegs and colors. Your task is to guess what ",30,160);
		g.drawString("code is chosen by the computer.",30,170);

		g.drawString("You can reprisent this code by clicking one of the ",30, 190);
		g.drawString("gray circles on the left panel of the screen. ",30, 200);
		g.drawString("these will change color. When you aprove of the  ",30, 210);
		g.drawString("combination, you can click the button check, located",30, 220);
		g.drawString("in the bottom of the screen. ",30, 230);

		g.drawString("When you do there will be a number of black and white",30, 250);
		g.drawString("dots appear on the right of the entered combination. ",30, 260);
		g.drawString("These dots reprisent if your code was correct at all.",30, 270);

		g.drawString("A white dot tells you that you took one color and entered",30, 290);
		g.drawString("it on the right location.",30, 300);

		g.drawString("A black dot tells you that you matched one color, but ",30, 320);
		g.drawString("failed to find the right location for it. ",30, 330);

		g.drawString("We hope you will have a good gaming experiance!",10, 360);
		g.drawString("Jeloko Sluis and Joris Overzier.",10, 370);
	}
}