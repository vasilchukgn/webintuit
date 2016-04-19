package local.web.server.messageSystem;

import java.util.HashMap;
import java.util.Map;

import local.web.server.base.Abonent;
import local.web.server.base.Address;
import local.web.server.base.AddressService;

public class AddressServiceImpl implements AddressService {
    private Map<Class<?>, Address> addresses = new HashMap<Class<?>, Address>();
    
    public Address getAddress(Class<?> abonentClass) {
        return addresses.get(abonentClass);
    }
    
/*    public Address getAddressAS() {
    	return addresses.get();
    }
*/    
    Address getAddressAS();    
    Address getAddressFrontend();   
    
    public void setAddress(Abonent abonent) {
        addresses.put(abonent.getClass(), abonent.getAddress());
    }
}
