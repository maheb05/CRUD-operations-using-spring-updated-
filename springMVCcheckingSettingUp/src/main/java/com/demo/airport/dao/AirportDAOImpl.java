package com.demo.airport.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.airport.entity.AirportEntity;

@Component
public class AirportDAOImpl implements AirportDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public AirportDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public AirportDAOImpl() {
		System.out.println("AirportDAO Implementation");
	}
	public boolean saveAirportEntity(AirportEntity entity) {
		
		Session session = null;
		boolean isDataValid = false;
		try {
			
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Serializable save = session.save(entity);
			System.out.println("save = "+save);
			transaction.commit();
			isDataValid = true;
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		
		return isDataValid;
	}

	public AirportEntity getAirportEntityById(int id) {
		
		Session session = null;
		AirportEntity entity = null;
		try {
			session = sessionFactory.openSession();
			entity = session.get(AirportEntity.class, id);
			
			if(entity != null) {
				return entity;
			}
			else {
				System.out.println("something Went Wrong ");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		
		return entity;
	}

	public List getAirportEntityByName(String name) {
		
		Session session = null;
		List list = null;
		
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from AirportEntity ae where airportName = '" +name+ "'");
			list = query.list();
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if(session != null) {
				session.close();
			}
		}
		
		return list;
	}

	public boolean deleteAirportEntityById(int id) {
		Session session = null;
		boolean isValid = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			AirportEntity entity = session.get(AirportEntity.class, id);
			session.delete(entity);
			transaction.commit();
			isValid = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return isValid;
	}

	public List<AirportEntity> getAllAirportEntities() {
		Session session = null;
		List <AirportEntity> result = null;
		try {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from AirportEntity");
		result = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return result;
	}

	public boolean updateAirportEntityById(AirportEntity entity) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
			return true;
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
	}

}
