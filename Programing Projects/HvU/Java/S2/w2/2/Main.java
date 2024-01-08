//////////////////////////////////////////////////////////////
// 
// Auteur:  Joris Overzier
// TIV1E
// 

public class Main {

  public static void main (String [ ] argv)
  {
    DobbelBeker d = new DobbelBeker(2);

    for(int i = 0; i < 10; i++) {
    	d.werp();
    	System.out.println (d);
	}
  }
}
