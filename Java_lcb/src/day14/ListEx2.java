package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx2 {

	public static void main(String[] args) {
		//정수를  5개 입력받아 입력받은 정수를 리스트에 저장하고, 출력하는 코드를 작성하세요.
		Scanner scan = new Scanner(System.in); //콘솔창에서 입력받기 위한 Scanner 인스턴스를 생성
		ArrayList<Integer> list = new ArrayList<Integer>(); //리스트 생성
		System.out.println("정수 입력 : "); //콘솔창에 문자열 출력
		for(int i = 0; i < 5; i++) { //5번 반복하기 위해 반복문을 작성 
			int num = scan.nextInt(); // 정수 입력
			list.add(num); // 입력한 정수 저장
		}
		for(int i = 0; i < list.size(); i++) { 
			System.out.print(list.get(i) + " "); //리스트 출력
		}
		
	}

}
