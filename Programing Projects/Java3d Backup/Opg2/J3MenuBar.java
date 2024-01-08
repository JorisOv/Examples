/* @author Job Zwiers  
 * @version  0, revision $Revision: 1.2 $,
 * $Date: 2001/06/15 12:36:31 $    
 * @since version 0       
 */



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.util.*;

/**
 * A J3MenuBar can be used as the basis for a MenuBar to be used 
 * in conjunction with a J3Browser, or other JFrame containing a Canvas3D.
 * (Settings are made to ensure that the menus are "heavyweight", so that they are
 *  not erased by the Canvas3D screen updates)
 * 
 */
public class J3MenuBar extends JMenuBar

{

    /**
     * creates a new menubar
     */
    public J3MenuBar() {
      this(null);
    }

    /**
     * creates a new menubar, and assigns it to the JFrame "browser"
     */
    public J3MenuBar(JFrame browser) {
      super();
      JPopupMenu.setDefaultLightWeightPopupEnabled(false);
      ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
      if (browser != null) browser.setJMenuBar(this);     
    }

    /**
     * adds a new menu to the menubar, and returns its index
     */
    public int addMenu(String menuName) {
       int menuIndex = getMenuCount();
       JMenu menu = new JMenu(menuName);
       add(menu);
       return menuIndex;
    }

    /**
     * adds an Action to the menu on the menubar.
     */
    public void addAction(int menuIndex, Action action) {
       getMenu(menuIndex).add(action);     
    }

    
    /**
     * adds a JMenuItem to a menu on the menubar.
     * The name and ActionListener must be provided.
     * The JMenuItem is returned, and can be used within the ActionListener to identify the
     * source of an ActionEvent.
     */
    public JMenuItem addJMenuItem(int menuIndex, String itemName, ActionListener actionListener) {
      JMenuItem menuItem = new JMenuItem(itemName);
      menuItem.addActionListener(actionListener);
      getMenu(menuIndex).add(menuItem); 
      return menuItem;    
    }

}
