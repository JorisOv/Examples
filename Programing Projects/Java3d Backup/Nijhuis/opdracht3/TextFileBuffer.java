package opdracht3;

import java.io.*;

public class TextFileBuffer{
  //buffer van 1 MB
  private static final int MAXLENGTH = 1024 * 1024;

  //buffer waar karakters in komen te staan
  private byte [] buffer;
  //length van ingelezen bestand
  private int fileLength;
  //index van huidige karakter
  private int index;

  private FileInputStream fInput;
  private DataInputStream input;

  public TextFileBuffer() {   
  }

  /**
   * opent het bestand str
   * @param str String het bestandsnaam
   */
  public void read(String str) throws FileNotFoundException, IOException{
    File file = new File(str);
    fileLength = (int) file.length();    
    buffer = new byte[fileLength];

    //opent bestand
    fInput = new FileInputStream(str);
    input = new DataInputStream(fInput);

    //leest bestand
    input.read(buffer);

    //sluit bestand
    input.close();
    fInput.close();
  }

  /**
   * geeft karakter op huidige index weer
   * @return char het huidige karakter
   */
  public char getChar(){
    return (char) buffer[index];
  }

  /**
   * hoogt de index met 1 op
   */
  public void nextPos(){
    index++;
  }

  /**
   * verhoogt de index en geeft vervolgens het karakter op index terug
   * @return char is karakter op index
   */
  public char getNextChar(){
    return (char) buffer[++index];
  }

  /**
   * methode die aangeeft of het einde van het bestand bereikt is
   * @return boolean true indien einde van file
   */
  public boolean endOfFile(){
    return index == fileLength;
  }

  /**
   * methode die de index terug geeft
   * @return int de index
   */
  public int getIndex(){
    return index;
  }
}


