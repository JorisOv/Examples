/* segment interface voor opdracht 1 */

/**
 * Implemented by Jeroen van Yperen, 21/feb/2002
 * (j.vanijperen@student.utwente.nl)
 */

import javax.media.j3d.*;
import javax.vecmath.*;


/**
 * The Segment interface describes Segments that define the visible part
 * of "body parts",
 */
public class SegmentAdapter extends TransformGroup implements Segment {
	private String myName = new String("bla");
	private Point3f myBboxCenter = new Point3f(0.0f, 0.0f, 0.0f);
	private Point3f myMassCenter = new Point3f(0.0f, 0.0f, 0.0f);
	private double myLength;
	private Float myMass;
	private TransformGroup myTransGroup = new TransformGroup();



	public SegmentAdapter(String name) {
		myName = name;

	}

	/*
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
	 * sets the center of the bounding box.
	 */
	public void setBboxCenter(Point3f bboxCenter) {
		myBboxCenter = bboxCenter;
	}
	
	/**
	 * gets the center of the bounding box.
	 */
	public Point3f getBboxCenter() {
		
		return myBboxCenter;
	}
		
	/**
	 * sets the length of the segment. 
	 */
	public void setLength(double length) {
		myLength = length;
		
	}
	
	
	/**
	 * gets the length of the segment. 
	 */
	public double getLength() {
		return myLength;
	}
	
	/**
	 * sets the center of mass.
	 */
	public void setCenterOfMass(Point3f bboxCenter) {
		myMassCenter = bboxCenter;
	}
	
	/**
	 * gets the center of mass.
	 */
	public Point3f getCenterOfMass() {
		
		return myMassCenter;
	}
	
	
	/**
	 * sets the mass.
	 */
	public void setMass(Float mass) {
		myMass = mass;
	}
	
	/**
	 * gets the mass.
	 */
	public float getMass() {
		return myMass.floatValue();
	}
	
	/**
	 * adds child to the list of children
	 */
	public void addChild(Node child) {
		myTransGroup.addChild(child);
	}
	
	/**
	 * returns all children, in the form of an Enumeration.
	 */
	public java.util.Enumeration getAllChildren() {
		return myTransGroup.getAllChildren();
	}
	
	
	/**
	 * removes the child at the specified index
	 */
	public void removeChild(int index) {
		myTransGroup.removeChild(index);
	}
	
}

