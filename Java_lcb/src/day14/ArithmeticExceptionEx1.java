package day14;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticExceptionEx1 {

	public static void main(String[] args) {
		//두 정수와 산술 연산자를 입력받아 산술연산하는 코드를 작성하세요.
		//단, 0으로 나눌 때 예외처를 적용
		
		Scanner scan = new Scanner(System.in);
		
		int num1 , num2;
		char operator;
		try {
			System.out.println("두 정수 입력 : ");
			num1 = scan.nextInt();
			operator = scan.next().charAt(0);
			num2 = scan.nextInt();
			switch(operator) {
			case '+' : System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
				break;
			case '-' : System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
				break;
			case '*' : System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));	
				break;
			case '%' : System.out.println(num1 + "%" + num2 + "=" + (num1 % num2));
				break;
			case '/' : System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
				break;
			}
			String pattern = "{0} {1} {2} = {3}";
			System.out.println(MessageFormat.format(pattern, num1, operator, num2));
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누면 안됩니다.");
		}catch(InputMismatchException e) {
			System.out.println("입력을 잘 못했습니다.");
		}
	}

}
