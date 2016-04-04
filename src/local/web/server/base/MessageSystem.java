package local.web.server.base;

public interface MessageSystem {

	void addService(Abonent abonent);

	void execForAbonent(Abonent abonent);

	void sendMessage(Msg message);
	
	AddressService getAddressService();
}
