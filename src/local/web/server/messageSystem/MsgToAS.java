package local.web.server.messageSystem;

import local.web.server.base.Abonent;
import local.web.server.base.AccountService;
import local.web.server.base.Address;
import local.web.server.base.Data;
import local.web.server.base.Msg;

public class MsgToAS extends Msg {
    public MsgToAS(Address from, Address to, Data data) {
        super(from, to, data);        
    }

    public void exec(Abonent abonent) {
        if(abonent instanceof AccountService){
//            exec((AccountService) abonent);
        	switch (super.data.getType()) {
        	case "RequestName":
        		((AccountService) abonent).setAccounter(super.data.getData());
        		System.out.println("Frontend -> AccountSystem: RequestName");
        		break;
        	}
        }
    }
}
