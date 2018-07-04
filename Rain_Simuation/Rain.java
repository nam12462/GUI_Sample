import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import javax.swing.Timer;

public class Rain extends JPanel implements ActionListener {
	Timer t = new Timer(5, this);
	double x = 0,y=0, VelY = .75;
	double x2 = 10,y2=0, VelY2 = 1;
	double x3 = 20,y3=0, VelY3 = 1.5;
	
	double x4 = 30,y4=0, VelY4 = 2;
	double x5 = 40,y5=0, VelY5 = 2.5;
	double x6 = 50,y6=0, VelY6 = 3;
	
	double x7 = 60,y7=0, VelY7 = 3.5;
	double x8 = 70,y8=0, VelY8 = 4;
	double x9 = 80,y9=0, VelY9 = 4.5;
	
	double x10 = 90, y10=0, VelY10 = 5;
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D square = new Rectangle2D.Double(x,y,10,10);
		Rectangle2D square2 = new Rectangle2D.Double(x2,y2,10,10);
		Rectangle2D square3 = new Rectangle2D.Double(x3,y3,10,10);
		Rectangle2D square4 = new Rectangle2D.Double(x4,y4,10,10);
		Rectangle2D square5 = new Rectangle2D.Double(x5,y5,10,10);
		Rectangle2D square6 = new Rectangle2D.Double(x6,y6,10,10);
		Rectangle2D square7 = new Rectangle2D.Double(x7,y7,10,10);
		Rectangle2D square8 = new Rectangle2D.Double(x8,y8,10,10);
		Rectangle2D square9 = new Rectangle2D.Double(x9,y9,10,10);
		Rectangle2D square10 = new Rectangle2D.Double(x10,y10,10,10);

		g2.fill(square);
		g2.fill(square2);
		g2.fill(square3);
		g2.fill(square4);
		g2.fill(square5);
		g2.fill(square6);
		g2.fill(square7);
		g2.fill(square8);
		g2.fill(square9);
		g2.fill(square10);
		t.start();
	}

	public void actionPerformed(ActionEvent e){
		
		if(y>350){
			y=0;
		}
		y+=VelY;

		if(y2>350){
			y2=0;
		}
		y2+=VelY2;

		if(y3>350){
			y3=0;
		}
		y3+=VelY3;
		
		if(y4>350){
			y4=0;
		}
		y4+=VelY4;

		
		if(y5>350){
			y5=0;
		}
		y5+=VelY5;

		if(y6>350){
			y6=0;
		}
		y6+=VelY6;
		if(y7>350){
			y7=0;
		}
		y7+=VelY7;

		
		if(y8>350){
			y8=0;
		}
		y8+=VelY8;

		if(y9>350){
			y9=0;
		}
		y9+=VelY9;
		if(y10>350){
			y10=0;
		}
		y10+=VelY10;

		repaint();
		
	}
}
