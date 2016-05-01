import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.lang.Math;

public class ClockShape implements MoveableShape{

	private int x;
	private int y;
	private int width;
	private int secondHandLen = 250;
	private int minuteHandLen = 200;
	private int hourHandLen = 100;
	private double sdegrees;
	private double hdegrees;
	private double mdegrees;
	private double hourX;
	private double hourY;
	private double minuteX;
	private double minuteY;
	private double secondX;
	private double secondY;
	
	public ClockShape(int x, int y, int width, int asecond, int aminute, int ahour)
	   {
	      this.x = x;
	      this.y = y;
	      this.width = width;
	      sdegrees = asecond*6-90;
	      mdegrees = aminute*6-90;
	      hdegrees = ahour*30-90;
	   }
	
	@Override
	public void draw(Graphics2D g2) {
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, width, width);
		 
		Point2D.Double hourstart = new Point2D.Double((width/2), (width/2));
		Point2D.Double hourend = new Point2D.Double(hourX, hourY);
		Point2D.Double minutestart = new Point2D.Double((width/2), (width/2));
		Point2D.Double minuteend = new Point2D.Double(minuteX, minuteY);
		Point2D.Double secondstart = new Point2D.Double((width/2), (width/2));
		Point2D.Double secondend = new Point2D.Double(secondX, secondY);
		
		Shape hour = new Line2D.Double(hourstart, hourend);
		Shape minute = new Line2D.Double(minutestart, minuteend);
		Shape second = new Line2D.Double(secondstart, secondend);
		
		g2.draw(hour);
		g2.draw(minute);
		g2.draw(second);
		
		g2.draw(circle);
	}

	@Override
	public void translate(double adegrees, double bdegrees, double cdegrees) {
		sdegrees += adegrees;
		mdegrees += bdegrees;
		hdegrees += cdegrees;
		secondX = (width/2)+secondHandLen*(Math.cos(Math.toRadians(sdegrees)));
		secondY = (width/2)+secondHandLen*(Math.sin(Math.toRadians(sdegrees)));
		minuteX = (width/2)+minuteHandLen*(Math.cos(Math.toRadians(mdegrees)));
		minuteY = (width/2)+minuteHandLen*(Math.sin(Math.toRadians(mdegrees)));
		hourX = (width/2)+hourHandLen*(Math.cos(Math.toRadians(hdegrees)));
		hourY = (width/2)+hourHandLen*(Math.sin(Math.toRadians(hdegrees)));
	}

	@Override
	public void setColor(Color red) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void translate(int dx, int dy) {
		// TODO Auto-generated method stub
		
	}
}
