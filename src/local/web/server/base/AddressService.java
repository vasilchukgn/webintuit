package local.web.server.base;

public interface AddressService {

    Address getAddressAS();    
    Address getAddressFrontend();   
	
	public Address getAddress(Class<?> abonentClass);
	void setAddress(Abonent abonent);
}
