package command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request) { //request : index의 진입페이지를 나타내는듯함. 
		/*회원가입, 멤버삭제를 눌럿더니 각각의 다른 주소값이 나왔음.
		 * org.apache.catalina.connector.RequestFacade@5c96c312
		org.apache.catalina.connector.RequestFacade@1dddc67a*/
		
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf("."))); 
		//request.Servletpath() : /member.do, setDomain의 값은 member
		setAction(request.getParameter("action"));
		//진입페이지의 액션 ex) 회원가입은 move
		setPage(request.getParameter("page"));
		//진입페이지의 페이지 ex) 회원가입은 JoinForm 
		execute();
		/*public void execute() {
			this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp"; //domain = joinForm 
			view = /WEB-INF/view/member/joinForm.jsp
		}*/
	}
}
