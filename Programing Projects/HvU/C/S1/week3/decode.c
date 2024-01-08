#include <stdio.h>
	
int main(void){
	int c1, c2;
	int charact1, charact2;
	int output;
	
	while ((c1=getchar())!= EOF && (c2=getchar())!= EOF) {
		charact1=c1;
		charact2=c2;
		charact2 = charact2 << 4; 
		charact1 = charact1 & 0xf; 
		output = charact1+charact2; 
		putchar(output);
	}
}