package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class DeleteCommand extends Command {
	public DeleteCommand(HttpServletRequest requset) {
		System.out.println("DeleteCommand 들어옴!!!");
		setRequest(requset);
		setDomain(request.getServletPath()
				.substring(1,
						request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	public void execute() {
		System.out.println("익스큐즈익스큐즈");
		switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER :
			MemberBean mem = new MemberBean();
			mem.setUserId(((MemberBean)request.getSession().getAttribute("user")).getUserId());
			mem.setPassword(request.getParameter("password"));
			System.out.println("맴"+mem);
			if(MemberServiceImpl.getInstance().login(mem)) {
				MemberServiceImpl.getInstance().deleteMemberInformation(mem);
				request.getSession().invalidate();
			} else {
				System.out.println("Error");
			}
			break;
		default : 
			break;
		}
	}
}

/*package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class DeleteCommand extends Command {

	public DeleteCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}

	public void execute() {
		super.execute();
		MemberBean bean = new MemberBean();
		bean.setUserId(((MemberBean)request.getSession().getAttribute("user")).getUserId());
		bean.setPassword(request.getParameter("password"));
		MemberServiceImpl.getInstance().deleteMemberInformation(bean);
		request.getSession().invalidate();
	}
}*/
