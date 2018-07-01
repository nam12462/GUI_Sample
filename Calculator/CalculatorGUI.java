import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Originally this was a 4 function calculator, but now it should include the basic calculator functions from (+,-,*,/,"+/-",0.0)
 * 	Adding the positive and negative button/function was simple; the decimal point button caused a little bit of issue,
 *  by throwing a error and clearing the textfield but to solve this simply the text in the textfield was concatenated with a "." and it worked.
 *  Wanted to set the decimal point so that if the first number was a decimal point would come after a "0," but that caused more issue and needs to be researched more.
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
	private final JButton neg;
	private final JButton dec;
	
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
		Operators.setLayout(new GridLayout(3,2));
		addi = new JButton("+");
		addi.addActionListener(this);
		sub = new JButton("-");
		sub.addActionListener(this);
		mul = new JButton("*");
		mul.addActionListener(this);
		div = new JButton("/");	
		div.addActionListener(this);
		neg = new JButton("+/-");
		neg.addActionListener(this);
		dec = new JButton(".");
		dec.addActionListener(this);
		Operators.add(addi);
		Operators.add(sub);
		Operators.add(mul);
		Operators.add(div);
		Operators.add(neg);
		Operators.add(dec);
		
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
		}if(arg.equals("+/-")){
			//Had to assign the negative button to variable b so that it can be taken as second input,
			// where as if it was var a then the program wouldn't allow the 
			//second input to be negative and would just reassign the value back to var a and process from there.
			b=Double.parseDouble(text.getText());
			b = b * -1;
			text.setText(Double.toString(b));
		}if(arg.equals(".")){
				text.setText(text.getText() + ".");
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
					showMessageDialog();
					text.setText(""); // Clear the text field
					result = 0; //reset the result
				}else {
					text.setText(Double.toString(result));
				}
			}

		}

	}

	private void showMessageDialog() {
		System.out.println("undefined");
		
	}
}
