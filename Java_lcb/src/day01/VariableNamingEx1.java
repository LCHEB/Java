package day01;

public class VariableNamingEx1 {

	// 변수명 작성 규칙(필수)과 관례(선택이지만 추천)
	public static void main(String[] args) {
		//1. 대소문자를 구분
		int num;
		int NUM;
		int Num;
		int nuM;
		
		//2. 예약이 사용 불가능
		//int public;
		//int int;
		//int class;
		
		//3. 숫자로 시작 불가능
		//int 2num;
		int num2;
		
		//4. 특수문자는 _와$만 가능
		//int #num;
		//int n um;
		int _num;
		int num$;
		
		//5. 중복 선언 불가능
		//위에서 선언됨
		//int num;
		
		/*관례
		 * 카멜표기법 : 두 단어로 된 경우 두번째 단어부터 첫글자만 대문자로
		 * 변수명은 의미있게
		 */
		
	}

}
