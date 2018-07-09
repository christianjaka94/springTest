package com.christian.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christian.spring.dao.ArtistDAO;
import com.christian.spring.entity.Artist;

@Service("artistService")
public class ArtistServiceImpl implements ArtistService {
	
	@Autowired
	private ArtistDAO artistDAO;

	public void setArtistDAO(ArtistDAO artistDAO) {
		this.artistDAO = artistDAO;
	}

	@Override
	@Transactional
	public void addArtist(Artist a) {
		this.artistDAO.addArtist(a);
	}

	@Override
	@Transactional
	public void updateArtist(Artist a) {
		this.artistDAO.updateArtist(a);
	}

	@Override
	@Transactional
	public List<Artist> listArtists() {
		return this.artistDAO.listArtists();
	}

	@Override
	@Transactional
	public Artist getArtistById(long id) {
		return this.artistDAO.getArtistById(id);
	}

	@Override
	@Transactional
	public void removeArtist(long id) {
		this.artistDAO.removeArtist(id);
	}

}
