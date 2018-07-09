package com.christian.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.christian.spring.entity.Style;



@Repository
public class StyleDAOImpl implements StyleDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(StyleDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addStyle(Style s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(s);
		logger.info("Style saved successfully, Style Details="+s);
	}

	@Override
	public void updateStyle(Style s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(s);
		logger.info("Style updated successfully, Style Details="+s);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Style> listStyles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Style> styleList = session.createQuery("from Style").list();
		for(Style s : styleList){
			logger.info("Style List::"+s);
		}
		return styleList;
	}

	@Override
	public Style getStyleById(long id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Style s = (Style) session.load(Style.class, new Long(id));
		logger.info("Style loaded successfully, Style details="+s);
		return s;
	}

	@Override
	public void removeStyle(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Style s = (Style) session.load(Style.class, new Long(id));
		if(null != s){
			session.delete(s);
		}
		logger.info("Style deleted successfully, Style details="+s);
	}

}
