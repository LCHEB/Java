package day11.homework;

import java.util.Scanner;

public class Homework1 {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/* 고등 학생 성적을 관리하는 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 학생 관리
		 *  - 학생 추가 : 동일한 학생(학년,반,번호가 같은)이 있으면 안됨
		 *  - 학생 수정
		 *  - 학생 삭제
		 * 2. 성적 관리
		 *  - 성적 추가 : 과목과 점수를 입력
		 *  - 성적 수정
		 *  - 성적 삭제
		 * 3. 프로그램 종료
		 * 
		 * - Student 클래스
		 * - Subject 클래스
		 *  - 쉬운 버전 : 과목명, 총점
		 * 	- 어려운 버전 : 과목명, 성적(중간, 기말, 수행평가, 총점) 
		 */
		Student []stds = new Student[5];
		stds[0] = new Student(1, 1, 1, "홍길동");
		stds[1] = new Student(1, 1, 2, "임꺽정");
		
		stds[0].insertSubject("국어", 100);
		stds[0].insertSubject("영어", 50);
		stds[1].insertSubject("국어", 90);
		stds[1].insertSubject("수학", 10);
		
		stds[0].print();
		stds[1].print();
		
		stds[0].updateSubject("국어", 50);
		stds[0].deleteSubject("영어");
		
		stds[0].print();
		int menu;
		
		do {
			printmenu();
			
			menu = scan.nextInt();
			
			runMenu(menu);
		}while(menu != 3);
		
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			student();
			break;
		case 2:
			subject();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}
	private static void subject() {
		System.out.println("1. 성적 추가");
		System.out.println("2. 성적 수정");
		System.out.println("3. 성적 삭제");
	}
	private static void student() {
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
	}
	private static void printmenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 관리");
		System.out.println("2. 성적 관리");
		System.out.println("3. 프로그램 종료");
		System.out.println("메뉴 선택 : ");
	}

}
