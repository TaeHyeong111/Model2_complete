package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Action;

public class Commander {
    public static Command order(HttpServletRequest request){
            Command cmd =null;
            switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
            case MOVE : 
                cmd = new MoveCommand(request);
                break;
            case ADD : 
                cmd = new AddCommand(request);
                break;
            case LOGIN :
            	cmd = new LoginCommand(request); // cmd == sentry.cmd
            	break;
            case RETRIEVE : 
            	cmd = new RetrieveCommand(request);
            	break;
            case SEARCH : 
            	cmd = new SearchCommand(request);
            	break;
            case MODIFY : 
            	cmd = new ModifyCommand(request);
            	break;
            case REMOVE : 
            	cmd = new RemoveCommand(request);
            	break;
            case COUNT : 
            	cmd = new CountCommand(request);
            	break;
            case FILEUPLOAD : 
            	cmd = new CountCommand(request);
            	break;
            default:
                break;
            }
            return cmd;
    }
}