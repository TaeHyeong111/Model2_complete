package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class AddCommand extends Command {
	public AddCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}

	@Override
	public void execute() {
		System.out.println("회원가입진입!!");
		MemberBean mem = new MemberBean();
		mem.setUserId(request.getParameter("userid")); 
		mem.setPassword(request.getParameter("password"));
		mem.setName(request.getParameter("name"));
		mem.setSsn(request.getParameter("ssn"));
		mem.setGender(request.getParameter("gender"));
		mem.setAge(request.getParameter("age"));
		mem.setRoll(request.getParameter("roll"));
		mem.setTeamId(request.getParameter("teamid"));
		mem.setSubject(request.getParameter("subject"));
		System.out.println("매미는 맴맴 : "+mem);
		// mem.setSubject(ParamMap.getValues(request, "subject"));
		MemberServiceImpl.getInstance().add(mem);

	}
}
