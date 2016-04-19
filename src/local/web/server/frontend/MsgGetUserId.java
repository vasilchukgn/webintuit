package local.web.server.frontend;

import local.web.server.base.AccountService;
import local.web.server.base.Address;
import local.web.server.base.Data;
import local.web.server.messageSystem.MsgToAS;

public class MsgGetUserId extends MsgToAS {
    private String name;
    
    public MsgGetUserId(Address from, Address to, Data data, String name) {
        super(from, to, data);
        this.name= name;
    }

    void exec(AccountService accountService) {
        Integer id = accountService.getUserId(name);
//        accountService.getMessageSystem().sendMessage(new MsgUpdateUserId(getTo(), getFrom(), name, id));
    }
}
