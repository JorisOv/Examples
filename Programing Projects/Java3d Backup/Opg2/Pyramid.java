

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



public class Pyramid extends JFrame {

   /**
    */
   public Pyramid() {
      J3Browser browser = new J3Browser("Pyramid", 20, 30, BROWSERWIDTH, BROWSERHEIGHT);
      BranchGroup cubescene = createSceneGraph();
      browser.addBranchGroup(cubescene);
      J3Hud hud = new J3Hud(browser);
      browser.show();
      browser.setPosition(new Vector3f(0.0f, 0.0f, 3.0f)); 
      browser.setRotYAngle(0.0 * Math.PI);
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

      Transform3D sceneTransform3D = new Transform3D();
      TransformGroup sceneGroup = new TransformGroup(sceneTransform3D);
      sceneGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      sceneGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      objRoot.addChild(sceneGroup);
      
      BoundingSphere mouseBounds = new BoundingSphere(new Point3d(), 100000.0);
      int mouseRotFlags = 0; // = MouseBehavior.INVERT_INPUT;
      MouseRotate mouseRot = new MouseRotate(mouseRotFlags);
      mouseRot.setFactor(0.01, 0.01);
      mouseRot.setTransformGroup(sceneGroup);
      mouseRot.setSchedulingBounds(mouseBounds);
      objRoot.addChild(mouseRot);
      
      int mouseTranslateFlags = MouseBehavior.INVERT_INPUT;
      MouseTranslate mouseTrans = new MouseTranslate();
      mouseTrans.setFactor(0.2, 0.1);
      mouseTrans.setTransformGroup(sceneGroup);
      mouseTrans.setSchedulingBounds(mouseBounds);
      objRoot.addChild(mouseTrans);
      
      int mouseZoomFlags = MouseBehavior.INVERT_INPUT;
      MouseZoom mouseZoom = new MouseZoom();
      mouseZoom.setFactor(0.8);
      mouseZoom.setTransformGroup(sceneGroup);
      mouseZoom.setSchedulingBounds(mouseBounds);
      objRoot.addChild(mouseZoom);    
      
      // ColorCube is a simple ready-made colored cube, useful for testing.
      float cubeScale = 0.2f; // half the cube height
      Node cube = new ColorCube(cubeScale);
      Node pyra = new TrianglePyramid2(0.5f, 0.3f);
      //sceneGroup.addChild(cube);
      sceneGroup.addChild(pyra);
      Color3f whiteColor = new Color3f(1.0f, 1.0f, 1.0f);
      Color3f redColor = new Color3f(1.0f, 0.0f, 0.0f);
      Color3f blueColor = new Color3f(0.0f, 0.0f, 1.0f);
      objRoot.addChild(new RotatingLight(RotatingLight.Yaxis, redColor, 3000));
      objRoot.addChild(new RotatingLight(RotatingLight.Xaxis, blueColor, 2000));
      objRoot.compile();
      return objRoot;
   } 

  public static final Color3f HSBColor3f(int hue, int saturation, int brightness) {
    Color3f col3f = new Color3f(Color.getHSBColor(hue/360.0f, saturation/100.0f, brightness/100.0f));
    return col3f;
  }


  
   public static void main(String[] args) {
      JFrame frame = new Pyramid();
   } 


   public static final int BROWSERWIDTH = 800;
   public static final int BROWSERHEIGHT = 700;

} 
