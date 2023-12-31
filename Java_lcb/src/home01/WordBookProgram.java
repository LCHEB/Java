package home01;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


public class WordBookProgram implements WordBook {
	static Scanner scan = new Scanner(System.in);
	static HashMap<String, String> wordbook = new HashMap<String, String>();
	@Override
	public void run() {
		int menu = 0;
		do {
			//메뉴 출력
			printMenu();
			try {
			//메뉴 입력
				menu = scan.nextInt();
			//메뉴 실행
			runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != 4);
	}
	

	@Override
	public void printMenu() {
		System.out.println("-----------메뉴---------");
		System.out.println("1. 단어 관리");
		System.out.println("2. 뜻 관리");
		System.out.println("3. 단어 조회");
		System.out.println("4. 종료");
		System.out.println("-----------------------");
		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			wordManager();
			break;
		case 2:
			meanManager();
			break;
		case 3:
			printManager();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}

	}

	public void printManager() {
		System.out.print("조회할 단어 : ");
		String word = scan.next();
		if(wordbook.containsKey(word) == true) {
			System.out.println(wordbook.get(word));
		}else {
			System.out.println("등록되지 않은 단어입니다.");
		}
	}


	public void meanManager() {
		// TODO Auto-generated method stub
		
	}


	public void wordManager() {
		//단어 관리 메뉴를 출력
			printWordMenu();
			//단어 관리 메뉴를 선택
			int menu = scan.nextInt();
			//단어 관리 메뉴를 실행
			runWordMenu(menu);
		
	}


	public void runWordMenu(int menu) {
		switch(menu) {
		case 1:
			insertWord();
			break;
		case 2:
			updateWord();
			break;
		case 3:
			//deleteWord();
			break;
		default:
			throw new InputMismatchException();
		}
		
	}


	private void updateWord() {
		System.out.print("단어 입력 : ");
		String word = scan.next();
		
	}


	public void insertWord() {
		System.out.println("단어 입력 : ");
		String word = scan.next();
		if(wordbook.containsKey(word) == true) {
			System.out.println("이미 등록된 단어입니다.");
		}else {
			System.out.print("뜻 입력 : ");
			String mean = scan.next();
			wordbook.put(word, mean);
			
		}
	}


	public void printWordMenu() {
		System.out.println("----------단어 관리--------");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("-----------------------");
		System.out.print("메뉴 선택 : ");
		
	}




}
