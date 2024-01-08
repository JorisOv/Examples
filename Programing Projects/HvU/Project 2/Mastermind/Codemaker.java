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

public int aantalGoed(int[] a)
{
         //vergelijk invoer met a[i], i is hierbij de pion nummer en bevat de kleur.
         int counter=0;
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
         return counter;
}

public int aantalOpDeJuistePlaats(int[] a)
{
         int[] codeClone = (int[]) code.clone();//copieren orginele waardes code dmv clone naar codeClone
         int counter=0;
         for (int i=0;i<pegs;i++){//4 loop runs voor locatie bepaling
                 if (a[i]==codeClone[i]){//vergelijking
                         counter++;
                 }
         }
         return counter;
}

/*
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
*/

}


