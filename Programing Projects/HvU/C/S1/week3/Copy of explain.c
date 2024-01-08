#include <stdio.h>


int main(void){

  // alle variabelen declareren voordat je assignments doet.
  int c;
  int charact1, charact2;


  // Lees vanaf de stdin tot aan het einde
  // Zet het ingelezen teken in c.

  while ((c=getchar())!= EOF) {

    // zet c (het binaire character wat we moeten gaan coderen)
    // in teken1 en teken2.

    charact1 = c;
    charact2 = c;


    // teken1 bevat nu een aantal bits , die we nummeren 12345678
    // Aangezien we hier alleen de laagste 4 bits willen, gaan we
    // gebruik maken van een "bitmask"
    //
    // teken1 = 12345678
    //    0xf = 00001111 &
    // -------------------
    // result = 00005678

    charact1 = charact1 & 0xf;


    // We moeten nu nog 0100 toevoegen VOOR de bits 5678 die we
    // hebben overgehouden.
    // Hiervoor gebruiken we een bitwise OR.
    // teken1 = 00005678
    //   0x40 = 01000000 |
    // -------------------
    // result = 01005678

    charact1 = charact1 | 0x40;



    // teken2 bevat ook de eerste bits 12345678, maar
    // nu willen we alleen de eerste 4 bits. Als we hiervoor
    // weer de bitmask zouden gebruiken, dan zouden we iets
    // krijgen in de vorm 12340000, terwijl we 00001234 willen.
    // Daarom passen we hier een bitshift toe.
    // 12345678 verschuiven we 4 bits naar rechts, waarbij we opvullen
    // met 0en.
    // 12345678 >> 4 = 00001234

    charact2 = charact2 >> 4;


    // Ook hier moeten we weer 0100 toevoegen voor de bits 1234.
    // We gebruiken dezelfde manier met de bitwise OR.

    charact2 = charact2 | 0x40;


    // We zijn nu klaar om de chars uit te voeren.
    putchar(charact1);
    putchar(charact2);

  }

  // elke main moet wat returnen.
  return 0;
}