#include <stdio.h>

main()
{
	int fahr;
	printf("Dit is de Tabel\n\n");
	for (fahr = 0; fahr < 300; fahr = fahr + 20)
		printf("%d\t%6.3f\n", fahr, (5.0/9.0)*(fahr-32));

	printf("Dit is de Tabel in reversie\n\n");
	for (fahr = 300; fahr > 0; fahr = fahr - 20)
		printf("%d\t%6.3f\n", fahr, (5.0/9.0)*(fahr-32));
}