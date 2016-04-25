package fr.inti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.inti.dao.IDaoCompteCourant;
import fr.inti.entities.Client;
import fr.inti.entities.CompteCourant;

@Service
public class ServiceCompteCourantImpl implements IServiceCompteCourant {
	
	@Autowired
	private IDaoCompteCourant daoCompte;
		
	public IDaoCompteCourant getDaoCompte() {
		return daoCompte;
	}

	public void takeMoney(CompteCourant cc, float montant) {
		cc.setSolde(cc.getSolde() - montant);
		daoCompte.update(cc);
	}

	public void addMoney(CompteCourant cc, float montant) {
		cc.setSolde(cc.getSolde() + montant);
		daoCompte.update(cc);
	}

	public List<CompteCourant> selectAll() {
		return daoCompte.selectAll();
	}

	public CompteCourant selectByIdClient(int idClient) {
		return daoCompte.getCompteByIdClient(idClient);
	}
	
	


}
