/*
Applet Door Joris Overzier
I1b1
Deze applet maakt een rekenmachine aan. Deze heeft de functies + en -. Is in 
staat om x+y+z-b-a= uit te rekenen en is in staad grote getallen van meer dan een carracter te behandelen. 

 */

import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class Calculator2 extends Applet implements ActionListener
{

	private Button one, two, three, four, five, six, seven, acht, nine, zerro, plus, minus, complete, clear;
	private int inputNumber;
	private int inputNumberBig;
	private int storeNumber;
	private int displayNumber;
	private boolean plusBool = false;
	private boolean minusBool = false;
	
	public void init()
	{
		
		//Uitschakelen standaart awt opmaak:
		setLayout(null);
		
		//bepalen groote aplet in picksele
		setSize(300,300);

/* 
In het voldende deel van voit init worden knoppen gemaakt. 
Ook deze knoppen worden geplaatst buiten AWT. 
Verdere uitleg word bij de eerst aangemaakte knop weergegeven.
*/			

// maak button
		one = new Button("1");
//bepaal locatie met buttonnaam.setBounds(x, y, xbreete, yhoogte);
		one.setBounds( 90, 80, 30, 30);
// toevoen variable
		add(one);
//toevoegen actionListener.
		one.addActionListener(this);

		
		two = new Button("2");
		two.setBounds(130, 80, 30, 30);
		add(two);
		two.addActionListener(this);
		
		three = new Button("3");
		three.setBounds(170, 80, 30, 30);
		add(three);
		three.addActionListener(this);
		
		four = new Button("4");
		four.setBounds(90,120, 30, 30);
		add(four);
		four.addActionListener(this);
		
		five = new Button("5");
		five.setBounds(130,120, 30, 30);
		add(five);
		five.addActionListener(this);
		
		six = new Button("6");
		six.setBounds(170,120, 30, 30);
		add(six);
		six.addActionListener(this);
		
		seven = new Button("7");
		seven.setBounds(90,160, 30, 30);
		add(seven);
		seven.addActionListener(this);
		
		acht = new Button("8");
		acht.setBounds(130,160, 30, 30);
		add(acht);
		acht.addActionListener(this);
		
		nine = new Button("9");
		nine.setBounds(170,160, 30, 30);
		add(nine);
		nine.addActionListener(this);
		
		zerro = new Button("0");
		zerro.setBounds(130,200, 30, 30);
		add(zerro);
		zerro.addActionListener(this);
		
		plus = new Button("+");
		plus.setBounds(170,200, 30, 30);
		add(plus);
		plus.addActionListener(this);
		
		minus = new Button("-");
		minus.setBounds(90,200, 30, 30);
		add(minus);
		minus.addActionListener(this);
		
		complete = new Button("=");
		complete.setBounds(170,240, 30, 30);
		add(complete);
		complete.addActionListener(this);
		
		clear = new Button("Ac");
		clear.setBounds( 90,240, 30, 30);
		add(clear);
		clear.addActionListener(this);
	}

// de komende methode is aangemaakt om diverse knoppen in combinatie ingedrukt 
// te kunnen gebruiken. Dit gebeurd door een mathematische actie.
	private int makeNumberBig(int bigOne, int smallOne) {
		int completeNumber;
		completeNumber = bigOne*10+smallOne;
		displayNumber = completeNumber;
		return completeNumber;
	}
	
	public void paint(Graphics g) {
// weergeven van omtrek zakjappaner
		g.drawRect(90, 40,110, 30);
		g.drawRect(80, 30,130, 250);
// weergeven waardes op display
		g.drawString("" + displayNumber,100, 60 );
	}

	
	public void actionPerformed(ActionEvent event)
	{
		
//Hier, in void actionPreformed worden berekeningen uitgevoerd als er een knop ingedrukt wordt:
// Zo nee, wordt dit het eerste cijfer.
//Er wordt gecontroleerd of er al een waarde is, zoja, wordt makeNumberBig aangeroepen. 

		if(event.getSource() == one) {
			if(inputNumberBig == 0) {
				inputNumberBig = 1;
				displayNumber = 1;
			}
			else
				inputNumberBig = makeNumberBig(inputNumberBig, 1);
		
		}
	
		if(event.getSource() == two) {
			if(inputNumberBig == 0) {
				inputNumberBig = 2;
				displayNumber = 2;
			}
			else
				inputNumberBig = makeNumberBig(inputNumberBig, 2);
			
		}
		
		if(event.getSource() == three){
			if(inputNumberBig == 0) {
				inputNumberBig = 3;
				displayNumber = 3;
			}
			else
				inputNumberBig = makeNumberBig(inputNumberBig, 3);
		}
		
		if(event.getSource() == four){
			if(inputNumberBig == 0) {
				inputNumberBig = 4;
				displayNumber = 4;
			}
			else
				inputNumberBig = makeNumberBig(inputNumberBig, 4);
		}
		
		if(event.getSource() == five){
			if(inputNumberBig == 0) {
				inputNumberBig = 5;
				displayNumber = 5;
			}
			else
				inputNumberBig = makeNumberBig(inputNumberBig, 5);
		}
		
		if(event.getSource() == six){
			if(inputNumberBig == 0) {
				inputNumberBig = 6;
				displayNumber = 6;
			}
			else
				inputNumberBig = makeNumberBig(inputNumberBig, 6);			
		}
		
		if(event.getSource() == seven){
			if(inputNumberBig == 0) {
				inputNumberBig = 7;
				displayNumber = 7;
			}
			else
				inputNumberBig = makeNumberBig(inputNumberBig, 7);
		}
		
		if(event.getSource() == acht){
			if(inputNumberBig == 0) {
				inputNumberBig = 8;
				displayNumber = 8;
			}
			else
				inputNumberBig = makeNumberBig(inputNumberBig, 8);
		}
		
		if(event.getSource() == nine){
			if(inputNumberBig == 0) {
				inputNumberBig = 9;
				displayNumber = 9;
			}
			else
				inputNumberBig = makeNumberBig(inputNumberBig, 9);
		}
		
		if(event.getSource() == zerro){
			if(inputNumberBig == 0) {
				inputNumberBig = 0;
				displayNumber = 0;
				}
			else
				inputNumberBig = inputNumberBig * 10;
		}
		
		if(event.getSource() == plus) {			
			if (storeNumber != 0){
				if(plusBool) {
					storeNumber = storeNumber + inputNumberBig;
					inputNumberBig = 0;
				}
				if(minusBool) {
					storeNumber = storeNumber - inputNumberBig;
					inputNumberBig = 0;
				}
			}
			else
				storeNumber = inputNumberBig;
				inputNumberBig = 0;
			plusBool = true;
			minusBool = false;
			
			}
		
// + en - knoppen zetten waarde weg. De ingegeven waarde worde weggeschreven in een store (storeNumber),
// en er wordt een waarde op geteld als er al een andere waarde weggeschreven was. 
// Als er al een waarde weg geschreven was betekend dit automatisch dat er op of afgetrokken moet worden. 
// Welke van de 2 wordt betaald door booleans plusBool en minusBool.
		if(event.getSource() == minus) {
			if (storeNumber != 0){
				if(plusBool) {
					storeNumber = storeNumber + inputNumberBig;
					inputNumberBig = 0;
				}
				if(minusBool) {
					storeNumber = storeNumber - inputNumberBig;
					inputNumberBig = 0;
				}
			}
			else
				storeNumber = inputNumberBig;
				inputNumberBig = 0;
			plusBool = false;
			minusBool = true;
		}
			
// De complete of = knop gebruikt de zelfde booleans om te bepalen wat het totaal word.
// Deze heet displayNumber. Deze worde gelijk aan storeNumber, aangezien daar de berekeningen in 
// gedaan worden.
		if(event.getSource() == complete) {
			if (storeNumber != 0){
				if(plusBool) {
					storeNumber = storeNumber + inputNumberBig;
					inputNumberBig = 0;
				}
				if(minusBool) {
					storeNumber = storeNumber - inputNumberBig;
					inputNumberBig = 0;
				}
			}
		displayNumber = storeNumber;
		
		}
		
// De Ac of clear zet alle waarden op 0 of false.
		if(event.getSource() == clear) {
			inputNumber = 0; 
			inputNumberBig = 0;
			storeNumber = 0;
			displayNumber = 0;
			plusBool = false;
			minusBool= false;
		}
		
// Maak scherm opnieuw op.
		repaint();
	
	}	
	
}
