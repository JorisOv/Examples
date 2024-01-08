#include <stdio.h>
#include <time.h>
#include <stdlib.h>


int roll[6];
int card[14];
int main2();
void rollnew();
void rolld(int dnr);
int getnr(int nr);
int check(int type);
int check_grote_straat();
int check_kleine_straat();
int check_yazee();
int check_carre();
int check_3oak();
int check_full_house();
int check_chance();
int check_1s();
int check_2s();
int check_3s();
int check_4s();
int check_5s();
int check_6s();


char s[80];
int ammount = 80;

main()
{
	int w;
	for (w = 0; w < 15; w++)
		card[w] = 0;
		
	int score;
	int scorestore;
 	int i;
	for (i = 0; i < 6; i++)
		roll[i] = 0;
	
	int j;
	for (j = 0; j < 14; j++)
	card[j] = 0;

	time_t timer;
	timer = time(NULL);
	srand(timer);
	
	rollnew();
	
	for(i = 1; i <= 5; i++)
		printf("dobbelsteen #%d = %d\n", i, roll[i]);
	printf("\nWelke dobbelstenen wilt u opnieuw gooien?\n: ");
 	fgets(s, ammount, stdin);
 	for(i = 0; i < 80; i++) {
 			if(s[i] == '1')
 				rolld(1);
 			else if(s[i] == '2')
	 			rolld(2);
 			else if(s[i] == '3')
 				rolld(3);
 			else if(s[i] == '4')
 				rolld(4);
	 		else if(s[i] == '5')
 				rolld(5);
 	}
	
	for(i = 1; i <= 5; i++)
		printf("dobbelsteen #%d = %d\n", i, roll[i]);
 	
 	printf("\nWelke dobbelstenen wilt u opnieuw gooien?\n: ");
 	
 	fgets(s, ammount, stdin);
 	
 	for(i = 0; i < 80; i++) {
 		if(s[i] == '1')
 			rolld(1);
 		else if(s[i] == '2')
 			rolld(2);
 		else if(s[i] == '3')
 			rolld(3);
 		else if(s[i] == '4')
 			rolld(4);
 		else if(s[i] == '5')
 			rolld(5);
 	}
	
	for(i = 1; i <= 5; i++)
		printf("dobbelsteen #%d = %d\n", i, roll[i]);
 	
 	printf("\nAls wat wilt u dit opschrijven?\n");
 	
 	if (card[8] != 1)
 	 	printf("1:  Totaal Van Alle Enen\n");
 	if (card[9] != 1)
 		printf("2:  Totaal Van Alle Tweeën\n");
 	if (card[10] != 1)
 		printf("3: Totaal Van Alle Drieën\n");
 	if (card[11] != 1)
 		printf("4: Totaal Van Alle Vieren\n");
 	if (card[12] != 1)
 		printf("5: Totaal Van Alle Vijven\n");
 	if (card[13] != 1)
 		printf("6: Totaal Van Alle Zessen\n");
 	if (card[2] != 1)
 		printf("K:  Kleine Straat\n");
  	if (card[1] != 1)
 		printf("G:  Grote Straat\n");
 	if (card[3] != 1)
 		printf("Y:  Yazee\n");
 	if (card[4] != 1)
 		printf("C:  Carre\n");
 	if (card[5] != 1)
 		printf("T:  3 Of A Kind\n");
 	if (card[6] != 1)
 		printf("F:  Full House\n");
 	if (card[7] != 1)
 		printf("L:  Chance\n");

 	
 	
 	fgets(s, ammount, stdin);
 	
 	scorestore - score;
 	
 	if ( s[0] == 'g' || s[0] == 'G')
 		score = check(1);
 	else if( s[0] == 'k' || s[0] == 'K')
 		score = check(2); 
 	else if( s[0] == 'y' || s[0] == 'Y')
 		score = check(3); 
 	else if( s[0] == 'c' || s[0] == 'C')
 		score = check(4); 
 	else if( s[0] == 't' || s[0] == 'T')
 		score = check(5);  		 		
 	else if( s[0] == 'f' || s[0] == 'F')
 		score = check(6); 
 	else if( s[0] == 'l' || s[0] == 'L')
 		score = check(7);
 	else if( s[0] == '1')
 		score = check(8);
 	else if( s[0] == '2')
 		score = check(9);
  	else if( s[0] == '3')
 		score = check(10); 		  		
  	else if( s[0] == '4')
 		score = check(11); 		  		
   	else if( s[0] == '5')
 		score = check(12); 		  
   	else if( s[0] == '6')
 		score = check(13); 		  		
 	else
 		score = 0;
 		
 	score = score + scorestore;
 	printf("Score was: %d\n\n", score);
}

void rollnew(){
	for(int i = 1; i <= 5; i++)
		rolld(i);
 }

void rolld(int dnr)
{	
	if( (1 <= dnr) && (dnr <= 6) )
	{ 
		roll[dnr] = (rand() % 6) + 1;
	}
}



