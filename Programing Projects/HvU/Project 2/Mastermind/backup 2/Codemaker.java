public class Codemaker {

private int colors = 0;
private int[] code = null;
private int pegs = 0;

public Codemaker(int c, int p)
{
         colors = c;
         pegs=p;
         code = new int[pegs];//initialiseren van array
         //plaatsing pionen
         for(int i=0;i<pegs;i++){
                 code[i]=(int)(Math.random()*colors); //aanmaken 5 variable waardes.
                 System.out.println(""+code[i]);
         }
}

/* mental note to self 
code = 2231
invoer =1020
testwaardes 0 1 2 3 4 5
code 	    0 1 2 1 0 0
invoer	    2 1 1 0 0 0
dan is de 
kleinste 
van de 2    0 1 1 0 0 0
dus zijn er 2 goed. Maar niet op juiste plaats.

*/

//hoort bij test aantal goed:
int[] testArray;
int[] testArrayWaarde1 = (int[]) code.clone();  //copieren orginele waardes code dmv clone naar codeClone
int[] testArrayWaarde2;
int[] testArrayCounter1;
int[] testArrayCounter2;
int[] testArrayCounterTotal;

public int aantalGoed(int[] a){

         //vergelijk code met de invoer a[i], i is hierbij de pion nummer en bevat de kleur. 
         int counter=0;
         int i = 0;
/*
         int[] codeClone = (int[]) code.clone();//copieren orginele waardes code dmv clone naar codeClone
         for(int i=0; i<a.length;i++){//4 loop runs (voor 4 waardes
                 for(int j=0;j < code.length;j++){//kleur vergelijking
                         if (code[i]==a[j]){//indien biede kleur en waarde gelijk.
                                 codeClone[j] = -1;
                                 counter++;
                                 break;
                         }
                 }
         }
  */
	for (i = 0; i < 6;i++){ //6 moet c worden ivm aantal kleuren. Zie definietie hieronder.
        	testArray[i] = i; 
        }
        
        // vullen van testArrayWaarde2 met de opgegeven waarde (a)
        for (i = 0; i < 6;i++){ //6 moet c worden ivm aantal kleuren. Zie definietie hieronder.
        	testArrayWaarde2[i] = a[i]; 
        }
      	
      	for (i = 0; i < 6; i++){
      		testArrayCounter1[i] = 0;
      	}

      	for (i = 0; i < 6; i++){
      		testArrayCounter2[i] = 0;
      	}
      	      	  
        //Hier bevat testArray[] de waardes 0 1 2 3 4 5
        //Hier bevat testArayWaarde1[] de waardes welk gelijk zijn aan de code.
        //Hier bevat testArayWaarde2[] de waardes welk ingevoerd zijn door de gebruiker.
        //Hier bevat testArrayCounter1[] enkel 0 waardes.
        //Hier bevat testArrayCounter2[] enkel 0 waardes.
        
        for (i = 0; i < 6; i++){
        	if (testArrayWaarde1[i] == testArray[i]){
        		testArrayCounter1[i] = testArrayCounter1[i] +1;
        	}
        }
        
        for (i = 0; i < 6; i++){
        	if (testArrayWaarde2[i] == testArray[i]){
        		testArrayCounter2[i] = testArrayCounter2[i] +1;
        	}
        }
        
        //2 bovenstaande vergelijken kleuren van invoer en code, en zetten deze in TestArrayCounterX
        
        for (i = 0; i < 6;i++){ 
        	if (testArrayCounter1[i] > testArrayCounter2[i]){ 
        		testArrayCounterTotal[i] = testArrayWaarde2[i];
        	}
               	else if (testArrayCounter1[i] < testArrayCounter2[i]){ 
        		testArrayCounterTotal[i] = testArrayWaarde1[i];
        	}
        	else{
        		testArrayCounterTotal[i] = 0;
        	}
        }

	for (i = 0; i < 6; i++){
		counter = counter + testArrayCounterTotal[i];
	}
	
         return counter;
}

public int aantalOpDeJuistePlaats(int[] a){
         int[] codeClone = (int[]) code.clone();//copieren orginele waardes code dmv clone naar codeClone
         int counter=0;
         for (int i=0;i<pegs;i++){//4 loop runs voor locatie bepaling
                 if (a[i]==codeClone[i]){//vergelijking
                         counter++;
                 }
         }
         return counter;
}


public static void main(String[] arg)
throws Exception{

         int c=6; //variable voor aantal kleuren
         int p=4; //variable voor aantal pionnen
         Codemaker codemaker = new Codemaker(c, p); //nieuwe opzet pionnen
         byte[] b = new byte[p+2];//aanmaken variable b om later de 4 waardes, plus enter in te zetten
         while(true){
                 System.out.print("next try >");//printje
                 System.in.read(b);//lees toetsenboard invoer
                 int[] a = new int[p];//nieuwe array welk even groot is als aray P
                 for(int i=0;i<p;i++)
                         a[i]=b[i]-48; //lusje om de waarde van een asci te lezen als int. en aan A te geven ter controlle
                 System.out.println("               aantal goed = "+ codemaker.aantalGoed(a));
                 System.out.println("aantal op de juiste plaats = "+ codemaker.aantalOpDeJuistePlaats(a));
         }
}


}


