package fr.inti.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.inti.dao.IDaoClient;
import fr.inti.entities.Client;
import fr.inti.services.IServiceClient;
import fr.inti.services.ServiceClientImpl;

public class Test {

	
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"src/main/webapp/WEB-INF/applicationContext.xml");
		IDaoClient daoClient = (IDaoClient) ctx.getBean("daoClientImpl");
		
		Client client= daoClient.getClientById(1);
		client.setNom("Man");
		client.setPrenom("Super");
		client.setAdresse("rue Krypton");
		daoClient.updateClient(client);
		
		System.out.println(daoClient.getClientById(1).toString());
	}
}
