package day02;

import java.util.Scanner;

public class TestEx3 {

	public static void main(String[] args) {
		// 정수를 입력받아 0인지, 양수인지, 음수인지 판별하는 코드를 작성하세요.
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력 : ");
		int num = scan.nextInt();
		
		if(num == 0) {
			System.out.println(num + "는 0");
		}else if(num > 0) {
			System.out.println(num + "는 양수");
		}else {
			System.out.println(num + " 는 음수");
		}
		
		scan.close();
		
		
	}

}
