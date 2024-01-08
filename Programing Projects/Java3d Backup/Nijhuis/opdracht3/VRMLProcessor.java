package opdracht3;

import java.util.*;
import javax.vecmath.*;


public class VRMLProcessor
{
	private String VRMLString = new String();

	public String name = new String();
	private Vector coordinates = new Vector();
	private Vector coordinateIndexes = new Vector();
	private Vector colors = new Vector();
	private Vector colorIndexes = new Vector();
	public Color3f materialColor = new Color3f();


	public int vertexCount = 0;
	public int indexCount = 0;
	public int[] stripIndexCounts;


	/* Constructs a VRMLProcessor. This class will direct process all the data
	 * in the file. This can take a while.
	 */
	public VRMLProcessor(String VRMLString)
	{
		this.VRMLString = VRMLString;
		name = readName();
		coordinates = readCoordinates();
		coordinateIndexes = readCoordinateIndexes();
		materialColor = readMaterialColor();
		// only when there is no materialColor there are colors and colorindices
		if (materialColor == null)
		{
			colors = readColors();
			colorIndexes = readColorIndexes();
		}

		vertexCount = coordinates.size();
		indexCount = coordinateIndexes.size();

		// the stripIndexCounts is filled in readCoordinateIndexes()!!!;
	}

	public String readName()
	{
		// search for the name
		int nameStart = VRMLString.indexOf("name") + 6;
		int nameEnd = VRMLString.indexOf("\"", nameStart);

		// return the name
		return VRMLString.substring(nameStart, nameEnd);
	}

	public Color3f readMaterialColor()
	{

	if (VRMLString.indexOf("Skin_Color") != -1) return new Color3f(0.749f, 0.601f, 0.462f);
 	if (VRMLString.indexOf("Shirt_Color") != -1) return new Color3f(0.6f, 0.0745f, 0.1137f);
	if (VRMLString.indexOf("Pants_Color") != -1) return new Color3f(0.054f, 0.233f, 0.39f);
	if (VRMLString.indexOf("Shoe_Color") != -1) return new Color3f(0.8f, 0.8f, 0.8f);

  return null;
	}

	/* Reads all vertices out of a Vector with String that contain floats.
	 * It is assumed that every third String ends with a comma (,)
	 * The Vector it returns should be
	 * three times smaller than de Vector returned by readFloats.
	 *
	 * @return a Vector containing all vertices
	 */
	public Vector readCoordinates()
	{
		Vector coordinateNumbers = readFloats("point [");

		return readTriples(coordinateNumbers);
	}

	/* Reads all triples out of a Vector with String that contain floats.
	 * It is assumed that every third String ends with a comma (,)
	 * The Vector it return is three times smaller than the Vector it takes.
	 *
	 * @return a Vector containing all triples
	 */

	public Vector readTriples(Vector numbers)
	{
		Vector vertices = new Vector();
		Enumeration enum = numbers.elements();
		Float[] number = new Float[3];
		while (enum.hasMoreElements())
		{
			// get three numbers
			for (int i = 0; i < number.length; i++)
			{
				number[i] = (Float) enum.nextElement();
			}
			// make a Point3f of the three numbers
			Point3f vertex = new Point3f(number[0].floatValue(),
				number[1].floatValue(), number[2].floatValue());
			vertices.add(vertex);
		}
		return vertices;
	}

	/* Read all integers from the VRML-file. This is INCLUSIVE the
	 * values of -1.
	 *
	 * @return a Vector containing all integers
	 */
	private Vector readIntsInclusive(String searchString)
	{
		// search for searchString
		int start = VRMLString.indexOf(searchString) + searchString.length() + 1;
		int end = VRMLString.indexOf("]", start);

		String ints = VRMLString.substring(start, end);

		// process ints to intsVector
		StringTokenizer st = new StringTokenizer(ints);
		Vector intsVector = new Vector();
		int index = 0;
		int temp = 0;
		String tempString = new String();
		while (st.hasMoreTokens())
		{
			// check if there is a comma at the end
			tempString = st.nextToken();
			if (tempString.indexOf(",") != -1)
			{
				// remove the comma
				tempString = tempString.substring(0, tempString.length() - 1);
			}

			// parse the integers to Integers
			intsVector.add(Integer.valueOf(tempString));
			index++;
		}
		return intsVector;
	}

