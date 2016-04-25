package fr.inti.dao;

import java.util.List;

import fr.inti.entities.Client;

public interface IDaoClient {
	
	List<Client> getAllClients();
	void addClient(Client client);
	Client getClientById(int id);
	void deleteClient(Client client);
	void updateClient(Client client);

}
