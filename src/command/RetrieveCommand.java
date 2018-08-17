package command;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.User;

import dao.MemberDAOImpl;
import domain.MemberBean;
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
		MemberBean mem = new MemberBean();
		mem = MemberServiceImpl.getInstance().retreieve(request.getParameter("userid"));
	request.setAttribute("user", mem);
	System.out.println("리"+request.getAttribute("user"));
	
		super.execute();
	}
}
