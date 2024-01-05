package homework2;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;

public class AccountBookProgram implements Program {
	private Scanner scan = new Scanner(System.in);
	private Date date = new Date();
	private final int EXIT = 4;
	private int num = 0;
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
		System.out.println("3. 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");

	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertAccountBook();
			break;
		case 2:
			searchAccountBook();
			break;
		case 3:
			System.out.println("종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}

	}

	private void searchAccountBook() {
		
	}

	private void insertAccountBook() {
		System.out.println("날짜 : ");
		scan.nextLine();
		String date = scan.nextLine();
		System.out.println("사용처 : ");
		String use = scan.next();
		System.out.println("금액 : ");
		int money = scan.nextInt();
		System.out.println("수입(1) / 지출(2) : ");
		int num = scan.nextInt();
		if(num == 1) {
			
		}else if(num == 2) {
			
		}else {
			
		}
	}

}
