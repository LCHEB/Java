package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {

	public static void main(String[] args) {
		//속담을 입력받아 저장하고, 출력하는 코드를 작성하세요.
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		String str;
		while(true) {
			System.out.println("속담 입력 : ");
			str = scan.nextLine();
			if(!str.equals("-1")) {
				break;
			}
			list.add(str);
		}
		
		for(String tmp : list) { 
			System.out.print(tmp);
		}
		
		scan.close();
	}

}
