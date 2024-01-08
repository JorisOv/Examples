//////////////////////////////////////////////////////////////
// 
// Auteur:  Joris Overzier
// TIV1E
// 

public class Zwembad {
	private double lengte;
	private double breedte;
	private double diepte;

	public Zwembad (double lengte, double breedte, double diepte) {
		this.lengte = lengte;
		this.breedte = breedte;
		this.diepte = diepte;
	}

	public double getInhoud() {
		return lengte * breedte * diepte;
	}
}