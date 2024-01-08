package homework2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;

public class AccountBookProgram implements Program {
	private Scanner scan = new Scanner(System.in);
	private static AccountBook ab = new AccountBook();
	private static ArrayList<AccountBook> acc = new ArrayList<>();
	private final int EXIT = 4;
	@Override
	public void run() {
		int menu = 0;
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				//메뉴 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != EXIT);
	}

	@Override
	public void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 가계부 작성");
		System.out.println("2. 가계부 조회");
		System.out.println("3. 가계부 검색");
		System.out.println("4. 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");

	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			look();
			break;
		case 3:
			search();
			break;
		case 4:
			System.out.println("종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}

	}

	private void search() {
		printSearch();
		//단어 관리 메뉴를 선택
		int menu = scan.nextInt();
		//단어 관리 메뉴를 실행
		runSearch(menu);
		
	}

	private void printSearch() {
		System.out.println("1.날짜 검색");
		System.out.println("2. 이전으로");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
	}

	private void runSearch(int menu) {
		switch(menu) {
		case 1:
			System.out.print("날짜 입력: ");
	         String sdate = scan.next();
	         int j = 0;
	         if (j == acc.size()) {
	            System.out.println("검색 결과 없음.");
	         
	         for (j = 0; j < acc.size(); j++) {
	            ab = acc.get(j);
	            if (sdate.equals(ab.getDate())) {
	               int Insum = ab.inMon;
	               int Outsum = ab.outMon;
	               int sum = 0;
	               sum = sum + (Insum + -Outsum);
	               System.out.println("번호: " + ab.num);
	               System.out.println("날짜: " + ab.date);
	               System.out.println("수입: " + Insum);
	               System.out.println("지출: " + -Outsum);
	               System.out.println("내역: " + ab.use);
	               System.out.println("합계: " + sum);
	               System.out.println();
	            }
	        }
        } 
			break;
		case 2:
			System.out.println("이전화면으로");
			return;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private void look() {
		printLook();
		//단어 관리 메뉴를 선택
		int menu = scan.nextInt();
		//단어 관리 메뉴를 실행
		runLook(menu);
	}

	private void printLook() {
		System.out.println("1. 전체 출력");
		System.out.println("2. 수입 출력");
		System.out.println("3. 지출 출력");
		System.out.println("4. 이전으로");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private void runLook(int menu) {
		switch(menu) {
		case 1:
			 int sum = 0;      
	         int i = 0;
	         if (i == acc.size()) {
	            System.out.println("검색 결과 없음.");
	         }
	         for (i = 0; i < acc.size(); i++) {
	            ab = acc.get(i);
	            int Insum = ab.inMon;
	            int Outsum = ab.outMon;            
	            sum = sum + (Insum + -Outsum);
	            System.out.println("번호: " + ab.num);
	            System.out.println("날짜: " + ab.date);
	            System.out.println("수입: " + Insum);
	            System.out.println("지출: " + -Outsum);
	            System.out.println("내역: " + ab.use);
	            System.out.println("합계: " + sum);
	            System.out.println();
	         }
	         break;
		case 2:
			 int inall = 0;   
	         i = 0;
	         if (i == acc.size()) {
	            System.out.println("검색 결과 없음.");
	         }
	         for (i = 0; i < acc.size(); i++) {
	            ab = acc.get(i);            
	            int Insum = ab.inMon;
	            inall = (inall + Insum);            
	            System.out.println("번호: " + ab.num);
	            System.out.println("날짜: " + ab.date);
	            System.out.println("수입: " + Insum);         
	            System.out.println("내역: " + ab.use);
	            System.out.println("합계: " + inall);   
	            System.out.println();
	         }
			break;
		case 3:
			 int outAll = 0;   
	         i = 0;
	         if (i == acc.size()) {
	            System.out.println("검색 결과 없음.");
	         }
	         for (i = 0; i < acc.size(); i++) {
	            ab = acc.get(i);
	            int Outsum = ab.outMon;            
	            outAll = outAll + Outsum;
	            System.out.println("번호: " + ab.num);
	            System.out.println("날짜: " + ab.date);
	            System.out.println("지출: " + -Outsum);
	            System.out.println("내역: " + ab.use);
	            System.out.println("합계: " + -outAll);
	            System.out.println();
	         }
	         break;
		case 4:
			System.out.println("이전화면으로");
			return;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private void insert() {
		printInsert();
		//단어 관리 메뉴를 선택
		int menu = scan.nextInt();
		//단어 관리 메뉴를 실행
		runInsert(menu);
		
	}


	private void printInsert() {
		System.out.println("1. 수입 등록");
		System.out.println("2. 지출 등록");
		System.out.println("3. 이전으로");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
	}
	
	private void runInsert(int menu) {
		switch(menu) {
		case 1:
			ab = new AccountBook();
			System.out.print("번호 : ");
			ab.setNum(scan.nextInt());
			System.out.print("날짜 : ");
			ab.setDate(scan.next());
			System.out.print("수입 : ");
			ab.setInMon(scan.nextInt());
			System.out.print("내역 : ");
			ab.setUse(scan.next());
			acc.add(ab);
			System.out.println("수입을 등록했습니다.");
			break;
		case 2:
			ab = new AccountBook();
			System.out.print("번호 : ");
			ab.setNum(scan.nextInt());
			System.out.print("날짜 : ");
			ab.setDate(scan.next());
			System.out.print("지출 : ");
			ab.setOutMon(scan.nextInt());
			System.out.print("내역 : ");
			ab.setUse(scan.next());
			acc.add(ab);
			System.out.println("지출을 등록했습니다.");
			break;
		case 3:
			System.out.println("이전화면으로");
			return;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

}
