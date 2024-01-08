#ifndef LIST_DEF

#define LIST_DEF

// Definities van types
typedef int ElementType;

struct Node { 
  ElementType value;
  struct Node *prev;
  struct Node *next;
};

typedef struct Node *PtrToNode;

typedef struct { 
  PtrToNode head;
  PtrToNode tail;
} List;

typedef PtrToNode Position;


// Prototypes van functies
List        MakeNewList();
int         IsEmpty(List L);
void        Insert(ElementType X, List L, Position P);
void        ClearList(List L);
Position    Head(List L);
Position    First(List L);
Position    Tail(List L);
Position    Last (List L);
int         IsHead(Position P, List L);
int         IsTail(Position P, List L);
Position    Advance(Position P);
Position    Retreat(Position P);
ElementType Retrieve(Position P);

#endif