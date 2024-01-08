/* @author Job Zwiers  
 * @version  0, revision $Revision: 1.6 $,
 * $Date: 2001/10/12 09:22:40 $    
 * @since version 0       
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class ConfiguredUniverse  { 
    public VirtualUniverse   universe;
    public Locale            locale;
    public Canvas3D          canvas3D ;
    private Transform3D       vpTransform3D;
    private TransformGroup    vpTransGroup;
    private	Vector3f	vpPos	= new Vector3f();
    private	float		vpScale;
    private	Quat4f		vpQuat	= new Quat4f();
    private Quat4d    q = new Quat4d();
    
    public ConfiguredUniverse() {           
      GraphicsConfigTemplate3D tmpl = new GraphicsConfigTemplate3D();
      tmpl.setStereo(GraphicsConfigTemplate.PREFERRED);
      GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice device = env.getDefaultScreenDevice();
      GraphicsConfiguration config = device.getBestConfiguration(tmpl);

      canvas3D = new Canvas3D(config);
      Screen3D screen3D = canvas3D.getScreen3D();
      //screen3D.setPhysicalScreenWidth(1.48);   // in meters, voor 3D scherm infinity box
      //screen3D.setPhysicalScreenHeight(1.10);
      //canvas.setStereoEnable(true);

      // Establish a virtual universe that has a single Locale
      universe = new VirtualUniverse();
      locale = new Locale(universe);
      
      // Create a default PhysicalBody and PhysicalEnvironment object
      PhysicalBody body = new PhysicalBody();
      
      PhysicalEnvironment environment = new PhysicalEnvironment();
      //FlockDevice flock = new FlockDevice();
      //environment.setSensor(0, flock.getSensor(0));
      //environment.addInputDevice(flock);
      
      // Create a View and attach the Canvas3D and the physical
      // body and environment to the view.
      View view = new View();
      view.addCanvas3D(canvas3D);
      view.setPhysicalBody(body);
      view.setPhysicalEnvironment(environment);

      double frontclip = view.getFrontClipDistance();
      double backclip = view.getBackClipDistance();
      view.setFrontClipDistance(0.1);
      view.setBackClipDistance(100);  // 1000 voor 3D scherm
      
      // Create a BranchGroup node for the view platform
      BranchGroup vpRoot = new BranchGroup();
      // Create a ViewPlatform object, and its associated
      // TransformGroup object, and attach it to the root of the
      // subgraph. Attach the view to the view platform.
      vpTransform3D = new Transform3D();
      // set a translation for the viewpoint: 6.0 metres before the screen.
      vpTransform3D.set(new Vector3f(0.0f, 4.0f, 6.0f));
      ViewPlatform vp = new ViewPlatform();
      vpTransGroup = new TransformGroup(vpTransform3D);
      vpTransGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      vpTransGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      vpTransGroup.addChild(vp);
      
      KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(vpTransGroup);
      keyNavBeh.setSchedulingBounds(new BoundingSphere(new Point3d(),100000.0));
      vpRoot.addChild(keyNavBeh);
      
 
      vpRoot.addChild(vpTransGroup);
      view.attachViewPlatform(vp);
      locale.addBranchGraph(vpRoot);
    }

    public void setViewTransform(Quat4f vpQuat, Vector3f vpPos, float vpScale) {
      vpTransform3D.set(vpQuat, vpPos, vpScale);
      vpTransGroup.setTransform(vpTransform3D);
    }

    public float getViewTransform(Quat4f vpQuat, Vector3f vpPos) {
      //vpTransGroup.getTransform(vpTransform3D);
      return vpTransform3D.get(vpQuat, vpPos);
    }

    public Vector3f getPosition() {
      //vpTransGroup.getTransform(vpTransform3D);
      vpTransform3D.get(vpQuat, vpPos);
      return vpPos;
    }

    public void setPosition(Vector3f newPos) {
      vpTransform3D.setTranslation(newPos);
      vpTransGroup.setTransform(vpTransform3D);
    }

    public void setRotation(AxisAngle4f rot) {
      vpTransform3D.setRotation(rot);
      vpTransGroup.setTransform(vpTransform3D);
    }

    public void setRotYAngle(double angle) {
      q.w =  Math.cos(angle/2.0);
      q.x = 0.0;
      q.z = 0.0;
      q.y = Math.sqrt(1.0 - q.w*q.w);
      if (Math.sin(angle/2.0) < 0) q.y = -q.y;
      vpTransform3D.setRotation(q);
      vpTransGroup.setTransform(vpTransform3D);
    }

    public  Canvas3D getCanvas3D() {
       return canvas3D;
    }

    public  void addBranchGroup(BranchGroup bg) {
      bg.compile();
       locale.addBranchGraph(bg);
    }    

    
}
