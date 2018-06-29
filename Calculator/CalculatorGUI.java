import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * After testing a few cases appeared that needs to be addressed.
 * First off when the result is shown the value is returned as a double, 
 *  any value that is after the decimal point cannot be altered and would have to be cleared so that. 
 * Or a decimal button could be added to account for decimal values. 
 * EX) 1/2=.5 .5+1=1.5
 * The next case is that when a value is divided by 0,
 *  there needs to be a statement that will appear in the result section saying the value is undefined.
 * EX) 1/0 = infinity or 1-2=-1/0=-infinity a simple checker would fix this issue. 
 * 		Issue is however, when the undefined statement is thrown and other operations are selected without clearing the textField
 * 		errors will appear because you cannot parse a string into a double. 
 * 		Need to research how to fix this. Maybe change the textField to zero?
 * The next potential addition could be a positive and negative button to account for negative values.
 * Over all a little more research would help.
**/
public class CalculatorGUI extends JFrame implements ActionListener {
	private final int width = 300;
	private final int height = 200;
	private final JButton addi;
	private final JButton sub;
	private final JButton mul;
	private final JButton div;
	private final JButton eql;
	private final JButton clr;
	
	private TextField text;

	private static final int[] order = {7,8,9,4,5,6,1,2,3,0};//Used to align the number buttons correctly.
	static double a=0; //Used to collect the initial value in the textField.
	static double b=0; //Used to collect the second value in the textField after an operation is selected.
	static double result=0; //Used to display the final value from A and B.
	static int operatorSelected = 0; //Used an in indicator to determine what operation was selected.
	
	public CalculatorGUI(){
		setTitle("Calculator");
		setLayout(new BorderLayout());
		setSize(width,height);
		setResizable(false);
		
		//Create a panel for the textField
		text = new TextField(10);
		text.setEditable(false);
		add(text, BorderLayout.NORTH);
		
		// Create a panel to place the numbers in
		JPanel Numbers = new JPanel();
		Numbers.setLayout(new GridLayout(4,3));
		JButton[] num = new JButton[10];
		for(int i=0;i<order.length;i++) {
			num[i] = new JButton(String.valueOf(order[i]));
			num[i].addActionListener(this);
			Numbers.add(num[i]);
		}
		eql = new JButton("=");
		eql.addActionListener(this);
		clr = new JButton("c");
		clr.addActionListener(this);
		Numbers.add(clr);
		Numbers.add(eql);

		//Create a panel to put in the operators
		//Should be done recursively, potentially using an array?
		JPanel Operators = new JPanel();
		Operators.setLayout(new GridLayout(4,1));
		addi = new JButton("+");
		addi.addActionListener(this);
		sub = new JButton("-");
		sub.addActionListener(this);
		mul = new JButton("*");
		mul.addActionListener(this);
		div = new JButton("/");	
		div.addActionListener(this);
		Operators.add(addi);
		Operators.add(sub);
		Operators.add(mul);
		Operators.add(div);
		
		//Create a panel to place the numbers and operators
		JPanel all_Buttons = new JPanel();
		all_Buttons.setLayout(new FlowLayout());
		all_Buttons.add(Numbers);
		all_Buttons.add(Operators);
		add(all_Buttons, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		//Way to recursively add numbers into the textField when a button is pressed.
		for(int i=0;i<10;i++) {
			if(arg.equals(String.valueOf(i))) {
				text.setText(text.getText() + i);
			}
		}
		//Clear the text field
		if(arg.equals("c")) {
			text.setText("");
		}
		//Extracts the value in the textField and assign it to variable A
		//Then change the operator to indicate what operation was selected.
		//And finally clear the textField for new input
		if(arg.equals("+")) {
			a=Double.parseDouble(text.getText());
			operatorSelected = 1;
			text.setText("");
		}if(arg.equals("-")) {
			a=Double.parseDouble(text.getText());
			operatorSelected = 2;
			text.setText("");
		}if(arg.equals("*")) {
			a=Double.parseDouble(text.getText());
			operatorSelected = 3;
			text.setText("");
		}if(arg.equals("/")) {
			a=Double.parseDouble(text.getText());
			operatorSelected = 4;
			text.setText("");
		}if(arg.equals("=")) {
			//When the equal button is pressed,
			// the text in the textField is taken as the second input for the calculator and assigned to variable B
			//Then the operation that was selected is checked and the result is determined, and displayed in the textField.
			b=Double.parseDouble(text.getText());
			if(operatorSelected == 1) {
			result = a + b;
			text.setText(Double.toString(result));
			}else if(operatorSelected == 2) {
			result = a - b;
			text.setText(Double.toString(result));
			}else if(operatorSelected == 3) {
			result = a * b;
			text.setText(Double.toString(result));
			}else if(operatorSelected == 4) {
			result = a / b;
				if(b==0) {
					text.setText("undefined");
				}else {
					text.setText(Double.toString(result));
				}
			}

		}

	}
}
