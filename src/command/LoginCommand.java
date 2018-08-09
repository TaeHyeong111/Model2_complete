package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}

	@Override
	public void execute() {
		System.out.println("로그인커맨드진입");
		MemberBean bean = new MemberBean();
		bean.setUserId(request.getParameter("userid"));
		bean.setPassword(request.getParameter("password")); 
		System.out.println("익스큐트 빈들어옴"+bean);
		if (MemberServiceImpl.getInstance().login(bean)) {
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", MemberServiceImpl.getInstance().retreieve(request.getParameter("userid")));
			//키,벨류   뒷놈이 멤버서비스임플에 값을 가져가 실행하여 user로 값을 전달함.
			System.out.println("리퀘스트 유저임"+request.getSession().getAttribute("user"));
		}else {
			request.setAttribute("match", "FALSE");
		}
		super.execute();
	}
}
