/* Joint interface voor opdracht 1 */
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
 * used only for minor corrections or not at all.
 * For the compositional case, the position of the Joint denotes its 
 * position relative to the parent of the Joint. 
 */
public interface Joint 
{

/**
 * sets the name of the Joint
 */
public void setName(String name);

/**
 * gets the name of the Joint
 */
public String getName();


/**
 * sets the center of rotation; must not be set when 
 * "relative" coordinates are used.
 */
public void setCenter(Vector3f center);

/**
 * gets the center of rotation, or null if the center is not set.
 */
public Vector3f getCenter();

/**
 * sets the rotation component of the Joint
 */
public void setRotation(AxisAngle4f rotation);

/**
 * gets the rotation component of the Joint
 */
public AxisAngle4f getRotation();

/**
 * sets the lower limits for the rotations around X, Y, and Z axis.
 */
public void setLLimit(float[] llimit);


/**
 * gets the lower limits for the rotations around X, Y, and Z axis.
 */
public float[]  getLLimit();

/**
 * sets the upper limits for the rotations around X, Y, and Z axis.
 */
public void setULimit(float[] ulimit);


/**
 * gets the upper limits for the rotations around X, Y, and Z axis.
 */
public float[]  getULimit();

/**
 * sets the "stiffness" coefficients for the rotations around X, Y, and Z axis.
 * The values must be between 0.0f and 1.0f.
 */
public void setStiffness(float[] stiffness);


/**
 * gets the "stiffness" coefficients for the rotations around X, Y, and Z axis.
 */
public float[]  getStiffness();

/**
 * sets the uniform scaling factor for the Joint
 */
public void setScale(float scale);

/**
 * gets the uniform scaling factor for the Joint
 */
public float getScale();

/**
 * sets the translation component of the Joint;
 * The translation is applied after the rotation and scaling transformations.
 */
public void setTranslation(Vector3f translation);

/**
 * gets the translation component of the Joint;
 */
public Vector3f getTranslation();


/**
 * adds child to the list of children
 */
public void addChild(Node child);

/**
 * returns all children, in the form of an Enumeration.
 */
public java.util.Enumeration getAllChildren();


/**
 * removes the child at the specified index
 */
public void removeChild(int index);


/**
 * returns a handle to the Transformgroup that contains
 * the rotational component and the scaling component of the Joint.
 * This TransformGroup has TransformGroup.ALLOW_TRANSFORM_READ
 * and TransformGroup.ALLOW_TRANSFORM_WRITE capabilities set, and so
 * can be used for animation, after the avatar is included in a "live" scene graph.
 */
public TransformGroup getScaleRotateTransformGroup();
}