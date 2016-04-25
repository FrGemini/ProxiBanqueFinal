package fr.inti.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.inti.entities.CompteEpargne;

@Repository
@Transactional
public class DaoCompteEpargneImpl implements IDaoCompteEpargne {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public CompteEpargne getCompteByIdCompte(int idCompte) {
		CompteEpargne ce = (CompteEpargne) getSession().get(
				CompteEpargne.class, idCompte);
		return ce;
	}

	public CompteEpargne getCompteByIdClient(int idClient) {
		List<CompteEpargne> listeRetour = getSession()
				.createQuery(
						"SELECT cc FROM CompteEpargne WHERE CompteEpargne.client_id_client=?")
				.setParameter(0, idClient).list();
		return listeRetour.get(0);
	}

	public void update(CompteEpargne compte) {
		getSession().update(compte);
	}

	public List<CompteEpargne> selectAll() {
		return getSession().createQuery("from epargne").list();
	}

}
