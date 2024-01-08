
/**
 * Hanim renders a simple avatar.
 * No lighting or texture mapping is used.
 */

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.awt.AWTEvent;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.event.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;



public class Hanim0 extends JFrame {

   /**
    * the constructor sets up a window with a canvas3D, a Universe, a viewpoint etc.
    * The actual contents of the scene graph is created by calling createSceneGraph().
    * Therefore, this part of the program can be kept the same for many experiments
    * with Java3D
    */
   public Hanim7() {
      // Standard setting up of a Canvas and universe.
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      setSize(512, 512);
      addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) { System.exit(0); } 
        } );
      GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
      Canvas3D canvas3D = new Canvas3D(config);
      cp.add("Center", canvas3D);
      show();
      
      SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
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


	// create a shape3d, then add it to a transformgroup and make it live
	
	



      objRoot.addChild(HumanoidRoot.getGroup());
      
      
      // Let Java 3D perform optimizations on this scene graph.
      objRoot.compile();
      return objRoot;
   } 

  public static final Color3f HSBColor3f(int hue, int saturation, int brightness) {
    Color3f col3f = new Color3f(Color.getHSBColor(hue/360.0f, saturation/100.0f, brightness/100.0f));
    return col3f;
  }


 	
  public TransformGroup createLimb(float radius, float radius2, float heigth) {
  	// the createLimb function makes a transform group with a sphere with "radius", a
  	// cylinder with "radius2" and "heigth", where the bottom of the cylinder
  	// is on 0,0,0. This is our basic "limb"
  	
  	// The Sphere has emisive color "red", while the cylinder is "blue"
  	// Since we have not applied any lighting, this is sufficient.  	
  	
  	TransformGroup base = new TransformGroup();

	if (radius > 0.0f) {
	  	Sphere sph = new Sphere(radius);

	  	// Create a red sphere. 
	        Material emissiveMat = new Material();
	        emissiveMat.setEmissiveColor( new Color3f(1.0f, 0.2f, 0.2f) );
	        Appearance app = new Appearance();
	        app.setMaterial(emissiveMat); 
  	
	  	sph.setAppearance(app);
  	  	base.addChild(sph);
  	}

 	if (radius > 0.0f && heigth > 0.0f) {
		Transform3D translate = new Transform3D();
		translate.set(new Vector3f(0f, 0.5f*heigth, 0f));
	  	TransformGroup cylTrans = new TransformGroup(translate);
  	
	  	Cylinder cyl = new Cylinder(radius2, heigth);
  	
	  	// Create a blue Cylinder. 
	        Material emissiveMat2 = new Material();
 	        emissiveMat2.setEmissiveColor( new Color3f(0.2f, 0.2f, 1.0f) );
	        Appearance app2 = new Appearance();
	        app2.setMaterial(emissiveMat2);
		cyl.setAppearance(app2);  	
  	
  		cylTrans.addChild(cyl);  
  		base.addChild(cylTrans);    	
	}

  	return base;	
  }
  
   public static void main(String[] args) {
      JFrame frame = new Hanim7();
   }
  
   
   // *************** BEHAVIOURS ************************************ 
   
   	// Two behaviour classes (comments only added in the first)
   	// These behaviours act on a key-press, at which moment they will transform
   	// their target TransformGroup, so that it rotates around the X-axis from 
   	// PI to PI + 0.6
   public class LeftBehavior extends Behavior{

      private TransformGroup  targetTG;
      private WakeupCriterion pairPostCondition;
      private WakeupCriterion wakeupNextFrame;
      private WakeupCriterion AWTEventCondition;
      private Transform3D     t3D = new Transform3D();
      private Matrix3d        rotMat = new Matrix3d();
      private double          armAngle;

      LeftBehavior(TransformGroup targetTG){

          this.targetTG = targetTG;
          
          // react to any key being pressed
          AWTEventCondition = new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED);
          wakeupNextFrame = new WakeupOnElapsedFrames(0);
                  
      }

      public void setBehaviorObjectPartner(Behavior behaviorObject){
          pairPostCondition = new WakeupOnBehaviorPost(behaviorObject, 1);
      }

      public void initialize(){
          this.wakeupOn(AWTEventCondition);
          
          // initial angle
          armAngle = 0.0f + Math.PI;

      }
  
      public void processStimulus(Enumeration criteria){

          if (criteria.nextElement().equals(pairPostCondition)){
              this.wakeupOn(AWTEventCondition);
              armAngle = 0.0f + Math.PI;
          } else { // could be KeyPress or nextFrame, in either case: open

              if (armAngle < 0.6 + Math.PI){
                  armAngle += 0.1;
                  if (armAngle > 0.6 + Math.PI) armAngle = 0.6 + Math.PI;
                  // get rotation and scale portion of transform
                  targetTG.getTransform(t3D);
                  t3D.getRotationScale(rotMat);
                  
                  // set x-axis rotation to armAngle
                  // (clobber any previous x-rotation, y and z scale)
                  rotMat.m11 = Math.cos(armAngle);  
                  rotMat.m22 = rotMat.m11;
                  rotMat.m12 = Math.sin(armAngle);
                  rotMat.m21 = -rotMat.m12;
                  
                  t3D.setRotation(rotMat);
                  targetTG.setTransform(t3D);
                  this.wakeupOn(wakeupNextFrame);
              } else { // finished animting arm one way, signal other behavior
                  this.wakeupOn(pairPostCondition);
                  postId(1);
              }
          }
      }

  } // end of class OpenBehavior

  public class RightBehavior extends Behavior{

      private TransformGroup  targetTG;
      private WakeupCriterion pairPostCondition;
      private WakeupCriterion wakeupNextFrame;
      private WakeupCriterion AWTEventCondition;
      private Transform3D     t3D = new Transform3D();
      private Matrix3d        rotMat = new Matrix3d();
      private double          armAngle;


      RightBehavior(TransformGroup targetTG){
      	  float[] blaat = new float[4];

          this.targetTG = targetTG;
          AWTEventCondition = new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED);
          wakeupNextFrame = new WakeupOnElapsedFrames(0);
          
      }

      public void setBehaviorObjectPartner(Behavior behaviorObject){
          pairPostCondition = new WakeupOnBehaviorPost(behaviorObject, 1);
      }

      public void initialize(){
          this.wakeupOn(pairPostCondition);

          armAngle = 0.6f + Math.PI;
      }
  
      public void processStimulus(Enumeration criteria){
      	
          if (criteria.nextElement().equals(pairPostCondition)){
              this.wakeupOn(AWTEventCondition);
              armAngle = 0.6f + Math.PI;
          } else { // could be KeyPress or nextFrame, in either case: close
              if (armAngle > 0.0f + Math.PI){
                  armAngle -= 0.1;
                  if (armAngle < 0.0f + Math.PI) armAngle = 0.0f + Math.PI;
                  // get rotation and scale portion of transform
                  targetTG.getTransform(t3D);
                  t3D.getRotationScale(rotMat);
                  
                  // set x-axis rotation to armAngle
                  // (clobber any previous x-rotation, y and z scale)
                  rotMat.m11 = Math.cos(armAngle);  
                  rotMat.m22 = rotMat.m11;
                  rotMat.m12 = Math.sin(armAngle);
                  rotMat.m21 = -rotMat.m12;
                 
                  t3D.setRotation(rotMat);
                  targetTG.setTransform(t3D);
                  this.wakeupOn(wakeupNextFrame);
              } else { // finished animting arm one way, signal other behavior
                  this.wakeupOn(pairPostCondition);
                  postId(1);
              }
          }
      }

  } // End of class RightBehaviour

} 
