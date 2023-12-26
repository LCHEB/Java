package day12.protected2;

import day12.protected1.A;

public class ProtectedEx1 {

	public static void main(String[] args) {
		/* num1 : private
		 * num2 : default
		 * num3 : protected
		 * num4 : public
		 */
		A a = new A();
		//a.num1 = 1;
		//a.num2 = 2;
		//a.num3 = 3;
		a.num4 = 4;
		B b = new B();
		//b.num1 = 1;
		//default인 nmu2는 B와 ProtectedEx1m이 같은 패키이지 이기 때문에 접근할 수 없음
		//b.num2 = 2;
		//같은 패키지이지만 ProtectedEx1이 B클래스의 자식 클래스가 아니기 때문에 접근 불가
		//b.num3 = 3;
		b.num4 = 4;
	}

}
