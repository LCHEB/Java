package day14;

import java.text.MessageFormat;
import java.util.Scanner;

public class ArithmeticExceptionEx2 {

	public static void main(String[] args) {
		//두 정수와 산술연사자를 입력받아 결과를 출력하는 메서드를 구현하세요. 
		//단, 메서드를 이용,throws와 throw를 이용
		Scanner scan = new Scanner(System.in);
		try {
		System.out.print("정수 입력 :");
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		double res = arithmeticCaculator(num1, operator, num2);
		String pattern = "{0} {1} {2} = {3}";
		System.out.println(MessageFormat.format(pattern, num1, operator, num2, res));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static double arithmeticCaculator(int num1, char operator, int num2) {
		switch(operator) {
		case '+' : return num1 + num2;
		case '-' : return num1 - num2;
		case '*' : return num1 * num2;
		case '%' : if(num2 == 0) {
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		}
			return num1 % num2;
		case '/' : if(num2 == 0) {
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		}
			return num1 / (double)num2;
		default:
			throw new RuntimeException(operator + "산술 연산자가 아닙니다.");
			}
	}
}
