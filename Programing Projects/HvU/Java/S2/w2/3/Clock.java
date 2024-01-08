//////////////////////////////////////////////////////////////
// FILE:    Clock.java
// Auteur:  Marten Wensink
// Datum:   8-11-2004
// Implementatie van de klasse Clock.
//
public class Clock {

   // Attributes:
   private int h, m, s;      // Hours, minutes and seconds
   private boolean showSec;  // Flag indicating if sec. has to be shown

   // Constructor. Constructs a Clock-object with the given time.
   public Clock (int hour, int min, int sec)
   {
      set (hour, min, sec);
   }

   // Methodes:
   public void set (int hour, int min, int sec)
   {
      // Reduce time to a 24 hours clock:
      h = hour % 24;
      m = min % 60;
      s = sec % 60;
   }

   public boolean isEerderDan(Clock t) {
      if(getHour() < t.getHour())
         return true;
      else
         if(getHour() == t.getHour() && getMin() < t.getMin())
            return true;
         else
            if(getHour() == t.getHour() && getMin() == t.getMin() && getSec() < t.getSec())
               return true;
            else
               return false;

   }

   public void setShowSec (boolean show)
   {
      showSec = show;
   }

   public int getHour ( )
   {
      return h;
   }

   public int getMin ( )
   {
      return m;
   }

   public int getSec ( )
   {
      return s;
   }

   // Advance the clock 1 second:
   public void tick ( )
   {  s = (s + 1) % 60;
      if (s == 0)
      {  m = (m + 1) % 60;
         if (m == 0)
            h = (h + 1) % 24;
      }
   }

   public String toString ( )
   {
      String timeStr = h + ":" + m;
      if (showSec)
         timeStr = timeStr + ":" + s;
      return timeStr;
   }
}
