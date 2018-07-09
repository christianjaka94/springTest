package com.christian.spring.dao;

import java.util.List;

import com.christian.spring.entity.Style;

public interface StyleDAO {

	public void addStyle(Style s);
	public void updateStyle(Style s);
	public List<Style> listStyles();
	public Style getStyleById(long id);
	public void removeStyle(long id);
}
