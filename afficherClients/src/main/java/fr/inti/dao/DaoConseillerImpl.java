package fr.inti.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.inti.entities.CompteCourant;
import fr.inti.entities.Conseiller;

@Repository
@Transactional
public class DaoConseillerImpl implements IDaoConseiller{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public List<Conseiller> getAllConseillers() {
		return getSession().createQuery("from Conseiller").list();
	}

	public void addConseiller(Conseiller conseiller){
		getSession().save(conseiller);
		}

	public Conseiller getConseillerById(int id) {
		Conseiller retour=(Conseiller) getSession().get(Conseiller.class, id);
		return retour;
	}

	public void updateConseiller(Conseiller conseiller) {
		getSession().update(conseiller);
		
	}
	


}
