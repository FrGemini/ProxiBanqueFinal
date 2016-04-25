package fr.inti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.inti.dao.DaoClientImpl;
import fr.inti.dao.IDaoClient;
import fr.inti.entities.Client;

@Service
public class ServiceClientImpl implements IServiceClient{

	@Autowired
	private IDaoClient daoClient;
	
	
	
	public ServiceClientImpl() {
		super();
		
	}



	public List<Client> listeClient() {
		return daoClient.getAllClients();
	}



	public Client ClientById(int id) {
		return daoClient.getClientById(id);
	}



	public void ajouterClient(Client client) {
		daoClient.addClient(client);
		
	}



	public void modifierClient(Client client) {
		daoClient.updateClient(client);
		
	}



	public void supprimerClient(Client client) {
		daoClient.deleteClient(client);
		
	}
	


}
