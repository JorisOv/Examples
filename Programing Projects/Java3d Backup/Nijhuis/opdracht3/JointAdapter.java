package opdracht3;

import javax.media.j3d.*;
import javax.vecmath.*;

/**
 * A JointAdapter is used to make Joints like they are used in the H|Anim
 * model. NOTE: the transforming methods setRotation(), setScale(),
 * setTranslation only remember the last value set with them. So the last
 * use of such a transform method will not be multiplied by the former uses
 * of the same transform method. This is true for each separate transform
 * method.
 */
public class JointAdapter extends TransformGroup implements Joint {

	static final int AMOUNTLIMITS = 100;

	private String name = new String();
	private Vector3f center = new Vector3f();
	private AxisAngle4f rotation = new AxisAngle4f();
	private float[] lLimit = new float[AMOUNTLIMITS];
	private float[] uLimit = new float[AMOUNTLIMITS];
	private float[] stiffness = new float[AMOUNTLIMITS];
	private float scale = 0;
	private Vector3f translation = new Vector3f();
  private TransformGroup childrenTG = new TransformGroup();

  // needed for the transformations of the JointAdapter
	private Transform3D toCenter3D = new Transform3D();
 	private Transform3D rotate3D = new Transform3D();
	private Transform3D toOrigin3D = new Transform3D();
  // the third TransformGroup is the class itself
  private TransformGroup rotateTG = new TransformGroup();
  private TransformGroup toOriginTG = new TransformGroup();


	/**
	 * Creates a new JointAdapter with default values for its private variables.
	 */
	public JointAdapter()
	{
    this("");
	}

	/**
	 * Creates a new JointAdapter with a given name and for the other
	 * private variables default values
	 *
	 * @param name the name of the JointAdapter
	 */
	public JointAdapter(String name)
	{
		this(name, new Vector3f());
	}

	/**
	 * Creates a new JointAdapter with a given name and center and for the
	 * other private variables default values
	 *
	 * @param name the name of the JointAdapter
	 * @param center the center of the JointAdapter
	 */
	public JointAdapter(String name, Vector3f center)
	{
		setName(name);
		setCenter(center);

    // the link between the internal TransformGroups
    super.addChild(rotateTG);
    rotateTG.addChild(toOriginTG);
    
    // set the abilities
    super.setCapability(ALLOW_TRANSFORM_READ);
    super.setCapability(ALLOW_TRANSFORM_WRITE);
		rotateTG.setCapability(ALLOW_TRANSFORM_READ);
		rotateTG.setCapability(ALLOW_TRANSFORM_WRITE);
		toOriginTG.setCapability(ALLOW_TRANSFORM_READ);
		toOriginTG.setCapability(ALLOW_TRANSFORM_WRITE);
	}

	/**
	 * Sets the name of the Joint
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the name of the Joint
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the center of rotation; must not be set when
	 * "relative" coordinates are used.
	 */
	public void setCenter(Vector3f center)
	{
		this.center = center;

    // set the toCenter translation
    toCenter3D.setTranslation(center);
    super.setTransform(toCenter3D);

    // set the toOrigin translation
    Vector3f negatedCenter = new Vector3f(center);
    negatedCenter.negate();
    toOrigin3D.setTranslation(negatedCenter);
    toOriginTG.setTransform(toOrigin3D);
	}

	/**
	 * Gets the center of rotation
	 */
	public Vector3f getCenter()
	{
		return center;
	}

	/**
	 * Sets the rotation component of the Joint. NOTE: only the last
	 * rotation given by a setRotation() is remembered. This last use of this
	 * method will not be multiplied with the former uses of this method. Rotates
	 * around the center.
	 */
	public void setRotation(AxisAngle4f rotation)
	{
    // fill the rotate TransformGroup
    rotate3D.setRotation(rotation);
    rotateTG.setTransform(rotate3D);
	}

	/**
	 * Gets the rotation component of the Joint
	 */
	public AxisAngle4f getRotation()
	{
		return rotation;
	}

