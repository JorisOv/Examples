package opdracht3;

import java.io.*;
import java.util.Vector;
import java.util.Hashtable;

public class InterpolatorsLoader{
  private final String DEF = "def";

  private TextFileBuffer tFBuffer;
  private Hashtable hTable;

  /**
   * Constructor van Interpolator
   * @param filename String is het bestandsnaam
   *        waar de interpolators staan
   */
  public InterpolatorsLoader(String filename){
    tFBuffer = new TextFileBuffer();
    hTable = new Hashtable();

    try{
      tFBuffer.read(filename);
    }
    catch(FileNotFoundException fnfe){
      System.out.println("Kan opgegeven bestand " + filename + " niet vinden");
      System.exit(0);
    }
    catch(IOException io){
      System.out.println(io);
      System.exit(0);
    }
  }

  /**
   * methode die een hashtable terug geeft met de
   * interpolators en timesensors die in een bestand zitten
   * @return HashTable de hashtable met interpolators en timesensors
   */
  public Hashtable getInterpolators(){
    //parsed alle waarden uit de string
    while(!tFBuffer.endOfFile()/*.getChar() != '\0'*/){
      whiteSpace();
      //def
      String definition = getString();
      if(!definition.toLowerCase().equals(DEF)){
        error();
      }
      whiteSpace();
      //naam
      String name = getString();      
      whiteSpace();

      //type
      String type = getString();
      type = type.toLowerCase();
      whiteSpace();

      //accolade
      if(tFBuffer.getChar() != '{') error();
      tFBuffer.nextPos();
      whiteSpace();

      if(type.equals("orientationinterpolator")){
        //stopt interpolator in hashtable
        hTable.put(name, getRotationInterpolator());
      }
      else if(type.equals("positioninterpolator")){
        hTable.put(name, getPositionInterpolator());
      }
      else if(type.equals("timesensor")){
        hTable.put(name, getTimeSensor());
      }
      else{
        error();
      }
      whiteSpace();
      if(tFBuffer.getChar() != '}') error();
      tFBuffer.nextPos();
      if(!tFBuffer.endOfFile()) whiteSpace();
      System.out.println("Module '" + name + "' loaded.");
    }    
    return hTable;
  }

  /**
   * methode die een RotationInterpolator uit een string parsed
   * @return Interpolator de gevonden interpolator
   */
  private Interpolator getRotationInterpolator(){
    Interpolator interpolator =
      new Interpolator(Interpolator.ROTATION_INTERPOLATOR);

    //haalt 'key' op
    if(!getString().toLowerCase().equals("key")) error();
    whiteSpace();

    //haalt '[' op
    if(tFBuffer.getChar() != '[') error();
    tFBuffer.nextPos();
    whiteSpace();

    //haalt array van getallen op
    while(tFBuffer.getChar() != ']'){
      interpolator.addKey(getFloat());
      whiteSpace();
      //haalt comma weg
      if(tFBuffer.getChar() == ','){
        tFBuffer.nextPos();
        whiteSpace();
      }
    }
    //haalt ']' weg
    tFBuffer.nextPos();
    whiteSpace();

    //haalt array met coordinaten op
    //haalt 'keyvalue' op
    if(!getString().toLowerCase().equals("keyvalue")) error();
    whiteSpace();

    //haalt '[' op
    if(tFBuffer.getChar() != '[') error();
    tFBuffer.nextPos();
    whiteSpace();

    //haalt tupels van getallen op
    while(tFBuffer.getChar() != ']'){
      interpolator.addValue(getFloatArray(4));
      whiteSpace();
      //haalt comma weg
      if(tFBuffer.getChar() == ','){
         tFBuffer.nextPos();
         whiteSpace();
      }
    }

     //haalt ']' weg
    tFBuffer.nextPos();
    whiteSpace();
    return interpolator;
  }

  /**
   * methode die een PositionInterpolator uit een String parsed
   * @return Interpolator de gevonden PositionInterpolator
   */
  private Interpolator getPositionInterpolator(){
    Interpolator interpolator =
      new Interpolator(Interpolator.POSITION_INTERPOLATOR);

    //haalt 'key' op
    if(!getString().toLowerCase().equals("key")) error();
    whiteSpace();

    //haalt '[' op
    if(tFBuffer.getChar() != '[') error();
    tFBuffer.nextPos();
    whiteSpace();

    //haalt array van getallen op
    while(tFBuffer.getChar() != ']'){
      interpolator.addKey(getFloat());
      whiteSpace();
      //haalt comma weg
      if(tFBuffer.getChar() == ','){
        tFBuffer.nextPos();
        whiteSpace();
      }
    }
    //haalt ']' weg
    tFBuffer.nextPos();
    whiteSpace();

    //haalt array met coordinaten op
    //haalt 'keyvalue' op
    if(!getString().toLowerCase().equals("keyvalue")) error();
    whiteSpace();

    //haalt '[' op
    if(tFBuffer.getChar() != '[') error();
    tFBuffer.nextPos();
    whiteSpace();

    //haalt tupels van getallen op
    while(tFBuffer.getChar() != ']'){
      interpolator.addValue(getFloatArray(3));
      whiteSpace();
      //haalt comma weg
      if(tFBuffer.getChar() == ','){
         tFBuffer.nextPos();
         whiteSpace();
      }
    }

     //haalt ']' weg
    tFBuffer.nextPos();
    whiteSpace();
    return interpolator;
  }


