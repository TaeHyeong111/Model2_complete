package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class SearchCommand extends Command {
	List<MemberBean>members;
	public List<MemberBean> getMembers() {
		return members;
	}
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("서치커맨드 들어옴");
		String searchOption = request.getParameter("searchOption");
		String searchWord = request.getParameter("searchWord");
		String page = request.getParameter("page");
		String action = request.getParameter("action");
		String domain = super.domain;
		System.out.println(searchOption+searchWord+page+action+domain);
		
		/*select * from domain where searchOption like '%searchWord'%*/
		request.setAttribute("list",MemberServiceImpl.getInstance().findMemberByTeamName(request.getParameter("searchOption")+"/"+request.getParameter("searchWord")));
		System.out.println(request.getParameter("searchOption")+"/"+request.getParameter("searchWord"));
		System.out.println("123123123"+request.getAttribute("list"));
		super.execute();
	}
}
