
/**
 * Hanim renders a simple avatar.
 * No lighting or texture mapping is used.
 */

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


public class Hanim4 extends JFrame {

   /**
    * the constructor sets up a window with a canvas3D, a Universe, a viewpoint etc.
    * The actual contents of the scene graph is created by calling createSceneGraph().
    * Therefore, this part of the program can be kept the same for many experiments
    * with Java3D
    */
   public Hanim4() {
      // The Swing "window" that contains our Canvas3D
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      setSize(512, 512);
      addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) { System.exit(0); } 
        } );
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

	// Let's make the skeleton.
	
	//****************************************************************************
	
	// Let's define some lengths
	
	final float TRUNK_LENGTH = 0.6f;
	final float UPPER_ARM_LENGTH = 0.33f;
	final float FORE_ARM_LENGTH = 0.33f;
	final float THIGH_LENGTH = 0.4f;
	final float CALF_LENGTH = 0.4f;
	final float FOOT_LENGTH = 0.1f;
	
	//the HumanoidRoot is the point from which all limbs are attached
	TransformGroup HumanoidRoot = new TransformGroup();

	/**
	 * We use two transform groups, because translation has to be set to one
	 * and rotation to the other. Rotation is actually set in the createLimb(...)
	 * function (as the last attribute given to it) (this rotation is around the z-axis)
	 */
	 
	// *** TRUNK, HEAD
	TransformGroup thorasic = new TransformGroup();
	TransformGroup thorasic2 = createLimb(0.1f, 0.25f, TRUNK_LENGTH, Math.PI * 1.0f);
	thorasic.addChild(thorasic2);
	HumanoidRoot.addChild(thorasic);
	
	TransformGroup cervical = new TransformGroup();
	TransformGroup cervical2 = createLimb(0.15f, 0.07f, 0.4f, Math.PI * 0.0f);
	cervical.addChild(cervical2);
	thorasic2.addChild(cervical);
	
	// *** ARMS ***
	
	TransformGroup l_upperarm = new TransformGroup();
	TransformGroup l_upperarm2 = createLimb(0.07f, 0.07f, UPPER_ARM_LENGTH, Math.PI * 0.2f);
	l_upperarm.addChild(l_upperarm2);
	thorasic2.addChild(l_upperarm);
	
	TransformGroup l_forearm = new TransformGroup(); 
	TransformGroup l_forearm2 = createLimb(0.073f, 0.06f, FORE_ARM_LENGTH, Math.PI * -0.2f);
	l_forearm.addChild(l_forearm2);
	l_upperarm2.addChild(l_forearm);
	
	TransformGroup l_hand = new TransformGroup();
	TransformGroup l_hand2 = createLimb(0.08f, 0.01f, 0.0f, Math.PI * -0.2f);
	l_hand.addChild(l_hand2);
	l_forearm2.addChild(l_hand);

	TransformGroup r_upperarm = new TransformGroup();
	TransformGroup r_upperarm2 = createLimb(0.07f, 0.07f, UPPER_ARM_LENGTH, Math.PI * -0.8f);
	r_upperarm.addChild(r_upperarm2);
	thorasic2.addChild(r_upperarm);
	
	TransformGroup r_forearm = new TransformGroup();
	TransformGroup r_forearm2 = createLimb(0.073f, 0.06f, FORE_ARM_LENGTH, Math.PI * -0.2f);
	r_forearm.addChild(r_forearm2);
	r_upperarm2.addChild(r_forearm);
	
	TransformGroup r_hand = new TransformGroup();
	TransformGroup r_hand2 = createLimb(0.08f, 0.01f, 0.0f, Math.PI * -0.2f);
	r_hand.addChild(r_hand2);
	r_forearm2.addChild(r_hand);
	
	// *** LEGS ***

	TransformGroup l_thigh = new TransformGroup();
	TransformGroup l_thigh2 = createLimb(0.08f, 0.08f, THIGH_LENGTH, Math.PI * 1.0f);
	l_thigh.addChild(l_thigh2);
	HumanoidRoot.addChild(l_thigh);
	
	TransformGroup l_calf = new TransformGroup(); 
	TransformGroup l_calf2 = createLimb(0.09f, 0.07f, CALF_LENGTH, Math.PI * 0.0f);
	l_calf.addChild(l_calf2);
	l_thigh2.addChild(l_calf);
	
	TransformGroup l_foot = new TransformGroup();
	TransformGroup l_foot2 = createLimb(0.08f, 0.07f, FOOT_LENGTH, Math.PI * 0.0f);
 	Transform3D l_foot2_rotate = new Transform3D();
  	l_foot2_rotate.rotX(Math.PI * 0.4f);
	l_foot2.setTransform(l_foot2_rotate);
	l_foot.addChild(l_foot2);
	l_calf2.addChild(l_foot);

	TransformGroup r_thigh = new TransformGroup();
	TransformGroup r_thigh2 = createLimb(0.08f, 0.08f, THIGH_LENGTH, Math.PI * 1.0f);
	r_thigh.addChild(r_thigh2);
	HumanoidRoot.addChild(r_thigh);
	
	TransformGroup r_calf = new TransformGroup(); 
	TransformGroup r_calf2 = createLimb(0.09f, 0.07f, CALF_LENGTH, Math.PI * 0.0f);
	r_calf.addChild(r_calf2);
	r_thigh2.addChild(r_calf);
	
	TransformGroup r_foot = new TransformGroup();
	TransformGroup r_foot2 = createLimb(0.08f, 0.07f, FOOT_LENGTH, Math.PI * 0.0f);
 	Transform3D r_foot2_rotate = new Transform3D();
  	r_foot2_rotate.rotX(Math.PI * 0.4f);
	r_foot2.setTransform(r_foot2_rotate);
	r_foot.addChild(r_foot2);
	r_calf2.addChild(r_foot);


	
	//****************************************************************************
	
	// here we set the translation every limb must undergo to be attached to 
	// the right point
	
	// ** TRUNK, HEAD **
	
	Transform3D vt1 = new Transform3D();
	vt1.set(new Vector3f(0.0f, TRUNK_LENGTH, 0.0f) );
	thorasic.setTransform(vt1);
	
	Transform3D skullbase = new Transform3D();
	skullbase.set(new Vector3f(0.0f, -0.23f, 0.0f) );
	cervical.setTransform(skullbase);
	
	// *** ARMS ***
	
	Transform3D l_shoulder = new Transform3D();
	l_shoulder.set(new Vector3f(-0.28f, 0.05f, 0.0f) );
	l_upperarm.setTransform(l_shoulder);

	Transform3D l_elbow = new Transform3D();
	l_elbow.set(new Vector3f(0.0f, UPPER_ARM_LENGTH, 0.0f));
	l_forearm.setTransform(l_elbow);

	Transform3D l_wrist = new Transform3D();
	l_wrist.set(new Vector3f(0.0f, FORE_ARM_LENGTH, 0.0f));
	l_hand.setTransform(l_wrist);

	Transform3D r_shoulder = new Transform3D();
	r_shoulder.set(new Vector3f(0.28f, 0.05f, 0.0f) );
	r_upperarm.setTransform(r_shoulder);

	Transform3D r_elbow = new Transform3D();
	r_elbow.set(new Vector3f(0.0f, UPPER_ARM_LENGTH, 0.0f) );
	r_forearm.setTransform(r_elbow);

	Transform3D r_wrist = new Transform3D();
	r_wrist.set(new Vector3f(0.0f, FORE_ARM_LENGTH, 0.0f));
	r_hand.setTransform(r_wrist);
	
	// *** LEGS ***

	Transform3D l_hip = new Transform3D();
	l_hip.set(new Vector3f(0.16f, -0.03f, 0.0f) );
	l_thigh.setTransform(l_hip);

	Transform3D l_knee = new Transform3D();
	l_knee.set(new Vector3f(0.0f, THIGH_LENGTH, 0.0f));
	l_calf.setTransform(l_knee);

	Transform3D l_ankle = new Transform3D();
	l_ankle.set(new Vector3f(0.0f, CALF_LENGTH, 0.0f));
	l_foot.setTransform(l_ankle);

	Transform3D r_hip = new Transform3D();
	r_hip.set(new Vector3f(-0.16f, -0.03f, 0.0f) );
	r_thigh.setTransform(r_hip);

	Transform3D r_knee = new Transform3D();
	r_knee.set(new Vector3f(0.0f, THIGH_LENGTH, 0.0f));
	r_calf.setTransform(r_knee);

	Transform3D r_ankle = new Transform3D();
	r_ankle.set(new Vector3f(0.0f, CALF_LENGTH, 0.0f));
	r_foot.setTransform(r_ankle);
	
	
	//****************************************************************************
	

      // we're ready to go "live", let's add the damn thing :)
      objRoot.addChild(HumanoidRoot);
      // Let Java 3D perform optimizations on this scene graph.
      objRoot.compile();
      return objRoot;
   } 

  public static final Color3f HSBColor3f(int hue, int saturation, int brightness) {
    Color3f col3f = new Color3f(Color.getHSBColor(hue/360.0f, saturation/100.0f, brightness/100.0f));
    return col3f;
  }


 	
  public TransformGroup createLimb(float radius, float radius2, float heigth, double angle) {
  	// the createLimb function makes a sphere with "radius", a
  	// cylinder with "radius2" and "heigth", where the bottom of the cylinder
  	// is on 0,0,0
  	
  	
  	TransformGroup base = new TransformGroup();

	if (radius > 0.0f) {
	  	Sphere sph = new Sphere(radius);

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
  	
	  	// Create a blue Cylinder. Unlike the ColorCube, we must set its
	        // appearance, or else it won't be visible.
	        Material emissiveMat2 = new Material();
 	        emissiveMat2.setEmissiveColor( new Color3f(0.2f, 0.2f, 1.0f) );
	        Appearance app2 = new Appearance();
	        app2.setMaterial(emissiveMat2);
		cyl.setAppearance(app2);  	
  	
  		cylTrans.addChild(cyl);  
  		base.addChild(cylTrans);    	
	}

 	Transform3D rotate = new Transform3D();
  	rotate.rotZ(angle);
	base.setTransform(rotate);
  	
  	
  	
  	return base;	
  }
  
   public static void main(String[] args) {
      JFrame frame = new Hanim4();
   } 

} 
