//////////////////////////////////////////////////////////////
// 
// Auteur:  Joris Overzier
// TIV1E
// 

public class DobbelBeker {

	private int aantalDobbelStenen;
	private int somVanOgen;

	public DobbelBeker(int aantal) {
		setAantalDobbelStenen(aantal);
	}

	public void werp() {
		somVanOgen = 0;
		for(int i = 0;i < getAantalDobbelStenen();i++) {
			somVanOgen += (int) (Math.random() * 6) + 1;
		}
	}

	public void setAantalDobbelStenen(int aantal) {
		aantalDobbelStenen = aantal;
	}

	public int getAantalDobbelStenen() {
		return aantalDobbelStenen;
	}

	public int getSomVanOgen() {
		return somVanOgen;
	}

	public String toString() {
		return "Er is " + getSomVanOgen() + " gegooid met " + getAantalDobbelStenen() + " dobbelstenen.";
	}

}