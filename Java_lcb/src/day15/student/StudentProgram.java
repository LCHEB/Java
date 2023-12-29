package day15.student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;


public class StudentProgram implements Program {

		private Scanner scan = new Scanner(System.in);
		private List<Student> list = new ArrayList<Student>();
		private int count = 0;
		@Override
		public void run() {
			int menu = 0;
			do {
				//메뉴 출력
				printMenu();
			
				try {
				//메뉴 입력
					menu = scan.nextInt();
				//메뉴 실행
				runMenu(menu);
				}catch(InputMismatchException e) {
					System.out.println("잘못된 메뉴입니다.");
					scan.nextLine();
				}
			}while(menu != 4);
			printExit();
			
		}

		public void printExit() {
			System.out.println("---------------------");
			System.out.println("프로그램을 종료합니다.");
			System.out.println("---------------------");
		}

		@Override
		public void printMenu() {
			System.out.println("-----------메뉴---------");
			System.out.println("1. 학생 관리");
			System.out.println("2. 성적 관리");
			System.out.println("3. 조회");
			System.out.println("4. 종료");
			System.out.println("-----------------------");
			System.out.print("메뉴 선택 : ");
			
		}

		@Override
		public void runMenu(int menu) {
			switch(menu) {
			case 1:
				studentInfo();
				break;
			case 2:
				scoreInfo();
				break;
			case 3:
				printManager();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				throw new InputMismatchException();
			}
			
		}

		private void printManager() {
			System.out.println("1. 학생 조회");
			System.out.println("2. 성적 조회");
			System.out.println("메뉴 선택 : ");
			int menu = scan.nextInt();
			switch(menu) {
			case 1:
				studentJoin();
				break;
			case 2:
				subjectJoin();
				break;
			}
		}

		private void studentJoin() {
			System.out.println("1. 전체");
			System.out.println("2. 학년");
			System.out.println("3. 반");
			System.out.println("4. 학생(학년, 반, 번호)");
			System.out.println("메뉴 선택 : ");
			int menu = scan.nextInt();
			int grade, classNum, num;
			switch(menu) {
			case 1:
				printStudent(s->true);
				break;
			case 2:
				System.out.println("학년 : ");
				grade = scan.nextInt();
				printStudent(s->s.getGrade() == grade);
				break;
			case 3:
				System.out.println("학년 : ");
				grade = scan.nextInt();
				System.out.println("반 : ");
				classNum = scan.nextInt();
				printStudent(s->s.getGrade() == grade && s.getClassNum() == classNum);
				break;
			case 4:
				System.out.println("학년 : ");
				grade = scan.nextInt();
				System.out.println("반 : ");
				classNum = scan.nextInt();
				System.out.println("번호 : ");
				num = scan.nextInt();
				Student std = new Student(grade, classNum, num, "");
				printStudent(s->s.equals(std));
				break;
			default:
				throw new InputMismatchException();
			}
		}
		private void subjectJoin() {
			System.out.println("1. 국어");
			System.out.println("2. 영어");
			System.out.println("3. 수학");
			System.out.println("메뉴 선택 : ");
			int menu = scan.nextInt();
			int kor, eng, math;
			switch(menu) {
			case 1:
				System.out.println("국어");
				printSubject(s->s.getKor());
				break;
			case 2:
				System.out.println("영어");
				printSubject(s->s.getEng());
				break;
			case 3:
				System.out.println("수학");
				printSubject(s->s.getMath());
				break;
			default:
				throw new InputMismatchException();
			}
			
		}
		private void printStudent(Predicate<Student> p) {
			for(Student std : list) {
				if(p.test(std)) {
					System.out.println(std);
				}
			}
		}

		private void printSubject(Function<Student, Integer> f) {
			for(Student std : list) {
					System.out.println(std.getName() + " : " + f.apply(std));
			}
		}
		

		private void scoreInfo() {
			//과목 출력 : 수정할 과목을 선택
			System.out.println("1. 국어");
			System.out.println("2. 영어");
			System.out.println("3. 수학");
			System.out.println("과목 선택 : ");
			//과목 선택
			int subject = scan.nextInt();
			//학년, 반, 번호, 성적을 입력
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("반 : ");
			int classNum = scan.nextInt();
			System.out.print("번호 : ");
			int num = scan.nextInt();
			System.out.println("성적 입력 : ");
			int score = scan.nextInt();
			//학년, 반, 번호를 이용해서 인스턴스 생성
			Student std = new Student(grade, classNum, num, "");
			//생성된 학생이 있는지 확인하고 없으면 없다고 알림 후 종료
			int index = list.indexOf(std);
			//없으면 없다고 하고 종료
			if(index == -1) {
				System.out.println("등록되지 않은 학생입니다.");
				return;
			}
			//선택한 과목에 맞는 성적을 수정
			switch(subject) {
			case 1:
				list.get(index).setKor(score);
				break;
			case 2:
				list.get(index).setEng(score);
				break;
			case 3:
				list.get(index).setMath(score);
				break;
			default:
				throw new InputMismatchException();
			}
			System.out.println("성적 수정이 완료 됐습니다.");
			//System.out.println(list.get(index));
		}

