package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class FileCommand extends Command{

	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
	request.setAttribute("pagename",
			request.getParameter("page")); //memberDetail에서 uesr 사용
	System.out.println(request.getAttribute("유저에는 모가있을까"+"user"));
		super.execute();
	}
}
