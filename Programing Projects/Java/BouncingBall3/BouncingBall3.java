/*
 * @(#)BouncingBall3.java 1.0 02/11/20
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_1\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */
package myprojects.bouncingball3;

import java.awt.*;
import java.awt.event.*;

class BouncingBall3 extends Frame {
	
	public BouncingBall3() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String args[]) {
		System.out.println("Starting BouncingBall3...");
		BouncingBall3 mainFrame = new BouncingBall3();
		mainFrame.setSize(400, 400);
		mainFrame.setTitle("BouncingBall3");
		mainFrame.setVisible(true);
	}
}
