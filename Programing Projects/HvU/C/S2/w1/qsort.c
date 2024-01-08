#include <stdio.h>
#include <stdlib.h>

#define MAXLENLINES 1000
#define MAXLINES 1000

int cmp(const void* a, const void* b);
char* readline(FILE *fp);

int main(void){
	char*totalLines[MAXLINES];
	int i=0;
	//int secundaryCounter=0;
	
	FILE *fp;
	fp=fopen("input.txt", "r");
	
	while (i<999&&(totalLines[i]=readline(fp))!= NULL){
		//totalLines[i]=readline(fp);
		//secundaryCounter++;
		i++;
	}
	

/*	while (i<999){
		totalLines[i]=readline(fp);
		//secundaryCounter++;
		i++;
	}
*/
	
	fclose(fp);
	
	qsort(totalLines, i, sizeof(char*),cmp);
	
	
	i=0;
	while (i<999 && totalLines[i]!=NULL) {
		printf("%s\n", totalLines[i]);
		i++;
	}
	
	return 0;
}

char* readline(FILE * fp) {
	char*p;
	char line[MAXLENLINES];
	int ch; 
	int i=0;
	
	while(i <999&& ((ch=getc(fp)) != EOF) &&ch!='\n') {
		line[i++]=ch;
	}
	if(i ==0 && ch == EOF) return NULL; {
		p=malloc(i+1);
	}
	
	line[i]='\0';
	if (p!=NULL)strcpy(p, line); {
		return p;
	}
}

int cmp(const void*a, const void* b) {
	char** pa=(char**) a;
	char** pb=(char**)b;
	return strcmp(*pa, *pb);
}



/* werkt

#include <stdio.h>
#include <stdlib.h>

int cmp(const void* a, const void* b);

int main(void){
	char*woorden[6] = {"koeien","schapen","geiten","paarden","ezels","kippen"};
	int i;
	qsort(woorden, 6, sizeof(char*),cmp);
	for (i=0;i<6;i++)
	printf("%s\n",woorden[i]);
	return 0;
}

int cmp(const void*a, const void* b) {
	char** pa=(char**) a;
	char** pb=(char**)b;
	return strcmp(*pa, *pb);
}
*/
