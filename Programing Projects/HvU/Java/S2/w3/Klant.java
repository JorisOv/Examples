/****************************************************************\
Autheur: Joris Overzier
Klas: 		TIV1E
Datum: 		13 Maart 2005
Functie: 	maakt nieuwe klant aan. Incl nieuwe rekening
\****************************************************************/

public class Klant extends Persoon{
	Rekening rekening;
	//aanmaken klant
	public Klant(String naam, String adres, String plaats) {
		super(naam,adres,plaats);
		rekening = new Rekening();
	}

	//weergave rekening als string
	public String getBankAfschrift() {
		return toString() + rekening;
	}

	//weergave rekening
	public Rekening getRekening() {
		return rekening;
	}
}