  /**
   * methode die een TimeSensor uit een String parsed
   * @return TimeSensor de gevonden Timesensor in een String
   */
  private TimeSensor getTimeSensor(){
    TimeSensor tSensor = new TimeSensor();
    for(int i = 0; i<4; i++){
      //haalt key-word op
      String name = getString();
      whiteSpace();
      //zoekt op key-words
      if(name.toLowerCase().equals("cycleinterval")){
        tSensor.setCycleInterval(getInt());
      }
      else if(name.toLowerCase().equals("starttime")){
        tSensor.setStartTime(getInt());
      }
      else if(name.toLowerCase().equals("stoptime")){
        tSensor.setStopTime(getInt());
      }
      else if(name.toLowerCase().equals("loop")){
        String bool = getString();
        if(bool.toLowerCase().equals("true"))
          tSensor.setLoop(true);
        else if(bool.toLowerCase().equals("false"))
          tSensor.setLoop(false);
        else error();
      }
      else error();
      whiteSpace();
    }
    return tSensor;
  }

  /**
   * whitespace zijn de karakters die een leegte vormen op het scherm
   * ze bestaan dus uit newline, carriage return, tab en spatie
   * whitespace = '\r' | '\n' | '\t' | ' '
                  whitespace
   * verwijdert de \r, \n, \t en spaties vanaf positie index in de buffer
   */
  private void whiteSpace(){
    char data = tFBuffer.getChar();
    while(data == ' ' || data == '\r' || data == '\n' || data == '\t'){
      data = tFBuffer.getNextChar();
    }
  }

  /**
   * een string is gelijk aan een serie met karakters waar geen whitespace
   * tussen zit
   * @return String de geparste string
   */
  private String getString(){
    StringBuffer sBuffer = new StringBuffer();
    //zoekt string op
    char data = tFBuffer.getChar();

    while(data != ' ' && data != '\r' && data != '\n' && data != '\t'){
      sBuffer.append(data);
      data = tFBuffer.getNextChar();
    }

    return sBuffer.toString();
  }

  /**
   * een float is een serie getallen gevolgt door eventueel een . en weer een serie
   * getallen
   * @return float de geparste float
   */
  private float getFloat(){
    float value = 0f;
    float afterPoint = 0f;
    int sign = 1;

    char data = tFBuffer.getChar();
    if(data == '-'){
      sign = -1;
      data = tFBuffer.getNextChar();
    }

    //haalt cijfers voor de comma op
    while (data != ' ' && data != '\r' && data != '\n' && data != '\t' &&
          data != '.' && data != ','){
      value *= 10;
      value += (int) (data - '0');
      data = tFBuffer.getNextChar();
    }
    //haalt comma gedeelt op
    if(data == '.'){
      data = tFBuffer.getNextChar();
      int factor = 1;
      while (data != ' ' && data != '\r' && data != '\n' && data != '\t' &&
             data != ','){
        factor *= 10;
        afterPoint += ((float) (data - '0'))/factor;
        data = tFBuffer.getNextChar();
      }
    }
    return sign*(value + afterPoint);
  }

  /**
   * methode die een int parsed
   * een int is een serie getallen achter elkaar
   * @return de gevonden integer
   */
  private int getInt(){
    int value = 0;
    int sign = 1;

    char data = tFBuffer.getChar();
    if(data == '-'){
      sign = -1;
      data = tFBuffer.getNextChar();
    }

    //haalt cijfers voor de comma op
    while (data != ' ' && data != '\r' && data != '\n' && data != '\t' &&
          data != '.' && data != ','){
      value *= 10;
      value += (int) (data - '0');
      data = tFBuffer.getNextChar();
    }
    return value;
  }

  /**
   * methode die een float array parsed uit een string
   * @return float [] de geparsde float array
   */
  private float [] getFloatArray(int arrayLength){
    float [] floats = new float[arrayLength];
    //haalt tupels op
    for(int i = 0; i<arrayLength; i++){
      floats[i] = getFloat();     
      whiteSpace();
    }    
    return floats;
  }

  /**
   * methode die een fout afbeeld
   * en vervolgens de applicatie sluit
   */
  private void error(){
    System.out.println("Ongeldig bestandsformaat, regel: " + tFBuffer.getIndex());
    //System.exit(0);
  }

  /**
   * methode die kijkt of een karakter een nummer is
   * @param value char het te controleren karakter
   * @return boolean geeft aan of karakter een nummer is
   */
  private boolean isNumber(char value){
    return ('0' <= value && value <= '9');
  }
}

