package day18.student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class StudentProgram implements Program {
	private static Scanner scan = new Scanner(System.in);
	private StudentManager sm = new StudentManager();
	private static final int EXIT = 4;
	private Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	@Override
	public void run() {
		String ip = "192.168.30.29";
		int port = 5001;
		//서버와 연결
		connectServer(ip,port);
		//서버에서 학생 정보를 불러옴
		load();
		int menu = 0;
		do {
			printMenu();
			try {
				
				menu = scan.nextInt();
			
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
			
		}while(menu != EXIT);
	}

	private void connectServer(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			System.out.println("[서버 연결 성공]");
		} catch (IOException e) {
			System.out.println("[서버 연결 실패]");
		}
	}

	private void load() {
		if(socket == null) {
			System.out.println("[서버에 연결되지 않아 불러올 수 없습니다.]");
		}
		try {
			oos.writeUTF("LOAD");
			oos.flush();
			//읽어옴
			List<Student> list = (List<Student>) ois.readObject();
			sm = new StudentManager(list);
			System.out.println("[불러오기 성공]");
		}catch(IOException | ClassNotFoundException e) {
			System.out.println("[불러오기 중 예외가 발생했습니다.]");
		}
		
	}

	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 목록 조회");
		System.out.println("3. 학생 수정(이름) : ");
		System.out.println("4. 종료");
		System.out.println("-----------------------");
		System.out.println("메뉴 선택 : ");

	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudnet();
			break;
		case 2:
			printStudent();
			break;
		case 3:
			updateStudent();
			break;
		case 4:
			exit();
			System.out.println("종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}


	private void updateStudent() {
		//학생 정보 입력
		System.out.println("학년 : ");
		int grade = scan.nextInt();
		System.out.println("반 : ");
		int classNum = scan.nextInt();
		System.out.println("번호 : ");
		int num = scan.nextInt();
		System.out.println("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		
		//학생 정보 수정
		Student std = new Student(grade, classNum, num, name);
		if(sm.updateStudent(std)) {
			System.out.println("이름을 수정했습니다.");
			sendUpdateStudent(std);
		}else {
			System.out.println("등록되지 않은 학생입니다.");
		}
		
	}

	private void sendUpdateStudent(Student std) {
		try {
			oos.writeUTF("UPDATE");
			oos.flush();
			oos.writeObject(std);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exit() {
		try {
			oos.writeUTF("SAVE");
			oos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void insertStudnet() {
		//학생 정보를 입력
		System.out.println("학년 : ");
		int grade = scan.nextInt();
		System.out.println("반 : ");
		int classNum = scan.nextInt();
		System.out.println("번호 : ");
		int num = scan.nextInt();
		System.out.println("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		
		Student std = new Student(grade, classNum, num, name);
		//매니저에게 입력받은 학생 정보를 추가
		if(sm.insertStudent(std)) {
			System.out.println("학생을 추가했습니다.");
			sendStudent(std);
		}else {
			System.out.println("등록된 학생입니다.");
		}
		
	}

	private void sendStudent(Student std) {
		if(socket == null) {
			System.out.println("[서버에 연결되지 않아 학생 정보를 추가할 수 없습니다.]");
		}
		try {
			oos.writeUTF("INSERT");
			oos.flush();
			oos.writeObject(std);
			oos.flush();
			System.out.println("[서버에 학생 추가 성공]");
		}catch(IOException e) {
			System.out.println("[서버에 학생 추가 중 예외가 발생했습니다.]");
		}
		
	}

	private void printStudent() {
		//매니저에게 전체 학생 정보를 출력
		sm.printStudent();
	}
}
