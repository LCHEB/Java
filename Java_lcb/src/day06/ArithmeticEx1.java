package day06;

import java.util.Scanner;

public class ArithmeticEx1 {

	public static void main(String[] args) {
		/* 랜덤으로 산수(+, -, *) 문제를 생성하여 맞추는 게임
		 * 단, 숫자 범위는 1~99, 연산자는 +, -, *
		 * 1 + 2 = 3
		 * 정답입니다.
		 * 2 * 3 = 5
		 * 틀렸습니다.
		 */
		
		int min = 1, max = 99;
		int min1 = 1, max1 = 3;
		//정수1 랜덤 생성 1 ~ 99
		int r1 = (int)(Math.random() * (max - min + 1) + min);
		//정수2 랜덤 생성 1 ~ 99
		int r2 = (int)(Math.random() * (max - min + 1) + min);
		//정수3(연산자) 랜덤 생성 1 ~ 3
		int op = (int)(Math.random() * (max1 - min1 + 1) + min1);
		Scanner scan = new Scanner(System.in);
		int num;
		switch(op) {
		case 1:
			System.out.println(r1 + " + " + r2 + " = " + " ? ");
			System.out.print("정답 입력 : ");
			num = scan.nextInt();
			if(num == r1 + r2) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("틀렸습니다.");
			}
			break;
		case 2:
			System.out.println(r1 + " - " + r2 + " = " + " ? ");
			System.out.print("정답 입력 : ");
			num = scan.nextInt();
			if(num == r1 - r2) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("틀렸습니다.");
			}
			break;
		case 3:
			System.out.println(r1 + " * " + r2 + " = " + " ? ");
			System.out.print("정답 입력 : ");
			num = scan.nextInt();
			if(num == r1 * r2) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("틀렸습니다.");
			}
			break;
		default:
			System.out.println("잘못된 연산자입니다.");
		}
		
		
		
		
		
		
		
		
		
		scan.close();
	}

}
