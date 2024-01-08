/****************************************************************\
Autheur: Joris Overzier
Klas: 		TIV1E
Datum: 		13 Maart 2005
Functie: 	Dit deel maakt een nieuw rekenmachinetje
\****************************************************************/

import java.awt.*;
import javax.swing.*;

public class Main {

   public static void main (String [ ] argv)
   {
      //aanmaken rekenmachine, en deze visible zetten.
      Rekenmachine rekenmachine = new Rekenmachine("Rekenmachine");
      rekenmachine.setVisible(true);
   }
}