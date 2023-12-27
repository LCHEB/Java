package day13;

import java.util.Random;

public class RandomEx1 {

	public static void main(String[] args) {
		
		Random random = new Random();
		int min = 1, max = 9;
		for(int i = 0; i < 11; i++) {
			System.out.println(random.nextInt(max - min) + min);
		}
	}

}
