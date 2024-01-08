//////////////////////////////////////////////////////////////
// 
// Auteur:  Joris Overzier
// TIV1E
// 

public class Student {

	private String naam;
	private int studentNummer;
	private float practicumCijfer;
	private float tentamenCijfer;

	public Student(String naam, int studentNummer) {
		this.naam = naam;
		this.studentNummer = studentNummer;
	}

	public Student(String naam, int studentNummer, float practicumCijfer, float tentamenCijfer) {
		this.naam = naam;
		this.studentNummer = studentNummer;
		setPracticumCijfer(practicumCijfer);
		setTentamenCijfer(tentamenCijfer);
	}

	public String getNaam() {
		return naam;
	}

	public int getStudentNummer() {
		return studentNummer;
	}

	public void setPracticumCijfer(float practicumCijfer) {
		this.practicumCijfer = practicumCijfer;
	}

	public void setTentamenCijfer(float tentamenCijfer) {
		this.tentamenCijfer = tentamenCijfer;
	}

	public float getGemiddelde() {
		return (practicumCijfer + tentamenCijfer) / 2f;
	}

	public String toString() {
		return getNaam() + " (" + getStudentNummer() + ")" +
				"\nGemiddelde: " + getGemiddelde();
	}

}