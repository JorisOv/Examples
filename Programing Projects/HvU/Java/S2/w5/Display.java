/****************************************************************\
Autheur: Joris Overzier
Klas: 		TIV1E
Datum: 		13 Maart 2005
Functie: 	Dit deel maakt het display aan en bied functies
		clear en addgetal voor bewerking display
\****************************************************************/

import java.awt.*;
import javax.swing.*;

public class Display extends JTextField {

   private String memory = "";

   public Display() {
      //formaat 200 bij 30, waar 30 iets hooger is als 1 regel.
      setPreferredSize(new Dimension(200, 30));
      Font f = new Font("Ariel", Font.BOLD, 16);
      setFont(f);
   }

   public void addGetal(int value) {
      //tijdelijk geplaatst als string, 
      //omdat er geen berekeningen uit gevoerd kunnen worden
      memory += "" + value;
      setText(memory);
   }

   public void clear() {
      //legen memory variable, en weergeven van deze
      memory = "";
      setText(memory);
   }
}