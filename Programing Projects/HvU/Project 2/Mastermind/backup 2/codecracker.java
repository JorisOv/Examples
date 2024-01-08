public class CodeCracker{

//ik krijg mee:
int c = 5; //aantal kleuren.
int p = 4; //aantal pionnen.

	public static void main(String[] arg){
		
	}

	public int CodeCracker(int c, int p){
		int[] array = new int[10];
		
	}
}


/*
1
Maak nieuwe array met alle mogelijke andwoorden
6 kleuren 4 pionen is 6 tot de macht 4 = 4096 mogelijkheden
7 kleuren 5 pionen is 7 tot de macht 5 = 16807 mogelijkheden

i.e. array:
0 0 0 0
0 0 0 1
0 0 0 2 enz

2
neem een random waarde uit onze array (4096 mogelijkheden)

3
aantal goed & aantal op juiste plaats

4
gekozen andwoord 2 1 3 0

5 
is 0 0 0 0 het andwoord? Nee want er is er een goed en een op de juiste plaats
test en vertivieer met aantal goed en aantal op juiste plaats.
delete waardes uit de array als deze het echt niet kunnen zijn ( niet eindigen op 0)
Doe dit door de volgende met de vorge waarde (welk dus niet kan) te vervangen.

6 ga naar stap 1.*/