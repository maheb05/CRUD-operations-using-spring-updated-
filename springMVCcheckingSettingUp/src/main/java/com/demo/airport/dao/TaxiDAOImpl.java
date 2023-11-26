package com.demo.airport.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.airport.entity.TaxiEntity;

@Component
public class TaxiDAOImpl implements TaxiDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public TaxiDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public TaxiDAOImpl() {
		System.out.println("Taxi Impl Default");
	}
	
	public boolean saveTaxiDetails(TaxiEntity entity) {
		Session session = null;
		boolean isValid = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Serializable save = session.save(entity);
			transaction.commit();
			System.out.println(save);
			isValid = true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null)
				session.close();
		}
		return isValid;
	}

	public TaxiEntity getTaxiEntityById(int id) {
		Session session = null;
		TaxiEntity entity = null;
		try {
			session = sessionFactory.openSession();
			entity = session.get(TaxiEntity.class, id);
			return entity;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return entity;
	}

	public List<TaxiEntity> getAllTaxiDetails() {
		Session session = null;
		List resultList = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from TaxiEntity");
			resultList = query.getResultList();
			return resultList;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return resultList;
	}

	public boolean updateTaxiEntityById(TaxiEntity entity) {
		Session session = null;
		boolean isValid = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
			isValid = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return isValid;
	}

	public boolean deleteTaxiEntityById(int id) {
		Session session = null;
		boolean isvalid = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			TaxiEntity entity = session.get(TaxiEntity.class, id);
			session.delete(entity);
			transaction.commit();
			isvalid = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return isvalid;
	}

}
