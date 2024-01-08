void main(int argc, char *argv[]){
	int ackWaarde1;
	int ackWaarde2;
	int andwoord;
	
	ackWaarde1 = 0;
	ackWaarde2 = 0;
	andwoord = ack(ackWaarde1,ackWaarde2);
	printf("A(%d, %d) = %d\n",ackWaarde1,ackWaarde2,andwoord);
	
	ackWaarde1 = 0;
	ackWaarde2 = 9;
	andwoord = ack(ackWaarde1,ackWaarde2);
	printf("A(%d, %d) = %d\n",ackWaarde1,ackWaarde2,andwoord);
	
	ackWaarde1 = 1;
	ackWaarde2 = 8;
	andwoord = ack(ackWaarde1,ackWaarde2);
	printf("A(%d, %d) = %d\n",ackWaarde1,ackWaarde2,andwoord);
	
	ackWaarde1 = 2;
	ackWaarde2 = 2;
	andwoord = ack(ackWaarde1,ackWaarde2);
	printf("A(%d, %d) = %d\n",ackWaarde1,ackWaarde2,andwoord);
	
	ackWaarde1 = 2;
	ackWaarde2 = 0;
	andwoord = ack(ackWaarde1,ackWaarde2);
	printf("A(%d, %d) = %d\n",ackWaarde1,ackWaarde2,andwoord);
	
	ackWaarde1 = 2;
	ackWaarde2 = 3;
	andwoord = ack(ackWaarde1,ackWaarde2);
	printf("A(%d, %d) = %d\n",ackWaarde1,ackWaarde2,andwoord);
	
	ackWaarde1 = 3;
	ackWaarde2 = 2;
	andwoord = ack(ackWaarde1,ackWaarde2);
	printf("A(%d, %d) = %d\n",ackWaarde1,ackWaarde2,andwoord);
	
	ackWaarde1 = 4;
	ackWaarde2 = 2;
	andwoord = ack(ackWaarde1,ackWaarde2);
	printf("A(%d, %d) = %d\n",ackWaarde1,ackWaarde2,andwoord);
	
	ackWaarde1 = 4;
	ackWaarde2 = 3;
	andwoord = ack(ackWaarde1,ackWaarde2);
	printf("A(%d, %d) = %d\n",ackWaarde1,ackWaarde2,andwoord);
	
	ackWaarde1 = 4;
	ackWaarde2 = 0;
	andwoord = ack(ackWaarde1,ackWaarde2);
	printf("A(%d, %d) = %d\n",ackWaarde1,ackWaarde2,andwoord);
}

/*
int ack(int m, int n){    //ackermann.c:62: invalid lvalue in assignment
	if (m == 0){
		return n+1;
	}
	else if (m > 0 && n == 0){      // <---- r62
		return ack(m-1, 1);
	}
	else{
		return ack(m-1, ack(m, n-1));
	}
}

*/

int ack(int m, int n){    //indien deze functie gebruikt wordt komt met sigmentatie fout
	while (m != 0){
       		if (n == 0){
			n = 1;
		}
		else{
       			n = ack(m, n-1);
         		m = m - 1;
         	}
         	
         	return n+1;
	}
}
