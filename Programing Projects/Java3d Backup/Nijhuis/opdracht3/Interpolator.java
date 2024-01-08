package opdracht3;

import java.util.Vector;
import javax.vecmath.Quat4f;
import javax.vecmath.Point3f;
import javax.vecmath.AxisAngle4f;

public class Interpolator {
  public static final int ROTATION_INTERPOLATOR = 0;
  public static final int POSITION_INTERPOLATOR = 1;

  private int type;
  private Vector keys;
  private Vector values;

  /**
   * Constructor van interpolator
   * @param type int is het type van de interpolator:
   *        Rotation of position interpolator
   */
  public Interpolator(int type) {
    this.type = type;
    keys = new Vector();
    values = new Vector();
  }

  /**
   * voegt een key toe
   * @param key float een knot value
   */
  public void addKey(float key){
    keys.add(new Float(key));
  }

  /**
   * voegt waarde toe
   * @param value float [] een value, dit kan een point of een
   *         axisangle4f voorstellen
   */
  public void addValue(float [] value){
  	if(type == ROTATION_INTERPOLATOR){  	  
  	  float temp = value[0];  		
  	}
    values.add(value);
  }

  /**
   * geeft key op plaats index terug
   * @param index int de index
   * @return een key op plaats index
   */
  public float getKey(int index){
    return ((Float) keys.elementAt(index)).floatValue();
  }

  /**
   * geeft waarde op plaats index terug
   * @param index int de index
   * @return array op plaats index. Dit kan zowel een positie
   *         als een axisangle4f voorstellen
   */
  public float [] getValue(int index){
    return (float []) keys.elementAt(index);
  }

  /**
   * methode die alle knots in een array zet en deze vervolgens terug geeft
   * @return een array van knots
   */
  public float [] getKnots(){
    float [] knots = new float[values.size()];

    for(int i = 0; i<keys.size(); i++){
      knots[i] = ((Float) keys.elementAt(i)).floatValue();      
    }
    return knots;
  }

  /**
   * geeft alle waarden terug in de vorm van een Quat
   * hiertoe moet een AxisAngle4f eerst omgezet worden
   * naar een quat
   * @return een array van quats van de interpolatie   
   */
  public Quat4f [] getQuat4fs(){
    Quat4f [] quats = new Quat4f[values.size()];
    if(type != ROTATION_INTERPOLATOR){
      for(int i = 0; i<values.size(); i++){
        quats[i] = new Quat4f(0.0f, 0.0f, 0.0f, 0.0f);
      }
    }
    else {
    	Quat4f quat;
      for(int i = 0; i<values.size(); i++){
      	quat = new Quat4f();
      	quat.set(new AxisAngle4f((float [])values.elementAt(i)));        
        quats[i] = quat;
      }
    }
    return quats;
  }

  /**
   * geeft alle waarden terug in de vorm van points
   * @return een array van Point3f van de verschillende
   *         psoities van de interpolator
   */
  public Point3f [] getPositions(){
    Point3f [] points = new Point3f[values.size()];
    if(type != POSITION_INTERPOLATOR){
      for(int i = 0; i<values.size(); i++){
        points[i] = new Point3f(0.0f, 0.0f, 0.0f);
      }
    }
    else{
      for(int i = 0; i<values.size(); i++){
        points[i] = new Point3f((float []) values.elementAt(i));
      }
    }
    return points;
  }
} 