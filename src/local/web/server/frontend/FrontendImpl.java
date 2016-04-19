package local.web.server.frontend;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import local.web.server.base.Abonent;
import local.web.server.base.AccountService;
import local.web.server.base.Address;
import local.web.server.base.AddressService;
import local.web.server.base.Data;
import local.web.server.base.Frontend;
import local.web.server.base.MessageSystem;
//import local.web.server.base.Msg;
import local.web.server.messageSystem.MsgToAS;
import local.web.server.utils.TimeHelper;
//import local.web.server.accountService.AccountServiceImpl;

public class FrontendImpl extends AbstractHandler implements Frontend, Abonent, Runnable {
//	private static final long serialVersionUID = 1L;
//	private int userID;
	private MessageSystem ms;
	private AccountService accountService;
	private Address address;
	public Map<String, Integer> nameToId = new HashMap<String, Integer>();
	
	
	public FrontendImpl(MessageSystem ms, AccountService accountService) {
		super();
        this.ms = ms;
        this.address = new Address();
        ms.addService(this);
        this.accountService = accountService;
//		userID = 0;
		System.out.println("Frontend created");
	}
	
	public void run(){
	    while(true){	  
//	        System.out.println("Frontend");
            ms.execForAbonent(this);
	        TimeHelper.sleep(100);
	    }
	}
	
	public Address getAddress(){
		return address;
	}
	   
	public void setId(String name, Integer id){
		nameToId.put(name, id);
	}    	
	
    public MessageSystem getMessageSystem(){
        return ms;
    } 
	
	public String renderLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().println("");
		response.getWriter().println("<!DOCTYPE html>");
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<meta charset=\"UTF-8\">");
		response.getWriter().println("<title>Gregory WebSite</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<script>");
		response.getWriter().println("</script>");
		response.getWriter().println("<body>");
		response.getWriter().println("<form method=\"post\" action=\"\">");
		response.getWriter().println("Username: <input type=\"text\" name=\"user\">");
		response.getWriter().println("<br>");
		response.getWriter().println("<br>");
		response.getWriter().println("<input type=\"submit\">");
		response.getWriter().println("</form>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
		
		return request.getParameter("user");
	}
	
	public void handle(String target, Request baseRequest,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        
        String user = renderLoginPage(request, response);
        
        if ((user != null) && (user.length() != 0)) {
        	MsgToAS msg2as = new MsgToAS(getAddress(), accountService.getAddress(), new Data("RequestName", user));
        	ms.sendMessage(msg2as);
        	
//        	userID++;
//        	setId(user, userID);
//        	response.getWriter().println("user: " + user + " ID: " + userID);
        }
	}
}
