package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class ModifyCommand extends Command {
	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath()
				.substring(1,
						request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
		case MEMBER :
			System.out.println("update 들어옴!!!");
			Map<String,Object> updateMap = new HashMap<>();
			updateMap.put("userid", (((MemberBean) request.getSession().getAttribute("user")).getUserId()));
			updateMap.put("password", request.getParameter("password"));
			updateMap.put("teamid", request.getParameter("teamid"));
			updateMap.put("roll", request.getParameter("roll"));
			MemberServiceImpl.getInstance().modify(updateMap);
			System.out.println("update 성공!!");
			break;
		default : 
			break;
		}
	}
}

/*package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class UpdateCommand extends Command{

	public UpdateCommand(HttpServletRequest request) {
		System.out.println("������Ʈ�� ������Ʈ"+request);
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	public void execute() {
		switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER : 
			System.out.println("업데이트들어옴");
			MemberBean mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			mem.setPassword("newpassword");
			MemberServiceImpl.getInstance().updateMemberInformation(mem);
	
            MemberBean mem = new MemberBean();
            mem.setUserId(request.getParameter("userid"));
            mem.setPassword(request.getParameter("password"));
            System.out.println("업데이트 맴들어옴"+mem);
            if(MemberServiceImpl.getInstance().login(mem)) {
                mem.setPassword(request.getParameter("newpassword"));
                MemberServiceImpl.getInstance().updateMemberInformation(mem);        
            } else {
                System.out.println("error");
            }
            break;
			default:
			 
				break;
		}
	}
}*/
