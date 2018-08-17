package command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command {
	public MoveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf("."))); //member
		setAction(request.getParameter("action"));
		execute();

	}
	@Override
	public void execute() {
		super.execute();
		request.setAttribute("pagename",
				request.getParameter("page"));
		System.out.println("페이지네임 : "+request.getAttribute("pagename"));
	}
}
