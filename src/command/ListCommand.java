package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class ListCommand extends Command {
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}

	@Override
	public void execute() {
		System.out.println("리스트");
			request.getSession().setAttribute("list", MemberServiceImpl.getInstance().listMember());
			//키,벨류   뒷놈이 멤버서비스임플에 값을 가져가 실행하여 user로 값을 전달함.
			System.out.println("리퀘스트 유저임"+request.getSession().getAttribute("list"));
		
		super.execute();
	}
}