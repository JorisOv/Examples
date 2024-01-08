#include <string.h>
#include <stdio.h>
#include <stdlib.h>

void bits(char c);

int main (int argc, char *argv[]) {
	if (argc < 2) {
		printf("Je moet een sting meegeven, sukkel!");
		exit(0);
	}
	
	char* array = argv[1];
	
	int length = strlen(array);
	
	for(int i = 0; i < length; i++) {
		printf("%c\t", array[i]);
		bits(array[i]);
	}
	//bits('1');
	//bits(-'1');
	exit(0);
}

void bits(char c) {
	char d = c;
	char e = c;
	
	for(int i = 0; i < 8; i++) {
		printf("%u", (d % 2));
		d = d >> 1;
	}
	printf("\t");
	for(int i = 0; i < 8; i++) {
		printf("%u", (e & 1<<7)/128);
		e = e << 1;
	}

	printf("\t%u\n", c);

}