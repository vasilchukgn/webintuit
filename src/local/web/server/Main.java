package local.web.server;

import org.eclipse.jetty.server.Server;

import local.web.server.accountService.AccountServiceImpl;
import local.web.server.base.MessageSystem;
import local.web.server.frontend.FrontendImpl;
import local.web.server.messageSystem.MessageSystemImpl;

public class Main {

	public static void main(String[] args) throws Exception {
		MessageSystem ms = new MessageSystemImpl();
		   
	    AccountServiceImpl accountService = new AccountServiceImpl(ms);
		FrontendImpl frontend = new FrontendImpl(ms);
	    
	    (new Thread(frontend)).start();
	    (new Thread(accountService)).start();   			
		
		Server server = new Server(8080);
		server.setHandler(frontend);
		
		try {
        	server.start();
        	System.out.println("Listening port : " + 8080 );
        	server.join();
        } catch (Exception e) {
            System.out.println("Error.");
        	e.printStackTrace();
        }
	}

}
