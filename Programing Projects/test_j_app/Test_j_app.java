/*
 * @(#)Test_j_app.java 1.0 04/06/15
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_1\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */
package myprojects.test_j_app;

import java.awt.*;
import java.awt.event.*;

class Test_j_app extends Frame {
	
	public Test_j_app() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String args[]) {
		System.out.println("Starting Test_j_app...");
		Test_j_app mainFrame = new Test_j_app();
		mainFrame.setSize(400, 400);
		mainFrame.setTitle("Test_j_app");
		mainFrame.setVisible(true);
	}
}
