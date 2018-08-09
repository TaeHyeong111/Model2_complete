package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import proxy.PageProxy;
import proxy.Pagination;
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
		System.out.println("0.SearchCommand 진입");
		Map<String,Object> paramMap = new HashMap<>();
		String pageNumber = request.getParameter("pageNumber");
		System.out.println("1.pageNumber : "+pageNumber);
		PageProxy pxy = new PageProxy();
		int pn = (pageNumber==null)? 1: Integer.parseInt(pageNumber);
		pxy.carrayOut(pn);
		System.out.println("2.pn : " + pn );
		Pagination page = pxy.getPagination();
		System.out.println("3.page : " + page);
		paramMap.put("beginRow", String.valueOf(page.getBeginRow()));
		System.out.println("4.paramMap beginRow : "+paramMap.get("beginRow"));
		paramMap.put("endRow", String.valueOf(page.getEndRow()));
		System.out.println("5.paramMap beginRow : "+paramMap.get("endRow"));
		request.setAttribute("page", page);
		System.out.println("6.page : "+page);
		request.setAttribute("list", MemberServiceImpl.getInstance().search(paramMap));
		System.out.println("7.list : "+request.getAttribute("list"));
		
		request.setAttribute("count", MemberServiceImpl.getInstance().Count());
		request.setAttribute("", arg1);
		super.execute();
	}

}