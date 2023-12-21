package day10.word;

import java.util.Scanner;

import day10.board.Board;

public class WordMain {
	private static Scanner scan = new Scanner(System.in);
	private static Word [] wordList = new Word[10];
	private static int count = 0;
	/* 영어 단어장 프로그램을 만드세요.
	 * 제한사항
	 * 
	 * 1. 기능정리
	 * 메뉴
	 * 1. 단어 조회
	 * 2. 단어 등록
	 * 메뉴 선택 : 1
	 * 
	 * 메뉴
	 * 1.단어 검색
	 * 2.단어 수정
	 * 3.단어 삭제
	 * 4.뒤로 가기
	 * 메뉴 선택 : 1
	 * 
	 * 검색할 단어 입력 : apple
	 * 뜻 : 사과
	 * 
	 * 메뉴
	 * 1.단어 조회
	 * 2.단어 수정
	 * 3.단어 삭제
	 * 4.뒤로 가기
	 * 메뉴 선택 : 2
	 * 
	 * 수정할 단어 입력 : apple
	 * 수정할 뜻 입력 : 사과
	 * 수정했습니다.
	 * 
	 * 메뉴
	 * 1.단어 조회
	 * 2.단어 수정
	 * 3.단어 삭제
	 * 4.뒤로 가기
	 * 메뉴 선택 : 3
	 * 
	 * 삭제할 단어 입력 : apple
	 * 삭제했습니다.
	 * 
	 * 메뉴
	 * 1.단어 조회
	 * 2.단어 수정
	 * 3.단어 삭제
	 * 4.뒤로 가기
	 * 메뉴 선택 :
	 * 
	 * 메뉴
	 * 1. 단어 목록 조회
	 * 2. 단어 등록
	 * 메뉴 선택 : 2
	 * 
	 * 등록할 단어 입력 : tiger
	 * 등록할 뜻 입력 : 호랑이
	 * 등록했습니다.
	 * 
	 * 
	 * 2. 틀 작성
	 * 
	 * 3. 필요한 메서드 구현
	 * 
	 */
	public static void main(String[] args) {
		int menu;
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 기능 실행
			runMenu(menu);
		}while(menu != 3);
	}
	/** menu를 입력하면 menu에 맞는 기능을 실행하는 메서드
	 * 
	 * @param menu
	 */
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//서브메뉴를 출력
			printSubmenu();
			//서브메뉴 선택
			int submenu = scan.nextInt();
			//서브메뉴 맞는 기능 실행
			runSubmenu(submenu);
			break;
		case 2:
			//단어 등록 기능을 구현
			intsertWord();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}
	/**submenu를 입력하면 맞는 submenu를 실행하는 메서드
	 * 
	 * @param submenu
	 */
	private static void runSubmenu(int submenu) {
		switch(submenu) {
		case 1:
			//단어 검색
			printWordSearch();
			break;
		case 2:
			//단어 수정
			updateWord();
			break;
		case 3:
			//단어 삭제
			deleteWord();
			break;
		case 4:
			System.out.println("이전으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	/**삭제할 단어 번호를 입력받아 단어를 삭제하는 메서드
	 * 
	 */
	private static void deleteWord() {
		//삭제할 단어 번호를 입력
		System.out.println("삭제할 단어 번호 : ");
		int num = scan.nextInt();
		//반복문 : 게시글 목록 전체
		int index = -1; //일치하는 게시글이 있는 번지
		for(int i = 0; i < count ; i++) {
			//입력한 번호와 일치하는 게시글을 찾아 번지를 저장
			if(num == wordList[i].getNum()) {
				index = 1;
				break;
			}
		}
		if(index == -1) {
			System.out.println("일치하는 게시글이 없습니다.");
			return;
		}
		count--;
		//가장 최근에 등록된 게시글을 삭제했다면 == 배열에서 가장 마지막에 있는 게시글을 삭제했다면
		if(index == count) {
			return;
		}
		//찾은 번지 다음부터 한칸씩 당겨옴
		//기본 배열을 크기가 같은 새 배열을 생성
		Board []tmpList = new Board[wordList.length];
		//새 배열에 기존 배열을 복사
		System.arraycopy(wordList, 0, tmpList, 0, wordList.length);
		//기존 배열에서 찾은 번지 다음부터 나머지 개수를 복사해서
		//새 배열에 찾은 번지부터 덮어씀
		System.arraycopy(tmpList, index + 1, wordList, index, count - index);
		System.out.println("단어가 삭제됐습니다.");
		
	}
	private static void printWordSearch() {
		//조회할 단어 번호를 입력
				System.out.println("조회할 단어 번호 : ");
				int num = scan.nextInt();
				//반복문 : 등록된 단어 전체, 배열 전체 X
				for(int i = 0; i < count ; i++ ) {
					
					//입력한 번호와 같은 번호를 가진 단어 찾고
					if(num == wordList[i].getNum()) {
						//해당 단어의 printInfoDetail을 호출
						wordList[i].printInfoDetail();
						return;
					}
				}
				System.out.println("일치하는 단어가 없습니다.");
				
		
	}
	/**수정할 단어 번호와 단어, 뜻을 입력받아 단어를 수정하는 메서드
	 * 
	 */
	private static void updateWord() {
		//수정할 단어 번호와 단어, 뜻을 입력
		System.out.print("검색할 단어 번호 : ");
		int num = scan.nextInt();
		scan.nextLine(); //엔터 처리
		System.out.print("수정할 단어 : ");
		String word = scan.nextLine();
		System.out.print("수정할 뜻 : ");
		String mean = scan.nextLine();
		
		//반복문 : 단어 목록 전체
		for(int i = 0; i < count ; i++) {
			//입력한 단어 번호와 일치하는 단어가 있으면
			if(num == wordList[i].getNum()) {
				//해당 단어의 단어와 뜻을 수정하고 메서드 종료
				wordList[i].update(word, mean);
				System.out.println("수정이 완료됐습니다.");
				return;
			}
		}
		//일치하는 단어가 없습니다라고 출력
		System.out.println("일치하는 단어가 없습니다.");
		
	}
	private static void printSubmenu() {
		System.out.println("------서브 메뉴------");
		System.out.println("1. 단어 검색");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 뒤로가기");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
	}
	/**단어 정보를 받아 단어를 등록하는 메서드
	 * 
	 */
	private static void intsertWord() {
		scan.nextLine(); //입력 버퍼에 남아있는 엔터 처리
		//단어, 뜻 순으로 입력받음
		System.out.print("단어 : ");
		String word = scan.nextLine();
		System.out.print("뜻 : ");
		String mean = scan.nextLine();
		//입력받은 정보들을 이용하여 단어 인스턴스를 생성
		Word words = new Word(word, mean);
		//생성된 인스턴스를 배열에 저장(몇번지)
		wordList[count] = words;
		++count;//저장된 개수를 1증가
		//배열 크기를 안늘려도 되면 종료
		if(count < wordList.length) {
			return;
		}
		//배열이 꽉 차면 배열을 늘려줌
		//기본 배열보다 큰 배열 생성
		Word[] tmpList = new Word[wordList.length + 5];
		//새로 생성된 배열에 기존 배열을 복사
		System.arraycopy(wordList, 0, tmpList, 0, count);
		//새로 생성된 배열을 wordList 연결
		wordList = tmpList;
	}
	
	/**선택한 번호를 입력받아 실행하는 메서드
	 * 
	 */
	private static void printMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1. 단어 조회");
		System.out.println("2. 단어 등록");
		System.out.println("3. 프로그램 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
	}

}
