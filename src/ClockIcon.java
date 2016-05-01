import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockIcon {

	public static void main(String[] args) {

		int CLOCKSIZE = 500;
		double DEGREES_EACH_SECOND = 6;
		double DEGREES_EACH_MINUTE = 0.1;
		double DEGREES_EACH_HOUR = 0.001667;
		GregorianCalendar current = new GregorianCalendar();
		JFrame frame = new JFrame();
		System.out.println(current.getTime());
		final MoveableShape shape = new ClockShape(0, 0, CLOCKSIZE, 
				current.get(Calendar.SECOND),
				current.get(Calendar.MINUTE),
				current.get(Calendar.HOUR));
		CircleIcon circleicon = new CircleIcon(shape, CLOCKSIZE);
		final JLabel label = new JLabel(circleicon);
		
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
		
		final int DELAY = 1000;
		Timer t = new Timer(DELAY, new
		         ActionListener()
		         {
		            public void actionPerformed(ActionEvent event)
		            {
		               shape.translate(DEGREES_EACH_SECOND, DEGREES_EACH_MINUTE, DEGREES_EACH_HOUR);
		               label.repaint();
		            }
		         });
		         
		      t.start();
	}

}
