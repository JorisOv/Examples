/****************************************************************\
Autheur: Joris Overzier
Klas: 		TIV1E
Datum: 		13 Maart 2005
Functie: 	aanmaken van persoonlijke gegevens. en geven 
		van functies om naam op te vragen
\****************************************************************/

//aanroep nieuwe klant =
//    Klant k1 = new Klant ("Jan", "Hier 3", "Utrecht");

public class Persoon {

	protected String naam;
	protected String adres;
	protected String plaats;

	//nieuwe persoon maken
	public Persoon(String naam, String adres, String plaats) {
		this.naam = naam;
		this.adres = adres;
		this.plaats = plaats;
	}

	//functie om de naam te returnen.
	public String geefNaam(){
		return naam;
	}
	
	functie om naw gegevens te displayen
	public String toString(){
		return "\n"+ naam +"\n" + adres + "\n" +plaats+ "\n";
	}
}