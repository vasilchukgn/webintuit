package local.web.server.accountService;

import java.util.HashMap;
import java.util.Map;

import local.web.server.base.Abonent;
import local.web.server.base.AccountService;
import local.web.server.base.Address;
import local.web.server.base.MessageSystem;
import local.web.server.utils.TimeHelper;


public class AccountServiceImpl implements AccountService, Abonent, Runnable {
    private Address address;
    private MessageSystem ms;
    private Integer id;
    
    private Map<String, Integer> Accounter = new HashMap<String, Integer>();
    
    public AccountServiceImpl(MessageSystem ms){
    	id = 0;
        this.ms = ms;
        this.address = new Address();
        ms.addService(this);
		System.out.println("Account Service created");
    }
      
    public void run(){
        while(true){
        	ms.execForAbonent(this);
            TimeHelper.sleep(100);
        }
    }

    public Integer getUserId(String name){
        TimeHelper.sleep(5000);
        return Accounter.get(name);
    }
    
    public Address getAddress() {
        return address;
    }
    
    public MessageSystem getMessageSystem(){
        return ms;
    }
    
	public void setAccounter(String name){
		id++;
		Accounter.put(name, id);
	}
}
