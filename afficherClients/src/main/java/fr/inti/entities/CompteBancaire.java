package fr.inti.entities;


public abstract class CompteBancaire {

	
	private float solde;
	

	public float getSolde() {
		return solde;
	}


	public void setSolde(float solde) {
		this.solde = solde;
	}


	public CompteBancaire(float solde) {
		super();
		this.solde = solde;
	}


	public CompteBancaire() {

	}

	

}