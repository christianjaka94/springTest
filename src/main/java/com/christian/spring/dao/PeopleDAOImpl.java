package com.christian.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.christian.spring.entity.People;



@Repository
public class PeopleDAOImpl implements PeopleDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PeopleDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPeople(People p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("People saved successfully, People Details="+p);
	}

	@Override
	public void updatePeople(People p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("People updated successfully, People Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<People> listPeople() {
		Session session = this.sessionFactory.getCurrentSession();
		List<People> artistList = session.createQuery("from People").list();
		for(People p : artistList){
			logger.info("People List::"+p);
		}
		return artistList;
	}

	@Override
	public People getPeopleById(long id) {
		Session session = this.sessionFactory.getCurrentSession();		
		People p = (People) session.load(People.class, new Long(id));
		logger.info("People loaded successfully, People details="+p);
		return p;
	}

	@Override
	public void removePeople(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		People p = (People) session.load(People.class, new Long(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("People deleted successfully, People details="+p);
	}

}
