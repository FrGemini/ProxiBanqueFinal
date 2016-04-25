package fr.inti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.inti.dao.IDaoCompteEpargne;
import fr.inti.entities.CompteEpargne;

@Service
public class ServiceCompteEpargneImpl implements IServiceCompteEpargne {

	@Autowired
	private IDaoCompteEpargne daoCompte;
	

	public IDaoCompteEpargne getDaoCompte() {
		return daoCompte;
	}

	public void takeMoney(CompteEpargne cc, float montant) {
		cc.setSolde(cc.getSolde() - montant);
		daoCompte.update(cc);
	}

	public void addMoney(CompteEpargne cc, float montant) {
		cc.setSolde(cc.getSolde() + montant);
		daoCompte.update(cc);
	}

	public List<CompteEpargne> selectAll() {
		return daoCompte.selectAll();
	}

	public CompteEpargne selectByIdClient(int idClient) {
		return daoCompte.getCompteByIdClient(idClient);
	}

}
