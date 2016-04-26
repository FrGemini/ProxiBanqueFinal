package fr.inti.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;

import fr.inti.dao.IDaoClient;
import fr.inti.entities.Client;
import fr.inti.entities.Conseiller;
import fr.inti.services.IServiceClient;

@Controller(value="gestionClient")
@SessionScoped
public class GestionClientMB implements Serializable{

	private List<Client> clients;
	@Autowired
	private IDaoClient daoClient;
	@Autowired
	private IServiceClient serviceClient;
	private Client client;
	private int id;
	private Client selectedClient;
	private Conseiller conseiller;
	
	/******** Constructor ********/

	public GestionClientMB() {
		super();	
	}

    @PostConstruct
    public void init() {
    	this.client = new Client();
    	this.selectedClient = new Client();
    	this.conseiller = new Conseiller();
		this.id=0;
    }
    
    /******** Getter - Setter ********/
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Client> getClients(){
		return serviceClient.listeClient();
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public Client getClient() {
		
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public Client getSelectedClient() {
		return selectedClient;
	}


	public void setSelectedClient(Client selectedClient) {
		Client client = new Client(
                selectedClient.getNom(),
                selectedClient.getPrenom(),
                selectedClient.getAdresse(),
                selectedClient.getCodePostal(),
                selectedClient.getVille(),
                selectedClient.getTelephone()
                );
		client.setClientId(selectedClient.getClientId());
        this.selectedClient = client;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	/******* Methode Bean ********/
	
	public void addClient(){
		//client.setConseiller(conseiller);
		serviceClient.ajouterClient(client);
	}
	
	public void clientById(){
		setClient(daoClient.getClientById(id));
	}

	public void effacerClient(){
		serviceClient.supprimerClient(selectedClient);
	}
	
	public void modifierClient(){
		serviceClient.modifierClient(selectedClient);
	}
}
