#include <stdio.h>

int main()
{
	int far, celsius;
	int lower, upper, step;

	lower = 0;
	upper = 300;
	step = 20;

	far = lower;
	while (far <= upper) {
		celsius = 5* (far-32) / 9;
		printf("%4d\t%6d\n", far, celsius);
		far = far +step;
	}
}
