#include <stdio.h>  
  
int main() {  
	char invoer;  
    
	do {  
		invoer = getchar();  
		if ( invoer >= '0' && invoer <= '9') {  
			putchar(invoer);  
		} 
		else if ( invoer == ' ' || invoer == '\n' || invoer == '\t' ) { 			putchar('\n');  
		} 
		else {  
			printf("invoer a-z niet toegestaan\n");  
		}  
	} 
	while ( invoer != EOF );  
   
}  
