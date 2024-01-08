
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;

public class TrianglePyramid2 extends Shape3D {

	public TrianglePyramid2(float basesize, float height) {
  
    int     totalN = 18; 

		Color3f red    = new Color3f(1.0f, 0.0f, 0.0f);
		Color3f yellow = new Color3f(0.7f, 0.5f, 0.0f);
		Color3f blue   = new Color3f(0.0f, 0.0f, 1.0f);

    // hoekunpten van de basis:
    float hs = basesize/2.0f;
    Point3f p0 = new Point3f(hs, 0.0f, hs);
    Point3f p1 = new Point3f(hs, 0.0f, -hs);
    Point3f p2 = new Point3f(-hs, 0.0f, -hs);
    Point3f p3 = new Point3f(-hs, 0.0f, hs);
    Point3f p4 = new Point3f(0.0f, height, 0.0f);
    

    
    // definieer de coordinaten van de vier schuine vlakken:      

    Point3f[] coords = new Point3f[] {
      p0, p1, p4,
      p1, p2, p4, 
      p2, p3, p4,
      p3, p0, p4,
      p0, p2, p1,
      p0, p3, p2
      
    };
    
		Color3f colors[] = new Color3f[] {
		  red, red, red,
		  blue, blue, blue,
		  red, red, red,
		  blue, blue, blue,
		  yellow, yellow, yellow,
		  yellow, yellow, yellow		  
		  
		 } ;


    GeometryInfo gi = new GeometryInfo(GeometryInfo.TRIANGLE_ARRAY);
    gi.setCoordinates(coords);
		//gi.setCoordinateIndices(coordIndices);
		gi.setColors(colors);
		//gi.setColorIndices(colorIndices);

		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(gi);
		
		Stripifier st = new Stripifier();
		st.stripify(gi);
		
		setGeometry(gi.getGeometryArray());
	    Appearance app = new Appearance();				
	    Material mat = new Material();
	    mat.setSpecularColor(yellow);
	    mat.setDiffuseColor(blue);
	    mat.setLightingEnable(true);	    
	    app.setMaterial(mat);
	    setAppearance(app);
	    
		//TriangleArray triPyr = 
		  //new TriangleArray (totalN, TriangleArray.COORDINATES | TriangleArray.COLOR_3 );
		
    //triPyr.setCoordinates(0, coords);
		//triPyr.setColors(0,colors);
    //setGeometry(triPyr);
	} 
                                
}       
