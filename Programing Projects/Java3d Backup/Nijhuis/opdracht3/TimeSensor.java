package opdracht3;

import javax.media.j3d.Alpha;

public class TimeSensor {
  //1 seconde
  private final int DELTA_TIME = 1000;

  private int cycleInterval;
  private int startTime;
  private int stopTime;
  private boolean loop;

  public TimeSensor() {
  }

  /**
   * methode die het cylceInterval zet
   * @param cycleInterval int het cycleInterval
   */
  public void setCycleInterval(int cycleInterval){
    this.cycleInterval = cycleInterval;
  }

  /**
   * methode die de starttijd zet
   * @param startTime int de starttijd
   */
  public void setStartTime(int startTime){
    this.startTime = startTime;
  }

  /**
   * methode die de stoptijd zet
   * @param stopTime int de stoptijd
   */
  public void setStopTime(int stopTime){
    this.stopTime = stopTime;
  }

  /**
   * methode die de boolean loop zet
   * deze geeft aan of de timer steeds opnieuw moet 
   * beginnen
   * @param loop boolean de waarde van loop
   */
  public void setLoop(boolean loop){
    this.loop = loop;
  }

  /**
   * methode die de cycleInterval terug geeft
   * @return int de cycleInterval
   */
  public int getCycleInterval(){
    return this.cycleInterval;
  }

  /**
   * methode die de starttijd terug geeft
   * @return int de starttijd
   */
  public int getStartTime(){
    return this.startTime;
  }

  /**
   * methode die de stoptijd terug geeft
   * @return int de stoptijd
   */
  public int getStopTime(){
    return this.stopTime;
  }

  /**
   * methode die de loop waarde terug geeft
   * @return boolean is de loop waarde
   */
  public boolean getLoop(){
    return this.loop;
  }

  /**
   * methode die een alpha object aanmaakt
   * van deze timesensor
   * @return Alpha de gecreerde alpha
   */
  public Alpha createAlpha(){
    int count;

    if(loop) count = -1;
    else count = 1;
    Alpha alpha = new Alpha(count, cycleInterval *  DELTA_TIME);
    return alpha;
  }
}