package pl.sda.service.seap;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService

public class Chat {
	public boolean login(String name){
		
		return true;
	}
	@WebMethod
	public boolean sendMessage(String login, String massega){
		
		return true;
	}

}
