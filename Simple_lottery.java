import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The point of this program is to create a gui that will print out a fixed number of random
 * numbers from a certain range
 * 
 * edit: needs to have a way to check the array for duplicates, have not figured out a way yet. If done, should be placed in the fill method
 *
 */

public class Simple_lottery extends JFrame implements ActionListener{

	static int min = 1; //minium number that can be generated
	static int max = 69; //maxium number that can be generated
	static int power = 26;
	static int[] array = new int[5]; //declare the size of the array
	static int ran;
	static int pball;
	private static final int W = 600; //width of the Jframe
	private static final int L = 100; //Length of the Jframe
	private JTextField output1;
	private JTextField output2;
	private JTextField output3;
	private JTextField output4;	
	private JTextField output5;
	private JTextField powerb;
	
	public static int rng(int min, int max){
		//Should generate a number between 1 and 69
		ran = ((int)(Math.random()*(max-min))) + min;
		return ran;
	}
	
	public static int rngp(int min, int power){
		//Should generate a number between 1 and 26
		pball = ((int)(Math.random()*(power-min))) + min;
		return pball;
	}
	
	
	/***
	public static void check(){
		//The problem with this method is that it does check,
		// but once a value has already been checked it wont check the previous values if it had already been used
		for(int i=0;i<array.length;i++){
			for(int j=1;j<array.length;j++){
				if(array[i] == array[j]){
					array[j]=rng(min,max);
				}
			}
		}
		return;
	}
	***/
	
	public static void fill(){
		//Will fill an array with values from the 1-69 range
		//EDIT: need to figure out a way to check for duplicates.
		for(int i=0;i<array.length;i++){
			array[i]=rng(min,max);
		}
		//check();
		return;
	}
	
	public Simple_lottery(String Title){
		super(Title);
		setLayout(new FlowLayout());
		setSize(W,L);
		setBackground(Color.BLUE);
		
		//Start button
		JButton start = new JButton("Drop");
		start.setBackground(Color.RED);
		start.setForeground(Color.WHITE);
		add(start);
		start.addActionListener(this);
		
		//Clear button
		JButton clear = new JButton("clear");
		clear.setBackground(Color.RED);
		clear.setForeground(Color.WHITE);
		add(clear);
		clear.addActionListener(this);
		
		//create a quit button
		JButton exit = new JButton("Exit");
		exit.setBackground(Color.RED);
		exit.setForeground(Color.WHITE);
		add(exit);
		exit.addActionListener(this);
		
		//a text field that shows the result
		output1 = new JTextField(5);
		add(output1);
		output2 = new JTextField(5);
		add(output2);
		output3 = new JTextField(5);
		add(output3);
		output4 = new JTextField(5);
		add(output4);
		output5 = new JTextField(5);
		add(output5);
		powerb = new JTextField(10);
		add(powerb);
	}
	
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		if (arg.equals("Drop")){
			fill();
			output1.setText(String.valueOf(array[0]));
			output2.setText(String.valueOf(array[1]));
			output3.setText(String.valueOf(array[2]));
			output4.setText(String.valueOf(array[3]));
			output5.setText(String.valueOf(array[4]));
			powerb.setText("Power Ball: " + String.valueOf(rngp(power,min)));
			
		}else if (arg.equals("clear")){
			output1.setText("");
			output2.setText("");	
			output3.setText("");
			output4.setText("");
			output5.setText("");
			powerb.setText("");
		}else{
			System.exit(0);
		}
	}	
	
	
	public static void main(String args[]){
		//Test to see if the rng will work with the max and min 
		//System.out.println(rng(min,max));
		//for(int i =0;i<array.length;i++){
			//This fills the array with rng numbers
		//	array[i] = rng(min,max);
		//}
		//for(int q =0;q<array.length;q++){
		//	//Prints out the rng numbers in the array
		//	System.out.println("In the array: " + array[q]);
		//}
		//fill();
		//for(int i=0;i<array.length;i++){
		//System.out.println(array[i]);
		//}
		Simple_lottery x = new Simple_lottery("Simple Lottery");
		x.setVisible(true);
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	

}
