/****************************************************************\
Autheur: Joris Overzier
Klas: 		TIV1E
Datum: 		13 Maart 2005
Functie: 	maakt nieuwe rekening aan en geeft functies voor
		bewerking van saldo
\****************************************************************/

public class Rekening {

	//aanmaken variable
	private static int hoogsteRekeningNr;
	private int rekNr;
	private double saldo;
	private String log="";
	
	//functie rekening voor aanmaken nieuwe rekening
	public void Rekening() {
		hoogsteRekeningNr += 1;
		rekNr = hoogsteRekeningNr;
	}
	
	//returnen rekening nr.
	public int geefRekNr(){
		return rekNr;
	}

	//returnen slado.
	public double geefSaldo(){
		return saldo;
	}

	//returnen van log gegevens
	public String geefLog(){
		return log;
	}

	//stort functie
	public void stort(double b){
		saldo = saldo +b;
		log += "Gestort: " +b+ " Euro\n";
	}

	//opname functie
	public void neemOp(double b){
		saldo = saldo - b;
		log += "Opgenomen: " +b+ " Euro\n";
	}

	//overboek functie
	public void boekOver(double b, Rekening rekening){
		neemOp(b);
		rekening.stort(b);
	}

	//log returnen
	public String toString(){
		return log;
	}
}