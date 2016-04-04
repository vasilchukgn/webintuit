package local.web.server.frontend;

import local.web.server.base.AccountService;
import local.web.server.base.Address;
import local.web.server.messageSystem.MsgToAS;

public class MsgGetUserId extends MsgToAS {
    private String name;
    
    public MsgGetUserId(Address from, Address to, String name) {
        super(from, to);
        this.name= name;
    }

    void exec(AccountService accountService) {
        Integer id = accountService.getUserId(name);
        accountService.getMessageSystem().sendMessage(new MsgUpdateUserId(getTo(), getFrom(), name, id));
    }
}
