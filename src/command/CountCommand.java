package command;

import javax.servlet.http.HttpServletRequest;

import enums.Domain;
import service.MemberServiceImpl;

public class CountCommand extends Command {
	private int count;

	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}

	public void execute() {
		request.setAttribute("count", MemberServiceImpl.getInstance().memberCount());
	}
}
