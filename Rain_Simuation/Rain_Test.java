import javax.swing.*;

public class Rain_Test {

	public static void main (String args[]){
		Rain r = new Rain();
		JFrame f = new JFrame();
		f.add(r);
		f.setVisible(true);
		f.setSize(500,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
