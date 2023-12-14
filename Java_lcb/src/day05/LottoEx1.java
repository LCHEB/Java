package day05;

import java.util.Arrays;

public class LottoEx1 {

	public static void main(String[] args) {
		/* 1~45사이의 랜덤한 수 6개를 생성하여 출력하는 예제
		 * 단, 정렬이 되도록
		 * */
		
		int min = 1, max = 45;
		int arr[] = new int[6];
		int count = 0;
		
		while(count < 6) {
			int r =(int)(Math.random() * (max - min + 1) + min);
			
			boolean duplicated = false; 
			for(int i = 0; i < count; i++) {
				if(arr[i] == r) {
					duplicated = true;
					break;
				}
			}
			if(!duplicated) {
				arr[count] = r;
				count++;
			}
		}
		/* 중복 확인 다른 방법
		 * int i;
			for(i = 0; i < count; i++) {
				if(arr[i] == r) {
					break;
				}
			} 
			if (i == count) {
				arr[count++] = r;
				
			}
		 */
		
		Arrays.sort(arr);
		
		for(int i =0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}