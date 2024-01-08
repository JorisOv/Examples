//public class Rekening extends Applet implements ActionListener{
public class BankRekening {
	private float saldo;
	
	public BankRekening () {
		saldo = 0.0f;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void updateSaldo( int change ) {
		saldo += change;
	}
}