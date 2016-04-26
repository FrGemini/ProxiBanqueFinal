package fr.inti.managedbeans;

import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



import fr.inti.entities.Client;
import fr.inti.entities.CompteBancaire;
import fr.inti.entities.CompteCourant;
import fr.inti.entities.CompteEpargne;
import fr.inti.services.IServiceCompteCourant;
import fr.inti.services.IServiceCompteEpargne;


@Controller(value="gestionCompte")
@RequestScoped
public class GestionCompteMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IServiceCompteCourant serviceCompteCourant;
	
	@Autowired
	private IServiceCompteEpargne serviceCompteEpargne;
	
	
	private CompteBancaire ccSource;
	private CompteBancaire ccDest;
	private String typeCompteSource;
	private String typeCompteDestination;
	private Client clientDebiter;
	private Client clientCrediter;
	
	private float montantVirement;
	private float montantRetrait;
	private float montantDepot;
	
	public GestionCompteMB() {
		super();
		this.typeCompteDestination = "";
		this.typeCompteSource = "";
		this.montantVirement = 0;
		this.montantRetrait = 0;
		this.montantDepot = 0;
		this.clientCrediter = new Client();
		this.clientDebiter = new Client();
	}
	
	
	/******* GETTER - SETTER *******/
	
	public CompteBancaire getCcSource() {
		return ccSource;
	}


	public void setCcSource(CompteBancaire ccSource) {
		this.ccSource = ccSource;
	}

	public CompteBancaire getCcDest() {
		return ccDest;
	}

	public void setCcDest(CompteBancaire ccDest) {
		this.ccDest = ccDest;
	}

	public String getTypeCompteSource() {
		return typeCompteSource;
	}

	public void setTypeCompteSource(String typeCompteSource) {
		this.typeCompteSource = typeCompteSource;
	}

	public String getTypeCompteDestination() {
		return typeCompteDestination;
	}

	public void setTypeCompteDestination(String typeCompteDestination) {
		this.typeCompteDestination = typeCompteDestination;
	}

	public float getMontantVirement() {
		return montantVirement;
	}

	public void setMontantVirement(float montantVirement) {
		this.montantVirement = montantVirement;
	}
	

	public float getMontantRetrait() {
		return montantRetrait;
	}


	public void setMontantRetrait(float montantRetrait) {
		this.montantRetrait = montantRetrait;
	}


	public float getMontantDepot() {
		return montantDepot;
	}


	public void setMontantDepot(float montantDepot) {
		this.montantDepot = montantDepot;
	}


	public IServiceCompteCourant getServiceCompteCourant() {
		return serviceCompteCourant;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IServiceCompteEpargne getServiceCompteEpargne() {
		return serviceCompteEpargne;
	}
	
	public Client getClientDebiter() {
		return clientDebiter;
	}


	public void setClientDebiter(Client clientDebiter) {
		this.clientDebiter = clientDebiter;
	}


	public Client getClientCrediter() {
		return clientCrediter;
	}


	public void setClientCrediter(Client clientCrediter) {
		this.clientCrediter = clientCrediter;
	}
	
	
	/********** Methodes managed bean **********/

	/**
	 * initialisation du compte débité en fonction du type de compte que l'on choisit
	 * @param typeCompteSource
	 * @param compte
	 */
	public void initCompteSource(String typeCompteSource,CompteBancaire compte){
		this.typeCompteSource = typeCompteSource;
		if (typeCompteSource.equals("Courant")){
			ccSource = new CompteCourant();
		} else {
			ccSource = new CompteEpargne();
		}
		ccSource = compte;
	}
	
	/**
	 * initialisation du compte crédité en fonction du type de compte que l'on choisit
	 * @param typeCompteDestination
	 * @param compte
	 */
	public void initCompteDest(String typeCompteDestination,CompteBancaire compte){
		System.out.println("methode initCOmpteDest !!!!");
		this.typeCompteDestination = typeCompteDestination;
		if (typeCompteDestination.equals("Courant")){
			ccDest = new CompteCourant();
		} else {
			ccDest = new CompteEpargne();
		}
		ccDest = compte;
	}
	
	/**
	 * quand on click sur annuler on remet tout a zero
	 */
	public void annulerOperation(){
		ccSource = null;
		ccDest = null;
		montantVirement = 0;
		montantRetrait = 0;
		clientCrediter = new Client();
		clientDebiter = new Client();
	}
	
	public void retrait(){
		if (typeCompteSource.equals("Courant")){
			serviceCompteCourant.takeMoney((CompteCourant)ccSource, montantRetrait);
		} else {
			serviceCompteEpargne.takeMoney((CompteEpargne)ccSource, montantRetrait);
		}
	}
	
	public void depot(){
		if (typeCompteDestination.equals("Courant")){
			serviceCompteCourant.addMoney((CompteCourant)ccDest, montantDepot);
		} else {
			serviceCompteEpargne.addMoney((CompteEpargne)ccDest, montantDepot);
		}
	}

	public void virement(){
		retrait();
		depot();
		System.out.println("type source : "+typeCompteSource);
		if (typeCompteSource.equals("Courant")){
			System.out.println("Source Compt Courant !!!");
			serviceCompteCourant.takeMoney((CompteCourant)ccSource, montantVirement);
		} else {
			System.out.println(" Source Compt Epargne !!!");
			serviceCompteEpargne.takeMoney((CompteEpargne)ccSource, montantVirement);
		}
		
		System.out.println("type destination : "+typeCompteDestination);
		if (typeCompteDestination.equals("Courant")){
			System.out.println("Dest Compt Courant !!!");
			serviceCompteCourant.addMoney((CompteCourant)ccDest, montantVirement);
		} else {
			System.out.println("Dest Compt Epargne !!!");
			serviceCompteEpargne.addMoney((CompteEpargne)ccDest, montantVirement);
		}
		ccSource = null;
		ccDest = null;
		montantVirement = 0;
	}
	
}
