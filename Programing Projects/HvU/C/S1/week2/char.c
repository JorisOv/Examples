#include <stdio.h>

int main (void) {
       int woord;
       int woordcont=-1;

       while((woord = getchar()) !=EOF) {
               if (woord >='0' && woord <='9'){
                       if (woordcont==-1)
                               woordcont=woord-'0';
                       else
                               woordcont=(woordcont*10)+(woord-'0');
               }
               
               else {
                       if (woord == ' ' || woord == '\t' || woord == '\n'){
                               if (woordcont!=-1){
    	                           firstfuncprint(woordcont);
     		                   woordcont=-1;
                               }
           			else {
           			}
           		}
           		
                       else {
                               printf("input a-z not allowed\n");
                            }
                       
               }
       
       }
       return 0;
} 

int firstfuncprint(printNumber) {
	int counter;
	int loopcount;
	int devider=10000;
	for (loopcount=0; loopcount <=4; loopcount++){
		counter=(printNumber/devider)%10;
		putchar(counter+'0');
		devider=devider/10;
	}
	
}
	