package home01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class WordBookProgram2 implements WordBook {
	static Scanner scan = new Scanner(System.in);
	private List<Word> list = new ArrayList<Word>();
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
		//리스트 출력
		printWord(s->true);
	}
	
	private void printWord(Predicate<Word> p) {
		for(Word std : list) {
			if(p.test(std)) {
				System.out.println("단어 : " + std.getWord() + ", 뜻 :  " + std.getMean());
			}
		}
	}

	public void meanManager() {
		//단어 관리 메뉴를 출력
		printMeanMenu();
		//단어 관리 메뉴를 선택
		int menu = scan.nextInt();
		//단어 관리 메뉴를 실행
		runMeanMenu(menu);
		
	}


	private void runMeanMenu(int menu) {
		switch(menu) {
		case 1:
			insertMean();
			break;
		case 2:
			updateMean();
			break;
		case 3:
			deleteMean();
			break;
		default:
			throw new InputMismatchException();
		}
		
	}


	private void deleteMean() {
		// TODO Auto-generated method stub
		
	}


	private void updateMean() {
		// TODO Auto-generated method stub
		
	}


	private void insertMean() {
		System.out.println("단어 입력 : ");
		String word = scan.next();
		
		//단어 등록
		if(!list.contains(word)) {
			System.out.print("뜻 입력 : ");
			String mean = scan.next();
			Word std = new Word(word, mean);
			list.add(std);
			System.out.println("단어를 등록했습니다.");
			return;
		}
		System.out.println("이미 등록된 뜻입니다.");
		
	}


	private void printMeanMenu() {
		System.out.println("----------뜻 관리--------");
		System.out.println("1. 뜻 추가");
		System.out.println("2. 뜻 수정");
		System.out.println("3. 뜻 삭제");
		System.out.println("-----------------------");
		System.out.print("메뉴 선택 : ");
		
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
			deleteWord();
			break;
		default:
			throw new InputMismatchException();
		}
		
	}


	private void deleteWord() {
		//삭제할 단어 입력
		System.out.print("단어 입력 : ");
		String word = scan.next();
		System.out.print("뜻 입력 : ");
		String mean = scan.next();
		//인스턴스 생성
		Word std = new Word(word, mean);
		//단어 삭제
		if(list.remove(std)) {
			System.out.println("단어가 삭제 되었습니다.");
		}else {
			System.out.println("등록되지 않은 단어입니다.");
		}
		
	}


	private void updateWord() {
		//기존 단어 입력
		System.out.print("단어 입력 : ");
		String word = scan.next();
		System.out.print("뜻 입력 : ");
		String mean = scan.next();
		Word std = new Word(word, mean);
		
		int index = list.indexOf(std);
		
		if(index == -1) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		
		//수정할 단어 입력
		System.out.print("수정할 단어 입력 : ");
		word = scan.next();
		System.out.print("수정할 뜻 입력 : ");
		mean = scan.next();
		Word newStd = new Word(word, mean);
		
		if(list.contains(newStd)) {
			System.out.println("이미 등록된 단어여서 수정할 수 없습니다.");
			return;
		}
		//기존 단어 삭제
		list.remove(index);
		//수정할 단어 추가
		list.add(newStd);
		
		System.out.println("단어가 수정 되었습니다.");
		System.out.println(list);
		
	}


	public void insertWord() {
		//등록할 단어 입력
		System.out.print("단어 입력 : ");
		String word = scan.next();
		System.out.print("뜻 입력 : ");
		String mean = scan.next();
		//인스턴스 생성
		Word std = new Word(word, mean);
		//단어 등록
		if(!list.contains(std)) {
			list.add(std);
			System.out.println("단어를 등록했습니다.");
			return;
		}
		System.out.println("이미 등록된 단어입니다.");
			
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