	/* Reads all coordinateIndexes and ignores '-1' in the data. This method
	 * does the same as readCoordinateIndexesInclusive, but leaves de '-1' out.
	 * It also fills the stripIndexCounts.
	 *
	 * @return a Vector contain the correct coordinateIndexes
	 */
	public Vector readCoordinateIndexes()
	{
		Vector coordinateIndexesInclusive = readIntsInclusive("coordIndex [");
		Vector coordinateIndexes = new Vector();
		Vector stripIndexCountsVector = new Vector();
		Enumeration enum = coordinateIndexesInclusive.elements();
		Integer currentIndex = new Integer(0);
		int count = 0;

		while (enum.hasMoreElements())
		{
			currentIndex = (Integer) enum.nextElement();

			// end of strip
			if (currentIndex.equals(new Integer(-1)))
			{
				stripIndexCountsVector.add(new Integer(count));
				count = 0;
			}
			else
			{
				coordinateIndexes.add(currentIndex);
				count++;
			}
		}
		// fill the stripIndexCounts
		Object[] array = stripIndexCountsVector.toArray();
		int[] stripIndexArray = new int[array.length];
		for (int i = 0; i < array.length; i++)
		{
			stripIndexArray[i] = ((Integer) array[i]).intValue();
		}
		stripIndexCounts = stripIndexArray;

		return coordinateIndexes;
	}

	/* Reads all colorIndexes and ignores '-1' in the data. This method
	 * uses the readIntsInclusive()
	 *
	 * @return a Vector contain the correct coordinateIndexes
	 */
	public Vector readColorIndexes()
	{
		Vector colorIndexesInclusive = readIntsInclusive("colorIndex [");
		Vector colorIndexes = new Vector();
		Enumeration enum = colorIndexesInclusive.elements();
		Integer currentIndex = new Integer(0);
		int count = 0;

		while (enum.hasMoreElements())
		{
			currentIndex = (Integer) enum.nextElement();

			// end of strip
			if (currentIndex.equals(new Integer(-1)))
			{
				count = 0;
			}
			else
			{
				colorIndexes.add(currentIndex);
				count++;
			}
		}

		return colorIndexes;
	}


	public Point3f[] getCoordinatesArray()
	{
		Object[] objectArray = coordinates.toArray();
		Point3f[] coordinatesArray = new Point3f[objectArray.length];

		for (int i = 0; i < objectArray.length; i++)
		{
			coordinatesArray[i] = (Point3f) objectArray[i];
		}
		return coordinatesArray;
	}

	public Color3f[] getColorsArray()
	{
		Object[] objectArray = colors.toArray();
		Color3f[] colorsArray = new Color3f[objectArray.length];
		Point3f point = new Point3f();
		float[] floatArray = new float[3];

		for (int i = 0; i < objectArray.length; i++)
		{
			point = (Point3f) objectArray[i];
			point.get(floatArray);
			colorsArray[i] = new Color3f(floatArray);
		}
		return colorsArray;
	}

	/**
	 * A method for reading floats out of the VRML file.
	 *
	 * @param searchString the text that proceeds the floats to be read
	 *
	 * @return a Vector containing all the floats in de part after
	 * the searchString
	 */
	private Vector readFloats(String searchString)
	{
		// search for searchString
		int start = VRMLString.indexOf(searchString);
		if (start != -1) start += searchString.length() + 1;
		else return null;
		int end = VRMLString.indexOf("]", start);

		// contains all colors in String format
		String string = VRMLString.substring(start, end);

		// process String to floats
		StringTokenizer st = new StringTokenizer(string);
		Vector numbers = new Vector();
		int indexNumbers = 0;
		String tempString = new String();
		while (st.hasMoreTokens())
		{
			tempString = st.nextToken();
			// after each third token follows a comma
			if ((indexNumbers + 1)%3 == 0)
			{
				// remove the comma
				tempString = tempString.substring(0, tempString.length() - 1);
			}
			// parse the date to Floats
			numbers.add(Float.valueOf(tempString));
			indexNumbers++;
		}
		return numbers;
	}

	public Vector readColors()
	{
		Vector colorNumbers = readFloats("color [");
		if (colorNumbers == null) return null;

		return readTriples(colorNumbers);
	}

	public int[] getCoordinateIndexesArray()
	{
		Object[] objectArray = coordinateIndexes.toArray();
		int[] coordinateIndexesArray = new int[objectArray.length];

		for (int i = 0; i < objectArray.length; i++)
		{
			coordinateIndexesArray[i] = ((Integer) objectArray[i]).intValue();
		}
		return coordinateIndexesArray;
	}

	public int[] getColorIndexesArray()
	{
		Object[] objectArray = colorIndexes.toArray();
		int[] colorIndexesArray = new int[objectArray.length];

		for (int i = 0; i < objectArray.length; i++)
		{
			colorIndexesArray[i] = ((Integer) objectArray[i]).intValue();
		}
		return colorIndexesArray;
	}
	
