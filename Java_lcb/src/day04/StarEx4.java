package day04;

public class StarEx4 {

	public static void main(String[] args) {
		/*     *  		i = 1, * = 1
		 *    ***		i = 2, * = 3
		 *   *****		i = 3, * = 5
		 *  *******		i = 4, * = 7
		 * *********	i = 5, * = 9
		 * 						2*i-1					
		 */
		
		int rows = 5;
		for(int i = 1; i <= 5; i++) {
			for(int j = 1;  j <= rows - i; j++) {
				System.out.print(' ');
			}
			for(int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
				}
			
		System.out.println();
			}
		
		for(int i = 1; i <= 5; i++) {
			//' '을 5-1개 출력
			for(int j = 1;  j <= rows - i; j++) {
				System.out.print(' ');
			}
			//*을 i개 출력
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
				}
			//*을 i-1개 출력
			for(int j = 1; j <= i-1; j++) {
				System.out.print("*");
				}
			
		System.out.println();
			}
		
		
		}

	}

