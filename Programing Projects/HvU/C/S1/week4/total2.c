#include <ctype.h>
#include <stdio.h>

int leesWoord(char arayChar[]);

int main(void) {
	int i, c; 
        char arayChar[50]; 
  
  	//legen lus
        for(i=0;i<50;i++) 
        	arayChar[i]=0; 
  
        //i = leeswoord =>0 moet hij nog een keer. -1 geeft namelijk een sceidingsteken of eof weer.
        //zo krijg je dus een positieve i waar je verder mee kunt.
        for (i = leesWoord(arayChar); i >= 0; i = leesWoord(arayChar)){
           	//zolang i nog niet negatief is moet hij de locatie i uit de aray printen.
           	for (i--;i >=0; i--)
           		putchar(arayChar[i]);
           	printf("\t");

        }
}

int leesWoord(char buffer[]);

/***************************************************
   int leesWoord(char buffer[])
   Leest woorden in vanaf de stdin en zet deze in buffer.
   Returnt het aantal karakters dat is weggeschreven.
   Returnt -1 als er direct een EOF wordt gelezen.
*****************************************************/
int leesWoord(char buffer[]) {
  int i = 0;
  int c;

  // lees eerste char in
  c = getchar();

  // zolang dit een "spatie" is, blijven we deze uitlezen,
  // om op die manier de eerste spaties over te slaan.
  // (anders krijg je telkens woorden van lengte 0 als er
  //  meerdere spaties staan.)
  while ( c!= EOF && isspace(c) ) {
    c = getchar();
  }

  // zolang er geen EOF of "spatie" gevonden is,
  // blijven we de chars wegschrijven naar de buffer
  // (waarbij we rekening houden met de grootte van de buffer)
  while ( c!= EOF && !isspace(c) ) {
     // wegschrijven
     buffer[i] = c;
     // ophogen van index
     i++;
     // controleren of we niet buiten de buffer komen
     if (i > 50) {
       break;
     }
     // nieuwe char inlezen
     c = getchar();
  }

  // Nadat we een EOF of spatie zijn tegengekomen
  // gaan we i returnen. Echter als we nog niks
  // hebben ingelezen en toch al een EOF hebben gezien
  // dan returnen we -1
//  printf("%d\n", i);
  if ( c == EOF && i == 0 ) {
    return -1;
  } else {
    return i;
  }
}
