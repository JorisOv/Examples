import java.io.*;
import java.util.Vector;
import java.util.Hashtable;
import java.util.Enumeration;
import javax.vecmath.Quat4f;
import javax.vecmath.Point3f;
import javax.vecmath.AxisAngle4f;
import javax.media.j3d.*;

public class RotPathInterpolatorReader {
	private File qw;
	private FileReader myReader;
	private StreamTokenizer	inputTokenizer;
	public boolean fileReady;

	// table containing RotationInterpolators
	// There is one special entry for the "HumanoidRoot", because that is a "rotPosPathInterpolator"
	private Hashtable riTable = new Hashtable(17);
	private Alpha generalAlpha;

	float[] knotsArray = new float[1];

	Quat4f[] quatsArray;
	Point3f[] posArray;

	BoundingSphere bounds;



	public RotPathInterpolatorReader(String filename, BoundingSphere renderBounds) {
		fileReady = false;
		qw = new File(filename);
		bounds = renderBounds;

		try{
			myReader = new FileReader(qw);
			inputTokenizer = new StreamTokenizer(myReader);
			tokenizerSetup();
			fileReady = true;
		}
		catch ( FileNotFoundException a ){
			System.out.println("File not Found");
			fileReady = false;
		}

		if(tryReady())
			readHashes();
		else
			System.out.println("Error while accessing file");

	}


	public static void main(String[] args) {
	      BoundingSphere bounds = new BoundingSphere(new javax.vecmath.Point3d(), 1000.0);
		RotPathInterpolatorReader blaat = new RotPathInterpolatorReader(args[0], bounds);

		System.out.println( blaat.getTable().toString());

	}

	public Hashtable getTable() {
		return riTable;
	}



	private void tokenizerSetup() {

		// comma's are "ordinary"

		// EOL chars are insignificant in VRML file
		inputTokenizer.eolIsSignificant(false);

		inputTokenizer.wordChars('A','z');
		inputTokenizer.wordChars('{','}');
		inputTokenizer.wordChars(',',',');

		// have StreamTokenizer parse numbers (makes double-precision)
		inputTokenizer.parseNumbers();

		// Comments begin with # to end of line
		inputTokenizer.commentChar('#');

		// Whitespace characters delineate words and numbers
		// blanks, tabs, and newlines are whitespace in	OOGL
		inputTokenizer.whitespaceChars('\t', '\r'); // ht, lf, ff, vt, cr
		inputTokenizer.whitespaceChars(' ', ' '); // space
	} // End of setup

	public boolean tryReady() {

		if (fileReady) {
			try {
				if (! myReader.ready() ) {
					//return();
					System.out.println("Er ging iets niet goed");
					fileReady = false;
				}

			}
			catch ( IOException a ){
				System.out.println("IOException while reading file");
				fileReady = false;
			}

		}

		return fileReady;

	}


	private void readHashes() {

		String hashKey;

		Transform3D dummyAxis = new Transform3D();
		TransformGroup dummyGroup = new TransformGroup();
		Alpha dummyAlpha = new Alpha();

		RotationPathInterpolator tempRPI;
		RotPosPathInterpolator tempRPPI;


		int subStringLength = "RotInterp_BasicWalk".length();

		if (fileReady) {
			try {
				while(inputTokenizer.ttype != inputTokenizer.TT_EOF ) {
					inputTokenizer.nextToken();
					if ( inputTokenizer.ttype == inputTokenizer.TT_WORD) {
						if(inputTokenizer.sval.equals("DEF")	) {
							inputTokenizer.nextToken();
							hashKey = inputTokenizer.sval;
							if (hashKey.startsWith("whole_body")) {
								// do something special
								hashKey = "HumanoidRoot";
								inputTokenizer.nextToken();
								if(inputTokenizer.sval.equals("PositionInterpolator")){
									int t = getKnots();

									// fake quats
									quatsArray = new Quat4f[t];
									for ( int q = 0; q < t; q++) {
										quatsArray[q] = new Quat4f(0.0f, 0.0f, 1.0f, 0.0f);
									}

									posArray = getPos();

									// put the things into the tempRPI
									tempRPPI = new RotPosPathInterpolator(dummyAlpha, dummyGroup, dummyAxis, knotsArray, quatsArray, posArray);
									tempRPPI.setSchedulingBounds(bounds);
									riTable.put(hashKey, tempRPPI);
								}
							}
							else if (hashKey.equals("Walk_Time")) {
								//create alpha object
								generalAlpha = getAlpha();
							}
							else {
								hashKey = hashKey.substring(0, hashKey.length() - subStringLength);
								if(hashKey.equals("lower_body"))
									hashKey = "sacroiliac";
								if(hashKey.equals("upper_body"))
									hashKey = "vl1";
								if(hashKey.equals("head"))
									hashKey = "skullbase";
								if(hashKey.equals("neck"))
									hashKey = "vc4";

								getKnots();
								quatsArray = getQuats();

								// put the things into the tempRPI
								tempRPI = new RotationPathInterpolator(dummyAlpha, dummyGroup, dummyAxis, knotsArray, quatsArray);
								tempRPI.setSchedulingBounds(bounds);
								riTable.put(hashKey, tempRPI);
							}
						}
					}
				}
			} catch (IOException a)	{
				System.out.println(a.toString());
			}

		} else { System.out.println("File is not ready"); }

		applyAlhpa();

	}

