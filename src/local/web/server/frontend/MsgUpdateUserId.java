package local.web.server.frontend;

import local.web.server.base.Address;
import local.web.server.base.Frontend;
import local.web.server.messageSystem.MsgToFrontend;

public class MsgUpdateUserId extends MsgToFrontend {
    private String name;
    private Integer id;
    
    public MsgUpdateUserId(Address from, Address to, String name, Integer id) {
        super(from, to);
        this.name = name;
        this.id = id;
    }

    void exec(Frontend frontend) {
        frontend.setId(name, id);
    }
}
