import javax.swing.*;
import java.io.*;
import java.util.*;
//import java.text.*;

public class Convert2 {
  public static void main(String[] arg) throws IOException {
  	    //op vragen waarde van euro

    String input = JOptionPane.showInputDialog("Hoeveel dollar betaalt u voor een euro? Gebruik als scheidingsteken een PUNT");
    float valutaWaarde = Float.parseFloat(input);
    
    //test waarde
    //JOptionPane.showMessageDialog(null,"koers: "+valutaWaarde);

//create a stream from standard input
    InputStreamReader isr = 
    new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

  //open the input file
    String inputFileVar = JOptionPane.showInputDialog("Wat wilt u als input file?");
    System.out.print("Input file");
    System.out.flush();
    String naam = br.readLine();
    FileReader fr = new FileReader(inputFileVar); //new FileReader(naam);
    BufferedReader inputFile = new BufferedReader(fr);

  //open the output file
    String outputFileVar = JOptionPane.showInputDialog("Wat wilt u als output file?");
    System.out.print("Output file ");
    System.out.flush();
    naam = br.readLine();
    FileWriter fw = new FileWriter(outputFileVar);//new FileWriter(naam);
    PrintWriter outputFile = new PrintWriter(fw);

    //copy
    int n = 0;
    while (true) {
    	String regel = inputFile.readLine();
    	if (regel == null) {
       		break;
    	}
    	
    	StringTokenizer stok = new StringTokenizer (regel,"$");
    	
		while (stok.hasMoreTokens()){  
			String text = stok.nextToken();
			String bedrag = stok.nextToken();
			float bedragFloat = 0;
			
			outputFile.print(text);
			outputFile.flush();
			try{
				//Float.parseFloat(bedrag) gaat niet omdat ultraedit me Float float maakt.
				bedragFloat = Float.parseFloat(bedrag);
				bedragFloat = Math.round((bedragFloat / valutaWaarde) * 100) / 100.0f;
			}
			catch (NumberFormatException e){
				//parsing failed
				System.out.print("na $ geen mogelijkheid tot parsen naar Float");
				
			}
			outputFile.print("€");
			outputFile.println(bedragFloat);
			outputFile.flush();
		}
	//outputFile.println(regel);
    	n++;
    }

	

    //sluiten files
    inputFile.close();
    outputFile.close();
    
    //ff voor de netheid
    System.out.println(n + " regels gekopieerd");
  }
}

/*IN DEZE BACKUP LEES JE ENKEL EEN BESTAND IN, WELK JE WEG SCHRIJFT. N TELT HOEVEEL REGELS ER IN TOTAAL GECOPIEERD ZIJN. 
import javax.swing.*;
import java.io.*;

public class Convert2 {
  public static void main(String[] arg) throws IOException {

//create a stream from standard input
    InputStreamReader isr = 
          new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

  //open the input file
    System.out.print("Input file ");
    System.out.flush();
    //String naam = br.readLine();
    FileReader fr = new FileReader("input.txt"); //new FileReader(naam);
    BufferedReader inputFile = new BufferedReader(fr);

  //open the output file
    System.out.print("Output file ");
    System.out.flush();
    //naam = br.readLine();
    FileWriter fw = new FileWriter("output.txt");//new FileWriter(naam);
    PrintWriter outputFile = new PrintWriter(fw);

    //copy
    int n = 0;
    while (true) {
    	int regel = inputFile.read();
    	if (regel == -1) {
       		break;
    	}
    	outputFile.write(regel);
    	n++;
    }

    //sluiten files
    inputFile.close();
    outputFile.close();
    
    //ff voor de netheid
    System.out.println(n + " regels gekopieerd");
  }
}
*/