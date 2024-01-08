
/**
 * SimpleCube renders a simple rotating colored cube
 * on top of a blue Cone.
 * No lighting or texture mapping is used.
 */

//package java3Dcourse;
//import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;



public class SimpleCube extends JFrame {

   /**
    * the constructor sets up a window with a canvas3D, a Universe, a viewpoint etc.
    * The actual contents of the scene graph is created by calling createSceneGraph().
    * Therefore, this part of the program can be kept the same for many experiments
    * with Java3D
    */
   public SimpleCube() {
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
      
      // ColorCube is a simple ready-made colored cube, useful for testing.
      float cubeScale = 0.2f; // half the cube height
      Node cube = new ColorCube(cubeScale);
      // Create a blue Cone. Unlike the ColorCube, we must set its
      // appearance, or else it won't be visible.
      Material emissiveMat = new Material();
      emissiveMat.setEmissiveColor(HSBColor3f(240, 100, 40));
      Appearance app = new Appearance();
      app.setMaterial(emissiveMat); 
      float coneWidth = 0.5f;
      float coneHeight = 0.4f;     
      Cone cone = new Cone(coneWidth, coneHeight);
      Cylinder cyl = new Cylinder(0.2f, 0.5f);
      cone.setAppearance(app);
      cyl.setAppearance(app);

      // now we have a cube and a cone; they must yet be 
      // included in the scene graph:
      // put the cone into position:
      Transform3D trafo1 = new Transform3D();
      trafo1.set(new Vector3f(0f, -0.45f*coneHeight, 0f));
      TransformGroup coneGroup = new TransformGroup(trafo1);
      coneGroup.addChild(cone);

      // next we build a scene graph part for the cube. It has a translation "trafo2",
      // and below that a rotation that is controlled by an interpolator.
      Transform3D trafo2 = new Transform3D();
      trafo2.set(new Vector3f(0f,  cubeScale,   0f));
      TransformGroup cubeGroup = new TransformGroup(trafo2);
    
      TransformGroup cubeRotate = new TransformGroup(); 
      cubeRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      long cycle = 3000;
      Alpha rotationAlpha = new Alpha(-1, cycle);
      Transform3D rotAxis = new Transform3D(); // default: rotate around Y-axis.
      //rotAxis.rotZ(1.57);  // rotate rotation axis: rotation axis becomes X axis!
	  
      RotationInterpolator rotator =
        new RotationInterpolator(rotationAlpha, cubeRotate, rotAxis, 0.0f, (float) Math.PI*2.0f);

      rotator.setSchedulingBounds(bounds);
      cubeGroup.addChild(rotator);
                
      cubeGroup.addChild(cubeRotate);
      cubeRotate.addChild(cube);
            
      // now we want to combine the cube part and the cone part.
      // The whole must be translated and rotated so as to give a good "view" on the scene.
      Transform3D trafo3 = new Transform3D();
      Transform3D trafo4 = new Transform3D();
      Transform3D trafo5 = new Transform3D();
      trafo3.set(new Vector3f(0f, 0.2f, 0f));
      trafo4.rotX(Math.PI/6.0d);
      trafo3.mul(trafo4);      
      trafo5.rotZ(Math.PI/10.0d);
      trafo3.mul(trafo5);
      TransformGroup cubeConeGroup = new TransformGroup(trafo3);
      cubeConeGroup.addChild(coneGroup);
      
      cubeConeGroup.addChild(cubeGroup);

      // finally, add the whole to objRoot, and compile it:      
      objRoot.addChild(cubeConeGroup);     
      // Let Java 3D perform optimizations on this scene graph.
      objRoot.compile();
      return objRoot;
   } 

  public static final Color3f HSBColor3f(int hue, int saturation, int brightness) {
    Color3f col3f = new Color3f(Color.getHSBColor(hue/360.0f, saturation/100.0f, brightness/100.0f));
    return col3f;
  }


  
   public static void main(String[] args) {
      JFrame frame = new SimpleCube();
   } 

} 
