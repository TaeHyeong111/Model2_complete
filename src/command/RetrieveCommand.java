package command;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.User;

import service.MemberServiceImpl;

public class RetrieveCommand extends Command {

	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("리트리브들어옴");
	request.getSession().setAttribute("user", MemberServiceImpl.getInstance().retreieve((request.getParameter("userid")))); 
	System.out.println("user : "+request.getAttribute("user"));
	String img = "";
	// ImageServiceImpl.getInstance.retrieve();
	String imgPath = "/upload/"+img;
	request.setAttribute("img", imgPath);
		super.execute();
	}
}
