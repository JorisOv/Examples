import java.io.*;
import javax.vecmath.*;
import java.util.Vector;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.*;
import java.util.Hashtable;



  public class LimbCreator extends Shape3D {

	// File stuff
	private File qw;
	private FileReader myReader;
	private StreamTokenizer	inputTokenizer;
	public boolean fileReady;

	// Variables of the Geometry
	private Point3f[]	pointArray;
	private int[] indexArray;
	private int[] stripCountArray;
	private boolean colorsRead = false;
	private Color3f[]	colorArray;
	private int[] colorIndexArray;
	public GeometryInfo geometry;
	// Variables for the Segment
	public Vector3f translation =	new Vector3f(0.0f,0.0f,0.0f);
	public AxisAngle4f rotation =	new AxisAngle4f(0.0f,0.0f,0.0f,0.0f);
	public Vector3f center = new Vector3f(0.0f,0.0f,0.0f);

	// Color stuff: one "diffuse color" and one Hashtable to look them in up and to update
	private Color3f diffuseColor3f = new Color3f(1.0f, 1.0f, 1.0f);
	private Hashtable refColors;



	LimbCreator(String filename, Hashtable referenceColors) {

		// let's set up the reference color table
		refColors = referenceColors;

		// set up the acces to the file, initializing the FileReader and Streamtokenizer
		fileReady =	false;
		qw = new File(filename);

		System.out.print(filename + " ");

		try{
			myReader = new FileReader(qw);
			inputTokenizer = new StreamTokenizer(myReader);
			tokenizerSetup();
			fileReady =	true;
		}
		catch	( FileNotFoundException	a ){
			System.out.println("File not Found");
			fileReady =	false;
		}

		// if	final	ready	check	passes, we're ready to set up	the geometry
		if(tryReady()) {
			this.setGeometry(createGeometry().getGeometryArray());
			if (!colorsRead)
				this.setAppearance(createAppearance());
		}
	}

	private GeometryInfo createGeometry() {
		Vector pointVector = new Vector();
		Vector indexVector = new Vector();
		Vector stripCountVector	= new	Vector();
		Vector3f myTranslation = new Vector3f(0.0f,0.0f,0.0f);
		AxisAngle4f	myRotation = new AxisAngle4f(0.0f,0.0f,0.0f,0.0f);
		Vector3f myCenter	= new	Vector3f(0.0f,0.0f,0.0f);
		Vector colorVector = new Vector();
		Vector colorIndexVector	= new	Vector();

		Object[] tempArray;

		// read the	file,	filling the	right	variables

		// begin reading the file

		if (fileReady) {
			try {
				while(inputTokenizer.ttype !=	inputTokenizer.TT_EOF )	{
					inputTokenizer.nextToken();
					if ( inputTokenizer.ttype == inputTokenizer.TT_WORD) {
						if(inputTokenizer.sval.equals("point")	) {
							System.out.print(inputTokenizer.sval + " ");
							if(pointVector.size() == 0)
								getPoint3fVector(pointVector);
							//System.out.println(pointVector.toString()	);
						}
						else if(inputTokenizer.sval.equals("coordIndex") ) {
							System.out.print(inputTokenizer.sval + " ");
							if(indexVector.size() == 0)
								getIndexVectors(indexVector, stripCountVector);
							//System.out.println(indexVector.toString()	);
							//System.out.println("stripCountVector");
							//System.out.println(stripCountVector.toString() );
						}
						else if(inputTokenizer.sval.equals("translation") ) {
							System.out.print(inputTokenizer.sval + " ");
							myTranslation = getFileTranslation();
							//System.out.println(myTranslation.toString() );
						}
						else if(inputTokenizer.sval.equals("rotation") ) {
							System.out.print(inputTokenizer.sval + " ");
							myRotation = getFileRotation();
							//System.out.println(myRotation.toString() );
						}
						else if(inputTokenizer.sval.equals("center") ) {
							System.out.print(inputTokenizer.sval + " ");
							myCenter = getFileCenter();
							//System.out.println(myCenter.toString() );
						}
						else if(inputTokenizer.sval.equals("color") ) {
							System.out.print(inputTokenizer.sval + " ");
							colorsRead = true;
							getColor3fVector(colorVector);
							//System.out.println(colorVector.toString()	);
						}
						else if(inputTokenizer.sval.equals("colorIndex") ) {
							System.out.print(inputTokenizer.sval + " ");
							getColorIndexVector(colorIndexVector);
							//System.out.println(colorIndexVector.toString() );
						}
						else if(inputTokenizer.sval.equals("material") ) {
							System.out.print(inputTokenizer.sval + " ");
							diffuseColor3f = getMaterialColor();
						}

					}
				}

			} catch (IOException a)	{
				System.out.println(a.toString() );
			}

		} else { System.out.println("File is not ready"); }

		System.out.println("");
	/**
	 *  Because	Vectors only accept Objects, we have put some of the stuff into "Integers"
	 *  Now for	the creation of the GeometryInfo object, we need to have it	transformed	into
	 *  arrays ( the ones with "[]" ). Some functions for	this have also been added.
	 *  tempArray is an Object[] in which the	things are temporarily stored. Direct casting to
	 *  (for instance) a Point3f[] doesn't work (allignment/reservated space differences?)
	**/

		// ***** pointArray ******
		tempArray =	pointVector.toArray();
		pointArray = new Point3f[pointVector.size()];
		for(int j =	0; j < pointVector.size(); j++) {
			pointArray[j] = (Point3f) tempArray[j];
		}
		// ****** indexArray ******
		indexArray = vectToIntArray(indexVector);
		// ****** stripCountArray****
		stripCountArray =	vectToIntArray(stripCountVector);
		// ****** translation ******
		translation	= myTranslation;
		// ****** rotation *******
		rotation = myRotation;
		// ******* center	*******
		center = myCenter;
		// ******* colorArray ******
		tempArray =	colorVector.toArray();
		colorArray = new Color3f[colorVector.size()];
		for(int j =	0; j < colorVector.size(); j++) {
			colorArray[j] = (Color3f) tempArray[j];
		}
		// ******* colorIndexArray ******
		colorIndexArray =	vectToIntArray(colorIndexVector);

	// -.-.-.-.-.- Not every variable has to have a	right	value... check these before giving them
	// -.-.-.-.-.- to	the GeometryInfo (?)

		// create the GeometryInfo object, and give it the variables
		geometry = new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
		geometry.setCoordinates(pointArray);
		geometry.setCoordinateIndices(indexArray);
		geometry.setStripCounts(stripCountArray);
		if (colorVector.size() > 0)
			geometry.setColors(colorArray);
		if (colorIndexVector.size() > 0)
			geometry.setColorIndices(colorIndexArray);
		geometry.recomputeIndices();

		Triangulator tr =	new Triangulator();
		tr.triangulate(geometry);
		geometry.recomputeIndices();

		NormalGenerator	ng = new NormalGenerator();
		ng.generateNormals(geometry);
		geometry.recomputeIndices();

		Stripifier st =	new Stripifier();
		st.stripify(geometry);
		geometry.recomputeIndices();


		// !!! Do we need	to pass it the color info here, or do we need to give	it
		// an	appearance instead (if no color is provided) !!!

		return geometry;
	}

	private Appearance createAppearance() {
		Appearance appear	= new	Appearance();

      	Material diffMat = new Material();
      	diffMat.setEmissiveColor(diffuseColor3f);
      	appear.setMaterial(diffMat);

		return appear;
	}

	public boolean tryReady() {

		if (fileReady) {
			try {
				if (!	myReader.ready() ) {
					//return();
					System.out.println("Er ging iets niet goed");
					fileReady =	false;
				}

			}
			catch	( IOException a ){
				System.out.println("IOException while reading file");
				fileReady =	false;
			}

		}

		return fileReady;

	}

	private void tokenizerSetup()	{

		// comma's are "ordinary"

		// EOL chars are insignificant in VRML file
		inputTokenizer.eolIsSignificant(false);

		inputTokenizer.wordChars('A','z');
		inputTokenizer.wordChars('{','}');
		inputTokenizer.wordChars(',',',');

		// have StreamTokenizer	parse	numbers (makes double-precision)
		inputTokenizer.parseNumbers();

		// Comments	begin	with # to end of line
		inputTokenizer.commentChar('#');

		// Whitespace characters delineate words and numbers
		// blanks, tabs, and newlines	are whitespace in	OOGL
		inputTokenizer.whitespaceChars('\t', '\r'); // ht, lf, ff, vt, cr
		inputTokenizer.whitespaceChars(' ',	' ');	// space
	} // End of	setup




//*******************************************************************************************
//******************** Convenience functions ************************************************


	private void getPoint3fVector(Vector array) {
		float	x, y,	z;

		// We're right at	the beginning of the point array
		// first token will have to be a '[', after that comma
		// sepparated point3f's	follow.
		// put readed values into point3f, then add that point to the
		// vector. At the	end the vector is	returned as	an array.
		try {
			inputTokenizer.nextToken();
			if (inputTokenizer.sval.equals("[")	) {
				while( !(inputTokenizer.sval.equals("]"))	) {
					inputTokenizer.nextToken();
					x = (float)	inputTokenizer.nval;
					inputTokenizer.nextToken();
					y = (float)	inputTokenizer.nval;
					inputTokenizer.nextToken();
					z = (float)	inputTokenizer.nval;

					array.add(new Point3f(x, y, z));

					inputTokenizer.nextToken();
				}
			}
		} catch (IOException a)	{
			System.out.println("" +	a);
		}
	}

	private void getIndexVectors(Vector	index, Vector strips) {
		int count =	0;
		// We're right at	the beginning of the point array
		// first token will have to be a '[', after that comma
		// sepparated point3f's	follow.
		// put readed values into point3f, then add that point to the
		// vector. At the	end the vector is	returned as	an array.
		try {
			inputTokenizer.nextToken();
			if (inputTokenizer.sval.equals("[")	) {

				while( !(inputTokenizer.sval.equals("]"))	) {
					inputTokenizer.nextToken();
					if ( inputTokenizer.nval != -1 ) {
						index.add( new Integer(	(int)	inputTokenizer.nval));
						count++;
					}
					else {
						strips.add(	new Integer(count));
						count	= 0;
					}
					// ignore the comma
					inputTokenizer.nextToken();
				}
			}
		} catch (IOException a)	{
			System.out.println("" +	a);
		}
	}

	private Vector3f getFileTranslation() {
		float	x = 0, y = 0, z =	0;

		try {
			inputTokenizer.nextToken();
			x = (float)	inputTokenizer.nval;
			inputTokenizer.nextToken();
			y = (float)	inputTokenizer.nval;
			inputTokenizer.nextToken();
			z = (float)	inputTokenizer.nval;
		} catch (IOException a)	{
			System.out.println("" +	a);
		}

		return new Vector3f(x, y, z);

	}

	private AxisAngle4f getFileRotation() {
		float	x = 0, y = 0, z =	0, angle = 0;

		try {
			inputTokenizer.nextToken();
			x = (float)	inputTokenizer.nval;
			inputTokenizer.nextToken();
			y = (float)	inputTokenizer.nval;
			inputTokenizer.nextToken();
			z = (float)	inputTokenizer.nval;
			inputTokenizer.nextToken();
			angle	= (float) inputTokenizer.nval;
		} catch (IOException a)	{
			System.out.println("" +	a);
		}

		return new AxisAngle4f(x, y, z, angle);
	}

	private Vector3f getFileCenter() {
		float	x = 0, y = 0, z =	0;

		try {
			inputTokenizer.nextToken();
			x = (float)	inputTokenizer.nval;
			inputTokenizer.nextToken();
			y = (float)	inputTokenizer.nval;
			inputTokenizer.nextToken();
			z = (float)	inputTokenizer.nval;
		} catch (IOException a)	{
			System.out.println("" +	a);
		}

		return new Vector3f(x, y, z);
	}

	private void getColor3fVector(Vector array) {
		float	x, y,	z;

		// We're right at	the beginning of the point array
		// first token will have to be a '[', after that comma
		// sepparated point3f's	follow.
		// put readed values into point3f, then add that point to the
		// vector. At the	end the vector is	returned as	an array.
		try {
			inputTokenizer.nextToken();
			if (inputTokenizer.sval.equals("[")	) {
				while( !(inputTokenizer.sval.equals("]"))	) {
					inputTokenizer.nextToken();
					x = (float)	inputTokenizer.nval;
					inputTokenizer.nextToken();
					y = (float)	inputTokenizer.nval;
					inputTokenizer.nextToken();
					z = (float)	inputTokenizer.nval;

					array.add(new Color3f(x, y, z));

					inputTokenizer.nextToken();
				}
			}
		} catch (IOException a)	{
			System.out.println("" +	a);
		}
	}

	private void getColorIndexVector(Vector index) {
		// We're right at	the beginning of the point array
		// first token will have to be a '[', after that comma
		// separated point3f's follow.
		// put readed values into point3f, then add that point to the
		// vector. At the	end the vector is	returned as	an array.
		try {
			inputTokenizer.nextToken();
			if (inputTokenizer.sval.equals("[")	) {

				while( !(inputTokenizer.sval.equals("]"))	) {
					inputTokenizer.nextToken();
					if ( inputTokenizer.nval != -1 ) {
						index.add( new Integer(	(int)	inputTokenizer.nval));
					}
					// ignore the comma
					inputTokenizer.nextToken();
				}
			}
		} catch (IOException a)	{
			System.out.println("" +	a);
		}
	}


	private Color3f getMaterialColor() {
		String temp;
		float x,y,z;

		try {
			inputTokenizer.nextToken();
			System.out.print(inputTokenizer.sval + " ");
			if (inputTokenizer.sval.equals("DEF")) {
				inputTokenizer.nextToken();
				temp = inputTokenizer.sval;
				while( inputTokenizer.ttype != inputTokenizer.TT_WORD || !inputTokenizer.sval.equals("diffuseColor") ) {
					inputTokenizer.nextToken();
				}
				inputTokenizer.nextToken();
				x = (float) inputTokenizer.nval;
				inputTokenizer.nextToken();
				y = (float) inputTokenizer.nval;
				inputTokenizer.nextToken();
				z = (float) inputTokenizer.nval;

				Color3f result = new Color3f(x,y,z);
				refColors.put(temp, result);
				return result;
			}
			else if (inputTokenizer.sval.equals("USE")) {
				inputTokenizer.nextToken();
				temp = inputTokenizer.sval;
				return (Color3f) refColors.get(temp);
			}
		} catch (IOException a)	{
			System.out.println("" +	a);
		}
		return diffuseColor3f;

	}




	private int[] vectToIntArray(Vector	vect)	{
		int[]	array	= new	int[vect.size()];
		Object[] vectArray = vect.toArray();

		for(int i =	0; i < vect.size(); i++) {
			array[i] = ( (Integer) vectArray[i]).intValue();
		}

		return array;
	}

	/*******************************useful functions for SegmentAdapter****************************************/

	public Vector3f getCenter(){
			return center;
	}

	public AxisAngle4f getRotation(){
			return rotation;
	}

	public Vector3f getTranslation(){
			return translation;
	}




}