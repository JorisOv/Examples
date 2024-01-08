struct noemerTellerBreuk breukAndwoord(int valueA, int valueB, int valueC, int valueD);
int ggdEuclides(int teller, int noemer);
#include <stdio.h>

//struct maken
struct noemerTellerBreuk {
	int initialNoemer;
	int initialTeller;
};

   	//variablen maken van struct
   	struct noemerTellerBreuk breukEen, breukTwee, breukDrie, breukVier, andwoordBreuk;


main(){
   	//breuken maken
   	breukEen.initialTeller = 1;
   	breukEen.initialNoemer = 2;
   	
   	breukTwee.initialTeller = 1;
   	breukTwee.initialNoemer = 3;
   	
   	breukDrie.initialTeller = 1;
   	breukDrie.initialNoemer = 5;
   	
   	breukVier.initialTeller = 1;
   	breukVier.initialNoemer = 7;
   	
	//1e som, 
	printf("%d/%d\t+\t%d/%d\n",breukEen.initialTeller, breukEen.initialNoemer, breukTwee.initialTeller, breukTwee.initialNoemer); //afdrukken som
	andwoordBreuk=breukAndwoord(breukEen.initialTeller, breukEen.initialNoemer, breukTwee.initialTeller, breukTwee.initialNoemer);//berekening
	printf("%d/%d\n", andwoordBreuk.initialTeller, andwoordBreuk.initialNoemer);//afdrukken andwoord
		
	//2e som
	printf("%d/%d\t+\t%d/%d\n",andwoordBreuk.initialTeller, andwoordBreuk.initialNoemer, breukDrie.initialTeller, breukDrie.initialNoemer);//afdrukken som
	andwoordBreuk=breukAndwoord(andwoordBreuk.initialTeller, andwoordBreuk.initialNoemer, breukDrie.initialTeller, breukDrie.initialNoemer);//berekening
	printf("%d/%d\n", andwoordBreuk.initialTeller, andwoordBreuk.initialNoemer);//afdrukken andwoord
	
	//3e som	
	printf("%d/%d\t+\t%d/%d\n",andwoordBreuk.initialTeller, andwoordBreuk.initialNoemer, breukVier.initialTeller, breukVier.initialNoemer);//afdrukken som
	andwoordBreuk=breukAndwoord(andwoordBreuk.initialTeller, andwoordBreuk.initialNoemer, breukVier.initialTeller, breukVier.initialNoemer);//berekening
	printf("%d/%d\n", andwoordBreuk.initialTeller, andwoordBreuk.initialNoemer);//afdrukken andwoord
}        

struct noemerTellerBreuk breukAndwoord(int valueA, int valueB, int valueC, int valueD){
   	int tempA, tempB, tempC, tempD;
   	
      	tempA = valueA; //tempA is breukEen.initialTeller
   	tempB = valueB; //tempB is breukEen.initialNoemer
   	tempC = valueC; //tempC is breukEen.initialTeller
   	tempD = valueD; //tempD is breukEen.initialNoemer

   	//vergelijking om noemer gelijk te krijgen.
   	while (tempB != tempD){
       		if (tempB > tempD){
           		tempD = tempD + valueD;
           		tempC = tempC + valueC;
       		}
       		if (tempB < tempD){
	           	tempB = tempB + valueB;
           		tempA = tempA + valueA;
		}
   	}

   	//andwoord opslaan.
   	andwoordBreuk.initialNoemer= tempD;
   	andwoordBreuk.initialTeller= tempA + tempC;
   
      	//andwoord returnen.
	return andwoordBreuk;
}

int ggdEuclides(int teller, int noemer) {

	int a, b, c, d;
	c = noemer;
	b = teller;
	while (b > c){
		while (b > c){
			d = b - c;
			b = d;
		}
	
		b=c;
	
		if (d != 0){
			c=d;
		}
	}
	return c;
}

/*Algoritme van Euclides
Het algoritme

   1. Noem het grootste van de beide getallen A, het andere B.
   2. Trek B net zo vaak van A af totdat er 0 over blijft of een getal kleiner dan B.
   3. Wanneer er 0 over blijft zijn we klaar, en is B de ggd.
   4. Zo niet, herhaal dan het algoritme met B en wat er van A over is.

[bewerken]

Voorbeeld

Als een voorbeeld bepalen we met het algoritme van Euclides de ggd van 900 en 1140:

    * A is 1140, B is 900. We kunnen 900 eenmaal van 1140 aftrekken, we krijgen dan C 240.
    * We herhalen het algoritme met A=900 en B=240. B 240 kan driemaal van A 900 worden afgetrokken, dan blijft C 180 over.
    * We herhalen ons algoritme met A=240 en B=180. B 180 kan eenmaal van A 240 worden afgetrokken. Dit levert C 60.
    * We herhalen ons algoritme met A=180 en B=60. 60 kan 3 maal van 180 afgetrokken worden, en 0 blijft dan over.
    * Daarmee zijn we aan het einde gekomen, en hebben bepaald dat 60 de grootste gemene deler van 900 en 1140 is, oftewel ggd(900,1140)=60.

Dit met variable:
c = b 
b = a
while b > c
	while b > c
		b-c=d
		b = d
	b=c
	c=d
	storage = c
return storage

*/

