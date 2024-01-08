import javax.swing.*;
import java.io.*;

public class Convert {
  public static void main(String[] arg) throws IOException {

    //op vragen waarde van euro
/*
    String input = JOptionPane.showInputDialog("Hoeveel dollar betaalt u voor een euro?");
    float valutaWaarde = Float.parseFloat(input);
    
    //test waarde
    JOptionPane.showMessageDialog(null,"koers: "+valutaWaarde);

*/

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

    
    //indien er een $ aan getroffen wordt,
    if (regel == '$'){
    	//schrijven we het $ teken weg
    	outputFile.write(regel);
    	//en gaan we in een while lus zitten to de '\n'
    	while ((regel -'0') >= -30 && regel != -1){
    		//hier lezen we een teken, en moeten we het later in een float zetten, of anders weg schrijven
    		regel = inputFile.read();
    		regel = regel - '0';
    		float storeFloat = 0;
    		boolean decimaal = false;
    		if (regel == -2){
    			decimaal = true;
    		}
    		if(!decimaal){
    			int onzinVariableWegHalen;
    		}
    		storeFloat = (storeFloat * 10) + regel;
    		//outputFile.write(regel);
       	}
    }
    
    	
    //outputFile.write(regel);
    // ff voor test waarde
    outputFile.write(regel);
    n = n + 1;
    }
    
    //sluiten files
    inputFile.close();
    outputFile.close();
    
    //ff voor de netheid
    System.out.println(n + " tekens gekopieerd");
  }
}