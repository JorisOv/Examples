import java.awt.Color;
import java.awt.MouseListener;
import java.awt.MouseEvent;

public class Control implements MouseListener{
	
	private MyFrame myFrame = null;
	Peg p = new peg(50,50);
	
	public Control(MyFrame mf){
		myframe =mf;
		p.addMouseListener(this);
		myFrame.add(p)
		myframe.repaint();
	}
	
	public void mouseExited(MouseEvent e){
		System.out.println("Control.mouseExited");
	}
	
	public void mouseEntered(MouseEvent e){
		System.out.println("Control.mouseEntered");
	}
	public void mousePressed(MouseEvent e){
		System.out.println("Control.mousePressed");
	}
	public void mouseReleased(MouseEvent e){
		System.out.println("Control.mouseReleased");
	}	
	public void mouseClicked(MouseEvent e){
		System.out.println("Control.mouseClicked");
		p.nextColor();
	}
	
}