#include <stdio.h>

int main(void) {
	/* initialisatie variablen en aray */
	int c, i;
	char arayChar[50];
	
	/* legen van aray */
	for(i=0;i<50;i++)
		arayChar[i]=0;
		
	i=leesWoord(arayChar);
	
	for (;i <= 0;i--)
		printf("%s\t",arayChar[i]);

}

int leesWoord(char arayChar[]) {
	int c, i;
	i=0;
	
	while ((c = getchar()) && c!=EOF){
		if (c!='\t' && c!='\n' && c!=' ' && c!='.' && c !=',') {
			arayChar[i]=c;
			i++;
		}
		else {
			return i;
			i=0;
		}
	}
	
}