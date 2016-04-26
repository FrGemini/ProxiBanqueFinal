package fr.inti.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.type.TrueFalseType;
import org.springframework.format.annotation.NumberFormat;



@Entity
@Table(name="clients")
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_client")
	protected int clientId;
	
	@Column(name="nom")
	protected String nom;
	
	@Column(name="prenom")
	protected String prenom;
	
	@Column(name="adresse")
	protected String adresse;
	
	@Column(name="code_postal")
	protected int codePostal;
	
	@Column(name="ville")
	protected String ville;
	
	@Column(name="telephone")
	protected String telephone;

	@OneToOne(mappedBy="client", orphanRemoval=true)
	protected CompteCourant cc;
	@OneToOne(mappedBy="client", orphanRemoval=true)
	protected CompteEpargne ce;
	
	@ManyToOne
	@JoinColumn (name="id_conseiller")
	private Conseiller conseiller;;

	
	
	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public CompteCourant getCc() {
		return cc;
	}

	public void setCc(CompteCourant cc) {
		this.cc = cc;
	}

	public CompteEpargne getCe() {
		return ce;
	}

	public void setCe(CompteEpargne ce) {
		this.ce = ce;
	}

	public Client() {
		super();
	}

	public Client(String nom, String prenom, String adresse, int codePostal,
			String ville, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;

	}
	
	

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int id) {
		this.clientId = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	@Override
	public String toString() {
		return "Client [id=" + clientId + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", telephone=" + telephone + "]";
	}

	
	
	
}