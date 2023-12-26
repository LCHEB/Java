package day12.product;

import java.util.Scanner;

public class ProductMain {
	public static Scanner scan = new Scanner(System.in);
	/* 제품을 추가하는 프로그램을 작성하세요.
	 * 제품은 Tv, 에어컨, 컴퓨터만 추가 가능
	 * 공통 : 브랜드, 제품코드, 제품명
	 * Tv : 화면크기
	 * 에어컨 : 냉방면적
	 * 노트북 : CPU, 램
	 * 
	 * Tv클래스, 에어컨 클래스, 노트북 클래스
	 * Product 클래스
	 * 메뉴
	 * 1. 제품 추가
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴 선택 : 1
	 * ---------------
	 * 추가할 제품
	 * 1. Tv
	 * 2. 에어컨
	 * 3. 노트북
	 * 제품 선택 : 1
	 * 브랜드 : 삼성
	 * 제품코드 : KQ75QCE1-W1
	 * 제품명 : 2023 QLED 4K QCE1 (189cm) 풀 모션 슬림핏 벽걸이형
	 * 화면크기(cm) : 189
	 * 등록이 완료됐습니다.
	 * 
	 * 브랜드 : 삼성
	 * 제품코드 : AF17B6474WSRT
	 * 제품명 : 에어컨 Q9000
	 * 냉방면적(m2) : 
	 */
	public static void main(String[] args) {
		int menu;
		do {
			printmenu();
			menu = scan.nextInt();
			runmenu(menu);
		}while(menu != 3);
	}

	private static void runmenu(int menu) {
		switch(menu) {
		case 1:
			insertProduct();
			break;
		case 2:
			printProduct();
			break;
		case 3:
			System.out.println("종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private static void printProduct() {
		// TODO Auto-generated method stub
		
	}

	private static void insertProduct() {
		printProductTitle();
		int submenu = scan.nextInt();
		runSubMenu(submenu);
	}

	private static void runSubMenu(int submenu) {
		switch(submenu) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			System.out.println("잘못된 제품입니다.");
		}
	}

	private static void printProductTitle() {
		System.out.println("추가할 제품");
		System.out.println("1. Tv");
		System.out.println("2. 에어컨");
		System.out.println("3. 노트북");
		System.out.println("제품 선택 : ");
	}

	private static void printmenu() {
		System.out.println("1. 제품 추가");
		System.out.println("2. 제품 확인");
		System.out.println("3. 종료");
		System.out.println("메뉴 선택 : ");
	}
	
}
