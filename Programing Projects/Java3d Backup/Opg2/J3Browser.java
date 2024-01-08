/* @author Job Zwiers  
 * @version  0, revision $Revision: 1.7 $,
 * $Date: 2001/08/31 12:06:26 $    
 * @since version 0       
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.util.*;


public class J3Browser extends JFrame
implements ActionListener
{
  protected ConfiguredUniverse universe;
  protected Canvas3D canvas;
  protected Container cp;
  protected J3MenuBar menuBar;
  protected HashMap viewPoints;
  
  public J3Browser(String title, double widthFraction, double heightFraction)
  {   
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int width =  (int) (d.width * widthFraction);
      int height = (int) (d.height * heightFraction);
      int x = (int) (d.width - width)/2;
      int y = (int) (d.height - height)/2;
      createBrowser(this, title, x, y, width, height);      
  }

  public J3Browser(String title, int x, int y, int width, int height)
  {   
     createBrowser(this, title, x, y, width, height);
  }

    private void createBrowser(J3Browser jframe,String title, int x, int y, int width, int height ) {

      jframe.setTitle(title);
      jframe.setSize(width, height);
      jframe.setLocation(x, y);
      
      jframe.addWindowListener (new WindowAdapter()
       { public void windowClosing(WindowEvent e) {  System.exit(0); } }
      );         
      universe = new ConfiguredUniverse();
      canvas = universe.getCanvas3D();
      createGui(jframe, canvas);
      viewPoints = new HashMap(50);
    }

    private void createGui(J3Browser jframe, Canvas3D canvas3D) {

      cp = jframe.getContentPane();   
      cp.setLayout(new BorderLayout());
      cp.add("Center", canvas3D);            
    }

    public Canvas3D getCanvas3D() {
       return canvas;
    }
    
    public void actionPerformed(ActionEvent evt) {
       System.exit(0);      
    }

    public void addPanel(Component panel, String location) {
      cp.add(panel, location);
    }

    public void addBranchGroup(BranchGroup scene) {
       universe.addBranchGroup(scene);
    }


    public void setMenuBar(J3MenuBar menubar) {
       this.menuBar = menuBar;
    }

    public void addViewpoint(String name, Vector3f pos) {
      viewPoints.put(name, pos);
    }

    public void toViewpoint(String name) {
      System.out.println("Browser to viewpoint " + name);
      Vector3f pos = (Vector3f) viewPoints.get(name);
      System.out.println("Browser to viewpoint " + name + ", position: " + pos);
      if (pos != null) setPosition(pos);
      else System.out.println("Could not find " + name);
    }


    public void setPosition(Vector3f pos) {
      universe.setPosition(pos);
    }

    public void setRotYAngle(double angle) {
      universe.setRotYAngle(angle);
    }
        
    public static void main(String[] arg) {
      J3Browser browser = new J3Browser("J3Browser", 0.4, 0.5);
    }

}
