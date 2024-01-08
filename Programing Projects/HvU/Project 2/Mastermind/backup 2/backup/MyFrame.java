// bouwsel naast codemaker. Codemaker is domein. gui splitsen besturing/vieuw.

//Frame, window met lijst
//window listener

import java.awt.Frame;
import java.awt.Color;
import java.awt.BorderLayout;


public class MyFrame extends Frame {

	//constructor:
	public MyFrame()
	{
		setBounds(100,100,400,400);//let op binnen de bounds vallen ook de windows layout dingen.
		setBackground(Color.orange);
		setLayout(new BorderLayout());//zelf plaatsen van componenten.
	}
}

