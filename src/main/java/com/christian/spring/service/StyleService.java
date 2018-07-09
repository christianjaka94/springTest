package com.christian.spring.service;

import java.util.List;

import com.christian.spring.entity.Style;

public interface StyleService {

	public void addStyle(Style s);
	public void updateStyle(Style s);
	public List<Style> listStyles();
	public Style getStyleById(long id);
	public void removeStyle(long id);
	
}
