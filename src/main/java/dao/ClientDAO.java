package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import bo.Client;
import org.hibernate.Transaction;

public class ClientDAO {

	
public void create(Client client) {
	Transaction tx=null;
		try {
		Session session=HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		session.save(client);
		tx.commit();
		session.close();
	}
	catch(HibernateException e) {
		tx.rollback();
		e.printStackTrace();
	}
}

public void update(Client client) {
Transaction tx=null;
	try {
	Session session=HibernateUtil.getSessionFactory().openSession();
	tx=session.beginTransaction();
	session.saveOrUpdate(client);
	tx.commit();
	session.close();
}
catch(HibernateException e) {
	tx.rollback();
	e.printStackTrace();
}
}
public boolean delete(Client client) {
Transaction tx=null;
	try {
	Session session=HibernateUtil.getSessionFactory().openSession();
	tx=session.beginTransaction();
	session.delete(client);
	tx.commit();
	session.close();
	return true;
}
catch(HibernateException e) {
	tx.rollback();
	return false;
}
}
public Client findById(int id) {
		Transaction tx=null;
		Client C=null;
			try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			tx=session.beginTransaction();
			C=session.find(Client.class, id);
			tx.commit();
			session.close();
			return C;
			
			
		}
		catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			return C;
		
		}

	}
	public static void main(String[] args) {
		System.out.println(new ClientDAO().findById(1));
	}
}