	private Alpha getAlpha() {
		Alpha readAlpha = new Alpha(-1, (long) 1);
		long time;

		try {
			inputTokenizer.nextToken();
			while(  !inputTokenizer.sval.equals("cycleInterval") ) {
				inputTokenizer.nextToken();
			}
			inputTokenizer.nextToken();
			time = (long) inputTokenizer.nval * 1000;
			readAlpha.setIncreasingAlphaDuration(time);

		} catch (IOException a)	{
			System.out.println("" +	a);
		}

		return readAlpha;
	}

	private int getKnots() {

		Vector knotsVector = new Vector();

		try {
			inputTokenizer.nextToken();
			while(  !inputTokenizer.sval.equals("key") ) {
				inputTokenizer.nextToken();
			}
			inputTokenizer.nextToken();
			if (inputTokenizer.sval.equals("[")) {
				while(!inputTokenizer.sval.equals("]")) {
					inputTokenizer.nextToken();
					knotsVector.add( new Float(inputTokenizer.nval) );
					inputTokenizer.nextToken();
				}
			}

		} catch (IOException a)	{
			System.out.println("" +	a);
		}

		knotsArray = vectToFloatArray(knotsVector);

		System.out.println(knotsVector.toString());

		return knotsVector.size();
	}


	private Point3f[] getPos() {
		Vector posVector = new Vector();
		float x, y, z;

		try {
			inputTokenizer.nextToken();
			while(  !inputTokenizer.sval.equals("keyValue") ) {
				inputTokenizer.nextToken();
			}
			inputTokenizer.nextToken();
			if (inputTokenizer.sval.equals("[")) {
				while(!inputTokenizer.sval.equals("]")) {
					inputTokenizer.nextToken();
					x = (float)	inputTokenizer.nval;
					inputTokenizer.nextToken();
					y = (float)	inputTokenizer.nval;
					inputTokenizer.nextToken();
					z = (float)	inputTokenizer.nval;

					posVector.add(new Point3f(x, y, z));

					inputTokenizer.nextToken();

				}
			}

		} catch (IOException a)	{
			System.out.println("" +	a);
		}

		Point3f[] posArray = new Point3f[posVector.size()];
		Object[] tempArray = posVector.toArray();

		for(int j =	0; j < posVector.size(); j++) {
			posArray[j] = (Point3f) tempArray[j];
		}


		return posArray;

	}

	private Quat4f[] getQuats() {
		Vector quatsVector = new Vector();
		Quat4f quat;
		AxisAngle4f axis;
		float x, y, z, angle;

		try {
			inputTokenizer.nextToken();
			while(  !inputTokenizer.sval.equals("keyValue") ) {
				inputTokenizer.nextToken();
			}
			inputTokenizer.nextToken();
			if (inputTokenizer.sval.equals("[")) {
				while(!inputTokenizer.sval.equals("]")) {
					inputTokenizer.nextToken();
					x = (float)	inputTokenizer.nval;
					inputTokenizer.nextToken();
					y = (float)	inputTokenizer.nval;
					inputTokenizer.nextToken();
					z = (float)	inputTokenizer.nval;
					inputTokenizer.nextToken();
					angle = (float)	inputTokenizer.nval;

					axis = new AxisAngle4f(x, y, z, angle);
					quat = new Quat4f();
					quat.set(axis);

					quatsVector.add(quat);

					inputTokenizer.nextToken();

				}
			}

		} catch (IOException a)	{
			System.out.println("" +	a);
		}

		Quat4f[] quatArray = new Quat4f[quatsVector.size()];
		Object[] tempArray = quatsVector.toArray();

		for(int j =	0; j < quatsVector.size(); j++) {
			quatArray[j] = (Quat4f) tempArray[j];
		}


		return quatArray;

	}


	private void applyAlhpa() {
		Enumeration enum = riTable.keys();
		String key;
		RotationPathInterpolator readRPI;

		while(enum.hasMoreElements()) {
			key = (String) enum.nextElement();
			if (!key.equals("HumanoidRoot") ){
				((RotationPathInterpolator) riTable.get(key)).setAlpha(generalAlpha);
			}
			else if(key.equals("HumanoidRoot")){
				((RotPosPathInterpolator) riTable.get(key)).setAlpha(generalAlpha);
			}
		}

	}


	private float[] vectToFloatArray(Vector vect)	{
		float[]	array	= new	float[vect.size()];
		Object[] vectArray = vect.toArray();

		for(int i =	0; i < vect.size(); i++) {
			array[i] = ( (Float) vectArray[i]).floatValue();
		}

		return array;
	}


}	