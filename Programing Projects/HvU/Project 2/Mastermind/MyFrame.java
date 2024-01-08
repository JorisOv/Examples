// bouwsel naast codemaker. Codemaker is domein. gui splitsen besturing/vieuw.

//Frame, window met lijst
//window listener

import java.awt.Frame;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;


public class MyFrame extends Frame {

	//constructor:
	public MyFrame()
	{
		setBounds(100,100,375,435);//let op binnen de bounds vallen ook de windows layout dingen.
		setBackground(Color.gray);
		setLayout(new BorderLayout());//zelf plaatsen van componenten.
		setTitle("Mastermind 1.0");


		Toolkit kit = Toolkit.getDefaultToolkit();
		Image image = kit.getImage("peg.gif");
		setIconImage(image);

	}
}

