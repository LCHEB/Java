package day12;

public class PolymorphismEx1 {

	public static void main(String[] args) {
		/* 다형성 예제
		 * 1. 매개변수의 다형성
		 */
		Remocon r = new Remocon();
		Tv tv = new Tv();
		AirConditioner aircon = new AirConditioner();
		Projector projector = new Projector();
		r.turnON(tv);
		r.turnON(aircon);
		r.turnON(projector);
	}

}
class Remocon{
	/*
	void turnOn(Tv target) {
		System.out.println("Tv 제품이 켜졌습니다.");
	}
	void turnOn(AirConditioner targer) {
		System.out.println("에어컨 제품이 켜졌습니다.");
	}*/
	//매개변수의 다형성을 이용하여 turnOn 메서드를 1개만 생성
	void turnON(ElectronicProduct target) {
		if(target instanceof Tv) {
			System.out.print("Tv ");
		}else if(target instanceof AirConditioner) {
			System.out.print("에어컨 ");
		}else if(target instanceof Projector) {
			System.out.print("빔 프로젝터");
		}else {
			System.out.print("전자 ");
		}
		System.out.println("제품이 켜졌습니다.");
	}
}

class ElectronicProduct{
	
}

class Tv extends ElectronicProduct{
	
}

class AirConditioner extends ElectronicProduct{
	
}

class Projector extends ElectronicProduct{
	
}