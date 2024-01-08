import java.io.*;
import javax.vecmath.*;
import java.util.Vector;

public class Erty {
	private char[] buffer = new char[80];
	private String readInput = new String("");
	private File qw;
	public FileReader myReader;
	public StreamTokenizer inputTokenizer;
	public boolean fileReady;
	
	// Variables
	Point3f[] pointArray;
	int[] indexArray;
	int[] stripCountArray;
	Vector3f translation;
	AxisAngle4f rotation;
	Point3f center;
	Color3f[] colorArray;
	int[] colorIndexArray;

	

	public Erty(String filename) {

		fileReady = false;

		qw = new File(filename);

		try{
			myReader = new FileReader(qw);
			inputTokenizer = new StreamTokenizer(myReader);
			setup();
			fileReady = true;
		}
		catch ( FileNotFoundException a ){
			System.out.println("File not Found");
			fileReady = false;
		}

	}

	private void setup()
 	{

		// comma's are "ordinary"

 		// EOL chars are insignificant in QUAD file
 		inputTokenizer.eolIsSignificant(false);

 		inputTokenizer.wordChars('A','z');
 		inputTokenizer.wordChars('{','}');
		inputTokenizer.wordChars(',',',');

 		// have StreamTokenizer parse numbers (makes double-precision)
 		inputTokenizer.parseNumbers();

 		// Comments begin with # to end of line
 		inputTokenizer.commentChar('#');

 		// Whitespace characters delineate words and numbers
 		// blanks, tabs, and newlines are whitespace in OOGL
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

	public String readFile() {
		Vector pointVector = new Vector();
		Vector indexVector = new Vector();
		Vector stripCountVector = new Vector();
		Vector3f myTranslation = new Vector3f();
		AxisAngle4f myRotation = new AxisAngle4f();
		Point3f myCenter = new Point3f();
		Vector colorVector = new Vector();
		Vector colorIndexVector = new Vector();
		
		Object[] tempArray;
		
		int type = 0;
		
		float x, y, z, angle;
		// if the type is 0, the values read are to be considered ints
		// anything else and the value is an float
		
		if (fileReady) {
			try {
				while(inputTokenizer.ttype != inputTokenizer.TT_EOF ) {
					inputTokenizer.nextToken();
					if ( inputTokenizer.ttype == inputTokenizer.TT_WORD) {
						if(inputTokenizer.sval.equals("point")	) {
							System.out.println(inputTokenizer.sval);
							getPoint3fArray(pointVector);
							System.out.println(pointVector.toString() );
						}
						else if(inputTokenizer.sval.equals("coordIndex") ) {
							System.out.println(inputTokenizer.sval);							
							getIndexArray(indexVector, stripCountVector);
							System.out.println(indexVector.toString() );	
							System.out.println("stripCountVector");
							System.out.println(stripCountVector.toString() );	
						}
						else if(inputTokenizer.sval.equals("translation") ) {
							System.out.println(inputTokenizer.sval);
							myTranslation = getTranslation();
							System.out.println(myTranslation.toString() );	
						}
						else if(inputTokenizer.sval.equals("rotation") ) {
							System.out.println(inputTokenizer.sval);
							myRotation = getRotation();
							System.out.println(myRotation.toString() );	
						}	
						else if(inputTokenizer.sval.equals("center") ) {
							System.out.println(inputTokenizer.sval);
							myCenter = getCenter();
							System.out.println(myCenter.toString() );	
						}
						else if(inputTokenizer.sval.equals("color") ) {
							System.out.println(inputTokenizer.sval);
							getColor3fArray(colorVector);
							System.out.println(colorVector.toString() );	
						}	
						else if(inputTokenizer.sval.equals("colorIndex") ) {
							System.out.println(inputTokenizer.sval);
							getColorIndexArray(colorIndexVector);
							System.out.println(colorIndexVector.toString() );	
						}	
							
					} 
					/*else if ( inputTokenizer.ttype == inputTokenizer.TT_NUMBER) {
						if (type == 0)
							System.out.println( (int) inputTokenizer.nval);
						else
							System.out.println( (float) inputTokenizer.nval);
					}
					else {
							System.out.println(inputTokenizer.toString());
					}
					*/

				}

			} catch (IOException a) {
				readInput = "IOException";
			}

		} else { readInput = "File is not ready"; }
	
		// ***** pointArray ******
		tempArray = pointVector.toArray();
		pointArray = new Point3f[pointVector.size()];
		for(int j = 0; j < pointVector.size(); j++) {
			pointArray[j] = (Point3f) tempArray[j];
		}
		// ****** indexArray ******
		indexArray = vectToIntArray(indexVector);
		// ****** stripCountArray****
		stripCountArray = vectToIntArray(stripCountVector);
		// ****** translation ******
		translation = myTranslation;
		// ****** rotation *******
		rotation = myRotation;
		// ******* center *******
		center = myCenter;
		// ******* colorArray ******
		tempArray = colorVector.toArray();
		colorArray = new Color3f[colorVector.size()];
		for(int j = 0; j < colorVector.size(); j++) {
			colorArray[j] = (Color3f) tempArray[j];
		}
		// ******* colorIndexArray ******
		colorIndexArray = vectToIntArray(colorIndexVector);

	

		return readInput;
	}


	public static void main(String[] args) {
		Erty blaat = new Erty(args[0]);
		
		if ( blaat.tryReady() ) {
			System.out.println( blaat.readFile() );
		}

	}


//*******************************************************************************************
//******************** Convenience functions ************************************************


	private void getPoint3fArray(Vector array) {
		float x, y, z;
		
		// We're right at the beginning of the point array
		// first token will have to be a '[', after that comma
		// sepparated point3f's follow.
		// put readed values into point3f, then add that point to the
		// vector. At the end the vector is returned as an array.
		try { 
			inputTokenizer.nextToken();
			if (inputTokenizer.sval.equals("[") ) {
				while( !(inputTokenizer.sval.equals("]")) ) {
					inputTokenizer.nextToken();
					x = (float) inputTokenizer.nval;
					inputTokenizer.nextToken();
					y = (float) inputTokenizer.nval;
					inputTokenizer.nextToken();
					z = (float) inputTokenizer.nval;
					
					array.add(new Point3f(x, y, z));
					
					inputTokenizer.nextToken();
				}
			}
		} catch (IOException a) {
			System.out.println("" + a);
		}
	}

	private void getIndexArray(Vector index, Vector strips) {
		int count = 0;
		// We're right at the beginning of the point array
		// first token will have to be a '[', after that comma
		// sepparated point3f's follow.
		// put readed values into point3f, then add that point to the
		// vector. At the end the vector is returned as an array.
		try { 
			inputTokenizer.nextToken();
			if (inputTokenizer.sval.equals("[") ) {
				
				while( !(inputTokenizer.sval.equals("]")) ) {
					inputTokenizer.nextToken();
					if ( inputTokenizer.nval != -1 ) {
						index.add( new Integer( (int) inputTokenizer.nval));
						count++;
					} 
					else { 
						strips.add( new Integer(count));
						count = 0;
					}
					// ignore the comma
					inputTokenizer.nextToken();
				}
			}
		} catch (IOException a) {
			System.out.println("" + a);
		}
	}
	
	private Vector3f getTranslation() {
		float x = 0, y = 0, z = 0;
		
		try {
			inputTokenizer.nextToken();
			x = (float) inputTokenizer.nval;
			inputTokenizer.nextToken();
			y = (float) inputTokenizer.nval;
			inputTokenizer.nextToken();
			z = (float) inputTokenizer.nval;
		} catch (IOException a) {
			System.out.println("" + a);
		}

		return new Vector3f(x, y, z);

	}
	
	private AxisAngle4f getRotation() {
		float x = 0, y = 0, z = 0, angle = 0;
		
		try {
			inputTokenizer.nextToken();
			x = (float) inputTokenizer.nval;
			inputTokenizer.nextToken();
			y = (float) inputTokenizer.nval;
			inputTokenizer.nextToken();
			z = (float) inputTokenizer.nval;
			inputTokenizer.nextToken();
			angle = (float) inputTokenizer.nval;
		} catch (IOException a) {
			System.out.println("" + a);
		}

		return new AxisAngle4f(x, y, z, angle);	
	}
	
	private Point3f getCenter() {
		float x = 0, y = 0, z = 0;
		
		try {
			inputTokenizer.nextToken();
			x = (float) inputTokenizer.nval;
			inputTokenizer.nextToken();
			y = (float) inputTokenizer.nval;
			inputTokenizer.nextToken();
			z = (float) inputTokenizer.nval;
		} catch (IOException a) {
			System.out.println("" + a);
		}

		return new Point3f(x, y, z);
	}

	private void getColor3fArray(Vector array) {
		float x, y, z;
		
		// We're right at the beginning of the point array
		// first token will have to be a '[', after that comma
		// sepparated point3f's follow.
		// put readed values into point3f, then add that point to the
		// vector. At the end the vector is returned as an array.
		try { 
			inputTokenizer.nextToken();
			if (inputTokenizer.sval.equals("[") ) {
				while( !(inputTokenizer.sval.equals("]")) ) {
					inputTokenizer.nextToken();
					x = (float) inputTokenizer.nval;
					inputTokenizer.nextToken();
					y = (float) inputTokenizer.nval;
					inputTokenizer.nextToken();
					z = (float) inputTokenizer.nval;
					
					array.add(new Color3f(x, y, z));
					
					inputTokenizer.nextToken();
				}
			}
		} catch (IOException a) {
			System.out.println("" + a);
		}
	}
	 
	private void getColorIndexArray(Vector index) {
		// We're right at the beginning of the point array
		// first token will have to be a '[', after that comma
		// separated point3f's follow.
		// put readed values into point3f, then add that point to the
		// vector. At the end the vector is returned as an array.
		try { 
			inputTokenizer.nextToken();
			if (inputTokenizer.sval.equals("[") ) {
				
				while( !(inputTokenizer.sval.equals("]")) ) {
					inputTokenizer.nextToken();
					if ( inputTokenizer.nval != -1 ) {
						index.add( new Integer( (int) inputTokenizer.nval));
					}
					// ignore the comma
					inputTokenizer.nextToken();
				}
			}
		} catch (IOException a) {
			System.out.println("" + a);
		}
	}
	
	private int[] vectToIntArray(Vector vect) {
		int[] array = new int[vect.size()];
		Object[] vectArray = vect.toArray();
		
		for(int i = 0; i < vect.size(); i++) {
			array[i] = ( (Integer) vectArray[i]).intValue();
		}
		
		return array;
	}
			
		
}	