package opdracht3;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.behaviors.mouse.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import java.io.File;
import java.util.*;


public class BodyWorld extends JFrame
{
	private final double BOUNDS = 1000.0;
	
	private Transform3D axis;
	private Transform3D y_axis;
	private Transform3D z_axis;
	
  private Hashtable hTable;

  private JointAdapter humanoidRoot;
  private JointAdapter skullbase;
  private JointAdapter r_shoulder;
  private JointAdapter r_elbow;
  private JointAdapter r_wrist;
  private JointAdapter l_shoulder;
  private JointAdapter l_elbow;
	private JointAdapter l_wrist;
	private JointAdapter vc4;
	private JointAdapter vc7;
	private JointAdapter r_hip;
	private JointAdapter r_knee;
	private JointAdapter r_ankle;
	private JointAdapter l_hip;
	private JointAdapter l_knee;
	private JointAdapter l_ankle;

	/**
	 * Shows a frame containing the scene graph.
	 */
	public BodyWorld()
	{
		axis = new Transform3D();
		//axis.setRotation(new AxisAngle4f(0.0f, 0.0f, 1.0f, 1.57f));
		
		
    //haalt interpolators op
    loadInterpolators();

		Container container = this.getContentPane();
		container.setLayout(null);

		Canvas3D canvas3D = new Canvas3D(null);
		canvas3D.setBounds(0, 0, 800, 600);
		container.add(canvas3D);

    BranchGroup scene = createSceneGraph();
    scene.compile();

    SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
    simpleU.getViewingPlatform().setNominalViewingTransform();

    simpleU.addBranchGraph(scene);

		this.setSize(800, 600);
    this.setResizable(false);
    this.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }
    });

    this.setVisible(true);
  }


  /**
   * Creates the actual "contents" of the scene graph, and returns a BranchGroup
   * that is ready to gco "live", by inserting it in a Universe.
   *
   * @return the BranchGroup containing the scene graph
   */
  public BranchGroup createSceneGraph() 
  {
    //haalt alpha object op
    Alpha alpha = ((TimeSensor) hTable.get("Walk_Time")).createAlpha();
    Alpha moveAlpha = ((TimeSensor) hTable.get("Move_Time")).createAlpha();
    BoundingSphere boundingSphere = new BoundingSphere(new Point3d(0.0f, 0.0f, 0.0f), BOUNDS);

    Appearance ap = new Appearance();
    ap.setMaterial(new Material());
    // objRoot is the top of our scene graph.
		BranchGroup objRoot = new BranchGroup();
		TransformGroup humanWorld = new TransformGroup();
		Transform3D verticalTranslation = new Transform3D();
		verticalTranslation.setTranslation(new Vector3f(0.0f, -0.2f, 0.0f));
		humanWorld.setTransform(verticalTranslation);
		humanWorld.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    humanWorld.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

    //bewegen van totale human
    TransformGroup humanMove = new TransformGroup();
		humanMove.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    humanMove.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

    //roteren van totale human
    TransformGroup humanTurn = new TransformGroup();
 		humanTurn.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    humanTurn.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);



		DirectionalLight dl = new DirectionalLight(new Color3f(1.0f, 1.0f, 1.0f),
			new Vector3f(0.0f, 0.0f, -1.0f));
		dl.setInfluencingBounds(new BoundingSphere(new Point3d(), 1000.0) );
		objRoot.addChild(dl);


    /** creatie human **/
		humanoidRoot = new JointAdapter("humanoidRoot");
		humanoidRoot.setCenter(new Vector3f(0.0f, 0.8240f, 0.0277f));

			SegmentAdapter pelvis = new SegmentAdapter(new File("opdracht3/data/hanim_pelvis.m4"));
			humanoidRoot.addChild(pelvis);

			vc7 = new JointAdapter("vc7");
			vc7.setCenter(new Vector3f(0.0066f, 1.5132f, -0.0301f));

				SegmentAdapter c7 = new SegmentAdapter(new File("opdracht3/data/hanim_c7.m4"));
				vc7.addChild(c7);

				vc4 = new JointAdapter("vc4");
				vc4.setCenter(new Vector3f(0.0066f, 1.5662f, -0.0084f));

					SegmentAdapter c4 = new SegmentAdapter(new File("opdracht3/data/hanim_c4.m4"));
					vc4.addChild(c4);

					skullbase = new JointAdapter("skullbase");
					skullbase.setCenter(new Vector3f(0.0044f, 1.6209f, 0.0236f));

						 SegmentAdapter skull = new SegmentAdapter(new File("opdracht3/data/hanim_skull.m4"));
						 skullbase.addChild(skull);

				vc4.addChild(skullbase);

			vc7.addChild(vc4);

				r_shoulder = new JointAdapter("r_shoulder");
				r_shoulder.setCenter(new Vector3f(-0.1907f, 1.4407f, -0.0325f));

					SegmentAdapter r_upperarm = new SegmentAdapter(new File("opdracht3/data/hanim_r_upperarm.m4"));
					r_shoulder.addChild(r_upperarm);

					r_elbow = new JointAdapter("r_elbow");
					r_elbow.setCenter(new Vector3f(-0.1949f, 1.1388f, -0.0620f));

						SegmentAdapter r_forearm = new SegmentAdapter(new File("opdracht3/data/hanim_r_forearm.m4"));
						r_elbow.addChild(r_forearm);

						r_wrist = new JointAdapter("r_wrist");
						r_wrist.setCenter(new Vector3f(-0.1959f, 0.8694f, -0.0521f));

							SegmentAdapter r_hand = new SegmentAdapter(new File("opdracht3/data/hanim_r_hand.m4"));
							r_wrist.addChild(r_hand);

					r_elbow.addChild(r_wrist);
					
  	      //voegt rotatie van rechter pols toe
          RotPosPathInterpolator rppi_r_wrist = getRppInterpolator(
            "r_wristRotInterp_BasicWalk", alpha, r_wrist.getScaleRotateTransformGroup(), axis);
          rppi_r_wrist.setSchedulingBounds(boundingSphere);
          r_wrist.addChild(rppi_r_wrist);	

				r_shoulder.addChild(r_elbow);
				
  	    //voegt rotatie van rechter elleboog toe
        RotPosPathInterpolator rppi_r_elbow = getRppInterpolator(
          "r_elbowRotInterp_BasicWalk", alpha, r_elbow.getScaleRotateTransformGroup(), axis);
        rppi_r_elbow.setSchedulingBounds(boundingSphere);
        r_elbow.addChild(rppi_r_elbow);	


			vc7.addChild(r_shoulder);
			
			//voegt rotatie van rechter schouder toe
      RotPosPathInterpolator rppi_r_shoulder = getRppInterpolator(
        "r_shoulderRotInterp_BasicWalk", alpha, r_shoulder.getScaleRotateTransformGroup(), axis);
      rppi_r_shoulder.setSchedulingBounds(boundingSphere);
      r_shoulder.addChild(rppi_r_shoulder);	
      
				l_shoulder = new JointAdapter("l_shoulder");
				l_shoulder.setCenter(new Vector3f(0.2029f, 1.4376f, -0.0387f));

					SegmentAdapter l_upperarm = new SegmentAdapter(new File("opdracht3/data/hanim_l_upperarm.m4"));
					l_shoulder.addChild(l_upperarm);

					l_elbow = new JointAdapter("l_elbow");
					l_elbow.setCenter(new Vector3f(0.2014f, 1.1357f, -0.0682f));

						SegmentAdapter l_forearm = new SegmentAdapter(new File("opdracht3/data/hanim_l_forearm.m4"));
						l_elbow.addChild(l_forearm);

						l_wrist = new JointAdapter("l_wrist");
						l_wrist.setCenter(new Vector3f(0.1984f, 0.8663f, -0.0583f));

							SegmentAdapter l_hand = new SegmentAdapter(new File("opdracht3/data/hanim_l_hand.m4"));
							l_wrist.addChild(l_hand);

						l_elbow.addChild(l_wrist);

  	        //voegt rotatie van linker pols toe
            RotPosPathInterpolator rppi_l_wrist = getRppInterpolator(
              "l_wristRotInterp_BasicWalk", alpha, l_wrist.getScaleRotateTransformGroup(), axis);
            rppi_l_wrist.setSchedulingBounds(boundingSphere);
            l_wrist.addChild(rppi_l_wrist);

					l_shoulder.addChild(l_elbow);

			    //voegt rotatie van linker elleboog toe
          RotPosPathInterpolator rppi_l_elbow = getRppInterpolator(
            "l_elbowRotInterp_BasicWalk", alpha, l_elbow.getScaleRotateTransformGroup(), axis);
          rppi_l_elbow.setSchedulingBounds(boundingSphere);
          l_elbow.addChild(rppi_l_elbow);	

			vc7.addChild(l_shoulder);

		  //voegt rotatie van linker schouder toe
      RotPosPathInterpolator rppi_l_shoulder = getRppInterpolator(
        "l_shoulderRotInterp_BasicWalk", alpha, l_shoulder.getScaleRotateTransformGroup(), axis);
      rppi_l_shoulder.setSchedulingBounds(boundingSphere);
      l_shoulder.addChild(rppi_l_shoulder);		

			r_hip = new JointAdapter("r_hip");
			r_hip.setCenter(new Vector3f(-0.0950f, 0.9171f, 0.0029f));

				SegmentAdapter r_thigh = new SegmentAdapter(new File("opdracht3/data/hanim_r_thigh.m4"));
				r_hip.addChild(r_thigh);

				r_knee = new JointAdapter("r_knee");
				r_knee.setCenter(new Vector3f(-0.0867f, 0.4913f, 0.0318f));

					SegmentAdapter r_calf = new SegmentAdapter(new File("opdracht3/data/hanim_r_calf.m4"));
					r_knee.addChild(r_calf);

						r_ankle = new JointAdapter("r_ankle");
						r_ankle.setCenter(new Vector3f(-0.0801f, 0.0712f, -0.0766f));

							SegmentAdapter r_foot = new SegmentAdapter(new File("opdracht3/data/hanim_r_hindfoot.m4"));
							r_ankle.addChild(r_foot);

						r_knee.addChild(r_ankle);
            
            //voegt rotatie van rechter enkel toe
            RotPosPathInterpolator rppi_r_ankle = getRppInterpolator(
              "r_ankleRotInterp_BasicWalk", alpha, r_ankle.getScaleRotateTransformGroup(), axis);
            rppi_r_ankle.setSchedulingBounds(boundingSphere);
            r_ankle.addChild(rppi_r_ankle);

				r_hip.addChild(r_knee);

        //voegt rotatie van rechter knie toe
        RotPosPathInterpolator rppi_r_knee = getRppInterpolator(
          "r_kneeRotInterp_BasicWalk", alpha, r_knee.getScaleRotateTransformGroup(), axis);
        rppi_r_knee.setSchedulingBounds(boundingSphere);
        r_knee.addChild(rppi_r_knee);

			l_hip = new JointAdapter("l_hip");
			l_hip.setCenter(new Vector3f(0.0961f, 0.9124f, -0.0001f));

			  SegmentAdapter l_thigh = new SegmentAdapter(new File("opdracht3/data/hanim_l_thigh.m4"));
				l_hip.addChild(l_thigh);

				l_knee = new JointAdapter("l_knee");
				l_knee.setCenter(new Vector3f(0.1040f, 0.4867f, 0.0308f));

				  SegmentAdapter l_calf = new SegmentAdapter(new File("opdracht3/data/hanim_l_calf.m4"));
				  l_knee.addChild(l_calf);

				  l_ankle = new JointAdapter("l_ankle");
					l_ankle.setCenter(new Vector3f(0.1101f, 0.0656f, -0.0736f));

						SegmentAdapter l_foot = new SegmentAdapter(new File("opdracht3/data/hanim_l_hindfoot.m4"));
						l_ankle.addChild(l_foot);

					l_knee.addChild(l_ankle);
					
					
				  //voegt rotatie van linker enkel toe
          RotPosPathInterpolator rppi_l_ankle = getRppInterpolator(
            "l_ankleRotInterp_BasicWalk", alpha, l_ankle.getScaleRotateTransformGroup(), axis);
          rppi_l_ankle.setSchedulingBounds(boundingSphere);
          l_ankle.addChild(rppi_l_ankle);

				l_hip.addChild(l_knee);
				 
				//voegt rotatie van linker knie toe
        RotPosPathInterpolator rppi_l_knee = getRppInterpolator(
          "l_kneeRotInterp_BasicWalk", alpha, l_knee.getScaleRotateTransformGroup(), axis);
        rppi_l_knee.setSchedulingBounds(boundingSphere);
        l_knee.addChild(rppi_l_knee);


		humanoidRoot.addChild(vc7);
		
		//voegt rotatie van upper body toe
    RotPosPathInterpolator rppi_neck = getRppInterpolator(
      "neckRotInterp_BasicWalk", alpha, vc7.getScaleRotateTransformGroup(), axis);
    rppi_neck.setSchedulingBounds(boundingSphere);    
    vc7.addChild(rppi_neck);		
    
		
		humanoidRoot.addChild(r_hip);
		
		//voegt rotatie van rechter heup toe
    RotPosPathInterpolator rppi_r_hip = getRppInterpolator(
      "r_hipRotInterp_BasicWalk", alpha, r_hip.getScaleRotateTransformGroup(), axis);
    rppi_r_hip.setSchedulingBounds(boundingSphere);
    r_hip.addChild(rppi_r_hip);		
		
		
		humanoidRoot.addChild(l_hip);
		
		//voegt rotatie van rechter heup toe
    RotPosPathInterpolator rppi_l_hip = getRppInterpolator(
      "l_hipRotInterp_BasicWalk", alpha, l_hip.getScaleRotateTransformGroup(), axis);
    rppi_l_hip.setSchedulingBounds(boundingSphere);
    l_hip.addChild(rppi_l_hip);		

    //rotatie van human
	  RotPosPathInterpolator rppi_humanoidRoot_rot = 
	    getRppInterpolator("whole_bodyRotInterp_BasicWalk", alpha,
	                       humanoidRoot.getScaleRotateTransformGroup(), axis);
	  rppi_humanoidRoot_rot.setSchedulingBounds(boundingSphere);
	  humanoidRoot.addChild(rppi_humanoidRoot_rot);
	  
	  //translatie van human
	  RotPosPathInterpolator rppi_humanoidRoot_walk = 
	    getRppInterpolator("whole_bodyTranInterp_BasicWalk", alpha, 
	                       humanoidRoot, axis);
	  rppi_humanoidRoot_walk.setSchedulingBounds(boundingSphere);
	  humanTurn.addChild(rppi_humanoidRoot_walk);
	  
	  //voegt human toe aan humanoidWorld
    humanTurn.addChild(humanoidRoot);

    humanMove.addChild(humanTurn);
    RotPosPathInterpolator rppi_human_turn =
      getRppInterpolator("turn_bodyRotInterp_BasicWalk", moveAlpha,
                         humanTurn, axis);
    rppi_human_turn.setSchedulingBounds(boundingSphere);
    humanMove.addChild(rppi_human_turn);


	  humanWorld.addChild(humanMove);
    RotPosPathInterpolator rppi_human_walk =
      getRppInterpolator("move_bodyTranInterp_BasicWalk", moveAlpha,
                         humanMove, axis);
    rppi_human_walk.setSchedulingBounds(boundingSphere);
    humanWorld.addChild(rppi_human_walk);


 		// for navigation
		MouseRotate mouseRotate = new MouseRotate();
		mouseRotate.setTransformGroup(humanWorld);
		mouseRotate.setSchedulingBounds(
			new BoundingSphere(new Point3d(0.0f, 0.0f, 0.0f), BOUNDS));

		int mouseZoomFlags = MouseBehavior.INVERT_INPUT;
		MouseZoom mouseZoom = new MouseZoom();
		mouseZoom.setFactor(0.1);
		mouseZoom.setTransformGroup(humanWorld);
		mouseZoom.setSchedulingBounds(
			new BoundingSphere(new Point3d(0.0f, 0.0f, 0.0f), BOUNDS));

    objRoot.addChild(humanWorld);
    objRoot.addChild(mouseRotate);
    objRoot.addChild(mouseZoom);

		return objRoot;
	}

  private void loadInterpolators()
  {
    InterpolatorsLoader iLoader = new InterpolatorsLoader(
      "opdracht3/data/basicwalkinterpolators.m4");
    hTable = iLoader.getInterpolators();    
  }

  private RotPosPathInterpolator getRppInterpolator(String name,
      Alpha alpha, TransformGroup target, Transform3D axisOfRotPos)
  {
    Interpolator interpolator = (Interpolator) hTable.get(name);    
    RotPosPathInterpolator rpp = new RotPosPathInterpolator(alpha, target, axisOfRotPos,
               interpolator.getKnots(), interpolator.getQuat4fs(), interpolator.getPositions());
    rpp.setSchedulingBounds(new BoundingSphere(new Point3d(0.0f, 0.0f, 0.0f), 500));

    return rpp;
  }

	public static void main(String[] args)
  {
    BodyWorld bw = new BodyWorld();
  }
}


