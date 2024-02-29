package kr.kh.app.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import kr.kh.app.model.vo.MemberVO;

/**
 * Servlet Filter implementation class GuestFilter
 */
@WebFilter({"/login","/signup"})
public class GuestFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//회원 정보를 가져옴
		MemberVO user = (MemberVO)((HttpServletRequest)request).getSession().getAttribute("user");
		//회원 정보가 있으면 로그인 한 회원이 이용할 수 없는 서비스입니다라고 알림 후 메인페이지로 오기
		if(user != null) {
			request.setAttribute("msg", "로그인 한 회원이 이용할 수 없는 서비스입니다.");
			request.setAttribute("url", "");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

}
