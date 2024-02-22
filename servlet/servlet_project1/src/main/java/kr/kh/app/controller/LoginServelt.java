package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServelt() {
    }
    
    /* 화면에서 전달한 id와 pw을 콘솔창에 출력 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("전송 받은 ID : " + id);
		String pw = request.getParameter("pw");
		System.out.println("전송 받은 PW : " + pw);
		doGet(request, response);
	}

}
