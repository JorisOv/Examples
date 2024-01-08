#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLEN 80
#define MAXLINES 100

char* readline(FILE *fp);
void freeline(char *s);
int cmp( const void* a, const void* b);
void sort(char* v[], int links, int rechts);


int main ( int argc, char *argv[]) {
	int i=0;
	int i2;
	int lines=0;
	FILE *fp;
	// mental note to self: linearray is een array van strings
	char *linearray[MAXLINES];
	
	fp = fopen("input.txt", "r");
	
	for(;i<MAXLINES;i++) {
        	linearray[i] = readline(fp);
        if ( linearray[i] == NULL ) {
          	break;
        }
        lines++;
    	}
	
	// sorteer de array, (had hier eerder sigmentatie fout.)
	 sort(linearray, 0, i);
	
	for (i2=lines;i2>0;i2--){
	printf("%s", linearray[i2]);
	}

	for (i2=lines;i2>0;i2--){
		freeline(linearray[i]);
	}

	return 0;
}


/*  OUDE MAIN. Bewaar als backup
int main( int argc, char *argv[]) {
	FILE *p;
	char *output;
	
	p = fopen("input.txt", "r");
	
	output = readline(p);
	
	printf("%s", output);
	freeline(output);
	
	return 0;	
}
*/

char* readline(FILE *fp) {
	char *s;
	char *a;
	
	// calloc alloceert geheugen voor een array s.
	// dit array bevat in eerste instantie alleen maar nullen
	s = calloc(MAXLEN, sizeof(char));
	
	
	a = fgets(s,MAXLEN,fp);
	
	// fgets levert NULL als er een EOF gezien wordt,
	// echter deze kan al wat ingelezen hebben in s.
	// Deze (volle) s moeten we dan returnen.
	// Als er niks in s staat (s[0] = '\0'), dan
	// kunnen we "veilig" NULL returnen.
	if ( a == NULL && s[0] == '\0' ) {
		free(s);
		// return 0
		return NULL;
	}
	//printf("%s", s);
	return s;
	
}


void freeline(char *s) {
	free(s);
}


int cmp( const void* a, const void* b) {
	return strcmp(*(char**) a, *(char**) b);
}


void sort(char* v[], int links, int rechts) {
	qsort( (void*) v, (rechts - links), sizeof(char*), cmp);
}	