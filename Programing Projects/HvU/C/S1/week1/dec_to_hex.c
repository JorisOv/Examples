#include <stdio.h>

int main()
{
	int inite;
	
	inite=0;

	while (inite <= 20) {
		printf("%3d%6x\n", inite, inite);
		inite=inite+1;
	}
}
