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
            case JOIN : 
                cmd = new CreateCommand(request);
                break;
            case LOGIN :
            	System.out.println("액션 로그인 진입");
            	cmd = new LoginCommand(request); // cmd == sentry.cmd
            	break;
            case LIST :
            	cmd = new ListCommand(request);
            	break;
            case SEARCH : 
            	cmd = new SearchCommand(request);
            	break;
            case RETRIEVE : 
            	System.out.println("리트리브진입");
            	cmd = new RetrieveCommand(request);
            	break;
            case UPDATE : 
            	cmd = new UpdateCommand(request);
            	break;
            case DELETE : 
            	System.out.println("딜리트커맨더 들어옴");
            	cmd = new DeleteCommand(request);
            	break;
            case COUNT : 
            	cmd = new CountCommand(request);
            	break;
            case ADMIN:
            	cmd = new CountCommand(request);
            default:
                break;
            }
            return cmd;
    }
}