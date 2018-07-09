package com.christian.spring.dao;

import java.util.List;

import com.christian.spring.entity.Artist;

public interface ArtistDAO {

	public void addArtist(Artist a);
	public void updateArtist(Artist a);
	public List<Artist> listArtists();
	public Artist getArtistById(long id);
	public void removeArtist(long id);
}
