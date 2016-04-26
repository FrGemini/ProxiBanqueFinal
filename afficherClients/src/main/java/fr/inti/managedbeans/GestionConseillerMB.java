package fr.inti.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.inti.dao.IDaoConseiller;
import fr.inti.entities.Client;
import fr.inti.entities.Conseiller;
import fr.inti.services.IServiceClient;
import fr.inti.services.IServiceConseiller;

@Controller(value="gestionConseiller")
@SessionScoped
public class GestionConseillerMB {
	@Autowired
	private IServiceConseiller serviceConseiller;
	
	private IServiceClient serviceClient;
	
	private List<Conseiller> conseillers;
	private List<Client> clients;
	
	public List<Client> getClients() {
		if(conseiller!=null){
		return serviceClient.listeClientByConseiller(conseiller.getConseillerId());
		}
		else{
			return serviceClient.listeClientByConseiller(1);
		}
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	private Conseiller conseiller;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GestionConseillerMB() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init(){
		this.conseiller=new Conseiller();
		this.clients=new ArrayList<Client>();
	}
	
	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public List<Conseiller> getConseillers() {
		return serviceConseiller.listeConseillers();
	}

	public void setConseillers(List<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	public void conseillerParId(int id){
		this.conseiller=serviceConseiller.getConseillerById(id);
	}
	
	public void ajouter(){
		serviceConseiller.ajouterConseiller(conseiller);
	}
	
	public void modifier(){
		serviceConseiller.modifierConseiller(conseiller);
		
	}
	
	
	
}
