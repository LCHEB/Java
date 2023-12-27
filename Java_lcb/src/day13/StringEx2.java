package day13;

import java.util.Scanner;

public class StringEx2 {

	private static Scanner scan = new Scanner(System.in);
	static String []List = new String[30];
	static int count = 0;
	public static void main(String[] args) {
		/* 문장들을 입력받아 배열에 저장하고, 특정 단어가 들어가있는 문잘들을 출력하는 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 문장 추가
		 * 2. 검색
		 * 3. 종료
		 */
		
		/* 안녕하세요
		 * 테스트
		 * 만나서 반갑습니다.
		 * 나는 홍길동입니다.
		 * 
		 * 나로 검색
		 * 
		 * 만나서 반갑습니다.
		 * 나는 홍길동입니다.
		 */
		int menu;
		do {
			printMenu();
			
			menu = scan.nextInt();
			
			runMenu(menu);
		}while(menu != 3);
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			search();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
			
		}
	}

	private static void search() {
		//단어 입력
		System.out.print("단어 입력 : ");
		String Line = scan.next();
		//검색
		for(String tmp : List) {
			if(tmp != null && tmp.contains(Line)) {
				System.out.println(tmp);
			}
		}
	}

	private static void insert() {
		//문장 입력
		System.out.print("문장 입력 : ");
		scan.nextLine();
		String Line = scan.nextLine();
		//문자 추가
		List[count] = Line;
		count++;
		
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 문장 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}

}
