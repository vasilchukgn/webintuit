package local.web.server.base;

public interface AccountService extends Abonent {
	MessageSystem getMessageSystem();
	
	Integer getUserId(String name);

	void setAccounter(String name);
}
