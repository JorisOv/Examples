
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.*;
import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.applet.MainFrame; 
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;


public class RotatingLight extends BranchGroup {
  
  public static final int Xaxis = 1;
  public static final int Yaxis = 2;
  public static final int Zaxis = 3;
  
  
  public RotatingLight(int axis, Color3f pColor, int cycle) {
	   super();
        //Color3f pColor = new Color3f(1.0f, 1.0f, 0.0f);
        Point3f pointPos = new Point3f();
        Vector3f direction = new Vector3f();
        Transform3D rotAxis = new Transform3D(); // default: rotate around Y-axis.
        switch (axis) {
          case Xaxis: 
                 pointPos = new Point3f(0.0f, 0.0f, 1.0f );
                 direction = new Vector3f(0.0f, 0.0f, -1.0f);
                 rotAxis.rotZ(1.57);
                 break;
          case Yaxis: 
                 pointPos = new Point3f(1.0f, 0.0f, 0.0f);
                 direction = new Vector3f(-1.0f, 0.0f, 0.0f);
                 break;
          case Zaxis: 
                 pointPos = new Point3f(1.0f, 0.0f, 0.0f);
                 direction = new Vector3f(-1.0f, 0.0f, 0.0f);
                 rotAxis.rotX(1.57);
                 break;                      
        }
        Point3f attenuation = new Point3f(1f, 0.0f, 0.0f);
        float spreadAngle = (float) (Math.PI/5.0);
        float concentration = 0.0f;
        PointLight spotLight = new PointLight(pColor, pointPos, attenuation);
        //SpotLight spotLight = 
        // new SpotLight(pColor, pointPos, attenuation, direction, spreadAngle, concentration);
	      BoundingSphere bounds = new BoundingSphere(new Point3d(), 10.0); 
        spotLight.setInfluencingBounds( bounds);

	// Create the transform group node and initialize it to the
	// identity.  Enable the TRANSFORM_WRITE capability so that
	// our behavior code can modify it at runtime.  Add it to the
	// root of the subgraph.
      TransformGroup objSpin = new TransformGroup();
    	objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	    objSpin.addChild(spotLight);


	Alpha rotationAlpha = new Alpha(-1, cycle);
	  
	RotationInterpolator rotator =
	    new RotationInterpolator(rotationAlpha, objSpin, rotAxis, 0.0f, (float) Math.PI*2.0f);

	BoundingSphere rotatorBounds = new BoundingSphere(new Point3d(), 1000);
	rotator.setSchedulingBounds(rotatorBounds);
	objSpin.addChild(rotator);
	
  // overall rotation/positioning :
	Transform3D rotate = new Transform3D();
	Transform3D tempRotate = new Transform3D();
  rotate.rotX(0.0d);
  //rotate.rotX(Math.PI/4.0d);  // vervang door -Math.PI/4.0d om onderkant te zien
	//tempRotate.rotY(Math.PI/5.0d);
  //rotate.mul(tempRotate);
	TransformGroup objRotate = new TransformGroup(rotate);
	objRotate.addChild(objSpin);
	Transform3D position = new Transform3D();
	Vector3f pos = new Vector3f(0.0f, 0.0f, 0.0f);
	position.set(pos);
	TransformGroup objPosition = new TransformGroup(position);
	objPosition.addChild(objRotate);
	addChild(objPosition);

 } 

 

} 
