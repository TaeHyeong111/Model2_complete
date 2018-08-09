package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import domain.MemberBean;
import enums.Action;
import javafx.scene.AccessibleAction;
import service.MemberServiceImpl;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request);
		System.out.println("여기는 멤버 컨트롤러");
		System.out.println(request);
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		
		case ADD :
			System.out.println("액션"+Action.valueOf(Receiver.cmd.getAction().toUpperCase()));
			Carrier.redirect(request, response,
					"/member.do?action=move&page=userLoginForm");
			break;
		case LOGIN : 
			System.out.println("========");
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response,"/member.do?action=move&page=userLoginForm");
			}
			break;
			
		case MODIFY : 
			System.out.println("업데이트들어옴");
			Carrier.redirect(request, response,"");
			break;
		case REMOVE : 
			System.out.println("===딜리트진입===");
			Carrier.redirect(request, response,"");
			break;
		case MOVE : 
			System.out.println("액션"+Action.valueOf(Receiver.cmd.getAction().toUpperCase()));
				Carrier.forward(request, response);
			break;
		default:
			break;
		}
	}
}