	/** Geeft de lijst van floats terug die in een string staat
	 * "0.10 0.13 0.1234"
	 * levert [0.10f, 0.13f, 0.1234]
	 */
	private float[] getSpaceSeperatedSequence(String str)
	{
		Vector vctFloats = new Vector();

		// process String to floats
		StringTokenizer st = new StringTokenizer(str);
		String strTemp;
		while (st.hasMoreTokens())
		{
			strTemp = st.nextToken();
			try	{	vctFloats.add(Float.valueOf(strTemp)); }
			catch (NumberFormatException nfe)	{ break; }
		}

			// vector omzetten naar een array
		float[] arrFloats = new float[vctFloats.size()];
		for (int i = 0; i < vctFloats.size(); i++)
		arrFloats[i] = ((Float) vctFloats.get(i)).floatValue();

		// array teruggeven
		return arrFloats;
	}
	
	public AxisAngle4f getRotation()
	{
		int iRotation = VRMLString.indexOf( "rotation" );
		// center komt altijd na rotation
		int iCenter = VRMLString.indexOf( "center" );
		
		if ((iRotation != -1) && (iCenter != -1) && (iRotation < iCenter))
		{
			iRotation += 9; // length(rotation)=8 (+1 space)
			float[] arrFloats = getSpaceSeperatedSequence(VRMLString.substring(iRotation,iCenter));
		
			if (arrFloats.length == 4){
				return new AxisAngle4f(arrFloats[0], arrFloats[1], arrFloats[2], arrFloats[3]);
			}
		}
		// in alle overige gevallen
		return new AxisAngle4f();
	}
	
	public Vector3f getCenter()
	{
		int iCenter = VRMLString.indexOf( "center" );
		
		if (iCenter != -1)
		{
			iCenter += 7;
			float[] arrFloats = getSpaceSeperatedSequence(VRMLString.substring(iCenter,VRMLString.length()));
			
			if (arrFloats.length == 3){
				return new Vector3f(arrFloats[0], arrFloats[1], arrFloats[2]);
			}
		}
		// in overige gevallen
		return new Vector3f();
	}
	
	public Vector3f getTranslation()
	{
		int iTranslation = VRMLString.indexOf( "translation" );
		int iRotation = VRMLString.indexOf( "rotation" );
		
		if ((iTranslation != -1) && (iRotation != -1) && (iTranslation < iRotation))
		{
			iTranslation += 12;
			float[] arrFloats = getSpaceSeperatedSequence(VRMLString.substring(iTranslation,iRotation));
			
			if (arrFloats.length == 3){
				return new Vector3f(arrFloats[0], arrFloats[1], arrFloats[2]);
			}
		}
		// in overige gevallen
		return new Vector3f();		
	}
	

	public static void main(String[] args)
	{
		String testString = "name \"skull\" {";
		testString += "point [ 0 1.708 -0.0435, 0 1.655 0.04322, 0 1.486 0.02335 ]";
		testString += "coordIndex [ 48, 87, 58, -1, 91, 92, 59, -1 ]";
		testString += "color [ 0.749 0.601 0.462, 0.1735 0.2602 0.749 ]";
		testString += "colorIndex [ 1, 1, 1, -1, 0, 0, 0, -1, 0, 0, 0 ]";
		testString += "translation 0 0.005382 0.008067\n";
		testString += "rotation -0.09024 0.994 -0.0624 1.216\n";
		testString += "center -0.217 0.811 -0.0338\n";		

		VRMLProcessor proc = new VRMLProcessor(testString);
		System.out.println("-" + proc.readName() + "-");

		Vector data = proc.readFloats("point [");
		System.out.println("coordinateNumbers: " + data);
		System.out.println("Coordinates: " + proc.readCoordinates());

		data = proc.readCoordinateIndexes();
		System.out.println("coordinateIndexes: " + data);

		int[] array = proc.stripIndexCounts;
		System.out.println("Inhoud StripIndexCounts:");
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i]);
		}
		System.out.println("");

		data = proc.readFloats("color [");
		System.out.println("colorNumbers: " + data);
		System.out.println("Colors: " + proc.readColors());

		proc.getColorsArray();

		data = proc.readColorIndexes();
		System.out.println("colorIndexes: " + data);

		System.out.print("Length of coordinateIndexes: ");
		System.out.println(proc.getCoordinateIndexesArray().length);
		System.out.print("Length of colorIndexes: ");
		System.out.println(proc.getColorIndexesArray().length);
		
		System.out.println("Translation: " + proc.getTranslation().toString());
		System.out.println("Center: " + proc.getCenter().toString());
		System.out.println("Rotation: " + proc.getRotation().toString());		
	}
}


