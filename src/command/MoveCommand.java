package command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request) { //request : index�� ������������ ��Ÿ���µ���. 
		/*ȸ������, ��������� �������� ������ �ٸ� �ּҰ��� ������.
		 * org.apache.catalina.connector.RequestFacade@5c96c312
		org.apache.catalina.connector.RequestFacade@1dddc67a*/
		
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf("."))); 
		//request.Servletpath() : /member.do, setDomain�� ���� member
		setAction(request.getParameter("action"));
		//������������ �׼� ex) ȸ�������� move
		setPage(request.getParameter("page"));
		//������������ ������ ex) ȸ�������� JoinForm 
		execute();
		/*public void execute() {
			this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp"; //domain = joinForm 
			view = /WEB-INF/view/member/joinForm.jsp
		}*/
	}
}