int getnr(int nr)
{
	int aantal = 0;
	
	for(int i = 1; i <= 5; i++) {
		if (roll[i] == nr)
			aantal++;
	}
	return aantal;
}

int check(int type) {
	if(type == 1)
		return check_grote_straat();
	else if (type == 2)
		return check_kleine_straat();
	else if (type == 3)
		return check_yazee();
	else if (type == 4)
		return check_carre();		
	else if (type == 5)
		return check_3oak();	
	else if (type == 6)
		return check_full_house();
	else if (type == 7)
		return check_chance();								
	else if (type == 8)
		return check_1s();								
	else if (type == 9)
		return check_2s();								
	else if (type == 10)
		return check_3s();								
	else if (type == 11)
		return check_4s();								
	else if (type == 12)
		return check_5s();								
	else if (type == 13)
		return check_6s();			
	
	else
		return 0;
}

int check_grote_straat() 
{
	if( getnr(2) && getnr(3) && getnr(4) && getnr(5) && (getnr(1) || getnr(6))) 
	{
		card[1] = 1;
		return 40;
	}
	else return 0;
}

int check_kleine_straat() 
{
	if( 	(getnr(1) && getnr(2) && getnr(3) && getnr(4)) ||
		(getnr(2) && getnr(3) && getnr(4) && getnr(5)) ||
		(getnr(3) && getnr(4) && getnr(5) && getnr(6)) )
			{
				card[2] = 1;
				return 30;
			}
	else return 0;
}

int check_yazee()
{
	for (int i = 1; i <= 6; i++)
	{
		if (getnr(i) == 5)
		card[3] = 1;
		return 50;
	}
		return 0;
}

int check_carre()
{
	int v = 0;

	for (int i = 1; i <= 5; i++)
	{
		if (getnr(i) == 4);
		v = (roll[1] + roll[2] + roll[3] + roll[4] + roll[5]);
		card[4] = 1;
		return v;
	}
	return 0;
}

int check_3oak()
{
	int v = 0;

	for (int i = 1; i <= 5; i++)
	{
		if (getnr(i) == 3);
		v = (roll[1] + roll[2] + roll[3] + roll[4] + roll[5]);
		card[5] = 1;
		return v;
	}
	return 0;
}

int check_full_house()
{
	int exclude = 0;

	if (getnr(1) == 3) 
		exclude = 1;
	if (getnr(2) == 3)
		exclude = 2;
	if (getnr(3) == 3)
		exclude = 3;
	if (getnr(4) == 3)
		exclude = 4;
	if (getnr(5) == 3)
		exclude = 5;
	if (getnr(6) == 3)
		exclude = 6;
		
	if (exclude == 1)
		{
		if (getnr(2) == 2 || getnr(3) == 2 || getnr(4) == 2 || getnr(5) == 2 || getnr(6) == 2)
		   {
		   card[6] = 1;
		   return 25;
		   }
		}


	if (exclude == 2)
		{
		if (getnr(1) == 2 || getnr(3) == 2 || getnr(4) == 2 || getnr(5) == 2 || getnr(6) == 2)
			{
				card[6] = 1;
				return 25;
			}
		}

	if (exclude == 3)
		{
		if (getnr(1) == 2 || getnr(2) == 2 || getnr(4) == 2 || getnr(5) == 2 || getnr(6) == 2)
			{
				card[6] = 1;
				return 25;
			}
		}

	
	if (exclude == 4)
		{
		if (getnr(1) == 2 || getnr(2) == 2 || getnr(3) == 2 || getnr(5) == 2 || getnr(6) == 2)
			{
				card[6] = 1;
				return 25;
			}
		}
	
	if (exclude == 5)
		{
		if (getnr(1) == 2 || getnr(2) == 2 || getnr(3) == 2 || getnr(4) == 2 || getnr(6) == 2)
			{
				card[6] = 1;
				return 25;
			}
		}


	if (exclude == 6)
		{
		if (getnr(1) == 2 || getnr(2) == 2 || getnr(3) == 2 || getnr(4) == 2 || getnr(5) == 2)
			{	card[6] = 1;
				return 25;
			}
		}
	else return 0;
}

int check_chance()
{
	int v = (roll[1] + roll[2] + roll[3] + roll[4] + roll[5]);
	return v;
	card[7] = 1;
}

int check_1s()
{
 int i = (getnr(1));
 return i;
 card[7] = 1;
}

int check_2s()
{
 int i = ((getnr(2)) * 2);
 return i;
 card[7] = 1;
}

int check_3s()
{
 int i = ((getnr(3)) * 3);
 return i;
 card[8] = 1;
}

int check_4s()
{
 int i = ((getnr(4)) * 4);
 card[9] = 1; 
 return i;

}

int check_5s()
{
 int i = ((getnr(5)) * 5);
 return i;
 card[10] = 1;
}

int check_6s()
{
 int i = ((getnr(6)) * 6);
 return i;
 card[11] = 1;
}
