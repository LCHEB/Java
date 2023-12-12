package day03;

import java.util.Scanner;

public class ForUpDownEx1 {

	public static void main(String[] args) {
		/* 숫자 업다운 게임을 작성하세요.
		 * 랜덤으로 생성된 숫자를 맞추는 게임. 1~100
		 * 예시
		 * 랜덤으로 생성된 숫자 : 30
		 * 정수 : 50
		 * Down!
		 * 정수 : 20
		 * Up!
		 * 정수 : 30
		 * 정답!
		 */
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 100;
		int r = (int)(Math.random() * (max-min+1) + min);
		
		int num = min - 1;
		
		for( ; num != r ; ) {
			System.out.print("정수 : ");
			num = scan.nextInt();
			if(num < r) {
				System.out.println("Up!");
			}else if(num > r) {
				System.out.println("Down!");
			}else {
				System.out.println("정답!");
			}
		}
		
		scan.close();

		
	}
		
		

}
