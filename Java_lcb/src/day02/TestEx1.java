package day02;

public class TestEx1 {
	
	//연산자 예제
	public static void main(String[] args) {
		/* 다음 코드를 이용하여 국어, 영어, 수학 성적의 평균을 구하여 콘솔에 출력하는 코드를 작성하세요. */
		int korScore = 100, engScore = 50, mathScore = 92;
		int sum = 0;
		double avg = 0.0;
		System.out.println("평균 = " + (korScore + engScore + mathScore)/(double)3);
		
		//총점 
		sum = korScore + engScore + mathScore;
		avg = sum / 3.0;
		
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + avg);
		
		/*연산자
		 * -연산자 종류를 알고, 연산 결과를 예측할 수 있다
		 * 
		 * 대입
		 * -=
		 * -오른쪽을 값을 왼쪽에 저장
		 * -왼쪽에는 변수 또는 상수가 1개만 와야 함
		 * -==와 착각
		 * 
		 * 산술
		 * -/:정수/정수 => 정수, 소수점이 버려짐,그 외에는 실수
		 * %:나머지 연산자,홀짝,약수,배수를 찾을 때 사용
		 * -/,%는 0으로 나누면 안됨
		 * 
		 * 증감	
		 * -최종적으로 1증감/감소
		 * -위치에 따라 전위/후위형
		 * 
		 * 비교
		 * -크기 비교
		 * -결과가 참/거짓
		 * ->=, <= 연산자 순서
		 * 
		 * 논리
		 * -결과가 참/거짓
		 * -&& : ~이고, 둘다 참일때 참
		 * -|| : ~이거나, 하나라도 참이면 참
		 * -! : 반대
		 * 
		 * 복합대입
		 * -연산자 줄여쓰기
		 * 
		 * 조건
		 * -조건문을 대체
		 * -코드를 간결하게 쓸수있다.
		 * 
		 * 비트
		 * -비트로 나열해서 논리연산
		 * 
		 * 비트 이동
		 * -비트로 나열해서 왼쪽/오른쪽으로 비트들을 이동
		 * 
		 * 연산자 우선순위
		 * -괄호가 가장 높다		 
		 */
	}

}
