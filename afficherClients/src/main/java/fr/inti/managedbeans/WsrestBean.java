package fr.inti.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import fr.inti.services.IServiceClient;
import fr.inti.services.WebServiceRestFull;

@Controller(value="WebServiceMB")
@SessionScoped
@Component
public class WsrestBean {

	@Autowired
	private WebServiceRestFull wsService;
	@Autowired
	private IServiceClient clientService1;
	

	private float montant;
	private float duree;
	private float teag;
	private float montantTotal=0;
	private float mensualite=0;
	private float montantTotalCredit=0;
	private boolean editeMode1=false;
	private float mensualite1=0;
	private float duree1=0;
	private float teag1=0;
	private float capital=0;
	private float montantTotalCredit1=0;
	private boolean editeMode2=false;
	
	
	public WebServiceRestFull getWsService() {
		return wsService;
	}

	public void setWsService(WebServiceRestFull wsService) {
		this.wsService = wsService;
	}


	public float getCapital() {
		return capital;
	}

	public void setCapital(float capital) {
		this.capital = capital;
	}

	public float getMontantTotalCredit1() {
		return montantTotalCredit1;
	}

	public void setMontantTotalCredit1(float montantTotalCredit1) {
		this.montantTotalCredit1 = montantTotalCredit1;
	}

	public boolean isEditeMode2() {
		return editeMode2;
	}

	public void setEditeMode2(boolean editeMode2) {
		this.editeMode2 = editeMode2;
	}

	public IServiceClient getClientService1() {
		return clientService1;
	}

	public boolean isEditeMode1() {
		return editeMode1;
	}

	public void setEditeMode1(boolean editeMode1) {
		this.editeMode1 = editeMode1;
	}

	public void setClientService1(IServiceClient clientService1) {
		this.clientService1 = clientService1;
	}

	public float getMensualite1() {
		return mensualite1;
	}

	public void setMensualite1(float mensualite1) {
		this.mensualite1 = mensualite1;
	}

	public float getDuree1() {
		return duree1;
	}

	public void setDuree1(float duree1) {
		this.duree1 = duree1;
	}

	public float getTeag1() {
		return teag1;
	}

	public void setTeag1(float teag1) {
		this.teag1 = teag1;
	}

	public float getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(float montantTotal) {
		this.montantTotal = montantTotal;
	}

	public float getMensualite() {
		return mensualite;
	}

	public void setMensualite(float mensualite) {
		this.mensualite = mensualite;
	}

	public float getMontantTotalCredit() {
		return montantTotalCredit;
	}

	public void setMontantTotalCredit(float montantTotalCredit) {
		this.montantTotalCredit = montantTotalCredit;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public float getDuree() {
		return duree;
	}

	public void setDuree(float duree) {
		this.duree = duree;
	}

	public float getTeag() {
		return teag;
	}

	public void setTeag(float teag) {
		this.teag = teag;
	}
//*********************methodes******************
	
	
	public void simulation(){
		editeMode1=true;
		editeMode2=false;
		mensualite=wsService.simulationCreditConsommation(montant,duree,teag);
		
	    montantTotal=mensualite*duree;
		montantTotalCredit=montantTotal-montant;

	}
	
	
	public void simulation1(){
		editeMode1=false;
		editeMode2=true;
		capital=wsService.simulationCreditConsommation1(mensualite1,duree1,teag1);
		
		float montantTotal=mensualite1*duree1;
		montantTotalCredit1=montantTotal-capital;

	}
	
}
