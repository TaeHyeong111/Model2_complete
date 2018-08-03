package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enums.Domain;
import enums.Term;

@WebServlet("/common.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	enum Resources{
		CTX, CSS, JS, IMG
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = 0;
		for(Resources r : Resources.values()) { //클래스타입, 변수명, 클래스길이
			if(i==0) {
				request.getSession() // 겟세션에 ctx의 값을 설정하고 리퀘스트로 보내는듯함 (세션함수는 메소드가 실행되는동안 값을 가지고있음) 
				.setAttribute(r.toString().toLowerCase(),
						request.getContextPath()); //ctx, getContextPath()로 어트리뷰트한것임 (ctx = getContextPath();)
				
				//ctx를 getContextPath()한것임
			}else {
				request.getSession()
				.setAttribute(r.toString().toLowerCase(),
						request.getContextPath()+
						"/resources/"+r.toString().toLowerCase());
			} //GMS-Model2/resources/css
			i++;
		}
		request.getRequestDispatcher(Term.WEBPATH.toString()+Term.MAIN.toString()).forward(request, response);
	} //페이지 이동기능
}