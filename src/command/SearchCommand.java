package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import enums.Domain;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import service.MemberServiceImpl;

public class SearchCommand extends Command {
	public SearchCommand(HttpServletRequest request) {
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
		Map<String,Object> paramMap = new HashMap<>();
		String pageNumber = request.getParameter("pageNumber");
		System.out.println("1.pageNumber : "+pageNumber);
		PageProxy pxy = new PageProxy();
	    pxy.carryOut((pageNumber==null)? 1: Integer.parseInt(pageNumber));
	    Pagination page = pxy.getPagination();
	    paramMap.put("table", Domain.MEMBER);
        paramMap.put("beginRow", String.valueOf(page.getBeginRow()));
        paramMap.put("endRow", String.valueOf(page.getEndRow()));
        paramMap.put("rowCount", String.valueOf(page.getRowCount()));
        paramMap.put("searchOption", request.getParameter("searchOption"));
        paramMap.put("searchWord", request.getParameter("searchWord"));
		
		request.setAttribute("page", page);
		System.out.println("page : "+ request.getAttribute("page"));
		request.setAttribute("list", MemberServiceImpl.getInstance().search(paramMap));
		System.out.println("list : " + request.getAttribute("list"));
		

		super.execute();
	}

}