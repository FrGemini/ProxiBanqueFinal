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

@Entity(name = "courant")
@Table(name = "comptes_courants")
public class CompteCourant extends CompteBancaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_courant")
	private int id;
	@Column(name = "date_creation")
	private Date dateCreation;
	@Column(name = "solde")
	private float solde;
	@OneToOne
	private Client client;
	@Column(name="decouvert")
	private float decouvert;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CompteCourant(Date dateCreation, float solde, Client client,
			float decouvert) {

		this.dateCreation = dateCreation;
		this.solde = solde;
		//this.client = client;
		this.decouvert = decouvert;
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



	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public float getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}

}