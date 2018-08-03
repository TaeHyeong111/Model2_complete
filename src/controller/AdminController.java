package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Sentry;
import domain.MemberBean;
import enums.Action;
import javafx.scene.AccessibleAction;
import service.MemberServiceImpl;


@WebServlet("/admin.do") 
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		Sentry.init(request);
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE : 
				Carrier.forward(request, response);
		case LIST : 
			Carrier.forward(request, response);
		case RETRIEVE : 
			System.out.println("서치들어옴");
			Carrier.forward(request, response);
			break;
		case SEARCH : 
			System.out.println("qqq서치들어옴");
			Carrier.forward(request, response);
			break;
		case COUNT : 
			System.out.println("COUNT 진입");
			Carrier.forward(request, response);
		default:
			break;
		}
	}
}
