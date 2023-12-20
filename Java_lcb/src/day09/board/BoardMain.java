package day09.board;

import java.util.Scanner;

public class BoardMain {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/* 게시판에서 게시글 관리를 위한 콘솔 프로그램 작성하세요.
		 *  제한사항 정리
		 *   - 게시판은 1개
		 *   - 로그인, 회원가입 구현 X => 게시글 작성 시 아이디를 입력
		 *   - 게시글 제목과 내용은 한 줄만 가능
		 *   - 작성일을 입력
		 * 1. 필요한 기능을 정리해서 메뉴로 출력
		 * 메뉴
		 * 게시글 목록 조회
		 * 게시글 등록
		 * 프로그램 종료
		 * 2. 기능을 구현
		 */
		int menu = 0;
		//반복문 : 프로그램 종료를 선택하지 않으면 반복
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			Scanner scan = new Scanner(System.in);
			menu = scan.nextInt();
			//선택한 기능 실행
			switch(menu) {
			case 1:
				printMenu1();
				break;
			case 2:
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 3);
		
	}
	
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 게시글 목록 조회");
		System.out.println("2. 게시글 등록");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	public static void printMenu1() {
		System.out.println("게시글 목록");
		System.out.println("메뉴");
		System.out.println("1. 게시글 상세 조회");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
		
		int menu = scan.nextInt();
		
		switch(menu) {
		//서브 메뉴가 1이면 게시글 상세 조회
		case 1:
			break;
		//서브 메뉴가 2이면 게시글 수정
		case 2:
			break;
		//서브 메뉴가 3이면 게시글 삭제
		case 3:
			System.out.println("삭제할 게시글 번호 : ");
			int num = scan.nextInt();
			System.out.println("게시글이 삭제됐습니다.");
			break;
		//서브 메뉴가 4이면 뒤로가기
		case 4:
			printMenu();
			break;
		default:
			System.out.println("잘못된 매뉴입니다.");
		}
		
	}
}
