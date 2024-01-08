/* Joint interface voor opdracht 1 */

/**
 * Implemented by Jeroen van Yperen, 21/feb/2002
 * (j.vanijperen@student.utwente.nl)
 */

import javax.media.j3d.*;
import javax.vecmath.*;



/**
 * The Joint interface describes Joints between "body parts",
 * The interface applies both to Joints in HAnim style, based
 * on "absolute" coordinates within a body, as well as a compositional
 * style, based on "relative" coordinates. 
 * The distinction is based on whether the Joint center is set (HAnim),
 * or is not set (compositional). 
 * In the HAnim case, the translation/position of the Joint is expected to be 
 * used only for minor corrections  not at all.
 * For the compositional case, the position of the Joint denotes its 
 * position relative to the parent of the Joint. 
 */
public class JointAdapter extends TransformGroup implements Joint {
	private String myName = new String("blaat");
	private Vector3f myCenterVector3f = new Vector3f(0.0f, 0.0f, 0.0f);
	private Vector3f myTransVector3f = new Vector3f(0.0f, 0.0f, 0.0f);
	private AxisAngle4f myAxisAngle = new AxisAngle4f();
	private float myScale = 1.0f;
	
	private Transform3D myTranslate3D = new Transform3D();
	private TransformGroup myTranslateGroup = new TransformGroup();
	private Transform3D myRotation3D = new Transform3D();
	private TransformGroup myRotateGroup = new TransformGroup();
	
	
	public JointAdapter(String name) {
		
		myName = name;
		
	        myRotateGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	        myRotateGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		
		myTranslateGroup.addChild(myRotateGroup);
		
	}
	
	/**
	 * Calculates the rotation and scale after it's been set. This function puts the
	 * rotation and scaling into one 
	 */
	
	private void calculateRotationScale() {

		myRotation3D.setScale(myScale);		
		myRotation3D.setRotation(myAxisAngle);
		
		myRotateGroup.setTransform(myRotation3D);
	}

	

	/**
	 * sets the name of the Joint
	 */
	public void setName(String name) {
		myName = name;
	}
	
	/**
	 * gets the name of the Joint
	 */
	public String getName() {
		return myName;
	}
	
	
	/**
	 * sets the center of rotation; must not be set when 
	 * "relative" coordinates are used.
	 */
	public void setCenter(Vector3f center) {
		myCenterVector3f = center;
	}
	
	/**
	 * gets the center of rotation, or null if the center is not set.
	 */
	public Vector3f getCenter() {
		return myCenterVector3f;
	}
	
	/**
	 * sets the rotation component of the Joint
	 */
	public void setRotation(AxisAngle4f rotation) {
		myAxisAngle = rotation;
		
		calculateRotationScale();
	}
		
	
	/**
	 * gets the rotation component of the Joint
	 */
	public AxisAngle4f getRotation() {
		return myAxisAngle;
	}
	
	/**
	 * sets the lower limits for the rotations around X, Y, and Z axis.
	 */
	public void setLLimit(float[] llimit) {
		// null
	}
	
	
	/**
	 * gets the lower limits for the rotations around X, Y, and Z axis.
	 */
	public float[]  getLLimit() {
		float[] blaat = new float[3];
		blaat[1] = 1.0f;

		return blaat;
	}
	
	/**
	 * sets the upper limits for the rotations around X, Y, and Z axis.
	 */
	public void setULimit(float[] ulimit) {
		// null
	}
	
	/**
	 * gets the upper limits for the rotations around X, Y, and Z axis.
	 */
	public float[]  getULimit() {
		float[] blaat = new float[3];
		blaat[1] = 1.0f;

		return blaat;
	}
	
	/**
	 * sets the "stiffness" coefficients for the rotations around X, Y, and Z axis.
	 * The values must be between 0.0f and 1.0f.
	 */
	public void setStiffness(float[] stiffness) {
		// null
	}
	
	
	/**
	 * gets the "stiffness" coefficients for the rotations around X, Y, and Z axis.
	 */
	public float[]  getStiffness() {
		float[] blaat = new float[3];
		blaat[1] = 1.0f;
		
		return ( blaat );
	}
	
	/**
	 * sets the uniform scaling factor for the Joint
	 */
	public void setScale(float scale) {
		myScale = scale;
		calculateRotationScale();
	}
	
	/**
	 * gets the uniform scaling factor for the Joint
	 */
	public float getScale() {
		return myScale;
	}
	
	/**
	 * sets the translation component of the Joint;
	 * The translation is applied after the rotation and scaling transformations.
	 */
	public void setTranslation(Vector3f translation) {
		myTransVector3f = translation;
		myTranslate3D.set(myTransVector3f);
		myTranslateGroup.setTransform(myTranslate3D);
	}
		
	
	/**
	 * gets the translation component of the Joint;
	 */
	public Vector3f getTranslation() {
		return myTransVector3f;
	}
	
	
	/**
	 * adds child to the list of children
	 */
	public void addChild(Node child) {
		myRotateGroup.addChild(child);
	}
	
	/**
	 * returns all children, in the form of an Enumeration.
	 */
	public java.util.Enumeration getAllChildren() {
		return myRotateGroup.getAllChildren();
	}
	
	
	/**
	 * removes the child at the specified index
	 */
	public void removeChild(int index) {
		myRotateGroup.removeChild(index);
	}
	
	
	/**
	 * returns a handle to the Transformgroup that contains
	 * the rotational component and the scaling component of the Joint.
	 * This TransformGroup has TransformGroup.ALLOW_TRANSFORM_READ
	 * and TransformGroup.ALLOW_TRANSFORM_WRITE capabilities set, and so
	 * can be used for animation, after the avatar is included in a "live" scene graph.
	 */
	public TransformGroup getScaleRotateTransformGroup() {
		return myRotateGroup;
	}
	

}