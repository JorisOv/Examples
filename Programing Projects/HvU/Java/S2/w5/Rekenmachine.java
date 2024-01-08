/****************************************************************\
Autheur: Joris Overzier
Klas: 		TIV1E
Datum: 		13 Maart 2005
Functie: 	Dit deel maakt een panel en roept zowel 
		toetsenbord als Display aan om zo een
		rekenmachintje te laten zien. 
\****************************************************************/

import java.awt.*;
import javax.swing.*;

public class Rekenmachine extends JFrame {

   public Rekenmachine(String title) {
      //constructie van instantie
      super(title);

      //window size opgeven
      setSize(new Dimension(205, 300));

      //laten sluiten bij klikken kruisje in window
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //container maken voor plaatsing gui objecten
      Container c = getContentPane();
      //selecteer layout manager borderlayout
      c.setLayout(new BorderLayout());
      //Display maken en plaatsen
      Display display = new Display();
      c.add(display, BorderLayout.NORTH);

      //Toetsenbord maken en plaatsen
      Toetsenbord toetsenbord = new Toetsenbord(display);
      c.add(toetsenbord, BorderLayout.CENTER);

   }

   public static void main (String [ ]  argv) {
      //aanmaken rekenmachine in main, met size 200 bij 300. 
      //Geen 205-300 omdat we ruimte oer laten voor windows bar.
      //tevens zetten we hem op visible
      Rekenmachine rm = new Rekenmachine("Rekenmachine");
      rm.setSize(200, 300);
      rm.setVisible(true);
   }
}