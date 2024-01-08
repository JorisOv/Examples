

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;


/**
 * A "Hud" to be added to a J3Browser
 */
public class J3Hud extends JPanel
implements ActionListener
{


   public J3Hud (J3Browser browser) {
     this();
      browser.addPanel(this, "South");
   }     

   public J3Hud () {
      super();
      JButton redButton = new JButton("red");
      JButton yellowButton = new JButton("yellow");
      JButton blueButton = new JButton("blue");
      add(redButton);
      add(yellowButton);
      add(blueButton);
    }

    public void actionPerformed(ActionEvent evt) {
       //System.exit(0);      
    }


}
