package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
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
		String pageNum = request.getParameter("pageNumber");
		if(pageNum == null) {
			System.out.println("넘어온 pageNumber 가 없어요!!");
		}else {System.out.println("넘어온 pageNumber : "+request.getParameter("pageNumber"));}
		
			int beginPage = 1;
			int blockSize = 5; //초과시 블락 미만시 endpage if문만들기
			String pageNumber = request.getParameter("pageNumber");
			int beginrow = Integer.parseInt(pageNumber)*(blockSize-1);
			int endrow = Integer.parseInt(pageNumber)*blockSize;
			int count = MemberServiceImpl.getInstance().memberCount();
	        int endPage = 5;
	        
	        if(count/5 <= blockSize) { //5page 만듦
	            if(count %5 != 0) { //5로 나누어 떨어지지않으면 +1
	                endPage = count/5+1;
	            }else {
	                endPage = count/5; // 나누어 떨어지면 +0
	            }
	        }else {
	            endPage = blockSize;
	        }
	        int prevBlock = beginPage - blockSize;
	        int nextBlock = beginPage + blockSize;
	        
	        boolean existPrev = false;
	        if(prevBlock >= 0) {
	        	existPrev = true;
	        }
	        boolean existNext = false;
	        if(nextBlock <= pageCount) {
	        	existNext = true;
	        }
	        
	        Map<String,Object> param = new HashMap<>();
	        String beginRow = "1";
	        String endRow = "5";
	        param.put("beginRow", beginRow);
	        param.put("endRow", endRow);
	        request.getSession().setAttribute("list", MemberServiceImpl.getInstance().listMember());
			request.getSession().setAttribute("count", MemberServiceImpl.getInstance().memberCount());
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
			request.getSession().setAttribute("getList", MemberServiceImpl.getInstance().getlist(param));
			/*request.getSession().setAttribute("addlist", );*/
		
		super.execute();
	}
}