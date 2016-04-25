package fr.inti.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import fr.inti.entities.Client;
import fr.inti.entities.CompteCourant;
import fr.inti.entities.CompteEpargne;

@Repository
@Transactional
public class DaoCompteCourantImpl implements IDaoCompteCourant {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public CompteCourant getCompteByIdCompte(int idCompte) {
		CompteCourant cc = (CompteCourant) getSession().get(CompteCourant.class, idCompte);
		return cc;
	}

	public CompteCourant getCompteByIdClient(int idClient) {
		List<CompteCourant> listeRetour = getSession()
				.createQuery(
						"SELECT cc FROM CompteCourant WHERE CompteCourant.client_id_client=?")
				.setParameter(0, idClient).list();
		return listeRetour.get(0);
	}

	public void update(CompteCourant compte) {
		getSession().update(compte);
	}
	
	public List<CompteCourant> selectAll() {
		return getSession().createQuery("from courant").list();
		
	}

}
