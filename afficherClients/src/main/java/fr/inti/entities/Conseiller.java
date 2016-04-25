package fr.inti.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="conseillers")
public class Conseiller implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_conseiller")
	private int conseillerId;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="agence")
	private String agence;
	
	@OneToMany(mappedBy="conseiller")
	private Set<Client> clients;

	public int getConseillerId() {
		return conseillerId;
	}

	public void setConseillerId(int conseillerId) {
		this.conseillerId = conseillerId;
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

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Conseiller() {
		super();
	}

	public Conseiller(String nom, String prenom, String agence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.agence = agence;
	}

	@Override
	public String toString() {
		return "Conseiller [conseillerId=" + conseillerId + ", nom=" + nom
				+ ", prenom=" + prenom + ", agence=" + agence + "]";
	}
	
	
	
}
