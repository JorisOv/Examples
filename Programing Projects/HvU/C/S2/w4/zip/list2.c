#include <stdio.h>
#include <stdlib.h>
#include "list2.h"


void main(int argc, char *argv[]) {
  List a;

  a = MakeNewList();
  if (IsEmpty(a)) {
    printf("Leeg!\n");
  } 
  
  Insert(10, a, NULL);
  Insert(12, a, First(a));
  Insert(14, a, First(a));
  Insert(16, a, First(a));

  if (!IsEmpty(a)) {
    printf("Niet leeg!\n");
  } 
  
  printf("%d %d %d\n", Retrieve(First(a)), Retrieve(First(a)->next), Retrieve(Last(a)));

  ClearList(a);  

  if (IsEmpty(a)) {
    printf("Leeg!\n");
  } 

  Insert(10, a, NULL);
  Insert(12, a, First(a));
  Insert(14, a, First(a));
  Insert(16, a, First(a));

  if (!IsEmpty(a)) {
    printf("Niet leeg!\n");
  } 
   
   
  ClearList(a);  

  if (IsEmpty(a)) {
    printf("Leeg!\n");
    }
}

List MakeNewList() {
  List newlist;
  
  newlist.head = (Position) malloc(sizeof(struct Node));
  newlist.tail = (Position) malloc(sizeof(struct Node));
  
  newlist.head->next = newlist.tail;
  newlist.head->prev = NULL;
  newlist.tail->prev = newlist.head;
  newlist.tail->next = NULL;
  
  return newlist;
}


int IsEmpty(List L) {
  return (L.head->next == L.tail);
}

void Insert(ElementType X, List L, Position P) {
  Position newp;
  Position current;
  Position previous;

  newp = (Position) malloc(sizeof(struct Node));
  newp->value = X;

  if (IsEmpty(L)) {
    // als de List leeg is, moeten we een nieuw element
    // aanmaken en deze erin toevoegen

    L.head->next = newp;
    newp->prev = L.head;
    L.tail->prev = newp;
    newp->next = L.tail;
    
    return;
  } else {
    // als we al wel een gevulde lijst hebben, dan moeten we
    // controleren of P in L zit, en zoja het nieuwe element
    // er _voor_ inserten.
    current = First(L);
    // We weten zeker dat Tail(L)->next altijd de waarde NULL bevat.
    // Hier kunnen we dus op controleren.
    while ( current != NULL ) {
      // als we het element gevonden hebben...
      if (current == P) {
        // dan voegen we het nieuwe element er _voor_ in
        previous = Retreat(current);
        previous->next = newp;
        newp->prev = previous;
        current->prev = newp;
        newp->next = current;
        return;
      }
      // als het niet het goede element was, dan gaan we verder.
      current = Advance(current);
    } 
      
  }
}

void ClearList(List L) {
  Position temp;
  Position current;
  
  current = Head(L);
  while ( current != Tail(L) ) {
    temp = Advance(current);
    free(current);
    current = temp;
  }
  
  Head(L)->next = Tail(L);
  Tail(L)->prev = Head(L);
}

Position Head(List L) {
  return L.head;
}

Position First(List L) {
  return L.head->next;
}

Position Tail(List L) {
  return L.tail;
}

Position Last (List L) {
  return L.tail->prev;
}

int IsHead(Position P, List L) {
  return (P == Head(L));
}

int IsTail(Position P, List L) {
  return (P == Tail(L));
}

Position Advance(Position P) {
  return P->next;
}

Position Retreat(Position P) {
  return P->prev;
}

ElementType Retrieve(Position P) {
  return P->value;
}

