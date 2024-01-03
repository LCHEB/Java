package day17.socket2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerEx2 {

	public static void main(String[] args) {
		//1. 서버의 포트번호 정함
		int port = 5001;
		ServerSocket serverSocker = null;
		
		try {
			//2. 서버용 소켓 객체 생성
			serverSocker =new ServerSocket(port);
			
			//3. 대기
			//4. 요청 수락 후 소켓 객체 생성
			Socket socket = serverSocker.accept();
			//5. 작업
			System.out.println("[연결 성공!]");
			//클라이언트가 보낸 문자열을 읽어와서 콘솔에 출력하는 쓰레드
			Thread receiveThread = new Thread(()->{
				try {
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					while(true) {
						String str = ois.readUTF();
						if(str.equals("-1")) {
							break;
						}
						System.out.println(str);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("서버 : 받는 기능 종료");
			});
			receiveThread.start();
			//문자열을 입력받아 클라이언트에 전송하는 쓰레드
			Thread sendThread = new Thread(()->{
				try{
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					Scanner scan = new Scanner(System.in);
					while(true) {
						String str = scan.nextLine();
						oos.writeUTF(str);
						oos.flush();
						if(str.equals("-1")) {
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("서버 : 보내는 기능 종료");
			});
			sendThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("서버 : 메인 기능 종료");
		
	}
	
	private static ArrayList<String> load(String fileName){
		ArrayList<String> list = new ArrayList<String>();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				list.add(ois.readUTF());
			}
		} catch (IOException e) {
			return list;
		}
	}
}
