/*
 * @(#)<PROJECT_NAME>.java 1.0 <%y>/<%m>/<%d>
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_1\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */
package myprojects.<LPROJECT_NAME>;

import java.awt.*;
import java.awt.event.*;

class <PROJECT_NAME> extends Frame {
	
	public <PROJECT_NAME>() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String args[]) {
		System.out.println("Starting <PROJECT_NAME>...");
		<PROJECT_NAME> mainFrame = new <PROJECT_NAME>();
		mainFrame.setSize(400, 400);
		mainFrame.setTitle("<PROJECT_NAME>");
		mainFrame.setVisible(true);
	}
}