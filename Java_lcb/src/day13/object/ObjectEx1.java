package day13.object;

import lombok.AllArgsConstructor;
import lombok.ToString;

public class ObjectEx1 {

	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A();
		System.out.println(a.toString());
		
		Student std1 = new Student(1, 1, 1, "홍길동");
		Student std2 = new Student(1, 1, 1, "임꺽정");
		if(std1.equals(std2)) {
			System.out.println("학년, 반, 번호가 같습니다.");
		}else {
			System.out.println("학년, 반, 번호가 다릅니다.");
		}
		
		A a1 = new A();
		a1.num1 = 20;
		//a1 출력
		System.out.println(a1);
		A a2 = a1;
		a2.num1 = 30;
		//a의 num1을 수정한 후 a1을 출력 : 공유하기 때문에 바뀜
		System.out.println(a1);
		A a3 = a1.clone();
		a3.num2 = 40;
		//a3의 num2를 수정한 후 a1을 출력 : 복제했기 때문에 바뀌지 않음
		System.out.println(a1);
				
	}
}

@AllArgsConstructor
class Student{
	int grade, classNum, num;
	String name;
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade;
	}
}

class A implements Cloneable{
	int num1 = 10;
	int num2 = 3;
	String name = "테스트";
	@Override
	public String toString() {
		return "[num1=" + num1 + ", num2=" + num2 + ", name=" + name + "]";
	}
	@Override
	public A clone() throws CloneNotSupportedException{
		return (A)super.clone();
	}
	
}