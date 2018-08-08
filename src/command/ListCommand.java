package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import proxy.PageProxy;
import proxy.Pagination;
import service.MemberServiceImpl;

public class ListCommand extends Command {
	public ListCommand(HttpServletRequest request) {
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
		PageProxy pxy = new PageProxy();
		int pn = (pageNumber==null)? 1: Integer.parseInt(pageNumber);
		pxy.carrayOut(pn);
		Pagination page = pxy.getPagination();
		paramMap.put("beginRow", String.valueOf(page.getBeginRow()));
		paramMap.put("endRow", String.valueOf(page.getEndRow()));
		request.setAttribute("page", page);
		request.setAttribute("list", MemberServiceImpl.getInstance().getlist(paramMap));
		super.execute();
	}

}