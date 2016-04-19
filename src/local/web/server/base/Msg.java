package local.web.server.base;

public abstract class Msg {
	   private Address from;
	   private Address to;
	   public Data data;
	    
	   public Msg(Address from, Address to, Data data){
	        this.from = from;
	        this.to = to;
	        this.data = data;
	   }
	    
	   public Address getFrom(){
	        return from;
	   }
	    
	   public Address getTo(){
	        return to;
	   }
	   
	   public Data getData(){
		   return data;
	   }
	    
	   public abstract void exec(Abonent abonent);
}
