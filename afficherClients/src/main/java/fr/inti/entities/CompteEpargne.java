package fr.inti.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "epargne")
@Table(name = "comptes_epargne")
public class CompteEpargne extends CompteBancaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_epargne")
	private int id;
	@Column(name = "date_creation")
	private Date dateCreation;
	@Column(name = "solde")
	private float solde;
	@Column(name = "taux")
	private float taux=(float) 0.03;
	@OneToOne
	private Client client;

	public CompteEpargne() {
		
	}

	public CompteEpargne(Date dateCreation, float solde, float taux,
			Client client) {
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.taux = taux;
		this.client = client;
	}

	
	public CompteEpargne(Date dateCreation, float solde2,
			Client client) {
		this.dateCreation = dateCreation;
		this.solde = solde2;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}