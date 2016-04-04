package local.web.server.messageSystem;

import local.web.server.base.Abonent;
import local.web.server.base.Address;
import local.web.server.base.Frontend;
import local.web.server.base.Msg;

public abstract class MsgToFrontend extends Msg {

    public MsgToFrontend(Address from, Address to) {
        super(from, to);
    }

    public void exec(Abonent abonent) {
        if(abonent instanceof Frontend){
            exec((Frontend)abonent);
        }
    } 
}
