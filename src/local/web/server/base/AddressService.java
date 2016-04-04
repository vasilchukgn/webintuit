package local.web.server.base;

public interface AddressService {

	public Address getAddress(Class<?> abonentClass);
	void setAddress(Abonent abonent);
}
