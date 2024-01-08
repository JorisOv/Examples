/****************************************************************\
Autheur: Joris Overzier
Klas: 		TIV1E
Datum: 		13 Maart 2005
Functie: 	Dit deel maakt het toetsenboard van 1 - 5 
		en maakt een actionlistner hiervoor
\****************************************************************/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Toetsenbord extends JPanel implements ActionListener {

   private Display display;

   //aanmaken buttons
   JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, clear, stop;

   public Toetsenbord(Display display) {
      //Displaytje aangeven
      this.display = display;

      //formaat opgeven
      setPreferredSize(new Dimension(200, 270));
      //layout op geven als gridlayout
      setLayout(new GridLayout(4, 3));

      //nieuwe buttons aan maken
      b1	= new JButton("1");
      b2 	= new JButton("2");
      b3 	= new JButton("3");
      b4 	= new JButton("4");
      b5 	= new JButton("5");
      b6 	= new JButton("6");
      b7	= new JButton("7");
      b8 	= new JButton("8");
      b9 	= new JButton("9");
      clear	= new JButton("clear");
      b0 	= new JButton("0");
      stop 	= new JButton("stop");

      //knoppen toe voegen aan huidig object en toevoegen op actionlistener
      //net als in applets maakt de volgorde van adden uit voor layout.
      this.add(b1);	b1.addActionListener(this);
      this.add(b2);	b2.addActionListener(this);
      this.add(b3);	b3.addActionListener(this);
      this.add(b4);	b4.addActionListener(this);
      this.add(b5);	b5.addActionListener(this);
      this.add(b6);	b6.addActionListener(this);
      this.add(b7);	b7.addActionListener(this);
      this.add(b8);	b8.addActionListener(this);
      this.add(b9);	b9.addActionListener(this);
      this.add(clear);	clear.addActionListener(this);
      this.add(b0);	b0.addActionListener(this);
      this.add(stop);	stop.addActionListener(this);

      //maken kleur voor background knopjes
      clear.setBackground(Color.GREEN);
      stop.setBackground(Color.RED);
   }

   //actionlistener
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == b1)
         //functie addgetal in display aanroepen
         display.addGetal(1);
      else if(e.getSource() == b2)
         display.addGetal(2);
      else if(e.getSource() == b3)
         display.addGetal(3);
      else if(e.getSource() == b4)
         display.addGetal(4);
      else if(e.getSource() == b5)
         display.addGetal(5);
      else if(e.getSource() == b6)
         display.addGetal(6);
      else if(e.getSource() == b7)
         display.addGetal(7);
      else if(e.getSource() == b8)
         display.addGetal(8);
      else if(e.getSource() == b9)
         display.addGetal(9);
      else if(e.getSource() == b0)
         display.addGetal(0);
      else if(e.getSource() == clear)
         display.clear();
      else if(e.getSource() == stop)
         System.exit(0);
   }
}