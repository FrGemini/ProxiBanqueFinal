package fr.inti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.inti.entities.Gerant;

public class DaoGerantImpl implements IDaoGerant {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<Gerant> getAllGerants() {
		return getSession().createQuery("from Gerant").list();
	}

	public void addGerant(Gerant gerant) {
		getSession().save(gerant);
	}

	public Gerant getGerantById(int id) {
		return (Gerant) getSession().get(Gerant.class, id);
	}

	public void deleteGerant(Gerant gerant) {
		getSession().delete(gerant);
	}

	public void updateGerant(Gerant gerant) {
		getSession().update(gerant);
	}

}
