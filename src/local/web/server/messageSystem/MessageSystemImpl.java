package local.web.server.messageSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import local.web.server.base.Abonent;
import local.web.server.base.Address;
import local.web.server.base.AddressService;
import local.web.server.base.MessageSystem;
import local.web.server.base.Msg;

public class MessageSystemImpl implements MessageSystem {
    private Map<Address, ConcurrentLinkedQueue<Msg>> messages = new HashMap<Address, ConcurrentLinkedQueue<Msg>>();
    private AddressService addressService = new AddressServiceImpl();
    
    public void addService(Abonent abonent){
        addressService.setAddress(abonent);
        messages.put(abonent.getAddress(), new ConcurrentLinkedQueue<Msg>());
    }
    
    public void sendMessage(Msg message){
        Queue<Msg> messageQueue = messages.get(message.getTo());
        messageQueue.add(message);      
    }
        
    public void execForAbonent(Abonent abonent) {
        Queue<Msg> messageQueue = messages.get(abonent.getAddress());
        if(messageQueue == null){
            return;
        }
        while(!messageQueue.isEmpty()){
            Msg message = messageQueue.poll();
//            System.out.println("from MessageSystem");
            message.exec(abonent);
        }
    }
    
    public AddressService getAddressService(){
        return addressService;
    }
}
