package day03;

public class ForEx2 {

	public static void main(String[] args) {
		/*1에서 10사이의 짝수들의 합을 구하는 코드를 작성하세요.
		 * 반복회수	:i는 1부터 10까지 1씩 증가
		 * 규칙성		:i를 2로 나누었을 때 나머지가 0과 같다면 sum = sum + i룰 살행
		 * 반복문종료후	:sum을 출력
		 */
		
		int i;
		int sum = 0;
		//초기화에 i를 선언하면 for(int i = 1; ; ) i는 반복문 밖에서 사용할 수없다. 사용하려면 재선언을 해야함
		for( i = 2 ; i <= 10 ; i = i + 2 ) {
			if(i % 2 == 0) {
				sum = sum + i;
				
			}
			
		}
		System.out.println(sum);
	}

}
