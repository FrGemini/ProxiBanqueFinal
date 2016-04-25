package fr.inti.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import fr.inti.entities.Client;

@Repository
@Transactional
public class DaoClientImpl extends HibernateDaoSupport implements IDaoClient {

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<Client> getAllClients() {
		String reqHqlGetAll = "FROM Client";
		List<Client> clientList = (List<Client>) getHibernateTemplate().find(
				reqHqlGetAll);
		return clientList;
	}

	public void addClient(Client client) {
		
		sessionFactory.getCurrentSession().save(client);
	}

	public Client getClientById(int id) {
		// HQL : Hibernate Query Language
		String reqHqlGetById = "FROM Client WHERE clientId = ?";
		List<Client> clientList = (List<Client>) getHibernateTemplate().find(
				reqHqlGetById, id);
		return clientList.get(0);
	}

	public void deleteClient(Client client) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Client where id = :ID");
		query.setParameter("ID", client.getClientId());
		query.executeUpdate();
		System.out.println("client effacé");

	}

	public void updateClient(Client client) {
		sessionFactory.getCurrentSession().update(client);

	}

}
