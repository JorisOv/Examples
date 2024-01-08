//////////////////////////////////////////////////////////////
// 
// Auteur:  Joris Overzier
// TIV1E
// 


public class TestStudenten {

	public static void main (String [ ] argv)
	{
		Student student1 = new Student ("Rot Student", 1221453);
		Student student2 = new Student ("Betere Student ", 1221275, 7.5f, 8.2f);

		student1.setPracticumCijfer(7.6f);
		student1.setTentamenCijfer(8.0f);

		//Output Rot Student
		System.out.println(student1.getNaam() + " (" + student1.getStudentNummer() + ")");
		System.out.println("Gemiddelde: " + student1.getGemiddelde());

		System.out.println("\n");

		//Output Betere Student
		System.out.println(student2);
	}
}