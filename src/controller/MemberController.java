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
		System.out.println("멤버두 들어옴");
		Receiver.init(request);
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE : 
				Carrier.forward(request, response);
			break;
		case ADD :
			System.out.println("케이스탐");
			Carrier.redirect(request, response,
					"/member.do?action=move&page=login");
			break;
		case LOGIN : 
			System.out.println("========");
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response,"/member.do?action=move&page=login");
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
		
		default:
			break;
		}
	}
}
