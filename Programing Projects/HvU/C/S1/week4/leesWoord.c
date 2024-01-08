/* Schrijf een functie int leesWoord(char[])	*/
/* Deze functie leest een woord uit stdin     	*/
/* Spaties, punten, komma's tabs, niewe regel   */
/* tekens zijn sceidingstekens.			*/
/* Scheidingstekens voor een woord worden 	*/
/* over geslagen en komen niet terug in het     */
/* array Alle letters die daar na komen		*/
/* wel in het array tot er weer een scheidings	*/
/* teken komt of EOF. Het resultaat is het 	*/
/* aantal letters van het woord			*/

# include <stdio.h>

int leesWoord(char arayChar[]) {
	int c, i;
	i=0;
	
	while ((c = getchar()) && c!='EOF'){
		if (c!='\t' && c!='\n' && c!=' ' && c!='.' && c !=',') {
			arayChar[i]=c;
			i++;
		}
		else {
			i=0;
		}
	}
	return i;
}