package command;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Sentry {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		cmd = Commander.order(request);
		System.out.println("씨엠디엔 뭐가올까"+cmd);
		/*String servletPath=request.getServletPath(); // servletPath /member.do
		System.out.println("��Ʈ��:" + servletPath.substring(1, servletPath.indexOf(".")));// .�տ����� �����Ͷ�
		System.out.println(servletPath);
		cmd = Commander.order(
				servletPath.substring(1,servletPath.indexOf(".")), //domain ����	(member)
				request.getParameter("action"), // action���� ���� (�׼�move)
				request.getParameter("page")); // page�� ������ (������joinForm)
*/	}
}
