package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void forward(HttpServletRequest request, 
			HttpServletResponse response) {
		try {
			request
			.getRequestDispatcher(Receiver.cmd.getView())
			.forward(request, response);
			System.out.println("??? : "+Receiver.cmd.getView());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void redirect(
			HttpServletRequest request, 
			HttpServletResponse response,String url){
		try {
			response.sendRedirect(request.getContextPath()+url);
			System.out.println("?? : "+request.getContextPath()+url);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}

/*package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
    public static void forward(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("포워드 : " + Sentry.cmd.getView());
        System.out.println("나는캐리어");
			try {
				request
				.getRequestDispatcher(Sentry.cmd.getView()) 
				.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    public static void redirect(
    		HttpServletRequest request, 
    		HttpServletResponse response, 
    		String url) {
    	try {
    		System.out.println("리퀘스트"+request);
			response.sendRedirect(request.getContextPath()+url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}*/