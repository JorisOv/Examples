
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


public class Hanim6 extends JFrame {

   /**
    * the constructor sets up a window with a canvas3D, a Universe, a viewpoint etc.
    * The actual contents of the scene graph is created by calling createSceneGraph().
    * Therefore, this part of the program can be kept the same for many experiments
    * with Java3D
    */
   public Hanim6() {
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
	final double zucht = 1.0d;
	
	JointAdapter HumanoidRoot = new JointAdapter("HumanoidRoot");
	
	JointAdapter vt1 = new JointAdapter("vt1");
	vt1.setTranslation(new Vector3f(0.0f, TRUNK_LENGTH, 0.0f) );
	vt1.setRotation( new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) (1 * Math.PI)) );
	
	SegmentAdapter thorasic = new SegmentAdapter("thorasic");
	thorasic.addChild( createLimb(0.1f, 0.25f, TRUNK_LENGTH));
	
	JointAdapter skullbase = new JointAdapter("skullbase");
	skullbase.setTranslation( new Vector3f(0.0f, -0.23f, 0.0f) );
	skullbase.setRotation( new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) (0 * Math.PI)) );

	SegmentAdapter cervical = new SegmentAdapter("cervical");
	cervical.addChild( createLimb(0.15f, 0.07f, 0.4f));
	
	// **** ARMS *****
	
	JointAdapter l_shoulder = new JointAdapter("l_shoulder");
	l_shoulder.setTranslation( new Vector3f(-0.28f, 0.05f, 0.0f) );
	l_shoulder.setRotation( new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) (0.2f * Math.PI)) );
	
	SegmentAdapter l_upperarm = new SegmentAdapter("l_upperarm");
	l_upperarm.addChild( createLimb(0.07f, 0.07f, UPPER_ARM_LENGTH));
		 

	JointAdapter l_elbow = new JointAdapter("l_elbow");
	l_elbow.setTranslation( new Vector3f(0.0f, UPPER_ARM_LENGTH, 0.0f) );
	l_elbow.setRotation( new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) (-0.2f * Math.PI)) );
	
	SegmentAdapter l_forearm = new SegmentAdapter("l_forearm");
	l_forearm.addChild( createLimb(0.073f, 0.06f, FORE_ARM_LENGTH));
	

	JointAdapter l_wrist = new JointAdapter("l_wrist");
	l_wrist.setTranslation( new Vector3f(0.0f, FORE_ARM_LENGTH, 0.0f) );
	l_wrist.setRotation( new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) (-0.2f * Math.PI)) );
	
	SegmentAdapter l_hand = new SegmentAdapter("l_hand");
	l_hand.addChild( createLimb(0.08f, 0.01f, 0.0f));
	
	

	JointAdapter r_shoulder = new JointAdapter("r_shoulder");
	r_shoulder.setTranslation( new Vector3f(0.28f, 0.05f, 0.0f) );
	r_shoulder.setRotation( new AxisAngle4f(1.0f, 0.2f, 0.0f, (float) (-1.0f * Math.PI)) );
	
	SegmentAdapter r_upperarm = new SegmentAdapter("r_upperarm");
	r_upperarm.addChild( createLimb(0.07f, 0.07f, UPPER_ARM_LENGTH));
	

	JointAdapter r_elbow = new JointAdapter("r_elbow");
	r_elbow.setTranslation( new Vector3f(0.0f, UPPER_ARM_LENGTH, 0.0f) );
	r_elbow.setRotation( new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) (0.2f * Math.PI)) );
	
	SegmentAdapter r_forearm = new SegmentAdapter("r_forearm");
	r_forearm.addChild( createLimb(0.073f, 0.06f, FORE_ARM_LENGTH));
	

	JointAdapter r_wrist = new JointAdapter("r_wrist");
	r_wrist.setTranslation( new Vector3f(0.0f, FORE_ARM_LENGTH, 0.0f) );
	r_wrist.setRotation( new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) (-0.2f * Math.PI)) );
	
	SegmentAdapter r_hand = new SegmentAdapter("r_hand");
	r_hand.addChild( createLimb(0.08f, 0.01f, 0.0f));
	
	
	
	// ***** LEGS ******

	JointAdapter l_hip = new JointAdapter("l_hip");
	l_hip.setTranslation( new Vector3f(0.16f, -0.03f, 0.0f) );
	l_hip.setRotation( new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) (1.0f * Math.PI)) );
	
	SegmentAdapter l_thigh = new SegmentAdapter("l_thigh");
	l_thigh.addChild( createLimb(0.08f, 0.08f, THIGH_LENGTH));
	

	JointAdapter l_knee = new JointAdapter("l_knee");
	l_knee.setTranslation( new Vector3f(0.0f, THIGH_LENGTH, 0.0f) );
	l_knee.setRotation( new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) (0.0f * Math.PI)) );
	
	SegmentAdapter l_calf = new SegmentAdapter("l_calf");
	l_calf.addChild( createLimb(0.09f, 0.07f, CALF_LENGTH));


	JointAdapter l_ankle = new JointAdapter("l_ankle");
	l_ankle.setTranslation( new Vector3f(0.0f, CALF_LENGTH, 0.0f) );
	l_ankle.setRotation( new AxisAngle4f(1.0f, 0.0f, 0.0f, (float) (0.4f * Math.PI)) );
	
	SegmentAdapter l_foot = new SegmentAdapter("l_foot");
	l_foot.addChild( createLimb(0.08f, 0.07f, FOOT_LENGTH));


	JointAdapter r_hip = new JointAdapter("r_hip");
	r_hip.setTranslation( new Vector3f(-0.16f, -0.03f, 0.0f) );
	r_hip.setRotation( new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) (1.0f * Math.PI)) );
	
	SegmentAdapter r_thigh = new SegmentAdapter("r_thigh");
	r_thigh.addChild( createLimb(0.08f, 0.08f, THIGH_LENGTH));


	JointAdapter r_knee = new JointAdapter("r_knee");
	r_knee.setTranslation( new Vector3f(0.0f, THIGH_LENGTH, 0.0f) );
	r_knee.setRotation( new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) (0.0f * Math.PI)) );
	
	SegmentAdapter r_calf = new SegmentAdapter("r_calf");
	r_calf.addChild( createLimb(0.09f, 0.07f, CALF_LENGTH));


	JointAdapter r_ankle = new JointAdapter("r_ankle");
	r_ankle.setTranslation( new Vector3f(0.0f, CALF_LENGTH, 0.0f) );
	r_ankle.setRotation( new AxisAngle4f(1.0f, 0.0f, 0.0f, (float) (0.4f * Math.PI)) );
	
	SegmentAdapter r_foot = new SegmentAdapter("r_foot");
	r_foot.addChild( createLimb(0.08f, 0.07f, FOOT_LENGTH));
	
	
	//**************************************************
	
	l_wrist.addChild(l_hand.getGroup());
	
	r_wrist.addChild(r_hand.getGroup());
	
	l_elbow.addChild(l_forearm.getGroup());
	l_elbow.addChild(l_wrist.getGroup());
	
	r_elbow.addChild(r_forearm.getGroup());
	r_elbow.addChild(r_wrist.getGroup());

	l_shoulder.addChild(l_upperarm.getGroup());
	l_shoulder.addChild(l_elbow.getGroup());
	
	r_shoulder.addChild(r_upperarm.getGroup());
	r_shoulder.addChild(r_elbow.getGroup());

	l_ankle.addChild(l_foot.getGroup());
	
	r_ankle.addChild(r_foot.getGroup());
	
	l_knee.addChild(l_calf.getGroup());
	l_knee.addChild(l_ankle.getGroup());
	
	r_knee.addChild(r_calf.getGroup());
	r_knee.addChild(r_ankle.getGroup());

	l_hip.addChild(l_thigh.getGroup());
	l_hip.addChild(l_knee.getGroup());
	
	r_hip.addChild(r_thigh.getGroup());
	r_hip.addChild(r_knee.getGroup());

	
	skullbase.addChild(cervical.getGroup());

	vt1.addChild(l_shoulder.getGroup());
	vt1.addChild(r_shoulder.getGroup());
	vt1.addChild(skullbase.getGroup());

	HumanoidRoot.addChild(l_hip.getGroup());
	HumanoidRoot.addChild(r_hip.getGroup());	

	
	vt1.addChild(thorasic.getGroup());
	HumanoidRoot.addChild(vt1.getGroup());


      // we're ready to go "live", let's add the damn thing :)
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

  	return base;	
  }
  
   public static void main(String[] args) {
      JFrame frame = new Hanim6();
   } 

} 
