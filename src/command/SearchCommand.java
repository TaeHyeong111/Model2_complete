package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import proxy.PageProxy;
import proxy.Pagination;

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
		Map<String,Object> map = new HashMap<>();
		String pageNumber = request.getParameter("pageNumber");
		/*PageProxy pxy = new PageProxy();
		pxy.carrayOut((pageNumber==null)?
				1 : Integer.parseInt(pageNumber));
		Pagination page = pxy.getPagination();
		System.out.println("page : "+page);*/
		super.execute();
	}

}