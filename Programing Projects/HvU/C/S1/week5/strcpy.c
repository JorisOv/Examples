void strcpy (char *dest, char *src, int n, int n2) {
	while(*dest != '\0')
		n++;
		
	while(*src++ !='\0')
		n2++;
	
	
	if (n2 > n)
		printf("De aray src is langer als de aray dest. Daarom werkt deze applicatie niet.\n");
	
	else 
		*dest++ = *src++;
}