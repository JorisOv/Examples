package opdracht3;

import javax.media.j3d.*;
import javax.vecmath.*;
import java.io.File;
import java.util.Vector;
import com.sun.j3d.utils.geometry.*;

/**
 * A SegmentAdapter is used to model visual parts of the body. It is
 * assumed that the bodypart is placed in the right position in relation
 * to other bodyparts. Use the functions setTranslation() and setRotation()
 * for this.
 * NOTE: The SegmentAdapter is a TransformGroup. For the rotation is no
 * special TransformGroup, because it is done by using the SegmentAdapter self.
 */

public class SegmentAdapter extends TransformGroup implements Segment {

	private String name = new String();
	private Point3f bboxCenter = new Point3f();
	private double length = 0.0d;
	private Point3f centerOfMass = new Point3f();
	private float mass = 0.0f;

	// used for putting the Segment in the right place
	
	// for center-translation specified in VRML-file (translation)
	private TransformGroup toCenterTG = new TransformGroup();
	private Transform3D toCenter3D = new Transform3D();

	// for rotation specified in VRML-file
	private TransformGroup rotateTG = new TransformGroup();
	private Transform3D rotate3D = new Transform3D();

	// negated center-translation
	private TransformGroup toOriginTG = new TransformGroup();
	private Transform3D toOrigin3D = new Transform3D();
	
	// for minor adjustments (translation in VRML-file)
	private TransformGroup adjustmentTG = new TransformGroup();
	private Transform3D adjustment3D = new Transform3D();

	/**
	 * Construct a SegmentAdapter with no translation and no rotation.
	 */
	public SegmentAdapter()
	{
		this("");
	}
	
	public SegmentAdapter(String name)
	{
		this(name, new Vector3f(), new AxisAngle4f());
	}

	/** 
	 * Construct a SegmentAdapter translation and rotation. Use this translation
	 * and rotation only for positioning the Segment in the good position in relation
	 * to the other segments (body parts).
	 *
	 * @param translation - the translation of the SegmentAdapter
	 * @param rotation - the rotation of the SegmentAdapter
	 */	
	public SegmentAdapter(String name, Vector3f translation, AxisAngle4f rotation)
	{
		setName(name);
		setTranslation(translation);
		setRotation(rotation);

    // set the capabilities
    super.setCapability(ALLOW_TRANSFORM_READ);
    super.setCapability(ALLOW_TRANSFORM_WRITE);
		rotateTG.setCapability(ALLOW_TRANSFORM_READ);
		rotateTG.setCapability(ALLOW_TRANSFORM_WRITE);
	}

	public SegmentAdapter(File file)
	{
    this("");
		createSegment(file);
	}

	/**
	 * Sets the translation of the SegmentAdapter. Use this only for the positioning
	 * of the Segment in relation the the other segments (body parts)
	 *
	 * @param translation - the translation of the SegmentAdapter
	 */
  public void setTranslation(Vector3f translation)
  {
		adjustment3D.setTranslation(translation);
		adjustmentTG.setTransform(adjustment3D);
  }
  
	/**
	 * Sets the rotation of the SegmentAdapter. Use this only for the positioning
	 * of the Segment in relation the the other segments (body parts)
	 *
	 * @param rotation - the rotation of the SegmentAdapter	 
	 */
  public void setRotation(AxisAngle4f rotation)
  {
		rotate3D.setRotation(rotation);
		rotateTG.setTransform(rotate3D);
  }

	/**
	 * Sets the name of the Segment
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the name of the Segment
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the center of the bounding box.
	 */
	public void setBboxCenter(Point3f bboxCenter)
	{
		this.bboxCenter = bboxCenter;
	}

	/**
	 * gets the center of the bounding box.
	 */
	public Point3f getBboxCenter()
	{
		return bboxCenter;
	}

	/**
	 * Sets the length of the segment.
	 */
	public void setLength(double length)
	{
		this.length = length;
	}

	/**
	 * Gets the length of the segment.
	 */
	public double getLength()
	{
		return length;
	}

	/**
	 * Sets the center of mass.
	 */
	public void setCenterOfMass(Point3f centerOfMass)
	{
		this.centerOfMass = centerOfMass;
	}

	/**
	 * Gets the center of mass.
	 */
	public Point3f getCenterOfMass()
	{
		return centerOfMass;
	}


	/**
	 * Sets the mass.
	 */
	public void setMass(float mass)
	{
		this.mass = mass;
	}

	/**
	 * Gets the mass.
	 */
	public float getMass()
	{
		return mass;
	}

	/**
	 * adds child to the list of children
	 */
	public void addChild(Node child)
	{
		rotateTG.addChild(child);
	}

	/**
	 * returns all children, in the form of an Enumeration.
	 */
	public java.util.Enumeration getAllChildren()
	{
		return rotateTG.getAllChildren();
	}

	/**
	 * removes the child at the specified index
	 */
	public void removeChild(int index)
	{
		rotateTG.removeChild(index);
	}

	private void createSegment(File file)
	{
		StringBuffer content = DataReader.readFile(file.getPath());
		String contentString = content.toString();
		VRMLProcessor processor = new VRMLProcessor(contentString);

		System.out.println("File '" + file.getPath() + "' loaded.");

		// set the name of the Semgment
		setName(processor.name);

		// make a GeometryInfo
		GeometryInfo gi = new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
		gi.setCoordinateIndices(processor.getCoordinateIndexesArray());
		gi.setCoordinates(processor.getCoordinatesArray());
		gi.setStripCounts(processor.stripIndexCounts);

		// there is no diffuse color
		if (processor.materialColor == null)
		{
			gi.setColorIndices(processor.getColorIndexesArray());
			gi.setColors(processor.getColorsArray());

		}       

		// triangluate
		Triangulator tri = new Triangulator();
		tri.triangulate(gi);
		// generate normals
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		// stripify
		Stripifier st = new Stripifier();
		st.stripify(gi);

		Shape3D bodyPart = new Shape3D();
		Appearance appearance = new Appearance();

		Material mat = new Material();
    if (processor.materialColor != null)
    {
      mat.setDiffuseColor(processor.materialColor);
    }

		appearance.setMaterial(mat);

		bodyPart.setAppearance(appearance);
		bodyPart.setGeometry(gi.getGeometryArray());

		// minor adjustments
		adjustment3D.setTranslation(processor.getTranslation());
		adjustmentTG.setTransform(adjustment3D);
		adjustmentTG.addChild(toCenterTG);

		// Adding rotation (from VRML-file)
		Vector3f center = processor.getCenter();
		
		// to center
		toCenter3D.setTranslation(center);
		toCenterTG.setTransform(toCenter3D);
		toCenterTG.addChild(rotateTG);
		
		// rotate
		rotate3D.setRotation(processor.getRotation());
		rotateTG.setTransform(rotate3D);
		rotateTG.addChild(toOriginTG);
		
		// back to original place
		center.negate();
		toOrigin3D.setTranslation(center);
		toOriginTG.setTransform(toOrigin3D);
		toOriginTG.addChild(bodyPart);
		
		super.addChild(adjustmentTG);
	}

	public static void main(String[] args)
	{
		SegmentAdapter sa = new SegmentAdapter();
		sa.createSegment(new File("opdracht2/data/hanim_skull.m4"));
		System.exit(0);
	}
}