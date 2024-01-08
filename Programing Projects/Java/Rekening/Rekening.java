/*
 * @(#)Rekening.java 1.0 02/11/30
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_2\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Rekening extends Applet implements ActionListener{
private BankRekening klantEen;
	private TextField input;
	private Label output;
	
	public void init() {
		setLayout(null);
		input = new TextField("", 10);
		input.setBounds(150, 20, 60, 50);
		add(input);
		input.addActionListener(this);
		
		output = new Label("");
		output.setBounds(150, 80, 60, 50);
		add(output);
		
		klantEen = new BankRekening();
	}

	public void actionPerformed(ActionEvent event) {
	if(event.getSource() == input){
			//updateSaldo
			int change = Integer.parseInt(input.getText());
			klantEen.updateSaldo(change);
			tekenSaldo(klantEen.getSaldo());
			repaint();
		}
	}
	
	public void tekenSaldo( float saldo ) {
		output.setText("" + saldo );
		this.repaint();
		if(tekenSaldo(klantEen.getSaldo()) >= 0)
			setBackground(Color.green);
		else
			setBackground(Color.red);
	}
	
	
	
	public void paint(Graphics g) {
	
	}
}
