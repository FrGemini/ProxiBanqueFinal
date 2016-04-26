package fr.inti.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gerants")
public class Gerant implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_client")
	private int gerantId;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="civilite")
	private String civilite;
	

	public Gerant() {
		super();
	}

	public Gerant(String nom, String prenom, String civilite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
	}

	public int getGerantId() {
		return gerantId;
	}

	public void setGerantId(int gerantId) {
		this.gerantId = gerantId;
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

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	
	

}
