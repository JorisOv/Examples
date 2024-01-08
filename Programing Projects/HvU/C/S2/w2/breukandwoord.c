#include <stdio.h>
#include "breuksom.h"

int breukAndwoord(int valueA, int valueB, int valueC, int valueD){
	
	int temp;
	int tempA, tempB, tempC, tempD;
	int antwoordNoemer, antwoordTeller;
	
	struct noemerTellerBreuk breukEen, breukTwee;
	
	tempA = valueA;
	tempB = valueB;
	tempC = valueC;
	tempD = valueD;

	//printf("%d\t%d\t%d\t%d\n",tempA, tempB, tempC, tempD);
		
	while (tempB != tempD){
		//printf("gaat while loop in\n");
		if (tempB > tempD){
			tempD = tempD + valueD;
			tempC = tempC + valueC;
			//printf("tempD = %d\n", tempD);
		}
		if (tempB < tempD){
			tempB = tempB + valueB;
			tempA = tempA + valueA;
			//printf("tempB = %d\n", tempB);
		}
	}
	
	printf("Teller 1 = %d\t Teller 2 = %d\t Noemer1 = %d\t Noemer 2 = %d \n",tempA, tempB, tempC, tempD);
	antwoordNoemer = tempA + tempC;
	antwoordTeller = tempD;
	
	printf("%d\t%d\n",antwoordNoemer, antwoordTeller);
	
	temp = 0;
	//temp = ((breukEen.initialNoemer*breukTwee.initialTeller)+(breukEen.initialTeller*breukTwee.initialNoemer))/(breukEen.initialTeller*breukTwee.initialTeller);
}