package day06;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {
		/* 다음 기능을 가진 성적 관리 프로그램을 작성하세요.
		 * -1반의 성적을 관리
		 * -최대 30명
		 * -성적은 번호순으로 관리
		 * -성적은 국어, 영어, 수학 성적을 관리
		 * 메뉴
		 * 1.성적수정
		 * 2.성적조회
		 * 3.프로그램 종료
		 * 메뉴 선택 :
		 * 
		 * --성적수정--
		 * 1. 국어
		 * 2. 영어
		 * 3. 수학
		 * 과목 선택 :
		 * 
		 * 학생 선택 : 학생 번호를 선택
		 * 성적 입력 : 100
		 *
		 * --성적조회--
		 * 1.과목별조회
		 * 2.학생별조회
		 * 선택 :
		 * --과목별조회--
		 * 1. 국어
		 * 2. 영어
		 * 3. 수학
		 * 과목 선택 :
		 * 1번 : 입력된 점수 출력
		 * 2번 : 1점
		 * 3번 : 2점
		 * ...
		 * 30번 : 100점
		 * --학생별조회--
		 * 학생 선택 : 학생번호
		 * 국어 : 0점
		 * 영어 : 0점
		 * 수학 : 0점
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		
		int menu;
		int submenu;
		int num;
		int score;
		int sub;
		int maxstudent = 30;
		int[] kor = new int[maxstudent]; 
		int[] eng = new int[maxstudent];
		int[] math = new int[maxstudent];
		do {
			System.out.println("메뉴");
			System.out.println("1. 성적수정");
			System.out.println("2. 성적조회");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			
			if(menu == 1) {
				System.out.println("--성적수정--");
				System.out.println("1. 국어");
				System.out.println("2. 영어");
				System.out.println("3. 수학");
				System.out.print("과목 선택 : ");
				submenu = scan.nextInt();
				
				
					if(submenu == 1) {
						System.out.print("학생 선택 : ");
						num = scan.nextInt();
						System.out.print("성적 입력 : ");
						score = scan.nextInt();
					}else if(submenu == 2) {
						System.out.print("학생 선택 : ");
						num = scan.nextInt();
						System.out.print("성적 입력 : ");
						score = scan.nextInt();
					}else {
						System.out.print("학생 선택 : ");
						num = scan.nextInt();
						System.out.print("성적 입력 : ");
						score = scan.nextInt();
					}
					switch(submenu) {
					case 1: kor[num - 1] = score; break;
					case 2: eng[num - 1] = score; break;
					case 3: math[num - 1] = score; break;
					}
				
				
				
				
			}else if(menu == 2) {
				System.out.println("--성적조회--");
				System.out.println("1. 과목별조회");
				System.out.println("2. 학생별조회");
				System.out.print("선택 : ");
				submenu = scan.nextInt();
				
				if(submenu == 1) {
					System.out.println("--과목별조회--");
					System.out.println("1. 국어");
					System.out.println("2. 영어");
					System.out.println("3. 수학");
					System.out.print("과목 선택 : ");
					sub = scan.nextInt();
					
					if(sub == 1) {
						for(int i = 0; i < kor.length; i++) {
							System.out.println((i+1) + "번 : " + kor[i] + "점");
						}
					}else if(sub == 2){
						for(int i = 0; i < eng.length ; i++) {
							System.out.println((i+1) + "번 : " + eng[i] + "점");
						}
					}else{
						for(int i = 0; i < math.length ; i++) {
							System.out.println((i+1) + "번 : " + math[i] + "점");
						}
					}
				}else if(submenu == 2) {
					System.out.println("--학생별조회--");
					System.out.print("학생 선택 : ");
					num = scan.nextInt();
					System.out.println("국어 : " + kor[num - 1] + "점");
					System.out.println("영어 : " + eng[num - 1] + "점");
					System.out.println("수학 : " + math[num - 1] + "점");
				}else {
					System.out.println("잘못된 메뉴입니다.");
				}
			}
		}while(menu != 3);
		System.out.println("프로그램을 종료합니다.");
		
		
		
		
		scan.close();
	}

}
