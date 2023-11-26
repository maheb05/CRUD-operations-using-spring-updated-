package com.demo.airport.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.airport.entity.RunwayEntity;

@Component
public class RunwayDAOImpl implements RunwayDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RunwayDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveRunwayEntity(RunwayEntity entity) {
		Session session = null;
		boolean isValid = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Serializable save = session.save(entity);
			System.out.println(save);
			transaction.commit();
			isValid = true;
		}
		finally {
			if(session != null) {
				session.close();
				System.out.println("Session is closed");
			}
		}
		return isValid;
	}

	public RunwayEntity getRunwayById(int id) {
		Session session = null;
		RunwayEntity entity = null;
		try {
			session = sessionFactory.openSession();
			entity = session.get(RunwayEntity.class, id);
			return entity ;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
				System.out.println("Session is closed");
			}
		}
		return entity;
	}

	public List<RunwayEntity> getAllRunwayDetails() {
		List list = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from RunwayEntity");
			list = query.getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
				System.out.println("Session is closed");
			}
		}
		return list;
	}

	public boolean updateRunwayEntityByID(RunwayEntity entity) {
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

	public boolean deleteRunwayById(int id) {
		Session session = null;
		boolean isValid = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			RunwayEntity entity = session.get(RunwayEntity.class, id);
			session.delete(entity);
			transaction.commit();
			isValid = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return isValid;
	}

}
