package fr.inti.managedbeans;

import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;









import fr.inti.dao.IDaoCompteCourant;
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
	//private IDaoCompteCourant daoCompte;
	private IServiceCompteCourant serviceCompteCourant;
	
	@Autowired
	private IServiceCompteEpargne serviceCompteEpargne;
	
	
	private CompteBancaire ccSource;
	private CompteBancaire ccDest;
	private String typeCompteSource;
	private String typeCompteDestination;
	
	private float montantVirement;
	
	public GestionCompteMB() {
		super();
		this.typeCompteDestination = "";
		this.typeCompteSource = "";
		this.montantVirement = 0;
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

	public IServiceCompteCourant getServiceCompteCourant() {
		return serviceCompteCourant;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IServiceCompteEpargne getServiceCompteEpargne() {
		return serviceCompteEpargne;
	}
	
	/********** Methodes managed bean **********/
	
	
	/**
	 * initialisation du compte source en fonction du type de compte que l'on choisit
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
	 * initialisation du compte destination en fonction du type de compte que l'on choisit
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
	}

	public void virement(){
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
