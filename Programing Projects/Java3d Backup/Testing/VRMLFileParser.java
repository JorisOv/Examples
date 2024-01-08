import java.io.*;

class VRMLFileParser extends StreamTokenizer {

 	// setup
 	// Sets up StreamTokenizer for reading OOGL file formats.
 	void setup()
 	{
 		resetSyntax();

 		// EOL chars are insignificant in QUAD file
 		eolIsSignificant(false);

 		wordChars('A','z');

 		// have StreamTokenizer parse numbers (makes double-precision)
 		parseNumbers();

 		// Comments begin with # to end of line
 		commentChar('#');

 		// Whitespace characters delineate words and numbers
 		// blanks, tabs, and newlines are whitespace in OOGL
 		whitespaceChars('\t', '\r'); // ht, lf, ff, vt, cr
 		whitespaceChars(' ', ' '); // space
 	} // End of setup

 	/* getToken
 	* Gets the next token from the stream. Puts one of the four
 	* constants (TT_WORD, TT_NUMBER, TT_EOL, or TT_EOF) and the token
 	* value into ttype token object.
        * The value of this method is in the catching of exceptions in this
        * central location.
        */
        boolean getToken() {
  	        int t;
        	boolean done = false;
       
        	try {
       			t = nextToken();
       		}
       		catch (IOException e) {
       			System.err.println("IO error on line " + lineno() + ": " + e.getMessage());
       			return false;
       		}
       
        	return true;
        } // End of getToken
       
        // VRMLFileParser constructor
        VRMLFileParser(Reader r) {
        	super(r);
        	setup();
        } // end of QuadFileParser
 } // End of file QuadFileParser.java