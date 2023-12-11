package day02;

public class LogicalOperatorEx1 {

	//논리 연산자 예제
	public static void main(String[] args) {
		/* && : ~하고, ~ 이고
		 * A && B : A와 B는 참/거짓을 판별할 수 있는 식 또는 변수
		 * 성적이 100이하이고, 성적이 90이상이면 A, 성적이 95 => true
		 * 100이고, 90이다 A, 성적이 95 => 판별할 수 없다 => 에러가 발생
		 * - 진리표
		 * A && B
		 * F && F => F
		 * F && T => F
		 * T && F => F
		 * T && T => T(둘다 참일 때 참)
		 * 
		 * || : ~이거나, ~하거나
		 * A || B
		 * - 진리표
		 * A || B
		 * F || F => F(둘다 거짓일 때 거짓)
		 * F || T => T
		 * T || F => T
		 * T || T => T
		 * 
		 * ! : ~ 아닌, 반대
		 * !A
		 * - 진리표
		 * F => T
		 * T => F
		 */
		int score = 90; //성적
		
		//성적이 올바른지 확인. 올바른 성적은 0이상 100이하
		//성적이 0이상이고, 성적이 100이하이다.
		//성적이 0보다 크거나 같고, 성적이 100보다 작거나 같다.
		//성적이 0보다 (크거나 같)(고), 성적이 100보다 (작거나 같다). () : 연산자
		//성적 >= 0 && 성적 <= 100;
		System.out.println(score + " 점은 올바른 성적인가? " + (score >= 0 && score <= 100));
		//앞 결과의 반대가 출력
		System.out.println(score + " 점은 올바른 성적이 아닌가? " + !(score >= 0 && score <= 100));
		/*성적이 올바르지 않은지를 확인. 올바르지 ㅇ낳은 성적은 0미만, 100초과
		 * 성적이 0미만이거나 성적이 100초과이다.
		 * 성적이 0보다 (작)(거나) 성적이 100보다 (크다)
		 * 성적 < 0 || 성적 > 100
		 */
		System.out.println(score + " 점은 올바른 성적이 아닌가? " + (score < 0 || score > 100));
		
		/*논리 연산자
		 * A 연산자 B
		 * -A와 B가 참 또는 거짓으ㅜ로 판별할 수 있는 식 또는 값
		 * -A와 B를 논리 연산
		 * 
		 * 비트 연산자
		 * A 연산자 B
		 * -A와 B가 값
		 * -A와 B를 비트로 나열한 후 논리 연산
		 */
	}

}
