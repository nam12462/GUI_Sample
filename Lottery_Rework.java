import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lottery_Rework extends JFrame implements ActionListener{
	/**
	 This is just a simple lottery reworked program.
	 The main difference is the array shuffler, which I used from the website: 
	 "https://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/" 

	 Something I should consider doing is setting a counter for all of the values and see how many times
	 certain values appear in the first five position of the array. This would require a counter method, maybe a spreadsheet,
	 and a few hundred test cases.
	 */

	int pBall;
	int[] list = new int[69];
	
	//Create text fields for the output to go
	private JTextField output1;
	private JTextField output2;
	private JTextField output3;
	private JTextField output4;
	private JTextField output5;
	private JTextField PBall;
	
	/**
	Used the array shuffler from this site to get the values to be random in the array.
	https://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
	**/
	public void fill_shuffle(){
		Random rng = new Random(); //Creates a random number generator
		
		//Needs to first fill the array from 1-26
		// The only reason list[i] has to be i+1 is because 0 cannot be one of the values in the array
		for(int i =0;i<list.length;i++){
			list[i]=i+1;
		}
		
		for(int j=0;j<list.length;j++){
			int position = rng.nextInt(list.length);
			int temp = list[j];
			list[j]=list[position];
			list[position] = temp;
		}
		
	}
	//Randomly selects a number from 1-26 for the powerball
	public int rng_PowerBall(){
		pBall = ((int)(Math.random()*(26-1)))+1;
		return pBall;
	}

	//Creates the layout and adds buttons and textfields to show results
	public Lottery_Rework(String Title){
		super(Title);
		setLayout(new FlowLayout());
		setSize(700,100);
		setBackground(Color.BLUE);
		
		JButton drop = new JButton("Pick");
		drop.addActionListener(this);
		add(drop);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(this);
		add(clear);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(this);
		add(exit);
		
		
		output1 = new JTextField(5);
		output2 = new JTextField(5);
		output3 = new JTextField(5);
		output4 = new JTextField(5);
		output5 = new JTextField(5);
		PBall = new JTextField(5);
		add(output1);
		add(output2);
		add(output3);
		add(output4);
		add(output5);
		add(PBall);
		
	}

	//Checks the button commands that was pressed and executed one of the following commands
	public void actionPerformed(ActionEvent e){
		String arg = e.getActionCommand();
		
		if(arg.equals("Pick")){
			fill_shuffle();
			results();
		}else if(arg.equals("Clear")){
			blank();
		}else{
			System.exit(0);
		}
	}
	
	//Extracts the first 5 values that were shuffled in the array 
	// as well as show the random power ball number
	public void results(){
		output1.setText(String.valueOf(list[0]));
		output2.setText(String.valueOf(list[1]));
		output3.setText(String.valueOf(list[2]));
		output4.setText(String.valueOf(list[3]));
		output5.setText(String.valueOf(list[4]));
		PBall.setText(String.valueOf(rng_PowerBall()));
	}
	
	//Clears the text field (not necessary)
	public void blank(){
		output1.setText("");
		output2.setText("");
		output3.setText("");
		output4.setText("");
		output5.setText("");
		PBall.setText("");
	}
	
	
}
