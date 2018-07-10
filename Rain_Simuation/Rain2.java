import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Could have set the x and y positions into a 2D array or an arraylist just so that it is less actual coding. 
 *
 **/

public class Rain2 extends JPanel implements ActionListener{
	Timer t = new Timer(100, this); //Had to change the increase the timers so that the objects appear slower.
	private double[] x_position = new double[100]; //used for random position on x-axis
	private double[] y_position = new double[100]; //Needed y positions to all be at zero initially 
	private double[] Velocity = new double[100]; //Array of random velocities that can be called.
	Random ran = new Random();	
	
	public void Vel(){
		for(int i=0;i<Velocity.length;i++){
			Velocity[i]=Math.random()*50; //Should fill the array with random values as the velocity to be added to the y-value later
		}
	}

	public void x_location(){
		for(int i=0;i<x_position.length;i++){
			x_position[i]=ran.nextInt(500); //Product a random set of integers on the x-axis
		}
	}
	
	public void paintComponent(Graphics g){
		t.start();
		Vel(); //Called so that the velocities are set
		x_location(); //Called to set the x-values
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; 
		g2.setColor(Color.CYAN); //Create a simple background color
		g2.fillRect(0,0,525,350);
		
		g2.setColor(Color.BLUE);
		for(int i =0;i<100; i++){
			Ellipse2D s = new Ellipse2D.Double(x_position[i],y_position[i],10,15);
			g2.fill(s);
		}

	}
	public void actionPerformed(ActionEvent e){
		for(int i=0;i<Velocity.length;i++) {
			if(y_position[i]>350){
				y_position[i] = 0;
			}
			y_position[i]+=Velocity[i];
			repaint();		
		}
	}
}
