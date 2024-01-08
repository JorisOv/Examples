#include <stdio.h>
#include <stdlib.h>

struct lijst_element{
    int     getal;
    struct lijst_element *next;
} ;

void enqueue();
	
typedef struct lijst_element element_t;

	//aanmaken element pointers
	element_t* start=NULL;
	element_t* last=NULL;

main(){
	enqueue();
	enqueue();
	start->getal = 24;
	last->getal = 55;
	printf("%d\t%d\n",start->getal,last->getal);
	dequeue();
	printf("%d\t%d\n",start->getal,last->getal);
}

void enqueue(){
	if (start == NULL){
		start = (element_t*) malloc(sizeof(element_t));
		if(start == NULL){ 
			printf("geheugen is vol");
		}
		start->next=start;
		last = start;
	}
	else {
		last->next = (element_t*)malloc(sizeof(element_t));
		if(last->next == NULL) 
			printf("geheugen is vol");
		last->next->next = start;
		last = last->next;
	}
}

void dequeue(){
	if(last->next == last){
		last = NULL;
		free(last);
	}
	if(last == NULL){
		printf("Attempt to dequeue form empty queue");
	}
	
	else{
		last = start->next;
		free(start);
		start = last;
	}
}