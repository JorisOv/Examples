package opdracht3;

/* segment interface voor opdracht 1 */
import javax.media.j3d.*;
import javax.vecmath.*;


/**
 * The Segment interface describes Segments that define the visible part
 * of "body parts",
 */
public interface Segment {


/**
 * sets the name of the Joint
 */
public void setName(String name);

/**
 * gets the name of the Joint
 */
public String getName();

/**
 * sets the center of the bounding box.
 */
public void setBboxCenter(Point3f bboxCenter);

/**
 * gets the center of the bounding box.
 */
public Point3f getBboxCenter();



/**
 * sets the length of the segment. 
 */
public void setLength(double length);


/**
 * gets the length of the segment. 
 */
public double getLength();

/**
 * sets the center of mass.
 */
public void setCenterOfMass(Point3f bboxCenter);

/**
 * gets the center of mass.
 */
public Point3f getCenterOfMass();


/**
 * sets the mass.
 */
public void setMass(float mass);

/**
 * gets the mass.
 */
public float getMass();

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



}

