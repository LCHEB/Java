package day16.board;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentProgram implements StudentMenu {
	static Scanner scan = new Scanner(System.in);
	static List<Student> list = new ArrayList<Student>();
	@Override
	public void run() {
		int menu = 0;
		String fileName = "src/day16/board/list.txt";
		Load(fileName);
		do {
			//메뉴 출력
			printMenu();
			try {
			//메뉴 입력
				menu = scan.nextInt();
			//메뉴 실행
			runMenu(menu);
			}catch(Exception e) {
				System.out.println("예외가 발생했습니다.");
				scan.nextLine();
			}
		}while(menu != 3);
		save(fileName);
	}
	
	private void Load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List<Student>)ois.readObject();
			System.out.println("학생 정보를 불러왔습니다.");
		} catch (Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		}
	}
	
	private static void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");
		}
	}
	
	@Override
	public void printMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");

	}
	
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			printStudent();
			break;
		case 3:
			System.out.println("종료합니다.");
			break;
		default:
			throw new RuntimeException();
		}

	}

	private void printStudent() {
		list.stream().forEach(s->System.out.println(s));
		
	}

	private void insertStudent() {
		System.out.print("학년 :");
		int grade = scan.nextInt();
		System.out.print("반 :");
		int classNum = scan.nextInt();
		System.out.print("번호 :");
		int num = scan.nextInt();
		System.out.print("이름 :");
		String name = scan.next();
		
		Student std = new Student(grade, classNum, num, name);
		
		if(!list.contains(std)) {
			list.add(std);
			System.out.println("학생을 추가했습니다.");
			return;
		}
		System.out.println("등록된 학생입니다.");
		
	}

}
