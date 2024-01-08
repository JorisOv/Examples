/* maak een programma dat alle woorden uit 	*/
/* stdin leest en ze omgekeerd afdrukt in 	*/
/* stdout gescheiden door tabs. Het		*/
/* programma gaat door tot EOF			*/
/* maak verschillende files en compileer die	*/
/* geschijden					*/

# include <stdio.h>
# include <leesWoord.h>

int main(void) {
	/* initialisatie variablen en aray */
	int c, i,char arayChar[20];
	
	/* legen van aray */
	for(i=0;i<20;i++)
		arayChar[i]=0;
		
	/* counter op 0 */
	i=0;

	/* Als er nog een teken komt met getchar welk niet gelijk is aan EOF*/
	while ((c = getchar()) && c != 'EOF') {
		i=leesWoord(arayChar);
		}
		
		else {
			for (;i <= 0;i--){ 
				printf("%s\t",arayChar[i]);
			}
		}
	}
}
