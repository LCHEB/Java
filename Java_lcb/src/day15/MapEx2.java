package day15;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MapEx2 {
	static Scanner scan = new Scanner(System.in);
	static Map<String, String> map = new HashMap<String, String>();
	public static void main(String[] args) {
		/* 회원을 관리하는 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 회원가입
		 * 	- 아이디와 비번만 입력
		 * 	- 이미 가입된 회원인지 체크(containsKey)
		 * 2. 회원검색
		 * 	- 아이디를 입력해서 회원 정보를 조회
		 * 3. 종료
		 */
		int menu = 0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
		}catch(InputMismatchException e) {
			System.out.println("잘못된 메뉴입니다.");
			scan.nextLine();
		}
		}while(menu != 3);
		
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertMember();
			break;
		case 2:
			searchMember();
			break;
		case 3:
			System.out.println("종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private static void searchMember() {
		System.out.print("아이디 : ");
		String id = scan.next();
		String pw = map.get(id);
		if(pw == null) {
			System.out.println("없는 회원입니다.");
		}
		System.out.println("아이디 : " + id + "비번 : " + pw);
	}

	private static void insertMember() {
		System.out.print("아이디 : ");
		String id = scan.next();
		if(map.containsKey(id)) {
			System.out.println("중복 아이디입니다.");
			return;
		}
		System.out.print("비번 : ");
		String pw = scan.next();
		
		map.put(id, pw);
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원검색");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}

}
