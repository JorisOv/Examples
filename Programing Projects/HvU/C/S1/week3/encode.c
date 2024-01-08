#include <stdio.h>


int main(void){
	int c;
	int charact1, charact2;
	
	while ((c=getchar())!= EOF) {
		charact1 = c;
    		charact2 = c;
		charact1 = charact1 & 0xf;
		charact1 = charact1 | 0x40;
		charact2 = charact2 >> 4;
		charact2 = charact2 | 0x40;
    		putchar(charact1);
    		putchar(charact2);
	}
}