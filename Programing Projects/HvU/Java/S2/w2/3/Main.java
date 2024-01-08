//////////////////////////////////////////////////////////////
// 
// Auteur:  Joris Overzier
// TIV1E
// 

public class Main {

  public static void main (String [ ] argv)
  {
    Clock t1 = new Clock(11, 30, 31);
    Clock t2 = new Clock(11, 30, 30);
    Clock t3 = new Clock(11, 30, 30);

    t1.setShowSec(true);
    t2.setShowSec(true);
    t3.setShowSec(true);

	System.out.println("Klok t1: " + t1.toString());
	System.out.println("Klok t2: " + t2.toString());
	System.out.println("Klok t3: " + t3.toString() + "\n");


    if(t1.isEerderDan(t2))
		System.out.println("Clock t1 is eerder dan Clock t2");
	else
		if(t2.isEerderDan(t1))
			System.out.println("Clock t2 is eerder dan Clock t1");
		else
			System.out.println("Clock t1 en Clock t2 zijn gelijk");

    if(t2.isEerderDan(t3))
		System.out.println("Clock t2 is eerder dan Clock t3");
	else
		if(t3.isEerderDan(t2))
			System.out.println("Clock t3 is eerder dan Clock t2");
		else
			System.out.println("Clock t2 en Clock t3 zijn gelijk");

    if(t1.isEerderDan(t3))
		System.out.println("Clock t1 is eerder dan Clock t3");
	else
		if(t3.isEerderDan(t1))
			System.out.println("Clock t3 is eerder dan Clock t1");
		else
			System.out.println("Clock t1 en Clock t3 zijn gelijk");


	System.out.println("");
  }
}
