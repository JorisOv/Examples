import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;

public class Peg extends Component{

    private int w = 25;
    private int h = 25;
    private boolean clickable = false;
    private boolean clicked = false;
    private Color[] color =
    {
        Color.gray,    //New Color(255,0,0)
        Color.green,    //0,255,0
        Color.blue,    //0,0,255
        Color.yellow,    //0,255,255
        Color.magenta,    //255,255,0 (?)
        Color.cyan,
        Color.darkGray,
        Color.black,
        Color.white
    };

    private int index=0;

    public Peg(int x, int y) {
        setBounds(x,y,w,h);
    	setVisible(true);
    }

    public void nextColor() {
        clicked = true;
        index++;
        if (index == 6)
            index = 1;
    }

    public void paint(Graphics g){
        //System.out.println("peg.paint");
        g.setColor(color[index]);
        g.fillOval(10,10,w-1,h-1); //-1 omdat circel anders te groot is.
    }

    public int getColor()
    {
		return index;
	}

	public void setColor(int color)
	{
		index = color;
	}

	public void setClickable(boolean clickable)
	{
		this.clickable = clickable;
	}

	public boolean getClicked()
	{
		return clicked;
	}

	public void setSize(int w, int h)
	{
		this.w = w;
		this.h = h;
	}
}