	/**
	 * Sets the lower limits for the rotations around X, Y, and Z axis.
	 */
	public void setLLimit(float[] lLimit)
	{
		this.lLimit = lLimit;
	}


	/**
	 * Gets the lower limits for the rotations around X, Y, and Z axis.
	 */
	public float[] getLLimit()
	{
		return lLimit;
	}

	/**
	 * Sets the upper limits for the rotations around X, Y, and Z axis.
	 */
	public void setULimit(float[] uLimit)
	{
		this.uLimit = uLimit;
	}


	/**
	 * Gets the upper limits for the rotations around X, Y, and Z axis.
	 */
	public float[]  getULimit()
	{
		return uLimit;
	}

	/**
	 * Sets the "stiffness" coefficients for the rotations around X, Y, and Z axis.
	 * The values must be between 0.0f and 1.0f.
	 */
	public void setStiffness(float[] stiffness)
	{
		for (int i = 0; i < stiffness.length; i++)
		{
			if (stiffness[i] < 0.0f || stiffness[i] > 1.0f)
			{
				/*System.out.println("setStiffness: The values of the array stiffness " +
													 "are not between 0.0f and 1.0f (inclusief)");*/
				return;
			}
		}

		this.stiffness = stiffness;
	}

	/**
	 * Gets the "stiffness" coefficients for the rotations around X, Y, and Z axis.
	 */
	public float[]  getStiffness()
	{
		return stiffness;
	}

	/**
	 * Sets the uniform scaling factor for the Joint. NOTE: only the last
	 * scaling given by a setScale() is remembered. This last use of this
	 * method will not be multiplied with the former uses of this method.
	 */
	public void setScale(float scale)
	{
		this.scale = scale;

    // set the scale component in the toCenterTG
    toCenter3D.setScale( (double) scale);
    super.setTransform(toCenter3D);
	}

	/**
	 * Gets the uniform scaling factor for the Joint
	 */
	public float getScale()
	{
		return scale;
	}

	/**
	 * Sets the translation component of the Joint;
	 * The translation is applied after the rotation and scaling transformations.
	 * NOTE: only the last translation
	 * given by a setTranslation() is remembered. This last use of this
	 * method will not be multiplied with the former uses of this method.
	 */
	public void setTranslation(Vector3f translation)
	{
		this.translation = translation;
	}

	/**
	 * Gets the translation component of the Joint;
	 */
	public Vector3f getTranslation()
	{
		return translation;
	}


	/**
	 * Adds child to the list of children
	 */
	public void addChild(Node child)
	{
		if (child instanceof SegmentAdapter)
    {
      // add the Segment to the tree
      toOriginTG.addChild(child);
    }
    else if (child instanceof JointAdapter)
    {
      // add the Joint to the tree
      JointAdapter jaChild = new JointAdapter();
      jaChild = (JointAdapter) child;
      toOriginTG.addChild(jaChild);
    }
    else toOriginTG.addChild(child);
	}

	/**
	 * Returns all children, in the form of an Enumeration.
	 */
	public java.util.Enumeration getAllChildren()
	{
		return childrenTG.getAllChildren();
	}

	/**
	 * Removes the child at the specified index
	 */
	public void removeChild(int index)
	{
    // remove the child from the chldrenTG
		childrenTG.removeChild(index);

    // remove the connection to the TransformGroup of the next Joint
    toOriginTG.removeChild(index);
	}

	/**
	 * returns a handle to the Transformgroup that contains
	 * the rotational component and the scaling component of the Joint.
	 * This TransformGroup has TransformGroup.ALLOW_TRANSFORM_READ
	 * and TransformGroup.ALLOW_TRANSFORM_WRITE capabilities set, and so
	 * can be used for animation, after the avatar is included in a "live" scene graph.
	 */
	public TransformGroup getScaleRotateTransformGroup()
	{
		return rotateTG;
	}
}