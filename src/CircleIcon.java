import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class CircleIcon implements Icon{

	private int width;
	private MoveableShape shape;
	
	public CircleIcon(MoveableShape shape, int aWidth)
	{
		this.shape = shape;
		width = aWidth;
	}

	public void paintIcon(Component c, Graphics g, int x, int y)
	{
	 Graphics2D g2 = (Graphics2D)g;
	 shape.draw(g2);
	}


	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return width;
	}


	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return width;
	}
}
