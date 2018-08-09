package command;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Receiver {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		cmd = Commander.order(request);
		
	}
}
