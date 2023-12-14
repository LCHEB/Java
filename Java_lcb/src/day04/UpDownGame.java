package day04;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		/* Up Down 게임을 구현하세요.
		 * - 다음과 같은 메뉴를 가져야 합니다.
		 * 1. 새게임
		 * 2. 최고기록 확인
		 * 3. 프로그램 종료
		 * 
		 * - 새게임은 업다운 게임을 시작
		 * 	- 랜덤으로 생성된 수를 맞추는 게임
		 * 	- 맞췄을 때 맞춘 회수를 출력하고 메뉴로 돌아감
		 * - 최고기록 확인 업다운 게임을 하면서 맞춘 횟수 중 가장 적은 횟수를 알려줌
		 */
		
		//반복문 -
			// 메뉴를 출력
		
			// 메뉴를 선택
		
			//선택한 메뉴에 따라 기능을 실행
			
			//1번메뉴 선택
			
				//업다운 게임을 실행
				//랜덤한 수 생성
				//반복문
				
					//정수 입력
					//입력회수를 1증가
					//입력한 정수와 랜덤한 수 비교 후 up/down 출력
				
				//게임이 끝났으면 현재 횟수과 최고기록 회수보다 좋으면 
				
					//최고 기록회수를 현재 횟수로 수정
					
				
				
			//2번메뉴 선택
			
				//최고기록을 출력
				
		
			//3번메뉴 선택
			
				//프로그램을 종료
				
			
		Scanner scan = new Scanner(System.in);
		int menu;
		int count , bestcount = -1;
		int min = 1, max = 100;
		int num = min - 1;
		
		do {
			System.out.println("메뉴");
			System.out.println("1. 새게임");
			System.out.println("2. 최고기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
		
		if(menu == 1) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			System.out.println(r);
			count = 0;
			for( ; num != r ; ) {
				System.out.print("정수 : ");
				num = scan.nextInt();
				count++;
				if(num < r) {
					System.out.println("Up!");
				}else if(num > r) {
					System.out.println("Down!");
				}else {
					System.out.println("정답!");
				}
			}
			System.out.println("기록 : "+ count);
			if (bestcount == -1 || count < bestcount) {
				bestcount = count;
			}
		}else if(menu == 2) {
			System.out.println("최고 기록 :  " + bestcount);
			
		}
		}while(menu != 3);
		System.out.println("프로그램을 종료합니다.");
		
		
		scan.close();
	}

}
