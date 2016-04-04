package local.web.server.messageSystem;

import local.web.server.base.Abonent;
import local.web.server.base.AccountService;
import local.web.server.base.Address;
import local.web.server.base.Msg;

public abstract class MsgToAS extends Msg {
    public MsgToAS(Address from, Address to) {
        super(from, to);        
    }

    public void exec(Abonent abonent) {
        if(abonent instanceof AccountService){
            exec((AccountService) abonent);
        }
    }
}
