package day12;

public class OverrideEx1 {

	public static void main(String[] args) {
		D d = new D();
		d.print1();//오버라이딩을 이용하여 재정의 메서드가 호출
		d.print2();
	}

}
class C{
	protected int num1 = 1, num2 = 2;
	
	protected void print1() {
		System.out.println(num1);
		System.out.println(num2);
	}
	
	public void print2() {
		System.out.println(num1);
		System.out.println(num2);
	}
}
class D extends C{
	
	@Override
	/*
	 * 매개변수가 부모 클래스에는 없음
	 * 부모 클래스에서는 접근페이지가 protected 였는데 여기선 default.
	 * 
		void print1(int num1) {
			
		}
	 */
	protected void print1() {
		System.out.println(num1);
		System.out.println(num2);
	}
	
	public void print2() {
		System.out.println("B 클래스의 메서드입니다.");
	}
}