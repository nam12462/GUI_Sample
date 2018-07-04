import javax.swing.JFrame;

public class Rain2_Test {

	public static void main (String args[]){
		Rain2 r2 = new Rain2();
		JFrame q = new JFrame();			
		q.add(r2);
		q.setVisible(true);
		q.setResizable(false);
		q.setSize(525,350);
		q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}