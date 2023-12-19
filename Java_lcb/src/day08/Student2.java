package day08;

	/* 학생의 국어, 영어, 수학 성적을 관리하기 위한 프로그램 작성하려고 한다.
	 * 이때 필요한 학생 클래스를 생성해보세요.
	 */
public class Student2 {
	// - 정보
		// - 과목 , 점수, 학생 번호, 학년, 반, 이름
	int kor, eng, math;
	int grade, classNum, num;
	String name;
	
	// - 기능
		// - 학생 정보 확인, 점수 수정
	/* 기능 : 학생 정보(학년, 반, 번호, 이름)을 콘솔에 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 메서드명 : printInfo
	 */
	public void printInfo() {
		System.out.println("---------------------");
		System.out.println("학년 : " + grade);
		System.out.println("반 : " + classNum);
		System.out.println("번호 : " + num);
		System.out.println("이름 : " + name);
	}
	
	/* 기능 : 학생 성적 (학생, 반, 번호, 이름, 국어, 영어, 수학)을 콘솔에 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 메서드명 : printScore
	 */
	public void printScore() {
		printInfo();
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("---------------------");
	}
	
	
	/* 기능 : 국어 성적을 수정하는 메서드
	 * 매개변수 : 수정하려는 국어 성적 => int korScore
	 * 리턴타입 : 없음
	 * 메서드명 : setKor
	 */
	public void setKor(int korScore) {
		kor = korScore;
	}
	/* 기능 : 영어 성적을 수정하는 메서드
	 * 매개변수 :
	 * 리턴타입 :
	 * 메서드명 :setKEng
	 */
	public void setEng(int engScore) {
		eng = engScore;
	}
	/* 기능 : 수학 성적을 수정하는 메서드
	 * 매개변수 :
	 * 리턴타입 :
	 * 메서드명 :setMath
	 */
	public void setMath(int mathScore) {
		math = mathScore;
	}

	public Student2(int grade1, int classNum1, int num1, String name1) {
		grade = grade1;
		classNum = classNum1;
		num = num1;
		name = name1;
	}
	
}

