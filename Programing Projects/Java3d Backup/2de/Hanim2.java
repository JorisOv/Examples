
/**
 * SimpleCube renders a simple rotating colored cube
 * on top of a blue Cone.
 * No lighting or texture mapping is used.
 */

//package java3Dcourse;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
//import vmc.j3d.*;


public class Hanim2 extends JFrame {

   /**
    * the constructor sets up a window with a canvas3D, a Universe, a viewpoint etc.
    * The actual contents of the scene graph is created by calling createSceneGraph().
    * Therefore, this part of the program can be kept the same for many experiments
    * with Java3D
    */
   public Hanim2() {
      // The Swing "window" that contains our Canvas3D
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      setSize(512, 512);
      addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) { System.exit(0); } 
        } );
      //show();
      // Find out what kind of graphics hardware we have, and 
      // apply corrsponding default settings:
      GraphicsConfiguration config =
         SimpleUniverse.getPreferredConfiguration();
      //Create a "3D drawing canvas", and make the Swing JFrame visible.
      Canvas3D canvas3D = new Canvas3D(config);
      cp.add("Center", canvas3D);
      show();
      
      //Create a basic Universe, with default settings:
      SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
      // move the viewpoint, so that we can see the origin:
      simpleU.getViewingPlatform().setNominalViewingTransform();
      // create some scenegraph, and add it to the universe.
      // This last step makes the scene "live", that is, rendering for
      // this scenegraph starts automatically.
      BranchGroup scene = createSceneGraph();
      simpleU.addBranchGraph(scene);
   } 


   /**
    * creates the actual "contents" of the scene graph, and returns a BranchGroup
    * that is ready to go "live", by inserting it in a Universe.
    */
   public BranchGroup createSceneGraph() {
      // objRoot is the top of our scene graph.
      BranchGroup objRoot = new BranchGroup();
      //bounds is used to indicate the region where background and animation are active.
      BoundingSphere bounds = new BoundingSphere(new Point3d(), 1000.0);

      // First, create a background color. 
      // HSBColor3f specifies a Color3f by means of hue, saturation, and brightness.
      Color3f backColor = HSBColor3f(240, 30, 70);
      Background background = new Background(backColor);
      background.setApplicationBounds(bounds); // background is active only within the bounds sphere.
      objRoot.addChild(background);   // add the background Node to the scene graph.


      objRoot.addChild(createLimb(5.0f, 5.0f, 10.0f, Math.PI * -0.5));     
      // Let Java 3D perform optimizations on this scene graph.
      objRoot.compile();
      return objRoot;
   } 

  public static final Color3f HSBColor3f(int hue, int saturation, int brightness) {
    Color3f col3f = new Color3f(Color.getHSBColor(hue/360.0f, saturation/100.0f, brightness/100.0f));
    return col3f;
  }

  public TransformGroup createLimb(float radius, float radius2, float heigth, double angle) {
  	TransformGroup base = new TransformGroup();

	Transform3D translate = new Transform3D();
	translate.set(new Vector3f(0f, 0.5f*heigth / 50.0f, 0f));
  	TransformGroup cylTrans = new TransformGroup(translate);
  	
  	Transform3D rotate = new Transform3D();
  	rotate.rotZ(angle);
  	TransformGroup cylRot = new TransformGroup(rotate);
  	Cylinder cyl = new Cylinder(radius2 / 50.0f, heigth / 50.0f);
  	
  	// Create a blue Cone. Unlike the ColorCube, we must set its
        // appearance, or else it won't be visible.
        Material emissiveMat = new Material();
        emissiveMat.setEmissiveColor( new Color3f(0.2f, 0.2f, 1.0f) );
        Appearance app = new Appearance();
        app.setMaterial(emissiveMat); 

	cyl.setAppearance(app);  	
  	
  	cylTrans.addChild(cyl);
  	cylRot.addChild(cylTrans);
  	
  	Sphere sph = new Sphere(radius / 50.0f);

        Material emissiveMat2 = new Material();
        emissiveMat2.setEmissiveColor( new Color3f(1.0f, 0.2f, 0.2f) );
        Appearance app2 = new Appearance();
        app2.setMaterial(emissiveMat2); 
  	
  	sph.setAppearance(app2);
  	
  	base.addChild(sph);
  	base.addChild(cylRot);  	
  	
  	return base;	
  }
  
   public static void main(String[] args) {
      JFrame frame = new Hanim2();
   } 

} 
