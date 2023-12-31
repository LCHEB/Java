package day10.word;

import java.util.Scanner;

import day10.board.Board;

public class WordMain2 {
	private static Scanner scan = new Scanner(System.in);
	private static Word2 [] List = new Word2[10];
	private static int count = 0; //저장된 단어 개수
	/* 영어 단어장 프로그램을 만드세요.
	 * 1. 기능정리
	 * -단어는 영어 단어와 한글 뜻으로 구성
	 * -영어 단어는 영어이고, 공백이 없는 단어
	 * -한글 뜻은 한글이고, 한 문장으로 되어 있다
	 * -한 단어에 뜻이 한개만 있다고 가정
	 * - 기능
	 * 	- 단어 등록
	 * 	- 단어 검색
	 * 	- 단어 수정
	 *  - 단어 삭제
	 * - Word 클래스
	 * 	- word : 영단어
	 * 	- meaning : 뜻
	 * 	- 단어 출력, 단어 수정, 단어 확인 : 주어진 문자열과 같은 단어인지 확인  
	 * 2. 틀 작성
	 * 	
	 * 3. 필요한 메서드 구현
	 * 
	 */
	public static void main(String[] args) {
		int menu;
		//반복문
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 메뉴에 맞는 기능 실행
			runMenu(menu);
		}while(menu != 5);
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//단어 등록 기능 구현
			insertWord();
			break;
		case 2:
			searchWord();
			break;
		case 3:
			updateWord();
			break;
		case 4:
			deletWord();
			break;
		case 5:
			System.out.println("종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}
	private static void deletWord() {
		//삭제할 단어를 입력
		System.out.print("삭제할 단어 : ");
		String word = scan.next();
		//단어장에서 단어를 삭제
		//삭제할 위치를 찾음
		//반복문 : 저장된 개수만큼
		int index = -1; //음수로 초기화, 배열의 번지는 0이상
		for(int i = 0; i < count ; i++) {
			//입력한 단어와 같으면
			if(List[i].equals(word)) {
				//현재 위치를 index에 저장
				index = 1;
				break;
			}
		}
		//일치하는 단어가 없으면
		if(index == -1) {
			//안내문구 출력후 종료
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		//저장된 단어의 개수를 1줄임
		count--;
		System.out.println("단어가 삭제됐습니다.");
		//일치하는 단어가 마지막 단어이면
		if(index == count) {
			//종료
			return;
		}
		//한칸씩 당겨옴
		//현재 배열과 같은 크기의 새 배열을 생성
		Word2[] tmpList = new Word2[List.length];
		//새 배열에 현재 배열을 복붙
		System.arraycopy(List, 0, tmpList, 0, List.length);
		//현재 배열에서 찾은 번지 다음부터 나머지 개수를 복사해서
		//새 배열에 찾은 번지부터 덮어씀
		System.arraycopy(tmpList, index + 1, List, index, count - index);
	}
	private static void updateWord() {
		//수정할 단어 입력
		System.out.println("수정할 단어 : ");
		String word = scan.next();
		//수정할 뜻 입력
		System.out.println("수정할 뜻 : ");
		scan.nextLine();
		String meaning = scan.nextLine();
		//반복문 : 저장된 개수만큼
		for(int i = 0; i < count ; i++) {
			//입력한 단어가 주어진 단어와 일치하면
			if(List[i].equals(word)) {
				//뜻을 수정하고 종료
				List[i].update(meaning);
				System.out.println("수정이 완료됐습니다.");
				return;
			}
		}
		//일치하는 단어가 없습니다라고 출력
		System.out.println("일치하는 단어가 없습니다.");
		
	}
	private static void searchWord() {
		//검색할 단어 입력
		System.out.println("단어 입력 : ");
		String word = scan.next();
		//단어장에서 검색해서 결과를 출력
		//반복문 : 저장된 개수만큼
		for(int i = 0; i < count ; i++ ) {
			//단어장에 단어가 주어진 단어와 일치하면
			if(List[i].equals(word)) {
				//출력 후 종료
				List[i].print();
				return;
			}
		}
		//단어가 없다고 출력
		System.out.println("일치하는 단어가 없습니다.");
		
		}
	
	private static void insertWord() {
		//단어와 뜻 입력
		System.out.print("단어 입력 : ");
		String word = scan.next();
		System.out.print("뜻 입력 : ");
		scan.nextLine(); //엔터 처리
		String meaning = scan.nextLine();
		
		//단어와 뜻을 이용하여 Word의 인스턴스를 생성
		Word2 tmp = new Word2(word, meaning);
		//위에서 생성한 인스턴스를 단어장에 저장
		List[count] = tmp;
		//저장된 단어의 개수를 1증가
		++count;
		
		//테스트용으로 단어장 목록 출력
		for(int i = 0; i < count; i++) {
			List[i].print();
		}
		
		//단어장이 꽉 차면 단어장 크기를 늘림
		if(count == List.length) {
			expandWordList();
		}
	}
	
	private static void expandWordList() {
		//기존 단어장보다 큰 단어장 생성
		Word2[] tmpList = new Word2 [List.length + 10];
		//새 단어장에 기존 단어들을 복붙
		System.arraycopy(List, 0, tmpList, 0, count);
		//새 단어장을 내 단어장이라고 선언
		List = tmpList;
	}
	private static void printMenu() {
		System.out.println("-----------------");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 검색");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
	}
	
}
