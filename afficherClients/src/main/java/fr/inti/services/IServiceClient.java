package fr.inti.services;

import java.util.List;

import fr.inti.entities.Client;

public interface IServiceClient {

	List<Client> listeClient();
	Client ClientById(int id);
	void ajouterClient(Client client);
	void modifierClient(Client client);
	void supprimerClient(Client client);
}
