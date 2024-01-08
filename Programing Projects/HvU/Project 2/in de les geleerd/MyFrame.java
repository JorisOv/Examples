// bouwsel naast codemaker. Codemaker is domein. gui splitsen besturing/vieuw.

//Frame, window met lijst
//window listener

import java.awt.Frame;

public class MyFrame extends Frame{

	//constructor:
	public MyFrame{
		setBounds(0,0,400,400);//let op binnen de bounds vallen ook de windows layout dingen.
		setBackground(Color.orange);
		setLayout(null);//zelf plaatsen van componenten.
		setVisible(true);
	}
}

/*
	
*/