		private void studentInfo() {
			System.out.println("1.학생 추가");
			System.out.println("2.학생 수정");
			System.out.println("3.학생 삭제");
			System.out.println("메뉴 선택 : ");
			int menu = scan.nextInt();
			switch(menu) {
			case 1:
				//이미 등록된 학생은 추가하지 않음
				addStudent();
				break;
			case 2:
				updateStudent();
				break;
			case 3:
				deleteStudent();
				break;
			}
		}

		private void deleteStudent() {
			//삭제할 학년, 반, 번호를 입력
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("반 : ");
			int classNum = scan.nextInt();
			System.out.print("번호 : ");
			int num = scan.nextInt();
			
			//학생 인스턴스를 생성
			Student std = new Student(grade, classNum, num, "");
			
			//삭제 요청 후 삭제되면 삭제됐다고 알림, 삭제 안되면 안됐다고 알림
			if(list.remove(std)) {
				System.out.println("학생 정보가 삭제됐습니다.");
			}else {
				System.out.println("등록되지 않은 학생 정보입니다.");
			}
		}

		private void updateStudent() {
			//기존 학년, 반, 번호를 입력
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("반 : ");
			int classNum = scan.nextInt();
			System.out.print("번호 : ");
			int num = scan.nextInt();
			
			Student std = new Student(grade, classNum, num, "");
			//기존 학년, 반, 번호와 일치하는 학생 인스턴스를 가져옴
			int index = list.indexOf(std);
			//없으면 없다고 하고 종료
			if(index == -1) {
				System.out.println("등록되지 않은 학생입니다.");
				return;
			}
			//수정할 학년, 반, 번호, 이름 입력
			//기존 학년, 반, 번호를 입력
			System.out.print("수정할 학년 : ");
			grade = scan.nextInt();
			System.out.print("수정할 반 : ");
			classNum = scan.nextInt();
			System.out.print("수정할 번호 : ");
			num = scan.nextInt();
			System.out.print("수정할 이름 : ");
			String name = scan.next();
			
			//수정할 학생 인스턴스를 생성
			Student newStd = new Student(grade, classNum, num, name);
			
			//수정할 학생 정보가 등록됐는지 확인해서 있으면 알림 후 종료
			if(list.contains(newStd)) {
				System.out.println("이미 등록된 학생 정보이어서 수정할 수 없습니다.");
				return;
			}
			//수정할 학생 인스턴스에 기존 학생 성적을들 업데이트하고
			newStd.setKor(std.getKor());
			newStd.setEng(std.getEng());
			newStd.setMath(std.getMath());
			//기존 학생 정보를 삭제
			list.remove(index);
			//수정할 학생 정보를 리스트에 추가
			list.add(newStd);
			//정렬
			sort();
			
			System.out.println("학생 정보가 수정 되었습니다.");
			System.out.println(list);
		}

		private void sort() {
			list.sort((o1,o2)->{
				if(o1.getGrade() != o2.getGrade()) {
					return o1.getGrade() - o2.getGrade();
				}
				if(o1.getClassNum() != o2.getClassNum()) {
					return o1.getClassNum() - o2.getClassNum();
				}
				return o1.getNum() - o2.getNum();
			});
		}
		
		private void addStudent() {
			//학년, 반, 번호, 이름을 입력
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("반 : ");
			int classNum = scan.nextInt();
			System.out.print("번호 : ");
			int num = scan.nextInt();
			System.out.print("이름 : ");
			String name = scan.next();
			//입력받은 정보로 인스턴스를 생성
			Student std = new Student(grade, classNum, num, name);
			//std가 리스트에 없으면 추가
			//contains는 Objects.equals(a,b)를 호출해서 a와 b의 클래스가 같으면
			//a.equals(b)를 이용하여 있는지 없는지 확인
			if(!list.contains(std)) {
				list.add(std);
				System.out.println("학생을 등록했습니다.");
				return;
			}
			System.out.println("이미 등록된 학생입니다.");
		}
		
}


