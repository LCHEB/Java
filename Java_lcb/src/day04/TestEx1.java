package day04;

import java.util.Scanner;

public class TestEx1 {

	public static void main(String[] args) {
		/* Scanner를 이용하여 국어, 영어, 수학 성적을 입력받고,
		 * 총점과 평균을 구하는 코드를 작성하세요.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("성적(영어, 국어, 수학) 입력 : ");
		int engscore = scan.nextInt();
		int korscore = scan.nextInt();
		int mathscore = scan.nextInt();
		
		System.out.println("세 성적의 합 : " + (engscore + korscore + mathscore));
		System.out.println("세 성적의 평균 : " + (double)(engscore + korscore + mathscore)/3);
		
		int sum = korscore + engscore + mathscore;
		double avg = sum/3.0;
		
		
	
		scan.close();
		
				
	}

}
