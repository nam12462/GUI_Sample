import java.util.*;

public class Calculator {
	static double a;
	static double b;
	static String operator;
	static double answer;
	
	public static double addition(double a2, double b2) {
		answer = a2 + b2;
		return answer;
	}
	public static double subtration(double a2, double b2) {
		answer = a2 - b2;
		return answer;
	}
	public static double multiplication(double a2, double b2) {
		answer = a2 * b2;
		return answer;
	}
	public static double division(double a2, double b2) {
		answer = a2 / b2;
		return answer;
	}
	
	public static void Calculator(double a2, double b2, String x) {
		if(x.equals("+")) {
		addition(a2,b2);
		System.out.println(answer);
		}else if(x.equals("-")) {
			subtration(a2,b2);
			System.out.println(answer);
		}else if(x.equals("*")) {
			multiplication(a2, b2);
			System.out.println(answer);
		}else if(x.equals("/")) {
			division(a2, b2);
			System.out.println(answer);
		}else {
			System.out.println("Not an operation currently acceptable.");
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("First number: ");
		a = scan.nextDouble();
		System.out.println("Second Number: ");
		b = scan.nextDouble();
		System.out.println("Operation Symbol(+, -, *, /): ");
		operator = scan.next();
		scan.close();
		Calculator(a,b, operator);
	}

}
