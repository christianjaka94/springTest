package com.christian.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.christian.spring.entity.Artist;



@Repository
public class ArtistDAOImpl implements ArtistDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ArtistDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addArtist(Artist a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(a);
		logger.info("Artist saved successfully, Artist Details="+a);
	}

	@Override
	public void updateArtist(Artist a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(a);
		logger.info("Artist updated successfully, Artist Details="+a);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artist> listArtists() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Artist> artistList = session.createQuery("from Artist").list();
		for(Artist a : artistList){
			logger.info("Artist List::"+a);
		}
		return artistList;
	}

	@Override
	public Artist getArtistById(long id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Artist a = (Artist) session.load(Artist.class, new Long(id));
		logger.info("Artist loaded successfully, Artist details="+a);
		return a;
	}

	@Override
	public void removeArtist(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Artist a = (Artist) session.load(Artist.class, new Long(id));
		if(null != a){
			session.delete(a);
		}
		logger.info("Artist deleted successfully, Artist details="+a);
	}

}
