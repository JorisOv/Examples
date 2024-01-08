/****************************************************************\
Autheur: Joris Overzier
Klas: 		TIV1E
Datum: 		13 Maart 2005
Functie: 	dit deel test het aanmaken van klanten.
\****************************************************************/

public class Main {

  public static void main (String [ ] argv)
  {
    //3 klanten maken
    Klant k1 = new Klant ("Jan", "Hier 3", "Utrecht");
    Klant k2 = new Klant ("Piet", "Daar 5", "De Bilt");
    Klant k3 = new Klant ("Klaas", "Overkant 8", "Zeist");
    
    //functie aanroepen als test.
    k1.getRekening().stort(500);
    k1.getRekening().neemOp(100);
    k1.getRekening().neemOp(500);
    k1.getRekening().boekOver(150, k2.getRekening());
    k1.getRekening().boekOver(150, k3.getRekening());
    k1.getRekening().boekOver(500, k2.getRekening());
    k2.getRekening().boekOver(100, k3.getRekening());

    //output als test.
    System.out.println (k1.getBankAfschrift());
    System.out.println ("------------------------------");
    System.out.println (k2.getBankAfschrift());
    System.out.println ("------------------------------");
    System.out.println (k3.getBankAfschrift());
  }
}