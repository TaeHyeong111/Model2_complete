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
	request.setAttribute("user", MemberServiceImpl.getInstance().findById((request.getParameter("userid")))); //memberDetail에서 uesr 사용
	System.out.println(request.getAttribute("유저에는 모가있을까"+"user"));
		super.execute();
	}
}
