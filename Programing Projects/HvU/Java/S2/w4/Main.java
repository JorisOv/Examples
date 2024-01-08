///////////////////////////////////////////////////////////
//
//	Naam: Ian Brekelmans
// 	File: Main.java
//	Omschrijving: Omzetten van USD naar Euro
//
///////////////////////////////////////////////////////////


import java.io.*;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] arg)
        throws IOException {
  //create a stream from standard input
    InputStreamReader isr =
          new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

  //open the input file
    System.out.print("Input file ");
    System.out.flush();
    //String naam = br.readLine();
    FileReader fr = new FileReader("input.txt");
    BufferedReader inputFile = new BufferedReader(fr);

  //open the output file
    System.out.print("Output file ");
    System.out.flush();
    //naam = br.readLine();
    FileWriter fw = new FileWriter("output.txt");
    PrintWriter outputFile = new PrintWriter(fw);

  //copy
    int n = 0;
    double conversie = 1.25;
    while (true){
      	String regel = inputFile.readLine();
      	try{
			StringTokenizer stok = new StringTokenizer(regel, "$");
			String tokens = "";
				while (stok.hasMoreTokens()){
					String t = stok.nextToken();
			       	tokens = tokens + "[" + t + "] ";
            	}
			double d = Double.parseDouble(tokens);
      		d = d / conversie;
      		regel = regel + d;
      		outputFile.println(regel);
			}
		catch(NumberFormatException nfe){
			outputFile.println(regel);
    	}
    	if (regel == null)
      	  	break;
    	n = n + 1;
	}

	inputFile.close();
    outputFile.close();
    System.out.println(n + " regels gekopieerd");
  }
}
